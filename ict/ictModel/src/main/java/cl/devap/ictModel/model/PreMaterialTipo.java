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
CREATE TABLE `pre_material_tipo` (
  `ID_MATERIAL_TIPO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_MATERIAL_TIPO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


 * 
 */
@Entity
@Table(name="pre_material_tipo")
public class PreMaterialTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID_MATERIAL_TIPO", nullable = false, insertable = true)
	private Integer idMaterialTipo;
	@Column (name = "DESCRIPCION")
	private String descripcion;
	
	public Integer getIdMaterialTipo() {
		return idMaterialTipo;
	}
	public void setIdMaterialTipo(Integer idMaterialTipo) {
		this.idMaterialTipo = idMaterialTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "PreMaterialTipo [idMaterialTipo=" + idMaterialTipo + ", descripcion=" + descripcion + "]";
	}
	
	
}