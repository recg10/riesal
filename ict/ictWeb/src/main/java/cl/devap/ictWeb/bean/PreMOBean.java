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
import cl.devap.ictCommon.user.PreMOCotizacionDTO;
import cl.devap.ictCommon.user.PreMaterialCotizacionDTO;
import cl.devap.ictCommon.user.PreTipoTrabajadorDTO;
import cl.devap.ictLogic.service.PreMOCotizacionService;
import cl.devap.ictLogic.service.PreTipoTrabajadorService;
import cl.devap.ictWeb.util.FacesUtils;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean (name="preMOBean")
@ViewScoped
@Component
@Scope("view")
public class PreMOBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PreMOCotizacionDTO preMOCotizacionDTO;    
	private List<PreMOCotizacionDTO> listPreMOCotizacionDTO;
	private Long totalDetalleMO;
	
	private String titulo="";
	private String idCotizacion="";
	private String id="";
	
	final static Logger logger = Logger.getLogger(PreMOBean.class);
	
	
    @Autowired
    private PreMOCotizacionService preMOCotizacionService;
    
    @Autowired
    private PreTipoTrabajadorService preTipoTrabajadorService;
    
    private List<PreTipoTrabajadorDTO> listTipoTrabajador;
    private PreTipoTrabajadorDTO tipoTrabajador;
	
	@PostConstruct
	public void init(){
		logger.debug("init");
		idCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formCotizacion:idCotizacion");
		id = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formCotizacion:id");
		
		if (idCotizacion!=null){
			preMOCotizacionDTO = new PreMOCotizacionDTO();
			preMOCotizacionDTO.setIdCotizacion(new Integer(idCotizacion));
			try {
//				listPreMOCotizacionDTO = preMOCotizacionEJBLocal.find(new Long(idCotizacion));
				listPreMOCotizacionDTO = preMOCotizacionService.find(new Long(idCotizacion), new Long(id));
				
				listTipoTrabajador = preTipoTrabajadorService.findAll();
				
			} catch (IctException e) {
				logger.error(e);
			}
			calculaTotalPrincipal();
		}
		logger.debug("Fin init");
	}
	
	public void save(ActionEvent event) {
		System.out.println("PASE...");
		try {
			FacesMessage message = null;   
			preMOCotizacionDTO.setIdCotizacionItem(new Long(id));
	        boolean save =  preMOCotizacionService.save(preMOCotizacionDTO);        
	        if(save) {   
	        	setListPreMOCotizacionDTO(preMOCotizacionService.find(new Long(idCotizacion), new Long(id)));
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro almacenado con exito" );  
	            calculaTotalPrincipal();
	        } else {
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al guardar");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			logger.error(e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin saveUser");			
		}    	
    }
	
	public void update(ActionEvent event) {
		logger.info("update...");
		try {
			FacesMessage message = null;
			preMOCotizacionDTO.setIdCotizacionItem(new Long(id));
			boolean save = preMOCotizacionService.update(preMOCotizacionDTO);
	        if(save) {
	        	setListPreMOCotizacionDTO(preMOCotizacionService.find(new Long(idCotizacion), new Long(id)));
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro actualizado con exito" );            
	        } else {
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al actualizar");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			logger.error(e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin update");			
		}
    	
    }   
	
//	public long getCalculaTotalDetalleMO() {
//		this.totalDetalleMO=0;      
//		if (listPreMOCotizacionDTO!=null){
//			for (PreMOCotizacionDTO preDTO : listPreMOCotizacionDTO) {
//				if(preDTO.getSubTotal()!=null){
//					this.totalDetalleMO = this.totalDetalleMO + preDTO.getSubTotal().longValue();
//				}
//			}		
//		}
//		return totalDetalleMO;
//	}

    
    public void generateCode(ActionEvent event) {
        try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("generateCode.jsf");
		} catch (IOException e) {
			logger.error(e);
		}
    }
    
    public void nuevo (ActionEvent event) {
		logger.info("nuevo");
		setTitulo("Crear");
    	setPreMOCotizacionDTO(new PreMOCotizacionDTO());	
    	preMOCotizacionDTO.setIdCotizacion(new Integer(idCotizacion));
    }
    
    public void eliminar (ActionEvent event) {
		logger.info("eliminar");
    	FacesMessage message = null;
    	try {
    		String idPreMoCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPreMoCotizacion");    	
        	getPreMOCotizacionDTO().setIdPreMoCotizacion(Integer.parseInt(idPreMoCotizacion));
            boolean eliminar =  preMOCotizacionService.delete(Integer.parseInt(idPreMoCotizacion));
            if(eliminar) {           
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro eliminado con exito" );
                setListPreMOCotizacionDTO(preMOCotizacionService.find(new Long(idCotizacion), new Long(id)));
                PreCotizacionBean preCotizacionBean = (PreCotizacionBean) FacesUtils.getManagedBean("preCotizacionBean");
                preCotizacionBean.calculaTotalDetalleMateriales();
                calculaTotalPrincipal();
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al eliminar");
            }         
            FacesContext.getCurrentInstance().addMessage(null, message);  
		} catch (Exception e) {
			logger.error(e);
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin eliminar");
		}

    }
    
    private void calculaTotalPrincipal(){
    	if (listPreMOCotizacionDTO==null){
			return;
		}
		Long total = new Long(0);
		for (PreMOCotizacionDTO dto : listPreMOCotizacionDTO) {
			total += dto.getSubTotal();
		}
	}
    
    
    public void editar (ActionEvent event) {
    	FacesMessage message = null;
    	String idPreMoCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPreMoCotizacion");
    	setTitulo("Modificar");
    	for (PreMOCotizacionDTO obj :  getListPreMOCotizacionDTO()) {
			if (obj.getIdPreMoCotizacion()==Integer.parseInt(idPreMoCotizacion)){
				this.setPreMOCotizacionDTO(obj);
				break;
			}
		}  
    }
    
    public void cargarValorMO() {
		try {
			tipoTrabajador = new PreTipoTrabajadorDTO();
			for (PreTipoTrabajadorDTO dto : listTipoTrabajador) {
				if (preMOCotizacionDTO.getIdTrabajdor().equals(dto.getIdPreTipoTrabajador())){
					this.tipoTrabajador = dto;
					this.preMOCotizacionDTO.setValorHora(dto.getValorHora());
					return;
				}
			}
		} catch (Exception e) {
			logger.error(e);
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
			logger.error(e);
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

	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public PreMOCotizacionDTO getPreMOCotizacionDTO() {
		return preMOCotizacionDTO;
	}

	public void setPreMOCotizacionDTO(PreMOCotizacionDTO preMOCotizacionDTO) {
		this.preMOCotizacionDTO = preMOCotizacionDTO;
	}

	public List<PreMOCotizacionDTO> getListPreMOCotizacionDTO() {
		return listPreMOCotizacionDTO;
	}

	public void setListPreMOCotizacionDTO(List<PreMOCotizacionDTO> listPreMOCotizacionDTO) {
		this.listPreMOCotizacionDTO = listPreMOCotizacionDTO;
	}

	public Long getTotalDetalleMO() {
		this.totalDetalleMO=new Long(0);      
		if (listPreMOCotizacionDTO!=null){
			for (PreMOCotizacionDTO preDTO : listPreMOCotizacionDTO) {
				if(preDTO.getSubTotal()!=null){
					this.totalDetalleMO = this.totalDetalleMO + preDTO.getSubTotal().longValue();
				}
			}		
		}
		return totalDetalleMO;
	}

	public void setTotalDetalleMO(long totalDetalleMO) {
		this.totalDetalleMO = totalDetalleMO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<PreTipoTrabajadorDTO> getListTipoTrabajador() {
		return listTipoTrabajador;
	}

	public void setListTipoTrabajador(List<PreTipoTrabajadorDTO> listTipoTrabajador) {
		this.listTipoTrabajador = listTipoTrabajador;
	}

	public PreTipoTrabajadorDTO getTipoTrabajador() {
		return tipoTrabajador;
	}

	public void setTipoTrabajador(PreTipoTrabajadorDTO tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}

	
}
