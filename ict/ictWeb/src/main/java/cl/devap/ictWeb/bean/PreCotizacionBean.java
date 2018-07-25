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
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.enums.EstadoCotizacion;
import cl.devap.ict.enums.TipoMaterial;
import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PlantelDTO;
import cl.devap.ictCommon.user.PreCotizacionDTO;
import cl.devap.ictCommon.user.PreCotizacionItemDTO;
import cl.devap.ictCommon.user.PreDetalleCotizacionDTO;
import cl.devap.ictCommon.user.PreFabricacionCotizacionDTO;
import cl.devap.ictCommon.user.PreMOCotizacionDTO;
import cl.devap.ictLogic.service.PlantelService;
import cl.devap.ictLogic.service.PreCotizacionItemService;
import cl.devap.ictLogic.service.PreCotizacionService;
import cl.devap.ictLogic.service.PreDetalleCotizacionService;
import cl.devap.ictLogic.service.PreFabricacionCotizacionService;
import cl.devap.ictLogic.service.PreMOCotizacionService;
import cl.devap.ictWeb.util.FacesUtils;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean (name="preCotizacionBean")
@ViewScoped
@Component
@Scope("view")
public class PreCotizacionBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PreDetalleCotizacionDTO preDetalleCotizacionDTO;    
	private List<PreDetalleCotizacionDTO> listPreDetalleCotizacion;
	private PreCotizacionItemDTO preCotizacionItemDTO;
	private PreCotizacionDTO preCotizacionDTO;
	private List<PreCotizacionDTO> listPreCotizacion;
	private List<PreCotizacionItemDTO> listPreCotizacionItemDTO;
	private List<PlantelDTO> listPlantel;
	private Integer idPlantel;

	
	private String titulo="";
	private String idCotizacion="";
	private String idItem="";
	
	
	final static Logger logger = Logger.getLogger(PreCotizacionBean.class);
	
	@Autowired
    private PreDetalleCotizacionService preDetalleCotizacionService;
    @Autowired
    private PreCotizacionItemService preCotizacionItemService;    
    @Autowired
    private PreCotizacionService preCotizacionService;
    @Autowired
    private PreMOCotizacionService preMOCotizacionService;
    @Autowired
    private PreFabricacionCotizacionService preFabricacionCotizacionService;
    @Autowired
    private PlantelService plantelService;
	
	@PostConstruct
	public void init(){
		logger.debug("init...");
		idCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCotizacion");
		Integer idCOtizacionSession=null;
		if ( FacesUtils.getHttpSession(false)!=null){
			idCOtizacionSession= (Integer)FacesUtils.getHttpSession(false).getAttribute("idCotizacion");
		}
		
		if (idCOtizacionSession!=null){
			idCotizacion=idCOtizacionSession+"";
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idCotizacion", null);
		}
		
		idItem = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPreCotizacionItem");
		
//		
		try {
			//Carga elemttos en la pantalla			
			listPlantel = plantelService.findAll();
			preCotizacionDTO = new PreCotizacionDTO();
			preCotizacionItemDTO = new PreCotizacionItemDTO();
			//Carga datos existentes
			if (idCotizacion != null){				
				preCotizacionDTO.setIdCotizacion(new Integer(idCotizacion));
				List<PreCotizacionDTO> list  = preCotizacionService.find(new Long(idCotizacion));
				if ( list!=null && list.size()>0 ){
					preCotizacionDTO = list.get(0);
				}
				try {
					listPreDetalleCotizacion = preDetalleCotizacionService.find(new Long(idCotizacion));
//					calculaTotalDetalleMateriales();					
				} catch (IctException e) {
					logger.error(e);
				}				
				setListPreCotizacionItemDTO(preCotizacionItemService.find(new Long(idCotizacion)));
				
			}else{//Carga datos nuevos
				preCotizacionDTO.setEstado(EstadoCotizacion.INGRESADO.getId());
			}
		} catch (Exception e) {
			logger.error(e);
		}		
		logger.debug("fin init...");
	}

//	public void calculaTotalDetalleMateriales() {
////		totalDetalleMateriales=0;
//		for (PreDetalleCotizacionDTO preDetalleCotizacionDTO : listPreDetalleCotizacion) {
////			this.totalDetalleMateriales = this.totalDetalleMateriales + preDetalleCotizacionDTO.getSubTotal().longValue();
//		}
//	}
	
	
	
	public void save(ActionEvent event) {
		logger.debug("saveUser...");
		try {
			FacesMessage message = null; 
			if (preCotizacionDTO.getIdCotizacion()!=null && preCotizacionDTO.getIdCotizacion()==0 ){
				preCotizacionDTO.setIdCotizacion(null);
			}
//			Double valorUnidadCotizacion = (double) ((preCotizacionDTO.getTrasladoPlantelValor()+preCotizacionDTO.getGastoOperacionalValor()+preCotizacionDTO.getPrevencionValor()+preCotizacionDTO.getUtilidadRiesalValor())/preCotizacionDTO.getUnidadCotizacion());
//			preCotizacionDTO.setMontoUnidadCotizacion(valorUnidadCotizacion.intValue());
			preCotizacionDTO.setEstado(EstadoCotizacion.INGRESADO.getId());
			Integer save = preCotizacionService.save(preCotizacionDTO);
	        if(save.intValue()>0) {   
	        	preCotizacionDTO.setIdCotizacion(save);
	        	setListPreCotizacion(preCotizacionService.find(new Long(preCotizacionDTO.getIdCotizacion())));
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro almacenado con exito con id de cotizacion:"+save );            
	        } else {
	            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			logger.error(e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.debug("Fin saveUser");			
		}
    	
    }   
	@Transactional
	public void update(ActionEvent event) {
		System.out.println("update...");
		try {
			FacesMessage message = null; 
			if (preCotizacionDTO.getIdCotizacion()==0){
				preCotizacionDTO.setIdCotizacion(null);
			}
			preCotizacionDTO.setEstado(EstadoCotizacion.INGRESADO.getId());
			boolean save = preCotizacionService.update(preCotizacionDTO);
	        if(save) {
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
	
	public void finalizar(ActionEvent event) {
		System.out.println("finalizar...");
		try {
			FacesMessage message = null;
			preCotizacionDTO.setEstado(EstadoCotizacion.FINALIZADO.getId());
			
			//Mejorar
			preCotizacionDTO.setTotalNetoPresupuesto(getTotalNetoPresupuesto());
			preCotizacionDTO.setTotalPresupuesto(getTotalNetoPresupuesto() + preCotizacionDTO.getTotal());
			
			boolean save = preCotizacionService.update(preCotizacionDTO);
	        if(save) {
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
	
	public void saveItem(ActionEvent event) {
		 logger.info("PASE..saveItem.");
		try {
			FacesMessage message = null; 
			Long item = (listPreCotizacionItemDTO!=null && listPreCotizacionItemDTO.size()>0?listPreCotizacionItemDTO.size():0L);
			if (preCotizacionItemDTO.getIdItem()==null){
				preCotizacionItemDTO.setIdItem(item+1);
			}
			preCotizacionItemDTO.setIdCotizacion(preCotizacionDTO.getIdCotizacion());
			boolean save = preCotizacionItemService.save(preCotizacionItemDTO);
	        if(save) {   
	        	setListPreCotizacionItemDTO(preCotizacionItemService.find(preCotizacionDTO.getIdCotizacion().longValue()));
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro asociado con exito" );            
	        } else {
	            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar detalles");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			 logger.error(e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin saveUser");			
		}
    	
    }   
	
	public void realizarCotizacion(ActionEvent event) {
		System.out.println("PASE..realizarCotizacion.");
		try {			
			String rowId = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
        	preCotizacionItemDTO = getListPreCotizacionItemDTO().get(new Integer(rowId));        	
        	FacesUtils.removeViewScopedBean("preDetalleCotizacionBean");
        	FacesUtils.removeViewScopedBean("preFabricacionBean");
        	FacesUtils.removeViewScopedBean("preMOBean");        	
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
			logger.error(e);
		}finally {
	        logger.info("Fin realizarCotizacion");			
		}
    	
    }
    
    public void nuevo (ActionEvent event) {
		logger.info("nuevo");
		setTitulo("Crear");
    	setPreDetalleCotizacionDTO(new PreDetalleCotizacionDTO());	
    	preDetalleCotizacionDTO.setIdCotizacion(preCotizacionDTO.getIdCotizacion());
    }
    
    
    public void eliminarItem (ActionEvent event) {
		logger.info("eliminarItem");
    	FacesMessage message = null;
    	try {
    		String idPreCotizacionItem = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPreCotizacionItem");    	
        	getPreCotizacionItemDTO().setId(Long.parseLong(idPreCotizacionItem));
            boolean eliminar =  preCotizacionItemService.delete(Long.parseLong(idPreCotizacionItem));
            if(eliminar) {           
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro eliminado con exito" );
                setListPreCotizacionItemDTO(preCotizacionItemService.find(new Long(idCotizacion)));
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
    
    public void nuevoItem (ActionEvent event) {
		logger.info("nuevo");
		setTitulo("Crear");
		setPreCotizacionItemDTO(new PreCotizacionItemDTO());
		if(idCotizacion==null){
			idCotizacion = preCotizacionDTO.getIdCotizacion()+"";
		}
		preCotizacionItemDTO.setIdCotizacion(new Integer(idCotizacion));
    }
    
    public void editarItem (ActionEvent event) {
    	FacesMessage message = null;
    	String idPreCotizacionItem = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPreCotizacionItem");
    	setTitulo("Modificar");
    	for (PreCotizacionItemDTO obj :  getListPreCotizacionItemDTO()) {
			if (obj.getId()==Integer.parseInt(idPreCotizacionItem)){
				this.setPreCotizacionItemDTO(obj);
				break;
			}
		}  
    }
    
    public void eliminar (ActionEvent event) {
		logger.info("eliminar");
    	FacesMessage message = null;
    	try {
    		String idDetalleCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idDetalleCotizacion}");    	
        	getPreDetalleCotizacionDTO().setIdDetalleCotizacion(Integer.parseInt(idDetalleCotizacion));
            boolean eliminar =  preDetalleCotizacionService.delete(Integer.parseInt(idDetalleCotizacion));
            if(eliminar) {           
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro eliminado con exito" );
                setListPreDetalleCotizacion(preDetalleCotizacionService.find(new Long(idCotizacion)));
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
    
    public void updateItem (ActionEvent event) {
		logger.info("updateItem");
    	FacesMessage message = null;
    	try {    		
            boolean update =  preCotizacionItemService.update(preCotizacionItemDTO);
            if(update) {           
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro update con exito" );
                setListPreCotizacionItemDTO(preCotizacionItemService.find(new Long(preCotizacionItemDTO.getIdCotizacion())));
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al update");
            }         
            FacesContext.getCurrentInstance().addMessage(null, message);  
		} catch (Exception e) {
			logger.error(e);
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin updateItem");
		}
    }
    
    
    public void editar (ActionEvent event) {
    	FacesMessage message = null;
    	String idDetalleCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idDetalleCotizacion");
    	setTitulo("Modificar");
    	for (PreDetalleCotizacionDTO obj :  getListPreDetalleCotizacion()) {
			if (obj.getIdDetalleCotizacion()==Integer.parseInt(idDetalleCotizacion)){
				this.setPreDetalleCotizacionDTO(obj);
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
    
    public Long getTotalNetoPresupuesto(){
    	if(idCotizacion==null){
    		return null;
    	}
    	Long total = new Long(0);
    	total = getTotalMOPresupuesto() + getTotalMaterialesPresupuesto() /*+ getTotalFabricacionPresupuesto()*/;
    	return total;
    }
    
    public Long getTotalMOPresupuesto(){
    	if(idCotizacion==null){
    		return null;
    	}
    	Long total = new Long(0);
    	try {
    		List<PreMOCotizacionDTO> list = preMOCotizacionService.find(new Long(idCotizacion));
    		for (PreMOCotizacionDTO dto : list) {
    			total += dto.getSubTotal();
			}
    		
    		List<PreFabricacionCotizacionDTO> listFabricacion = preFabricacionCotizacionService.findByItem(new Long(idCotizacion), preCotizacionItemDTO.getId(), TipoMaterial.MO.getId());
    		for (PreFabricacionCotizacionDTO dto : listFabricacion) {
    			total += dto.getSubTotal();
			}
    		
		} catch (NumberFormatException e) {
			logger.error(e);
		} catch (IctException e) {
			logger.error(e);
		}
    	return total;
    }
    
    public void calculaResultadoMO(){
    	if ( preCotizacionItemDTO!= null){
    		this.preCotizacionDTO.setMoResult((long) ((getTotalMOPresupuesto()*this.preCotizacionDTO.getMoPorc())/100));
    	}    	    	
    }
    
    
    public Long getTotalMaterialesPresupuesto(){
    	if(idCotizacion==null){
    		return null;
    	}
    	Long total = new Long(0);
    	try {
    		List<PreDetalleCotizacionDTO> list = preDetalleCotizacionService.find(new Long(idCotizacion));
    		for (PreDetalleCotizacionDTO preDetalleCotizacionDTO : list) {
    			total += preDetalleCotizacionDTO.getSubTotal();
			}
    		
    		List<PreFabricacionCotizacionDTO> listFabricacion = preFabricacionCotizacionService.findByItem(new Long(idCotizacion), preCotizacionItemDTO.getId(), TipoMaterial.MATERIAL.getId());
    		for (PreFabricacionCotizacionDTO dto : listFabricacion) {
    			total += dto.getSubTotal();
			}
    		
		} catch (NumberFormatException e) {
			logger.error(e);
		} catch (IctException e) {
			logger.error(e);
		}
    	return total;
    }
    
    public void calculaResultadoMateriales(){
    	if (preCotizacionItemDTO!=null){
    		this.preCotizacionDTO.setMaterialesResult((long) ((getTotalMaterialesPresupuesto()*this.preCotizacionDTO.getMaterialesPorc())/100));
    	}    		
    	    	
    }
    
    
    public Long getTotalFabricacionPresupuesto(){
    	if(idCotizacion==null){
    		return null;
    	}
    	Long total = new Long(0);
    	try {
    		List<PreFabricacionCotizacionDTO> list = preFabricacionCotizacionService.find(new Long(idCotizacion));
    		for (PreFabricacionCotizacionDTO preDetalleCotizacionDTO : list) {
    			total += preDetalleCotizacionDTO.getSubTotal();
			}
		} catch (NumberFormatException e) {
			logger.error(e);
		} catch (IctException e) {
			logger.error(e);
		}
    	return total;
    }
    
    public Long getCalculaTotal(){
    	long total = new Long(0);
    	try {
        	total =getTotalMaterialesPresupuesto()+getTotalMOPresupuesto();
		} catch (Exception e) {
			total = new Long(0);
		}
    	return total;
    }
    
    public void calculaResultadoGO(){
    	try {
    		if (preCotizacionItemDTO!=null){
        		this.preCotizacionDTO.setGoResult((long) ((getTotalNetoPresupuesto()*this.preCotizacionDTO.getGoPorc())/100));
        	}   
    		
		} catch (Exception e) {
			logger.error(e);
		}
    	    	
    }
    
    public void calculaResultadoUtilidad(){
//    	resultadoTotalUtilidad = (long) ((getTotalNetoPresupuesto()*this.porcentajeTotalUtilidad)/100);
    	try {
    		if (preCotizacionItemDTO!=null){
        		this.preCotizacionDTO.setUtilidadResult((long) ((getTotalNetoPresupuesto()*this.preCotizacionDTO.getUtilidadPorc())/100));
        	}   
		} catch (Exception e) {
			logger.error(e);
		}
    }
    
    public void calculaResultadoTotalTraslado(){
    	try {
    		if (preCotizacionItemDTO!=null){
    			this.preCotizacionDTO.setTrasladoTotal((long) ((this.preCotizacionDTO.getTrasladoValor()*this.preCotizacionDTO.getTrasladoCantidad())));
    		}
		} catch (Exception e) {
			logger.error(e);
		}
    	
//    	if (montoTraslado==null || porcentajeTotalTraslados==null){
//    		return;
//    	}
//    	resultadoTotalTraslado = (long) (montoTraslado*this.porcentajeTotalTraslados);    	
    }
    
    public void calculaCuadroProcentaje(ActionEvent event){
    	logger.debug("Calcula porcentajes...");
    	try {
    		calculaResultadoUtilidad();
        	calculaResultadoTotalTraslado();
        	calculaResultadoMO();
        	calculaResultadoMateriales();
        	calculaResultadoGO();
		} catch (Exception e) {
			logger.error("Error:", e);
		}
    	
    	logger.debug("Fin Calcula porcentajes...");
    }
    
    
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public PreDetalleCotizacionDTO getPreDetalleCotizacionDTO() {
		return preDetalleCotizacionDTO;
	}

	public void setPreDetalleCotizacionDTO(PreDetalleCotizacionDTO preDetalleCotizacionDTO) {
		this.preDetalleCotizacionDTO = preDetalleCotizacionDTO;
	}

	public List<PreDetalleCotizacionDTO> getListPreDetalleCotizacion() {
		return listPreDetalleCotizacion;
	}

	public void setListPreDetalleCotizacion(List<PreDetalleCotizacionDTO> listPreDetalleCotizacion) {
		this.listPreDetalleCotizacion = listPreDetalleCotizacion;
	}

	public PreCotizacionDTO getPreCotizacionDTO() {
		return preCotizacionDTO;
	}

	public void setPreCotizacionDTO(PreCotizacionDTO preCotizacionDTO) {
		this.preCotizacionDTO = preCotizacionDTO;
	}

	public List<PreCotizacionDTO> getListPreCotizacion() {
		return listPreCotizacion;
	}

	public void setListPreCotizacion(List<PreCotizacionDTO> listPreCotizacion) {
		this.listPreCotizacion = listPreCotizacion;
	}

	public List<PlantelDTO> getListPlantel() {
		return listPlantel;
	}

	public void setListPlantel(List<PlantelDTO> listPlantel) {
		this.listPlantel = listPlantel;
	}

	public Integer getIdPlantel() {
		return idPlantel;
	}

	public void setIdPlantel(Integer idPlantel) {
		this.idPlantel = idPlantel;
	}

	public PreCotizacionItemDTO getPreCotizacionItemDTO() {
		return preCotizacionItemDTO;
	}

	public void setPreCotizacionItemDTO(PreCotizacionItemDTO preCotizacionItemDTO) {
		this.preCotizacionItemDTO = preCotizacionItemDTO;
	}

	public List<PreCotizacionItemDTO> getListPreCotizacionItemDTO() {
		return listPreCotizacionItemDTO;
	}

	public void setListPreCotizacionItemDTO(List<PreCotizacionItemDTO> listPreCotizacionItemDTO) {
		this.listPreCotizacionItemDTO = listPreCotizacionItemDTO;
	}
	
}
