/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class PreFabricacionCotizacionDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPreFabricacion;
	private Integer idTrabajador;
	private Integer idPreMaterialItem;
	private Integer unidad;
	private Long precio;
	private Integer valorHora;
	private Integer tipo;
	private Integer idCotizacion;
	private Long idCotizacionItem;
	private Long subTotal;
	
	public Long getIdPreFabricacion() {
		return idPreFabricacion;
	}
	public void setIdPreFabricacion(Long idPreFabricacion) {
		this.idPreFabricacion = idPreFabricacion;
	}
	public Integer getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(Integer idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
	public Integer getIdPreMaterialItem() {
		return idPreMaterialItem;
	}
	public void setIdPreMaterialItem(Integer idPreMaterialItem) {
		this.idPreMaterialItem = idPreMaterialItem;
	}
	public Integer getUnidad() {
		return unidad;
	}
	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public Integer getValorHora() {
		return valorHora;
	}
	public void setValorHora(Integer valorHora) {
		this.valorHora = valorHora;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public Integer getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	public Long getIdCotizacionItem() {
		return idCotizacionItem;
	}
	public void setIdCotizacionItem(Long idCotizacionItem) {
		this.idCotizacionItem = idCotizacionItem;
	}
	@Override
	public String toString() {
		return "PreFabricacionCotizacionDTO [idPreFabricacion=" + idPreFabricacion + ", idTrabajador=" + idTrabajador
				+ ", idPreMaterialItem=" + idPreMaterialItem + ", unidad=" + unidad + ", precio=" + precio
				+ ", valorHora=" + valorHora + ", tipo=" + tipo + ", idCotizacion=" + idCotizacion
				+ ", idCotizacionItem=" + idCotizacionItem + "]";
	}
	public Long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Long subTotal) {
		this.subTotal = subTotal;
	}
	
	
	
	
}
