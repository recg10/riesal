package cl.devap.ictWeb.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import cl.devap.ict.enums.Encoding;



/**
 * 
 * Clase que Permite obtener Xml a partir de type
 * 
 * @author INDRA
 *
 */
public class JaxbUtil<T> {
	
	/**
	 * Corresponde al Tipo de Clase.
	 */
	private Class<T> t;
	private static Map<String,JAXBContext> instancias;
	
	/**
	 * Constructor que recibe el Tipo de Clase.
	 *
	 * @param t
	 */
	public JaxbUtil(Class<T> t) {
		this.t = t;
	}


	/**
	 * Obtiene un String Xml a partir de la definicion de types
	 * 
	 * @param t
	 * @return
	 */
	public String getXml(T t) {
		StringWriter st = new StringWriter();
		String xml = null;
		try {
			JAXBContext context = JAXBContext.newInstance(this.t);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, Encoding.UTF_8.getCharset());
			m.marshal(t, st);
			xml = st.toString();
		} catch (PropertyException pe) {
			throw new RuntimeException(pe);
		} catch (JAXBException jaxbe) {
			throw new RuntimeException(jaxbe);
		} 
		finally{
			try {
				st.close();
				st = null;
			} catch (IOException e) {
				
			}
		}
		return xml;
	}
	
	public String getXml(T t, String encoding) {
		StringWriter st = new StringWriter();
		String xml = null;
		try {
			JAXBContext context = JAXBContext.newInstance(this.t);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, encoding);
			m.marshal(t, st);
			xml = new String(st.toString().getBytes(encoding),encoding);
		} catch (PropertyException pe) {
			throw new RuntimeException(pe);
		} catch (JAXBException jaxbe) {
			throw new RuntimeException(jaxbe);
		} catch (UnsupportedEncodingException uee) {
			throw new RuntimeException(uee);
		}
		finally{
			try {
				st.close();
				st = null;
			} catch (IOException e) {
				
			}
		}
		return xml;
	}
	
	/**
	 * Obtiene un String Xml a partir de la definicion de types
	 * 
	 * @param t
	 * @return
	 */
	public String getXMLSinEncabezado(T t) {
		StringWriter st = new StringWriter();
		String xml = null;
		try {
			JAXBContext context = JAXBContext.newInstance(this.t);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			m.marshal(t, st);
			xml = st.toString();
		} catch (PropertyException pe) {
			throw new RuntimeException(pe);
		} catch (JAXBException jaxbe) {
			throw new RuntimeException(jaxbe);
		} 
		finally{
			try {
				st.close();
				st = null;
			} catch (IOException e) {
				
			}
		}
		return xml;
	}
	

	/**
	 * 
	 * Obtiene un Objeto desde un XML
	 * 
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getObject(String xml) {
		T obj = null;
		try {
			JAXBContext context = JAXBContext.newInstance(t);
			Unmarshaller m = context.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			obj = (T)m.unmarshal(reader);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public T getObjectSingleton(String xml) {
		
		T obj = null;
		JAXBContext instance = null;
		try {
			if(instancias == null){
				instancias = new HashMap<String, JAXBContext>();
			}
			if (instancias.get(t.getName()) == null){
				instancias.put(t.getName(), JAXBContext.newInstance(t));
			}
			instance = instancias.get(t.getName());
		} catch (JAXBException e) {
		}
		
		try {
			JAXBContext context = instance;
			Unmarshaller m = context.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			obj = (T)m.unmarshal(reader);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}
	
	public static void limpiaSimgleton(){
		instancias = null;
	}
	
	public Class<T> getT() {
		return t;
	}

	public void setT(Class<T> t) {
		this.t = t;
	}
	
}