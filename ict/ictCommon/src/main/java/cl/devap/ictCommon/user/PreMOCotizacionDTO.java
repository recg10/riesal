/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class PreMOCotizacionDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPreMoCotizacion;
	private Integer cantidad;
	private Integer horas;
	private Integer valorHora;
	private Integer idTrabajdor;
	private Integer idCotizacion;
	private Long subTotal;	
	private Long idCotizacionItem;
	
	
	
	public Long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Long subTotal) {
		this.subTotal = subTotal;
	}
	public Integer getIdPreMoCotizacion() {
		return idPreMoCotizacion;
	}
	public void setIdPreMoCotizacion(Integer idPreMoCotizacion) {
		this.idPreMoCotizacion = idPreMoCotizacion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public Integer getValorHora() {
		return valorHora;
	}
	public void setValorHora(Integer valorHora) {
		this.valorHora = valorHora;
	}
	public Integer getIdTrabajdor() {
		return idTrabajdor;
	}
	public void setIdTrabajdor(Integer idTrabajdor) {
		this.idTrabajdor = idTrabajdor;
	}
	public Integer getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	@Override
	public String toString() {
		return "PreMOCotizacionDTO [idPreMoCotizacion=" + idPreMoCotizacion + ", cantidad=" + cantidad + ", horas="
				+ horas + ", valorHora=" + valorHora + ", idTrabajdor=" + idTrabajdor + ", idCotizacion=" + idCotizacion
				+ ", subTotal=" + subTotal + "]";
	}
	public Long getIdCotizacionItem() {
		return idCotizacionItem;
	}
	public void setIdCotizacionItem(Long idCotizacionItem) {
		this.idCotizacionItem = idCotizacionItem;
	}
	
	
	
	
}
