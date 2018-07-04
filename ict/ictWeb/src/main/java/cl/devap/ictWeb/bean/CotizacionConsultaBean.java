/**
 * 
 */
package cl.devap.ictWeb.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PlantelDTO;
import cl.devap.ictCommon.user.PreCotizacionDTO;
import cl.devap.ictCommon.user.PreCotizacionItemDTO;
import cl.devap.ictLogic.service.PlantelService;
import cl.devap.ictLogic.service.PreCotizacionItemService;
import cl.devap.ictLogic.service.PreCotizacionService;
import cl.devap.ictWeb.util.FacesUtils;
import cl.devap.ictWeb.util.JaxbUtil;
import cl.riesal.cotizaOnline.report.ObjectFactory;
import cl.riesal.cotizaOnline.report.Xml;
import cl.riesal.cotizaOnline.report.Xml.Productos;
import cl.riesal.cotizaOnline.report.Xml.Productos.Producto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRXmlUtils;



/**
 * @author rcastro
 * Clase encargada del login del aplicaion y controlar el perfilamiento del usuairo
 */
@ManagedBean (name="cotizacionConsultaBean")
@ViewScoped
@Component
@Scope("view")
public class CotizacionConsultaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PreCotizacionItemDTO preCotizacionItemDTO;
	private PreCotizacionDTO preCotizacionDTO;
	private List<PreCotizacionDTO> listPreCotizacion;
	private List<PlantelDTO> listPlantel;
	private Integer idPlantel;
	
	
	final static Logger logger = Logger.getLogger(CotizacionConsultaBean.class);
	
//    @Autowired
//    private PreDetalleCotizacionService preDetalleCotizacionEJBLocal;
    @Autowired
    private PreCotizacionItemService preCotizacionItemEJBLocal;    
    @Autowired
    private PreCotizacionService preCotizacionEJBLocal;
    @Autowired
    private PlantelService plantelEJBLocal;
	
	@PostConstruct
	public void init(){
		logger.info("init...");
		try {
			//Carga elemttos en la pantalla			
			listPlantel = plantelEJBLocal.findAll();
			preCotizacionDTO = new PreCotizacionDTO();
			preCotizacionItemDTO = new PreCotizacionItemDTO();
			//Carga datos existentes
		
//				try {
//					listPreDetalleCotizacion = preDetalleCotizacionEJBLocal.find(new Long(idCotizacion));
//					calculaTotalDetalleMateriales();					
//				} catch (IctException e) {
//					e.printStackTrace();
//				}				
//				setListPreCotizacionItemDTO(preCotizacionItemEJBLocal.find(new Long(idCotizacion)));
				preCotizacionDTO.setEstado(0);
			
		} catch (Exception e) {
			logger.error(e);
		}
		logger.info("fin init.");
	}
	
	public void consultar(ActionEvent event) {
		logger.info("consultar...");			
		try {
			FacesMessage message = null;			
			listPreCotizacion = preCotizacionEJBLocal.findAll();
	        if(listPreCotizacion.isEmpty()) {	          
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "No hay registros en la consulta.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
	                
		} catch (Exception e) {
			logger.error(e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin consultar");			
		}
    }
	
	public void editarCotizacion(ActionEvent event) {
		System.out.println("editarCotizacion...");		
//		FacesUtils.resetManagedBean("preDetalleCotizacionBean");
//		FacesUtils.resetManagedBean("preFabricacionBean");
//		FacesUtils.resetManagedBean("preMOBean");
//		FacesUtils.resetManagedBean("preCotizacionBean");	
		MenuView menuView = (MenuView)FacesUtils.getManagedBean("menuView");
		menuView.setSeleccion("cotizacion");
		String idCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCotizacion");	
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idCotizacion", new Integer(idCotizacion));
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("common.jsf");
//			FacesUtils.resetManagedBean("preCotizacionBean")
			FacesUtils.removeViewScopedBean("preCotizacionBean");
			
//			FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().put("idCotizacion", idCotizacion);
		} catch (IOException e1) {
			logger.error(e1);
		}        
			
		
    }
	
	public void generarPDF() {
		String idCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCotizacion");	
		logger.debug("generarPDF...idCotizacion:"+idCotizacion);		      
		try {			
			byte[] reporte = null;
			for (PreCotizacionDTO dto : listPreCotizacion) {
				if (Integer.parseInt(idCotizacion)==dto.getIdCotizacion()){
					preCotizacionDTO = dto;
					break;
				}
			}
			ObjectFactory obj = new ObjectFactory();
			
			Xml cotizacion = obj.createXml();
			cotizacion.setArea(preCotizacionDTO.getArea()+"");
			cotizacion.setDescripcionTrabajo(preCotizacionDTO.getDetalleTrabajo()+"");
			cotizacion.setDireccionEmpresa(preCotizacionDTO.getDireccion()+"");
			cotizacion.setFechaCotizacion(preCotizacionDTO.getFecha()+"");
			cotizacion.setNCotizacion(Short.parseShort(idCotizacion));
			cotizacion.setRutEmpresa(preCotizacionDTO.getEmpresa()+"");
			cotizacion.setNombreEmpresa(preCotizacionDTO.getEmpresa()+"");
			cotizacion.setSolicita(preCotizacionDTO.getSupervisor()+"");
			cotizacion.setPlantel(preCotizacionDTO.getPlantel()+"");
			
			List<PreCotizacionItemDTO> list = null;
			try {
				list = preCotizacionItemEJBLocal.find(Long.parseLong(idCotizacion));
			} catch (NumberFormatException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (IctException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			Productos productos = obj.createXmlProductos();
			
			for (PreCotizacionItemDTO preCotizacionItemDTO : list) {
				Producto producto= obj.createXmlProductosProducto();
//				producto.setCantidad(Integer.bitCount(Integer.toBinaryString(preCotizacionItemDTO.getCantidad())));
				producto.setDetalle(preCotizacionItemDTO.getDescripcion());
				producto.setNeto(preCotizacionItemDTO.getCantidad());
//				producto.setValorUnitario(preCotizacionItemDTO.get);
				
				productos.getProducto().add(producto);
			}
			
			cotizacion.setProductos(productos);
			
			JaxbUtil<Xml> jaxb = new JaxbUtil<Xml>(Xml.class);
			String xml = jaxb.getXml(cotizacion);		
			logger.debug("XML::"+xml);		
			Map<String, Object> params = new HashMap<String, Object>();
			Document document = null;
			try {
				document = JRXmlUtils.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
			} catch (UnsupportedEncodingException e) {
				logger.error(e);
			}
			params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
			params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "yyyy-MM-dd");
			params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0.##");
			params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.ENGLISH);
			
			String path= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
 			//F:\desarrollo\java\workspaceFlowMonitor\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ictWeb\
 			
            String rutaJasper=path+"/reporte/Reporte/Cotizacion.jasper";
			
			JasperPrint prt = JasperFillManager.fillReport(rutaJasper, params);
			reporte = JasperExportManager.exportReportToPdf(prt);		
			
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition","attachment;filename=cotizacion+"+idCotizacion+".pdf");
			response.setContentLength(reporte.length);
			ServletOutputStream servletOutputStream = null;
			try {
				servletOutputStream = response.getOutputStream();
				servletOutputStream.write(reporte, 0, reporte.length);
				servletOutputStream.flush();
				servletOutputStream.close();
			} catch (IOException e1) {
				logger.error(e1);
			}        
		} catch (JRException e) {			
			logger.error(e);
		}
      

        FacesContext.getCurrentInstance().responseComplete();
			
		
    }
	
	
	public void generarXLS() {
		String idCotizacion = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCotizacion");
		logger.debug("generarPDF...idCotizacion:"+idCotizacion);
     

		FacesContext context = FacesContext.getCurrentInstance();
		try {			
			byte[] reporte = null;
			for (PreCotizacionDTO dto : listPreCotizacion) {
				if (Integer.parseInt(idCotizacion)==dto.getIdCotizacion()){
					preCotizacionDTO = dto;
					break;
				}
			}
			ObjectFactory obj = new ObjectFactory();
			
			Xml cotizacion = obj.createXml();
			cotizacion.setArea(preCotizacionDTO.getArea()+"");
			cotizacion.setDescripcionTrabajo(preCotizacionDTO.getDetalleTrabajo()!=null?preCotizacionDTO.getDetalleTrabajo():"");
			cotizacion.setDireccionEmpresa(preCotizacionDTO.getDireccion()+"");
			cotizacion.setFechaCotizacion(preCotizacionDTO.getFecha()+"");
			cotizacion.setNCotizacion(Short.parseShort(idCotizacion));
			cotizacion.setRutEmpresa(preCotizacionDTO.getEmpresa()+"");
			cotizacion.setNombreEmpresa(preCotizacionDTO.getEmpresa()!=null?preCotizacionDTO.getEmpresa():"");
			cotizacion.setSolicita(preCotizacionDTO.getSupervisor()+"");
			cotizacion.setPlantel(preCotizacionDTO.getPlantel()+"");
			
			List<PreCotizacionItemDTO> list = null;
			try {
				list = preCotizacionItemEJBLocal.find(Long.parseLong(idCotizacion));
			} catch (NumberFormatException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (IctException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			Productos productos = obj.createXmlProductos();
			
			for (PreCotizacionItemDTO preCotizacionItemDTO : list) {
				Producto producto= obj.createXmlProductosProducto();
				producto.setCantidad(preCotizacionItemDTO.getCantidad());
				producto.setDetalle(preCotizacionItemDTO.getDescripcion());
				producto.setNeto(preCotizacionItemDTO.getTotalNeto().intValue());
				producto.setValorUnitario(preCotizacionItemDTO.getValorUnitario().intValue());				
				productos.getProducto().add(producto);
			}		
			cotizacion.setProductos(productos);
			
			
			//Calculo de totales
			/**
			 * valor mano obra técnicos maestros y ayudantes 					
				materiales ferreterías y/o maquinarias arrendadas por RIESAL limitada					
				Traslados del personal ejecutando obra					
 				Gasto operacional y visitas supervisor , prevencionista 					
				Utilidad RIESAL Ltda.				

			 * **/
			
			PreCotizacionBean preCotizacionBean = (PreCotizacionBean)FacesUtils.getManagedBean("preCotizacionBean");		
			
			try {
				Double MO = (double) (preCotizacionBean.getTotalMOPresupuesto() +  preCotizacionDTO.getMoResult());
				cotizacion.setValorManoObra(MO.intValue());
			} catch (Exception e) {
				cotizacion.setValorManoObra(0);
				logger.error(e);
			}
			
			try {
				Double detalleMateriales = (double) (preCotizacionBean.getTotalMaterialesPresupuesto() + preCotizacionDTO.getMaterialesResult());
				cotizacion.setValorMateriales(detalleMateriales.intValue());
			} catch (Exception e) {
				cotizacion.setValorMateriales(0);
				logger.error(e);
			}
			
			try {
				Double utildad = preCotizacionDTO.getUtilidadResult().doubleValue();
				cotizacion.setUtilidad(utildad.intValue());
			} catch (Exception e) {
				cotizacion.setUtilidad(0);
				logger.error(e);
			}
			
			
			try {
				Double traslado = preCotizacionDTO.getTrasladoTotal().doubleValue();
				cotizacion.setValorTraslado(traslado.intValue());
			} catch (Exception e) {
				cotizacion.setValorTraslado(0);
				logger.error(e);
			}
			
			try {
				Double go =  preCotizacionDTO.getGoResult().doubleValue();
				cotizacion.setGastoOperacional(go.intValue());
			} catch (Exception e) {
				cotizacion.setGastoOperacional(0);
				logger.error(e);
			}
			
			
			 
			cotizacion.setTotalNeto(preCotizacionDTO.getTotalPresupuesto().intValue());
			
			
			
			
			JaxbUtil<Xml> jaxb = new JaxbUtil<Xml>(Xml.class);
			String xml = jaxb.getXml(cotizacion);		
			logger.debug("XML::"+xml);			
				HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
                 System.out.println("-----INICIADO REPORTE ----------");
                 
                 Map<String, Object> params = new HashMap<String, Object>();
     			Document document = null;
     			try {
     				document = JRXmlUtils.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
     			} catch (UnsupportedEncodingException e) {
     				logger.error(e);
     			}
     			params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
     			params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "yyyy-MM-dd");
     			params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0.##");
     			params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.ENGLISH);
//                 
//                 JasperPrint jasperPrint = JasperFillManager.fillReport(RUTA_REPORTES + File.separator + "TipoDeProblema.jasper", parameters, new dsProblemas(dataReport));
//                 JasperPrint jasperPrint = JasperFillManager.fillReport("F:/desarrollo/java/workspaceFlowMonitor/ictWeb/src/main/webapp/reporte/Reporte/Cotizacion.jasper", parameters, new dsProblemas(dataReport));
//     			String path= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
     			///ictWeb
     			String path= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
     			//F:\desarrollo\java\workspaceFlowMonitor\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ictWeb\
     			
                 JasperPrint jasperPrint = JasperFillManager.fillReport(path+"/reporte/Reporte/Cotizacion.jasper", params);
                 String xlsFileName = "cotizacion+"+idCotizacion+".xls";
                 JRXlsExporter exporter = new JRXlsExporter();
                 exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                 exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, xlsFileName);
                 exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
                 exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                 exporter.exportReport();
                 File file = new File(xlsFileName);
                 response.setContentType("application/vnd.ms-excel");
                 response.setHeader("Content-Disposition", "attachment;filename=\"" + xlsFileName + "\"");
                 InputStream inputStream = null;
				try {
					inputStream = new FileInputStream(file);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                 ServletOutputStream outputStream = null;
				try {
					outputStream = response.getOutputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 int bit = 256;
                 
                 while (bit >= 0) {
                     try {
						bit = inputStream.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                     try {
						outputStream.write(bit);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                 }
                 try {
					outputStream.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 try {
					outputStream.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
                 return;    
		} catch (JRException e) {			
			logger.error(e);
		}
        FacesContext.getCurrentInstance().responseComplete();		
    }
	
	
	public void realizarCotizacion(ActionEvent event) {
		logger.debug("realizarCotizacion...");
		try {
			FacesUtils.resetManagedBean("preDetalleCotizacionBean");
			FacesUtils.resetManagedBean("preFabricacionBean");
			FacesUtils.resetManagedBean("preMOBean");
		} catch (Exception e) {
			logger.error(e);		
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage())); 
		}finally {
	        logger.info("Fin realizarCotizacion");			
		}
    	
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
	
}
