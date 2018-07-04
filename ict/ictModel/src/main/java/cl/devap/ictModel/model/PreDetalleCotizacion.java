package cl.devap.ictModel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="pre_detalle_cotizacion")
public class PreDetalleCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID_DETALLE_COTIZACION", nullable = false, insertable = true)
	private Integer idDetalleCotizacion;
	@Column (name = "ID_MATERIAL_COTIZACION")
	private Integer idMaterialCotizacion;
	@Column (name = "CANTIDAD")
	private Integer cantidad;
	@Column (name = "VALOR_UNITARIO")
	private Integer valorUnitario;
	@Column (name = "ID_COTIZACION")
	private Integer idCotizacion;
	@Column (name = "ID_COTIZACION_ITEM")
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
	public Long getIdCotizacionItem() {
		return idCotizacionItem;
	}
	public void setIdCotizacionItem(Long idCotizacionItem) {
		this.idCotizacionItem = idCotizacionItem;
	}
	
	
}