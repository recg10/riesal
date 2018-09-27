package cl.devap.ictModel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * The persistent class for the user database table.
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_COTIZACION` int(11) NOT NULL DEFAULT '0',
  `ID_ITEM` int(11) NOT NULL DEFAULT '0',
  `DESCRIPCION` varchar(200) NOT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `MO_PORC` double DEFAULT NULL,
  `MO_RESULT` int(11) DEFAULT NULL,
  `MATERIALES_PORC` double DEFAULT NULL,
  `MATERIALES_RESULT` int(11) DEFAULT NULL,
  `TRASLADO_VALOR` int(11) DEFAULT NULL,
  `TRASLADO_CANTIDAD` int(11) DEFAULT NULL,
  `GO_PORC` double DEFAULT NULL,
  `GO_RESULT` int(11) DEFAULT NULL,
  `UTILIDAD_PORC` double DEFAULT NULL,
  `UTILIDAD_RESULT` int(11) DEFAULT NULL,
  `TOTAL` bigint(20) DEFAULT NULL,
 * 
 */
@Entity
@Table(name="pre_cotizacion_item")
public class PreCotizacionItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column (name = "ID", nullable = false, insertable = true)
	private Long id;	
	@Column (name = "ID_COTIZACION")
	private Integer idCotizacion;
	@Column (name = "ID_ITEM")
	private Long idItem;
	@Column (name = "DESCRIPCION")
	private String descripcion;
	@Column (name = "CANTIDAD")
	private Integer cantidad;
	
	
	
	
	
	
	public Integer getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}