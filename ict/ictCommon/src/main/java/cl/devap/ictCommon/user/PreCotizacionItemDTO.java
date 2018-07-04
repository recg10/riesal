/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class PreCotizacionItemDTO implements Serializable{	
	
	/**
	 * 
	 * 
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
	private static final long serialVersionUID = 1L;
	
	private Integer idCotizacion;	
	private Long idItem;
	private Long id;
	private String descripcion;
	private Integer cantidad;
	private Long totalNeto;
	private Long valorUnitario;
	
	
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
	public Long getTotalNeto() {
		return totalNeto;
	}
	public void setTotalNeto(Long totalNeto) {
		this.totalNeto = totalNeto;
	}
	public Long getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Long valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

}
