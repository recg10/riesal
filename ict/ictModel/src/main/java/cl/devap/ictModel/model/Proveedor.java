package cl.devap.ictModel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




/**
 * The persistent class for the proveedor database table.
 * 
 * CREATE TABLE `proveedores` (
  `rut` int(11) NOT NULL DEFAULT '0',
  `digito` char(1) NOT NULL DEFAULT '',
  `razonSocial` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `comuna` varchar(50) DEFAULT NULL,  
  PRIMARY KEY (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 * 
 */
@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "rut")
	private Integer rut;
	@Column (name = "digito")
	private Character digito;	
	@Column (name = "razonSocial")
	private String razonSocial;
	@Column (name = "direccion")
	private String direccion;
	@Column (name = "comuna")
	private String comuna;
	
	
	public Integer getRut() {
		return rut;
	}
	public void setRut(Integer rut) {
		this.rut = rut;
	}
	public Character getDigito() {
		return digito;
	}
	public void setDigito(Character digito) {
		this.digito = digito;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	
}