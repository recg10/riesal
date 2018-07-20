/**
 * 
 */
package cl.devap.ictWeb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.event.ToggleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.devap.ictCommon.user.PreGuiaDespachoDTO;
import cl.devap.ictCommon.user.PreGuiaDespachoDetalleDTO;
import cl.devap.ictCommon.user.PreMaterialCotizacionDTO;
import cl.devap.ictCommon.user.ProveedorDTO;
import cl.devap.ictLogic.service.GuiaDespachoDetalleService;
import cl.devap.ictLogic.service.GuiaDespachoService;
import cl.devap.ictLogic.service.PreMaterialService;
import cl.devap.ictLogic.service.ProveedorService;
import cl.devap.ictWeb.util.FacesUtils;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean (name="preGuiaDespachoBean")
@ViewScoped
@Component
public class PreGuiaDespachoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(PreGuiaDespachoBean.class);
	
	
	private List<PreGuiaDespachoDTO> listPreGuiaDespachoDTO = new ArrayList<PreGuiaDespachoDTO>();
	private PreGuiaDespachoDTO preGuiaDespachoDTO;
	private PreGuiaDespachoDetalleDTO preGuiaDespachoDetalleDTO;
	private List<PreMaterialCotizacionDTO> listMateriales;
	private ProveedorDTO proveedorDTO;
	private String leyenda="Crear";
	private Long idGuia;
	
	private List<ProveedorDTO> listProveedores;
   
	 @Autowired
	 private GuiaDespachoService preGuiaDespachoService;
	 @Autowired
	 private GuiaDespachoDetalleService preGuiaDespachoDetalleService;
	 @Autowired
	 private PreMaterialService preMaterialService;
	 @Autowired
	 private ProveedorService proveedorService;
	 
	@PostConstruct
	public void init(){
		logger.debug("init...");
		try {
			setProveedorDTO(null);
			setListProveedores(proveedorService.find());
			setListPreGuiaDespachoDTO(preGuiaDespachoService.findAll());
			//Cargo combobox
			listMateriales = preMaterialService.findAll();
		} catch (Exception e) {
			logger.error(e);
		}		
		logger.debug("fin init...");
	}
	
	public void cargarRut() {
		try {
			proveedorDTO = new ProveedorDTO();
			for (ProveedorDTO dto : listProveedores) {
				if (dto.getRut().equals(this.preGuiaDespachoDTO.getRutProveedor())){
					this.setProveedorDTO(dto);
					break;					
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	
	public void agregarDetalle(ActionEvent event) {	
		setPreGuiaDespachoDetalleDTO(new PreGuiaDespachoDetalleDTO());		
	}	
	
	public void guiaDespacho(ActionEvent event) {	
		MenuView menuView = (MenuView)FacesUtils.getManagedBean("menuView");
		menuView.guiaDespacho();
		setPreGuiaDespachoDTO(new PreGuiaDespachoDTO());
//		FacesContext.getCurrentInstance().responseComplete();
	}	
	
	
	
	public void cargarPrecio() {
		try {			
			for (PreMaterialCotizacionDTO preMaterialCotizacionDTO : listMateriales) {
				if (preMaterialCotizacionDTO.getIdMaterialCotizacion().equals(preGuiaDespachoDetalleDTO.getCodigo())){
					preGuiaDespachoDetalleDTO.setValor(preMaterialCotizacionDTO.getPrecio());
					return;
				}
			} 
			
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	
	public void consultar(ActionEvent event) {
		try {
			if (this.idGuia!=null){
				setListPreGuiaDespachoDTO(preGuiaDespachoService.find(this.idGuia));
			}else{
				setListPreGuiaDespachoDTO(preGuiaDespachoService.findAll());
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
			logger.error(e);
		}finally {
	        logger.info("Fin realizarCotizacion");			
		}
	}
	
	public void editarGuiaDespacho(ActionEvent event) {
		try {
			setLeyenda("Modificar");			
			String rowId = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
        	setPreGuiaDespachoDTO(getListPreGuiaDespachoDTO().get(new Integer(rowId)));  
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
			logger.error(e);
		}finally {
	        logger.info("Fin realizarCotizacion");			
		}
	}
	
	public void eliminarGuiaDespacho(ActionEvent event) {
		try {						
			String rowId = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
        	setPreGuiaDespachoDTO(getListPreGuiaDespachoDTO().get(new Integer(rowId)));
        	if (preGuiaDespachoService.delete(getPreGuiaDespachoDTO().getIdGuiaDespacho())){
        		setListPreGuiaDespachoDTO(preGuiaDespachoService.findAll());
        		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado con exito."));
        	}else{
        		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al eliminar guia."));
        	}
        	
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
			logger.error(e);
		}finally {
	        logger.info("Fin realizarCotizacion");			
		}
	}
	
	public void crearGuiaDespacho(ActionEvent event) {		
		setLeyenda("Crear");		
		setPreGuiaDespachoDTO(new PreGuiaDespachoDTO());
	}
	
	public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void updateGuiaDespacho(ActionEvent event) {		
		try {
			if ( preGuiaDespachoService.update(preGuiaDespachoDTO)){
				setListPreGuiaDespachoDTO(preGuiaDespachoService.findAll());
			}
		} catch (Exception e) {
			logger.error(e);
		}		
	}
	
	
	
	public void saveGuiaDespachoDetalle(ActionEvent event) {	
		FacesMessage message=null;
		try {
			preGuiaDespachoDetalleDTO.setIdGuia(getPreGuiaDespachoDTO().getIdGuiaDespacho());
			int id = preGuiaDespachoDetalleService.save(preGuiaDespachoDetalleDTO);
			logger.debug("preGuiaDespachoDetalle actualizado:"+id);
			if (id>0){
//				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Guia almacenada exitosamente" );
				//Recorro lista de materiales a actualizar con el nuevo stock
				for (PreMaterialCotizacionDTO preMaterialCotizacionDTO : listMateriales) {
					if (preMaterialCotizacionDTO.getIdMaterialCotizacion().equals(preGuiaDespachoDetalleDTO.getCodigo())){
						preMaterialCotizacionDTO.setStock(preGuiaDespachoDetalleDTO.getCantidad()+preMaterialCotizacionDTO.getStock());
						boolean updateMaterial = preMaterialService.update(preMaterialCotizacionDTO);
						message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Guia almacenada exitosamente" );
						logger.debug("Material actualizado:"+updateMaterial);
						getPreGuiaDespachoDTO().setListPreGuiaDespachoDetalleDTO(preGuiaDespachoDetalleService.findByIdGuia(preGuiaDespachoDetalleDTO.getIdGuia().longValue()));
						return;
					}
				}
			}
		} catch (Exception e) {
			 message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar Guia" );
			logger.error(e);
		}
		FacesContext.getCurrentInstance().addMessage(null, message);        
	}
	
	public void saveGuiaDespacho(ActionEvent event) {	
		FacesMessage message=null;
		try {
			LoginBean login = (LoginBean)FacesUtils.getManagedBean("loginBean");
			preGuiaDespachoDTO.setUsuarioRut(new Integer( login.getUsername()));
			int idGuia = preGuiaDespachoService.save(preGuiaDespachoDTO);
			preGuiaDespachoDTO.setIdGuiaDespacho(idGuia);
			if (idGuia>0){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Guia almacenada exitosamente" );
//				setListPreGuiaDespachoDTO(preGuiaDespachoService.findAll());
			}
		} catch (Exception e) {
			 message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar Guia" );
			logger.error(e);
		}
		FacesContext.getCurrentInstance().addMessage(null, message);        
	}
	
	
	public void eliminarGuiaDespachoDtalle(ActionEvent event) {	
	try {						
		String rowId = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
		setPreGuiaDespachoDetalleDTO(getPreGuiaDespachoDTO().getListPreGuiaDespachoDetalleDTO().get(new Integer(rowId)));    	
    	if (preGuiaDespachoDetalleService.delete(getPreGuiaDespachoDetalleDTO().getIdGuiaDespachoDetalle())){    		
    		for (PreMaterialCotizacionDTO preMaterialCotizacionDTO : listMateriales) {
				if (preMaterialCotizacionDTO.getIdMaterialCotizacion().equals(preGuiaDespachoDetalleDTO.getCodigo())){
					preMaterialCotizacionDTO.setStock(preGuiaDespachoDetalleDTO.getCantidad()-preMaterialCotizacionDTO.getStock());
					boolean updateMaterial = preMaterialService.update(preMaterialCotizacionDTO);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado con exito."));
					getPreGuiaDespachoDTO().setListPreGuiaDespachoDetalleDTO(preGuiaDespachoDetalleService.findByIdGuia(preGuiaDespachoDetalleDTO.getIdGuia().longValue()));
					logger.debug("Material eliminado:"+updateMaterial);
					return;
				}
			}
    		
    	}else{
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al eliminar guia."));
    	}
    	
	} catch (Exception e) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		logger.error(e);
	}finally {
        logger.info("Fin realizarCotizacion");			
	}
	}

	public List<PreGuiaDespachoDTO> getListPreGuiaDespachoDTO() {
		return listPreGuiaDespachoDTO;
	}

	public void setListPreGuiaDespachoDTO(List<PreGuiaDespachoDTO> listPreGuiaDespachoDTO) {
		this.listPreGuiaDespachoDTO = listPreGuiaDespachoDTO;
	}

	public PreGuiaDespachoDTO getPreGuiaDespachoDTO() {
		return preGuiaDespachoDTO;
	}

	public void setPreGuiaDespachoDTO(PreGuiaDespachoDTO preGuiaDespachoDTO) {
		this.preGuiaDespachoDTO = preGuiaDespachoDTO;
	}



	public String getLeyenda() {
		return leyenda;
	}



	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}


	public PreGuiaDespachoDetalleDTO getPreGuiaDespachoDetalleDTO() {
		return preGuiaDespachoDetalleDTO;
	}


	public void setPreGuiaDespachoDetalleDTO(PreGuiaDespachoDetalleDTO preGuiaDespachoDetalleDTO) {
		this.preGuiaDespachoDetalleDTO = preGuiaDespachoDetalleDTO;
	}


	public List<PreMaterialCotizacionDTO> getListMateriales() {
		return listMateriales;
	}


	public void setListMateriales(List<PreMaterialCotizacionDTO> listMateriales) {
		this.listMateriales = listMateriales;
	}


	public Long getIdGuia() {
		return idGuia;
	}


	public void setIdGuia(Long idGuia) {
		this.idGuia = idGuia;
	}


	public List<ProveedorDTO> getListProveedores() {
		return listProveedores;
	}


	public void setListProveedores(List<ProveedorDTO> listProveedores) {
		this.listProveedores = listProveedores;
	}

	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	
	
}
