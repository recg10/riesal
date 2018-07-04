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

import cl.devap.ict.enums.TipoMaterial;
import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreFabricacionCotizacionDTO;
import cl.devap.ictCommon.user.PreMaterialCotizacionDTO;
import cl.devap.ictCommon.user.PreTipoTrabajadorDTO;
import cl.devap.ictLogic.service.PreFabricacionCotizacionService;
import cl.devap.ictLogic.service.PreMaterialCotizacionService;
import cl.devap.ictLogic.service.PreTipoTrabajadorService;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean (name="preFabricacionBean")
@ViewScoped
@Component
@Scope("view")
public class PreFabricacionBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PreFabricacionCotizacionDTO preFabricacionCotizacionDTO;    
	private List<PreFabricacionCotizacionDTO> listPreFabricacionCotizacionDTO;
	private List<PreFabricacionCotizacionDTO> listPreFabricacionCotizacionMODTO;	
	
	private List<PreMaterialCotizacionDTO> listMateriales;
	private List<PreTipoTrabajadorDTO> listTipoTrabajador;
	private String titulo="";
	
	final static Logger logger = Logger.getLogger(PreFabricacionBean.class);
	
    @Autowired
    private PreFabricacionCotizacionService preFabricacionCotizacionEJBLocal;
    @Autowired
    private PreMaterialCotizacionService preMaterialCotizacionEJBLocal;
    @Autowired
    private PreTipoTrabajadorService preTipoTrabajadorService;
    
    private Long totalDetalleMO;
    private Long totalDetalleCotizacion;
  
    
    private String idCotizacion="";
    private String id="";
	
	@PostConstruct
	public void init(){
		logger.debug("init");
		idCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formCotizacion:idCotizacion");
		id = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formCotizacion:id");
		try {
			listMateriales = preMaterialCotizacionEJBLocal.findAll();
			listTipoTrabajador = preTipoTrabajadorService.findAll();
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		if (idCotizacion!=null){
			preFabricacionCotizacionDTO = new PreFabricacionCotizacionDTO();
			preFabricacionCotizacionDTO.setIdCotizacion(new Integer(idCotizacion));
			try {
				listPreFabricacionCotizacionDTO = preFabricacionCotizacionEJBLocal.findByItem(new Long(idCotizacion),new Long(id), TipoMaterial.MATERIAL.getId());
			} catch (IctException e) {
				logger.error(e);
			}
			
			try {
				listPreFabricacionCotizacionMODTO = preFabricacionCotizacionEJBLocal.findByItem(new Long(idCotizacion),new Long(id), TipoMaterial.MO.getId());
			} catch (IctException e) {
				logger.error(e);
			}	
		}
		logger.debug("fin init");
	}
	
	public void saveMateriales(ActionEvent event) {
		logger.info("save...");
		try {
			FacesMessage message = null;        
			preFabricacionCotizacionDTO.setIdCotizacionItem(new Long(id));
//			preFabricacionCotizacionDTO.setSubTotal(new Long(preDetalleCotizacionDTO.getCantidad()*preDetalleCotizacionDTO.getValorUnitario()));
			preFabricacionCotizacionDTO.setTipo(TipoMaterial.MATERIAL.getId());
	        boolean save =  preFabricacionCotizacionEJBLocal.save(preFabricacionCotizacionDTO);        
	        if(save) {   
	        	setListPreFabricacionCotizacionDTO(preFabricacionCotizacionEJBLocal.findByItem(new Long(idCotizacion),new Long(id), TipoMaterial.MATERIAL.getId()));
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro almacenado con exito" );            
	        } else {	        	
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al guardar");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			logger.error(e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin save...");			
		}
    	
    }
	
	public void saveMO(ActionEvent event) {
		logger.debug("saveMO");
		try {
			FacesMessage message = null;   
			preFabricacionCotizacionDTO.setIdCotizacionItem(new Long(id));
			preFabricacionCotizacionDTO.setTipo(TipoMaterial.MO.getId());
	        boolean save =  preFabricacionCotizacionEJBLocal.save(preFabricacionCotizacionDTO);        
	        if(save) {   
	        	setListPreFabricacionCotizacionMODTO(preFabricacionCotizacionEJBLocal.findByItem(new Long(idCotizacion),new Long(id), TipoMaterial.MO.getId()));
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro almacenado con exito" );
	        } else {
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al guardar");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			logger.error(e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin saveMO");			
		}    	
    }
    
    public long getCalculaTotalDetalleMO() {
		long totalDetalleMO=0;       
		if (listPreFabricacionCotizacionDTO!=null){
			for (PreFabricacionCotizacionDTO preDTO : listPreFabricacionCotizacionDTO) {
//				if(preDTO.getSubTotal()!=null){
//					totalDetalleMO = totalDetalleMO + preDTO.getSubTotal().longValue();
//				}
			}
		}		
		return totalDetalleMO;

	}
    
    public void nuevo (ActionEvent event) {
		logger.info("nuevo");
		setTitulo("Crear");
    	setPreFabricacionCotizacionDTO(new PreFabricacionCotizacionDTO());	
    	preFabricacionCotizacionDTO.setIdCotizacion(new Integer(idCotizacion));
    }
    
    public void eliminarMateriales (ActionEvent event) {
		logger.info("eliminar");
    	FacesMessage message = null;
    	try {
    		String idPreFabricacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPreFabricacion");    	
        	getPreFabricacionCotizacionDTO().setIdPreFabricacion(Long.parseLong(idPreFabricacion));
            boolean eliminar =  preFabricacionCotizacionEJBLocal.delete(Long.parseLong(idPreFabricacion));
            if(eliminar) {           
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro eliminado con exito" );
                setListPreFabricacionCotizacionDTO(preFabricacionCotizacionEJBLocal.findByItem(new Long(idCotizacion),new Long(id), TipoMaterial.MATERIAL.getId()));              
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
    
    public void eliminarMO (ActionEvent event) {
		logger.info("eliminarMO");
    	FacesMessage message = null;
    	try {
    		String idPreFabricacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPreFabricacion");    	
        	getPreFabricacionCotizacionDTO().setIdPreFabricacion(Long.parseLong(idPreFabricacion));
            boolean eliminar =  preFabricacionCotizacionEJBLocal.delete(Long.parseLong(idPreFabricacion));
            if(eliminar) {           
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro eliminado con exito" );
                setListPreFabricacionCotizacionMODTO(preFabricacionCotizacionEJBLocal.findByItem(new Long(idCotizacion),new Long(id), TipoMaterial.MO.getId()));              
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
    
    public void updateMateriales(ActionEvent event) {
		logger.debug("update");
		try {
			FacesMessage message = null;
	        boolean save =  preFabricacionCotizacionEJBLocal.update(preFabricacionCotizacionDTO);        
	        if(save) {   
	        	setListPreFabricacionCotizacionDTO(preFabricacionCotizacionEJBLocal.findByItem(new Long(idCotizacion),new Long(id), TipoMaterial.MATERIAL.getId()));
	        	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro almacenado con exito" );   
	            
	        } else {
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al guardar");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.debug("Fin update");
		}    	
    }   
    public void updateMO(ActionEvent event) {
		logger.debug("update");
		try {
			FacesMessage message = null;
	        boolean save =  preFabricacionCotizacionEJBLocal.update(preFabricacionCotizacionDTO);        
	        if(save) {   
	        	setListPreFabricacionCotizacionMODTO(preFabricacionCotizacionEJBLocal.findByItem(new Long(idCotizacion),new Long(id), TipoMaterial.MO.getId()));
	        	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro almacenado con exito" );   
	            
	        } else {
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al guardar");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.debug("Fin update");
		}    	
    }   
    
    public void editar (ActionEvent event) {    	
    	String idPreMoCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPreFabricacion");
    	setTitulo("Modificar");
    	for (PreFabricacionCotizacionDTO obj :  getListPreFabricacionCotizacionDTO()) {
			if (obj.getIdPreFabricacion()==Integer.parseInt(idPreMoCotizacion)){
				this.setPreFabricacionCotizacionDTO(obj);
				break;
			}
		}  
    }
    
    public void editarMO (ActionEvent event) {    	
    	String idPreMoCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPreFabricacion");
    	setTitulo("Modificar");
    	for (PreFabricacionCotizacionDTO obj :  getListPreFabricacionCotizacionMODTO()) {
			if (obj.getIdPreFabricacion()==Integer.parseInt(idPreMoCotizacion)){
				this.setPreFabricacionCotizacionDTO(obj);
				break;
			}
		}  
    }
    
    public String getMaterialId(Integer index){    	
    	for (PreMaterialCotizacionDTO preMaterialCotizacionDTO : listMateriales) {
    		if ( preMaterialCotizacionDTO.getIdMaterialCotizacion().intValue()==index.intValue()){
    			return preMaterialCotizacionDTO.getDescripcion();
    		}
		}
    	return "";
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

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PreFabricacionCotizacionDTO getPreFabricacionCotizacionDTO() {
		return preFabricacionCotizacionDTO;
	}

	public void setPreFabricacionCotizacionDTO(PreFabricacionCotizacionDTO preFabricacionCotizacionDTO) {
		this.preFabricacionCotizacionDTO = preFabricacionCotizacionDTO;
	}


	public List<PreFabricacionCotizacionDTO> getListPreFabricacionCotizacionDTO() {
		return listPreFabricacionCotizacionDTO;
	}

	public void setListPreFabricacionCotizacionDTO(List<PreFabricacionCotizacionDTO> listPreFabricacionCotizacionDTO) {
		this.listPreFabricacionCotizacionDTO = listPreFabricacionCotizacionDTO;
	}

	public List<PreMaterialCotizacionDTO> getListMateriales() {
		return listMateriales;
	}

	public void setListMateriales(List<PreMaterialCotizacionDTO> listMateriales) {
		this.listMateriales = listMateriales;
	}

	public List<PreFabricacionCotizacionDTO> getListPreFabricacionCotizacionMODTO() {
		return listPreFabricacionCotizacionMODTO;
	}

	public void setListPreFabricacionCotizacionMODTO(List<PreFabricacionCotizacionDTO> listPreFabricacionCotizacionMODTO) {
		this.listPreFabricacionCotizacionMODTO = listPreFabricacionCotizacionMODTO;
	}

	public Long getTotalDetalleMO() {
		this.totalDetalleMO=new Long(0);      
		if (listPreFabricacionCotizacionMODTO!=null){
			for (PreFabricacionCotizacionDTO preDTO : listPreFabricacionCotizacionMODTO) {
//				if(preDTO.getSubTotal()!=null){
//					this.totalDetalleMO = this.totalDetalleMO + preDTO.getSubTotal().longValue();
					this.totalDetalleMO += preDTO.getUnidad()+preDTO.getValorHora()+preDTO.getPrecio();
//				}
			}		
		}
		return totalDetalleMO;
	}

	public void setTotalDetalleMO(Long totalDetalleMO) {
		this.totalDetalleMO = totalDetalleMO;
	}

	public Long getTotalDetalleCotizacion() {
		totalDetalleCotizacion = new Long(0);
		if (listPreFabricacionCotizacionDTO!=null && listPreFabricacionCotizacionDTO.size()>0){
			for (PreFabricacionCotizacionDTO dto : listPreFabricacionCotizacionDTO) {
				totalDetalleCotizacion += dto.getUnidad()*dto.getPrecio();
			}
		}		
		return totalDetalleCotizacion;		
	}

	public void setTotalDetalleCotizacion(Long totalDetalleCotizacion) {
		this.totalDetalleCotizacion = totalDetalleCotizacion;
	}

	public List<PreTipoTrabajadorDTO> getListTipoTrabajador() {
		return listTipoTrabajador;
	}

	public void setListTipoTrabajador(List<PreTipoTrabajadorDTO> listTipoTrabajador) {
		this.listTipoTrabajador = listTipoTrabajador;
	}
}
