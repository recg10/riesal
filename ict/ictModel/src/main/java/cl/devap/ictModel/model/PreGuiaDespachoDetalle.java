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
CREATE TABLE `pre_guiadespachodetalle` (
  `ID_GUIA_DESPACHO_DETALLE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_GUIA` int(11) DEFAULT NULL,
  `CODIGO` int(11) DEFAULT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `VALOR` int(11) DEFAULT NULL,
  `DESCUENTO` double DEFAULT NULL,
  `TOTAL` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_GUIA_DESPACHO_DETALLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 * 
 */
@Entity
@Table(name="pre_guiadespachodetalle")
public class PreGuiaDespachoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID_GUIA_DESPACHO_DETALLE", nullable = false, insertable = true)
	private Integer idGuiaDespachoDetalle;
	@Column (name = "ID_GUIA")
	private Integer idGuia;
	@Column (name = "CODIGO")
	private Integer codigo;
	@Column (name = "CANTIDAD")
	private Integer cantidad;
	@Column (name = "VALOR")
	private Integer valor;
	@Column (name = "DESCUENTO")
	private Double descuento;
	@Column (name = "TOTAL")
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
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	

	
}