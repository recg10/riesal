/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class PreGuiaDespachoDetalleDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idGuiaDespachoDetalle;	
	private Integer idGuia;	
	private Integer codigo;	
	private Integer cantidad;	
	private Integer valor;	
	private Double descuento;	
	private Long total;
	
	public Integer getIdGuiaDespachoDetalle() {
		return idGuiaDespachoDetalle;
	}
	public void setIdGuiaDespachoDetalle(Integer idGuiaDespachoDetalle) {
		this.idGuiaDespachoDetalle = idGuiaDespachoDetalle;
	}
	public Integer getIdGuia() {
		return idGuia;
	}
	public void setIdGuia(Integer idGuia) {
		this.idGuia = idGuia;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public Long getTotal() {
		try {
			long totalCalculado = this.cantidad*this.valor;
			double descuento = (((totalCalculado)*this.descuento)/100);
			this.total = (long) (totalCalculado - descuento);
		} catch (Exception e) {
			this.total=new Long(0);
		}		
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PreGuiaDespachoDetalleDTO [idGuiaDespachoDetalle=" + idGuiaDespachoDetalle + ", idGuia=" + idGuia
				+ ", codigo=" + codigo + ", cantidad=" + cantidad + ", valor=" + valor + ", descuento=" + descuento
				+ ", total=" + total + "]";
	}
	
}
