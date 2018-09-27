/**
 * 
 */
package cl.devap.ictWeb.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.devap.ictCommon.user.UserDTO;
import cl.devap.ictLogic.service.UserService;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean
@SessionScoped
@Component
@Scope("view")
public class LoginBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LoginBean.class);
	private String username;    
    private String password;
    
    @ManagedProperty(value = "#{userService}")
    @Autowired
    private UserService userService;

//	
	@PostConstruct
	public void init(){
		logger.info("INIT...");
		try {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        ServletContext servletContext = (ServletContext) externalContext.getContext();
//	        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
//	                                   getAutowireCapableBeanFactory().autowireBean(this);
//	        
//	        
//	        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
	        //UserServiceImpl someBean = (UserServiceImpl) ctx.getBean("UserServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) {
    	logger.debug("login...");
    	try {
    		RequestContext context = RequestContext.getCurrentInstance();
    		FacesContext context2 = FacesContext.getCurrentInstance();
            FacesMessage message = null;
            boolean loggedIn = false;
            System.out.println("A");
//            UserService impl = new UserServiceImpl();
//            UserDTO usuario2 = impl.login(username, password);
            UserDTO usuario = userService.login(username, password);
            context2.isValidationFailed();
            System.out.println("B");
            if(usuario!=null) {
                loggedIn = true;               
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
                 message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
                try {
    				FacesContext.getCurrentInstance().getExternalContext().redirect("common.jsf");
    			} catch (IOException e) {
    				logger.error("invalido", e);
    			}
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
                logger.warn("usuario invalido...");
            }
             
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error login", e);
		}
    	
    }
    
    public UserDTO getDatosUsuario(){
    	return (UserDTO)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
    }
    
    public void cerrar(ActionEvent event) {
        FacesContext facescontext = FacesContext.getCurrentInstance();
    	HttpSession sesion = (HttpSession) facescontext.getExternalContext().getSession(false);
        sesion.invalidate();
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesion finalizada", username);
        FacesContext.getCurrentInstance().addMessage(null, message);
        try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
		} catch (IOException e) {
			
		}
    }

//	public UserService getUserService() {
//		return userService;
//	}
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}

}
