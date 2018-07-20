/**
 * 
 */
package cl.devap.ictWeb.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.UserDTO;
import cl.devap.ictLogic.service.UserService;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean (name="userBean")
@ViewScoped
@Component
@Scope("view")
public class UserBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDTO user;    
	private List<UserDTO> listUser;
	
	private String titulo="";
	
	final static Logger logger = Logger.getLogger(UserBean.class);
	
    @Autowired
    private UserService userService;
	
	@PostConstruct
	public void init(){
		user = new UserDTO();
		try {
			listUser = userService.getUser();
		} catch (IctException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveUser(ActionEvent event) {
    	FacesMessage message = null;
        try {
        	boolean save =  userService.save(user);
        	if(save) {   
            	setListUser(userService.getUser());
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro almacenado con exito" );            
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al guardar");
            }         
            FacesContext.getCurrentInstance().addMessage(null, message);     
		} catch (Exception e) {
			logger.error(e);
		}
           
    }   
	
	public void updateUser(ActionEvent event) {
    	FacesMessage message = null;
    	try {
    		boolean save =  userService.update(user);        
            if(save) {   
            	setListUser(userService.getUser());
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro actualizado con exito" );            
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al Actualizar");
            }         
            FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			logger.error(e);
		}
        
    }   

    public void nuevo (ActionEvent event) {
		logger.info("nuevo");
		setTitulo("Crear");
    	setUser(new UserDTO());		  
    }
    
    public void eliminar (ActionEvent event) {
		logger.info("eliminar");
    	FacesMessage message = null;
    	String rut = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rutUser");    	
    	getUser().setRut(Integer.parseInt(rut));
        boolean eliminar;
		try {
			eliminar = userService.delete(Integer.parseInt(rut));
			if(eliminar) {           
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro eliminado con exito" );
	            setListUser(userService.getUser());
	        } else {
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al eliminar");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message); 
		} catch (NumberFormatException | IctException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
           
        logger.info("Fin eliminar");
    }
    
    
    public void editar (ActionEvent event) {
    	FacesMessage message = null;
    	String rut = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rutUser");
    	setTitulo("Modificar");
    	for (UserDTO userDTO :  getListUser()) {
			if (userDTO.getRut()==Integer.parseInt(rut)){
				this.setUser(userDTO);
				break;
			}
		}  
    }
    
    public boolean getBotonVisible(){
		if (titulo!=null && "Crear".equals(titulo)){
			return true;
		}else{
			return false;
		}
	} 

	public void movements(ActionEvent event) {
        try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("movements.jsf");
		} catch (IOException e) {
			
		}
    }
    
    public void manUser(ActionEvent event) {
        try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("manUser.jsf");
		} catch (IOException e) {
			
		}
    }
    public void report(ActionEvent event) {
        try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("report.jsf");
		} catch (IOException e) {
			
		}
    }

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<UserDTO> getListUser() {
		return listUser;
	}

	public void setListUser(List<UserDTO> listUser) {
		this.listUser = listUser;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
