package cl.devap.ictModel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




/**
 * The persistent class for the user database table.
 * 
CREATE TABLE `pre_material_cotizacion` (
  `ID_MATERIAL_COTIZACION` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  `PRECIO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_MATERIAL_COTIZACION`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1

 * 
 */
@Entity
@Table(name="pre_material_cotizacion")
public class PreMaterialCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID_MATERIAL_COTIZACION", nullable = false, insertable = true)
	private Integer idMaterialCotizacion;
	@Column (name = "DESCRIPCION")
	private String descripcion;
	@Column (name = "PRECIO")
	private Integer precio;
	@Column (name = "STOCK")
	private Integer stock;
	@Column (name = "STOCK_CRITICO")
	private Integer stockCritico;
	
	@JoinColumn (name = "PROVEEDOR_RUT")
	@ManyToOne(fetch=FetchType.LAZY)
	private Proveedor proveedor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_MATERIAL_TIPO")
	private PreMaterialTipo preMaterialTipo;
	
	public Integer getIdMaterialCotizacion() {
		return idMaterialCotizacion;
	}
	public void setIdMaterialCotizacion(Integer idMaterialCotizacion) {
		this.idMaterialCotizacion = idMaterialCotizacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "PreMaterialCotizacion [idMaterialCotizacion=" + idMaterialCotizacion + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getStockCritico() {
		return stockCritico;
	}
	public void setStockCritico(Integer stockCritico) {
		this.stockCritico = stockCritico;
	}
	public PreMaterialTipo getPreMaterialTipo() {
		return preMaterialTipo;
	}
	public void setPreMaterialTipo(PreMaterialTipo preMaterialTipo) {
		this.preMaterialTipo = preMaterialTipo;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
}