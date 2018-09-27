package cl.devap.ictModel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 *
CREATE TABLE `pre_fabricacion_cotizacion` (
  `ID_PRE_FABRICACION` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TRABAJADOR` int(11) DEFAULT NULL,
  `ID_PRE_MATERIAL_ITEM` int(11) DEFAULT NULL,
  `UNIDAD` int(11) DEFAULT NULL,
  `PRECIO` int(11) DEFAULT NULL,
  `VALOR_HORA` int(11) NOT NULL,
  `TIPO` int(11) NOT NULL,
  `ID_COTIZACION` int(11) NOT NULL,
  ID_COTIZACION_ITEM
  PRIMARY KEY (`ID_PRE_FABRICACION`),
  KEY `FK_PRE_FABRICACION_ITEM` (`ID_PRE_MATERIAL_ITEM`),
  KEY `FK_FAB_ID_COTIZACION` (`ID_COTIZACION`),
  CONSTRAINT `FK_FAB_ID_COTIZACION` FOREIGN KEY (`ID_COTIZACION`) REFERENCES `pre_cotizacion` (`ID_COTIZACION`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
 * 
 */
@Entity
@Table(name="pre_fabricacion_cotizacion")
public class PreFabricacionCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID_PRE_FABRICACION", nullable = false, insertable = true)
	private Long idPreFabricacion;
	@Column (name = "ID_TRABAJADOR")
	private Integer idTrabajador;
	@Column (name = "ID_PRE_MATERIAL_ITEM")
	private Integer idPreMaterialItem;
	@Column (name = "UNIDAD")
	private Integer unidad;
	@Column (name = "PRECIO")
	private Long precio;
	@Column (name = "VALOR_HORA")
	private Integer valorHora;
	@Column (name = "TIPO")
	private Integer tipo;
	@Column (name = "ID_COTIZACION")
	private Integer idCotizacion;	
	@Column (name = "ID_COTIZACION_ITEM")
	private Long idCotizacionItem;
	
	
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
	
	
	
}