/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class PreMaterialCotizacionDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idMaterialCotizacion;	
	private String descripcion;
	private Integer precio;
	private Integer stock;
	private Integer stockCritico;
	private PreMaterialTipoDTO preMaterialTipoDTO;
	private Integer proveedorRut;
	private String nombreProveedor;
	
	
		
	public Integer getIdMaterialCotizacion() {
		return idMaterialCotizacion;
	}
	public void setIdMaterialCotizacion(Integer idMaterialCotizacion) {
		this.idMaterialCotizacion = idMaterialCotizacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getStockCritico() {
		return stockCritico;
	}
	public void setStockCritico(Integer stockCritico) {
		this.stockCritico = stockCritico;
	}
	public PreMaterialTipoDTO getPreMaterialTipoDTO() {
		return preMaterialTipoDTO;
	}
	public void setPreMaterialTipoDTO(PreMaterialTipoDTO preMaterialTipoDTO) {
		this.preMaterialTipoDTO = preMaterialTipoDTO;
	}
	@Override
	public String toString() {
		return "PreMaterialCotizacionDTO [idMaterialCotizacion=" + idMaterialCotizacion + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", stock=" + stock + ", stockCritico=" + stockCritico + ", preMaterialTipoDTO="
				+ preMaterialTipoDTO + "]";
	}
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public Integer getProveedorRut() {
		return proveedorRut;
	}
	public void setProveedorRut(Integer proveedorRut) {
		this.proveedorRut = proveedorRut;
	}
	
	
}
