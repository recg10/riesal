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
	
	
}
