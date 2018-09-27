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
 * CREATE TABLE `pre_mo_cotizacion` (
  `ID_PRE_MO_COTIZACION` int(11) NOT NULL AUTO_INCREMENT,
  `ID_COTIZACION` int(11) DEFAULT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `HORAS` int(11) DEFAULT NULL,
  `VALOR_HORA` int(11) DEFAULT NULL,
  `ID_TRABAJADOR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PRE_PRESUPUESTO`),
  KEY `FK_PRE_ID_COTIZACION` (`ID_COTIZACION`),
  CONSTRAINT `FK_PRE_ID_COTIZACION` FOREIGN KEY (`ID_COTIZACION`) REFERENCES `pre_cotizacion` (`ID_COTIZACION`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

 * 
 */
@Entity
@Table(name="pre_mo_cotizacion")
public class PreMOCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID_PRE_MO_COTIZACION", nullable = false, insertable = true)
	private Integer idPreMoCotizacion;
	@Column (name = "CANTIDAD")
	private Integer cantidad;
	@Column (name = "HORAS")
	private Integer horas;
	@Column (name = "VALOR_HORA")
	private Integer valorHora;
	@Column (name = "ID_TRABAJADOR")
	private Integer idTrabajdor;
	@Column (name = "ID_COTIZACION")
	private Integer idCotizacion;
	@Column (name = "ID_COTIZACION_ITEM")
	private Long idCotizacionItem;
	
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
		return "PreMOCotizacion [idPreMoCotizacion=" + idPreMoCotizacion + ", cantidad=" + cantidad + ", horas=" + horas
				+ ", valorHora=" + valorHora + ", idTrabajdor=" + idTrabajdor + ", idCotizacion=" + idCotizacion + "]";
	}
	public Long getIdCotizacionItem() {
		return idCotizacionItem;
	}
	public void setIdCotizacionItem(Long idCotizacionItem) {
		this.idCotizacionItem = idCotizacionItem;
	}
	
	
	
	
}