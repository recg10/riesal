/**
 * 
 */
package cl.devap.ictWeb.bean;

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
import cl.devap.ictCommon.user.ParametroDTO;
import cl.devap.ictLogic.service.ParametroService;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean (name="parametroBean")
@ViewScoped
@Component
@Scope("view")
public class ParametroBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ParametroDTO parametroDTO;    
	private List<ParametroDTO> listParametroDTO;
	
	private String titulo="";
	
	final static Logger logger = Logger.getLogger(ParametroBean.class);
	
    @Autowired
    private ParametroService parametroService;
	
	@PostConstruct
	public void init(){
		parametroDTO = new ParametroDTO();
		try {
			listParametroDTO = parametroService.findAll();
		} catch (IctException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveUser(ActionEvent event) {
    	FacesMessage message = null;
        try {
        	boolean save =  parametroService.save(parametroDTO);
        	if(save) {   
            	setListParametroDTO(parametroService.findAll());
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
    		boolean save =  parametroService.update(parametroDTO);        
            if(save) {   
            	setListParametroDTO(parametroService.findAll());
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro actualizado con exito" );            
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al Actualizar");
            }         
            FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			logger.error(e);
		}
        
    }   

    
//    public void generateCode(ActionEvent event) {
//        try {
//			FacesContext.getCurrentInstance().getExternalContext().redirect("generateCode.jsf");
//		} catch (IOException e) {
//			
//		}
//    }
    
    public void nuevo (ActionEvent event) {
		logger.info("nuevo");
		setTitulo("Crear");
    	setParametroDTO(new ParametroDTO());		  
    }
    
    public void eliminar (ActionEvent event) {
		logger.info("eliminar");
    	FacesMessage message = null;
    	String id = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");    	
    	getParametroDTO().setId(Integer.parseInt(id));
        boolean eliminar;
		try {
			eliminar = parametroService.delete(Integer.parseInt(id));
			if(eliminar) {           
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro eliminado con exito" );
	            setListParametroDTO(parametroService.findAll());
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
    	String id = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
    	setTitulo("Modificar");
    	for (ParametroDTO dto :  getListParametroDTO()) {
			if (dto.getId()==Integer.parseInt(id)){
				this.setParametroDTO(dto);
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

	    
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ParametroDTO getParametroDTO() {
		return parametroDTO;
	}

	public void setParametroDTO(ParametroDTO parametroDTO) {
		this.parametroDTO = parametroDTO;
	}

	public List<ParametroDTO> getListParametroDTO() {
		return listParametroDTO;
	}

	public void setListParametroDTO(List<ParametroDTO> listParametroDTO) {
		this.listParametroDTO = listParametroDTO;
	}
}
