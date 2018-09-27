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
import cl.devap.ictCommon.user.PreDetalleCotizacionDTO;
import cl.devap.ictCommon.user.PreMaterialCotizacionDTO;
import cl.devap.ictLogic.service.PreDetalleCotizacionService;
import cl.devap.ictLogic.service.PreMaterialCotizacionService;
import cl.devap.ictWeb.util.FacesUtils;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean (name="preDetalleCotizacionBean")
@ViewScoped
@Component
@Scope("view")
public class PreDetalleCotizacionBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PreDetalleCotizacionDTO preDetalleCotizacionDTO;    
	private List<PreDetalleCotizacionDTO> listPreDetalleCotizacion;
	
	private String titulo="";
	
	
	final static Logger logger = Logger.getLogger(PreDetalleCotizacionBean.class);
	private String idCotizacion="";
	private String id="";
	private Long totalDetalleCotizacion;
	private List<PreMaterialCotizacionDTO> listMateriales;
	private PreMaterialCotizacionDTO preMaterialCotizacionDTO;
	
    @Autowired
    private PreDetalleCotizacionService preDetalleCotizacionEJBLocal;
    @Autowired
    private PreMaterialCotizacionService preMaterialCotizacionEJBLocal;
	
	@PostConstruct
	public void init(){
		try {
			listMateriales = preMaterialCotizacionEJBLocal.findAll();
			preMaterialCotizacionDTO = new PreMaterialCotizacionDTO();
		} catch (Exception e) {
			logger.error(e);
		}		
		
		idCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formCotizacion:idCotizacion");
		id = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formCotizacion:id");
		
		if (idCotizacion!=null && !"".equals(idCotizacion)){
			preDetalleCotizacionDTO = new PreDetalleCotizacionDTO();
			preDetalleCotizacionDTO.setIdCotizacion(new Integer(idCotizacion));
			if( id!=null && !"".equals(id)){
				try {
					//listPreDetalleCotizacion = preDetalleCotizacionEJBLocal.find(new Long(idCotizacion));
					listPreDetalleCotizacion = preDetalleCotizacionEJBLocal.findByItem(new Long(idCotizacion),new Long( id));
				} catch (IctException e) {
					e.printStackTrace();
				}
			}
			
		}
		calculaTotalPrincipal();
		
	}
	
	public void save(ActionEvent event) {
		System.out.println("save...");
		try {
			FacesMessage message = null;
			if (preDetalleCotizacionDTO.getCantidad()!=null && preDetalleCotizacionDTO.getCantidad().intValue()<=0){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Debe ingresar un valor de Stock mayor a Cero." );
				FacesContext.getCurrentInstance().addMessage(null, message);
				return ;
			}
			
			preDetalleCotizacionDTO.setSubTotal(new Long(preDetalleCotizacionDTO.getCantidad()*preDetalleCotizacionDTO.getValorUnitario()));
			preDetalleCotizacionDTO.setIdCotizacionItem(new Long(id));
	        boolean save =  preDetalleCotizacionEJBLocal.save(preDetalleCotizacionDTO);        
	        if(save) {	        	
	        	for (PreMaterialCotizacionDTO preMaterialCotizacionDTO : listMateriales) {
					if (preMaterialCotizacionDTO.getIdMaterialCotizacion().equals(preDetalleCotizacionDTO.getIdMaterialCotizacion())){
						preMaterialCotizacionDTO.setStock(preMaterialCotizacionDTO.getStock() - preDetalleCotizacionDTO.getCantidad());
						boolean updateMaterial = preMaterialCotizacionEJBLocal.update(preMaterialCotizacionDTO);
						message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro almacenado con exito" );
						logger.debug("Material actualizado:"+updateMaterial);
						setListPreDetalleCotizacion(preDetalleCotizacionEJBLocal.findByItem(new Long(idCotizacion), new Long(id)));
			        	PreCotizacionBean preCotizacionBean = (PreCotizacionBean) FacesUtils.getManagedBean("preCotizacionBean");
			            preCotizacionBean.setListPreDetalleCotizacion(listPreDetalleCotizacion);
//			            preCotizacionBean.calculaTotalDetalleMateriales();
			            calculaTotalPrincipal();
					}
				}         
	        } else {
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al guardar");
	        }         
	        FacesContext.getCurrentInstance().addMessage(null, message);        
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin saveUser");			
		}
    	
    }   
	
	public void update(ActionEvent event) {
		logger.debug("update");
		try {
			FacesMessage message = null;
			preDetalleCotizacionDTO.setIdCotizacionItem(new Long(id));
			preDetalleCotizacionDTO.setSubTotal(new Long(preDetalleCotizacionDTO.getCantidad()*preDetalleCotizacionDTO.getValorUnitario()));
	        boolean save =  preDetalleCotizacionEJBLocal.update(preDetalleCotizacionDTO);        
	        if(save) {   
	        	setListPreDetalleCotizacion(preDetalleCotizacionEJBLocal.findByItem(new Long(idCotizacion), new Long(id)));
	        	PreCotizacionBean preCotizacionBean = (PreCotizacionBean) FacesUtils.getManagedBean("preCotizacionBean");
	            preCotizacionBean.setListPreDetalleCotizacion(listPreDetalleCotizacion);
//	            preCotizacionBean.calculaTotalDetalleMateriales();
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro actualizado con exito" );   
	            calculaTotalPrincipal();
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

	private void calculaTotalPrincipal(){
		Long total = new Long(0);
//		if (listPreDetalleCotizacion==null){
//			return;
//		}
//		for (PreDetalleCotizacionDTO dto : listPreDetalleCotizacion) {
//			total += dto.getSubTotal();
//		}
//		
//		LoginBean loginBean = (LoginBean)FacesUtils.getManagedBean("loginBean");
//		loginBean.setTotalDetalleCotizacion(total);
	}
    
    public void nuevo (ActionEvent event) {
		logger.info("nuevo");
		setTitulo("Crear");
    	setPreDetalleCotizacionDTO(new PreDetalleCotizacionDTO());	
    	preDetalleCotizacionDTO.setIdCotizacion(new Integer(idCotizacion));
    }
    
    public void eliminar (ActionEvent event) {
		logger.info("eliminar");
    	FacesMessage message = null;
    	try {
    		String idDetalleCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idDetalleCotizacion}");    	
        	getPreDetalleCotizacionDTO().setIdDetalleCotizacion(Integer.parseInt(idDetalleCotizacion));
            boolean eliminar =  preDetalleCotizacionEJBLocal.delete(Integer.parseInt(idDetalleCotizacion));
            if(eliminar) {           
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro eliminado con exito" );
                setListPreDetalleCotizacion(preDetalleCotizacionEJBLocal.find(new Long(idCotizacion)));
//                PreCotizacionBean preCotizacionBean = (PreCotizacionBean) FacesUtils.getManagedBean("preCotizacionBean");
//                preCotizacionBean.setListPreDetalleCotizacion(listPreDetalleCotizacion);
//                preCotizacionBean.calculaTotalDetalleMateriales();
                calculaTotalPrincipal();
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al eliminar");
            }         
            FacesContext.getCurrentInstance().addMessage(null, message);  
		} catch (Exception e) {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin eliminar");
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
    
    public String getMaterialId(Integer index){    	
    	for (PreMaterialCotizacionDTO preMaterialCotizacionDTO : listMateriales) {
    		if ( preMaterialCotizacionDTO.getIdMaterialCotizacion().intValue()==index.intValue()){
    			return preMaterialCotizacionDTO.getDescripcion();
    		}
		}
    	return "";
    }
    
    public Long getTotal(){
    	Long total = new Long(0);
    	for (PreDetalleCotizacionDTO preDetalleCotizacionDTO : getListPreDetalleCotizacion()) {
    		preDetalleCotizacionDTO.getSubTotal();
    		total += preDetalleCotizacionDTO.getCantidad()*preDetalleCotizacionDTO.getValorUnitario();
		}
    	return total;
    }
    
    public void cargarMaterial() {
		try {
			preMaterialCotizacionDTO = new PreMaterialCotizacionDTO();
			for (PreMaterialCotizacionDTO preMaterialCotizacionDTO : listMateriales) {
				if (preMaterialCotizacionDTO.getIdMaterialCotizacion().equals(preDetalleCotizacionDTO.getIdMaterialCotizacion())){
					this.preMaterialCotizacionDTO = preMaterialCotizacionDTO;
					this.preDetalleCotizacionDTO.setValorUnitario(preMaterialCotizacionDTO.getPrecio());
					return;
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
    
    public void validaStock() {
		try {			
			if (this.preMaterialCotizacionDTO.getStock()!=null && preDetalleCotizacionDTO.getCantidad()!=null &&
					preDetalleCotizacionDTO.getCantidad().intValue() > this.preMaterialCotizacionDTO.getStock().intValue()) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El valor Ingresado en el campo de STOCK debe ser menor al STOCK ACTUAL.");
				this.preDetalleCotizacionDTO.setCantidad(0);
				FacesContext.getCurrentInstance().addMessage(null, message); 
				return;
				
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

	public List<PreMaterialCotizacionDTO> getListMateriales() {
		return listMateriales;
	}

	public void setListMateriales(List<PreMaterialCotizacionDTO> listMateriales) {
		this.listMateriales = listMateriales;
	}

	public Long getTotalDetalleCotizacion() {
		totalDetalleCotizacion = new Long(0);
		if (listPreDetalleCotizacion!=null && listPreDetalleCotizacion.size()>0){
			for (PreDetalleCotizacionDTO dto : listPreDetalleCotizacion) {				
				totalDetalleCotizacion += dto.getSubTotal();
			}
		}		
		return totalDetalleCotizacion;
	}

	public void setTotalDetalleCotizacion(Long totalDetalleCotizacion) {
		this.totalDetalleCotizacion = totalDetalleCotizacion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PreMaterialCotizacionDTO getPreMaterialCotizacionDTO() {
		return preMaterialCotizacionDTO;
	}

	public void setPreMaterialCotizacionDTO(PreMaterialCotizacionDTO preMaterialCotizacionDTO) {
		this.preMaterialCotizacionDTO = preMaterialCotizacionDTO;
	}

	
}
