package cl.devap.ictLogic.service;

import cl.devap.ict.exception.IctException;

public interface MailService  {
	
	public void enviarMail(String destinatario, String asunto, String cuerpo) throws IctException;
	
}
