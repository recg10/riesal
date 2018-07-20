package cl.devap.ictWeb.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cl.devap.ictWeb.util.FacesUtils;

@SessionScoped
@ManagedBean (name="menuView")
public class MenuView {
	
	private String seleccion="cotizacion";
 
    public void save() {
        addMessage("Success", "Data saved");
    }
 
    public void update() {
        addMessage("Success", "Data updated");
    }
    
    public void crearCotizacion() {
    	resetBeans();			
    	seleccion="cotizacion";
    }
    
    public void consultarCotizacion() {
    	resetBeans();
		seleccion="cotizacionConsultar";   	
    }
    
    public void mantenedorMateriales() {
    	resetBeans();
		seleccion="mantenedorMateriales";
    }
    
 
    public void mantenedorUsuarios() {
    	resetBeans();
		seleccion="mantenedorUsuarios";
    }

    public void guiaDespacho() {
    	resetBeans();
		seleccion="guiaDespacho";
    }
    
    public void guiaDespachoConsulta() {
    	resetBeans();
		seleccion="guiaDespachoConsulta";
    }
    
    public void mantenedorProveedor() {
    	resetBeans();
		seleccion="mantenedorProveedor";
    }
    
    
    
	private void resetBeans() {
		FacesUtils.removeViewScopedBean("preCotizacionBean");
		FacesUtils.removeViewScopedBean("preDetalleCotizacionBean");
		FacesUtils.removeViewScopedBean("preFabricacionBean");
		FacesUtils.removeViewScopedBean("preMOBean");
		FacesUtils.removeViewScopedBean("userBean");
		FacesUtils.removeViewScopedBean("guiaDespachoBean");
		FacesUtils.removeViewScopedBean("mantenedorMaterialesBean");
		FacesUtils.removeViewScopedBean("cotizacionConsultaBean");
		FacesUtils.removeViewScopedBean("proveedorBean");
		FacesUtils.removeViewScopedBean("preGuiaDespachoBean");		
		
	}
 
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public String getSeleccion() { 
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}
    
}