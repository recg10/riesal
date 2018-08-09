package cl.devap.ictModel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/**
CREATE TABLE `pre_parametro` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(200) NOT NULL DEFAULT '0',
  `TEXTO` varchar(200) NOT NULL,
  `NUMERICO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
 * 
 */
@Entity
@Table(name="pre_parametro")
public class PreParametro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "id", nullable = false, insertable = true)
	private Integer id;
	@Column (name = "NOMBRE")
	private String nombre;
	@Column (name = "TEXTO")
	private String texto;
	@Column (name = "NUMERICO")
	private Integer numerico;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getNumerico() {
		return numerico;
	}
	public void setNumerico(Integer numerico) {
		this.numerico = numerico;
	}
	
}