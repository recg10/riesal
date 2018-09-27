/**
 * 
 */
package cl.devap.ictWeb.bean;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.hibernate.id.ForeignGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.Connection;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreMaterialCotizacionDTO;
import cl.devap.ictCommon.user.PreMaterialTipoDTO;
import cl.devap.ictCommon.user.ProveedorDTO;
import cl.devap.ictLogic.service.PreMaterialService;
import cl.devap.ictLogic.service.PreMaterialTipoService;
import cl.devap.ictLogic.service.ProveedorService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean (name="mantenedorMaterialesBean")
@ViewScoped
@Component
@Scope("view")
public class MantenedorMaterialesBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String rutParameter;
	final static Logger logger = Logger.getLogger(MantenedorMaterialesBean.class);
	private List<PreMaterialCotizacionDTO> listMateriales= new ArrayList<PreMaterialCotizacionDTO>();
	private PreMaterialCotizacionDTO preMaterialCotizacionDTO;
	private List<PreMaterialTipoDTO> listMaterialTipo;
	private Integer idMaterialTipo;
	private String titulo="";
	private List<ProveedorDTO> listProveedores;

    @Autowired
	private PreMaterialService preMaterialService;
    @Autowired
   	private PreMaterialTipoService preMaterialTipoService;
    @Autowired
	 private ProveedorService proveedorService;
	
	@PostConstruct
	public void init(){
		logger.info("INIT...");		 
		preMaterialCotizacionDTO = new PreMaterialCotizacionDTO();
		try {
			setListMateriales(preMaterialService.findAll());
			setListMaterialTipo(preMaterialTipoService.findAll());
			setListProveedores(proveedorService.find());
		} catch (IctException e) {
			logger.error(e);
		}
	}
	
	public void save(ActionEvent event) {
		logger.info("save");
    	FacesMessage message = null;     
    	try {
    		if (idMaterialTipo!=null){
    			PreMaterialTipoDTO preMaterialTipoDTO= new PreMaterialTipoDTO();
    			preMaterialTipoDTO.setIdMaterialTipo(idMaterialTipo);
				preMaterialCotizacionDTO.setPreMaterialTipoDTO(preMaterialTipoDTO);
    		}
    		Integer save = preMaterialService.save(preMaterialCotizacionDTO);
            if(save.intValue()>0) { 
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro almacenado con exito" );
                preMaterialCotizacionDTO.setIdMaterialCotizacion(save);
//                listMateriales.add(preMaterialCotizacionDTO);
                setListMateriales(preMaterialService.findAll());
//                for (PreMaterialCotizacionDTO dto : listMateriales) {
//                	for (ProveedorDTO dtoProveedor : listProveedores) {
//                		if (dto.getProveedorRut().equals(dtoProveedor.getRut())){
//                			dto.setNombreProveedor(dtoProveedor.get);
//                		}
//                		
//					}					
//				}
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al guardar");
            }         
            FacesContext.getCurrentInstance().addMessage(null, message);  
		} catch (Exception e) {
			logger.error(e);
		}
         
        logger.info("fin save");
    }
	
	public void eliminar (ActionEvent event) {
		logger.info("eliminar");
    	FacesMessage message = null;
    	try {
//        	String idMaterial = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idMaterialCotizacion");
        	String rowId = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
        	preMaterialCotizacionDTO = getListMateriales().get(new Integer(rowId));
            boolean eliminar =  preMaterialService.delete(preMaterialCotizacionDTO.getIdMaterialCotizacion());        
            if(eliminar) {           
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro eliminar con exito" );                
//                listMateriales.remove(preMaterialCotizacionDTO);
                setListMateriales(preMaterialService.findAll());
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al eliminar");
            }         
            FacesContext.getCurrentInstance().addMessage(null, message);    
		} catch (Exception e) {
			logger.error(e);
		}

        logger.info("Fin eliminar");
    }
	
	public void editar (ActionEvent event) {
    	FacesMessage message = null;
    	String id = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idMaterialCotizacion");
    	setTitulo("Modificar");
    	for (PreMaterialCotizacionDTO obj :  getListMateriales()) {
			if (obj.getIdMaterialCotizacion()==Integer.parseInt(id)){
				setPreMaterialCotizacionDTO(obj);
				this.setIdMaterialTipo(obj.getPreMaterialTipoDTO().getIdMaterialTipo());
				break;
			}
		}  
    }
	
	public void modificar (ActionEvent event) {
		logger.info("modificar");
		FacesMessage message = null;
		try {
			if (idMaterialTipo!=null){
    			PreMaterialTipoDTO preMaterialTipoDTO= new PreMaterialTipoDTO();
    			preMaterialTipoDTO.setIdMaterialTipo(idMaterialTipo);
				preMaterialCotizacionDTO.setPreMaterialTipoDTO(preMaterialTipoDTO);
    		}
			
			boolean update =  preMaterialService.update(preMaterialCotizacionDTO);
			 if(update) {           
		            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro modificado con exito" );
//		            listMateriales.add(preMaterialCotizacionDTO);
		            setListMateriales(preMaterialService.findAll());
		    		logger.info("modificar:"+update);
		        } else {
		            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al modificado");
		        }    
			 FacesContext.getCurrentInstance().addMessage(null, message);    
		} catch (Exception e) {
			logger.error(e);
		}
		
		logger.info("Fin modificar");
    }
	
	public boolean getBotonVisible(){
		if (titulo!=null && "Crear".equals(titulo)){
			return true;
		}else{
			return false;
		}
	} 
	
	public void nuevo (ActionEvent event) {
		logger.info("nuevo");
		setTitulo("Crear");
    	setPreMaterialCotizacionDTO(new PreMaterialCotizacionDTO());		  
    }
	
	public void generarContratoPDF(ActionEvent event) {
		logger.info("generarContratoPDF");
    	FacesMessage message = null;
//        FacesContext.getCurrentInstance().addMessage(null, message);
        Connection conexion=null;
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error("Errror reporte", e);
		}
        try {
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/flowmon", "root", "root");
		} catch (SQLException e) {
			logger.error("Errror reporte", e);
		}
        JasperReport reporte;
		try {
			reporte = (JasperReport) JRLoader.loadObject("reporte1.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
	        JRExporter exporter = new JRPdfExporter();
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportePDF.pdf"));
	        exporter.exportReport();
		} catch (JRException e) {
			logger.error("Errror reporte", e);
		}
        
        logger.info("fin generarContratoPDF");
    }

	public String getRutParameter() {
		return rutParameter;
	}

	public void setRutParameter(String rutParameter) {
		this.rutParameter = rutParameter;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<PreMaterialCotizacionDTO> getListMateriales() {
		return listMateriales;
	}

	public void setListMateriales(List<PreMaterialCotizacionDTO> listMateriales) {
		this.listMateriales = listMateriales;
	}

	public PreMaterialCotizacionDTO getPreMaterialCotizacionDTO() {
		return preMaterialCotizacionDTO;
	}

	public void setPreMaterialCotizacionDTO(PreMaterialCotizacionDTO preMaterialCotizacionDTO) {
		this.preMaterialCotizacionDTO = preMaterialCotizacionDTO;
	}

	public List<PreMaterialTipoDTO> getListMaterialTipo() {
		return listMaterialTipo;
	}

	public void setListMaterialTipo(List<PreMaterialTipoDTO> listMaterialTipo) {
		this.listMaterialTipo = listMaterialTipo;
	}

	public Integer getIdMaterialTipo() {
		return idMaterialTipo;
	}

	public void setIdMaterialTipo(Integer idMaterialTipo) {
		this.idMaterialTipo = idMaterialTipo;
	}

	public List<ProveedorDTO> getListProveedores() {
		return listProveedores;
	}

	public void setListProveedores(List<ProveedorDTO> listProveedores) {
		this.listProveedores = listProveedores;
	}
}
