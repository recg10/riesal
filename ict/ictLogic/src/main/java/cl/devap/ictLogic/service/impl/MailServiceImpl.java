package cl.devap.ictLogic.service.impl;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cl.devap.ict.exception.IctException;
import cl.devap.ictLogic.service.MailService;

@Service
public class MailServiceImpl implements MailService{
	
	final static Logger logger = Logger.getLogger(MailServiceImpl.class);
	
	@Override	
	public void enviarMail(String destinatario, String asunto, String cuerpo) throws IctException{
		// Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    String remitente = "rodrigo.e.castro.gonzalez@gmail.com";  //Para la dirección nomcuenta@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "gogi99999");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        
	        Address address = new InternetAddress(destinatario);
			message.addRecipient(Message.RecipientType.TO, address);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "gogi99999");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
		

}
