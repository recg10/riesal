package cl.devap.ictWeb.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceLocator {

//	private static final Log LOGGER = LogFactory.getLog(ServiceLocator.class);
	private Context initalContext;
	private Map<String, Object> cache;

	private static ServiceLocator _instance = null;

	public static ServiceLocator getInstance() {
		if (_instance == null)
			_instance = new ServiceLocator();
		return _instance;
	}

	private ServiceLocator() {
		try {
			this.initalContext = new InitialContext();
			this.cache = Collections
					.synchronizedMap(new HashMap<String, Object>());
		} catch (NamingException ex) {
//			LOGGER.error("Error in CTX lookup", ex);
		}
	}

	public Object getEjb(String jndiName) {
		
		Object ejb = null;
		try {
			if (this.cache.containsKey(jndiName))
				ejb = this.cache.get(jndiName);
			else {
				Context envContext = (Context) initalContext.lookup("java:comp/env");
				ejb = envContext.lookup(jndiName);
				this.cache.put(jndiName, ejb);
			}
		}
		catch (NamingException ex)
		{
			System.out.println(ex);
		}
		return ejb;
	}

}
