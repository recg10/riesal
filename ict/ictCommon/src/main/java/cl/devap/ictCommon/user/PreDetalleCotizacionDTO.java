/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class PreDetalleCotizacionDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idDetalleCotizacion;	
	private Integer idMaterialCotizacion;	
	private Integer cantidad;	
	private Integer valorUnitario;	
	private Integer idCotizacion;
	private Long subTotal;
	private Long idCotizacionItem;
	
	
	public Integer getIdDetalleCotizacion() {
		return idDetalleCotizacion;
	}
	public void setIdDetalleCotizacion(Integer idDetalleCotizacion) {
		this.idDetalleCotizacion = idDetalleCotizacion;
	}
	public Integer getIdMaterialCotizacion() {
		return idMaterialCotizacion;
	}
	public void setIdMaterialCotizacion(Integer idMaterialCotizacion) {
		this.idMaterialCotizacion = idMaterialCotizacion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Integer valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Integer getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	
	@Override
	public String toString() {
		return "PreDetalleCotizacionDTO [idDetalleCotizacion=" + idDetalleCotizacion + ", idMaterialCotizacion="
				+ idMaterialCotizacion + ", cantidad=" + cantidad + ", valorUnitario=" + valorUnitario
				+ ", idCotizacion=" + idCotizacion + "]";
	}
	public Long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Long subTotal) {
		this.subTotal = subTotal;
	}
	public Long getIdCotizacionItem() {
		return idCotizacionItem;
	}
	public void setIdCotizacionItem(Long idCotizacionItem) {
		this.idCotizacionItem = idCotizacionItem;
	}
	
	
	
	
	
}
