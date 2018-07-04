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
 * The persistent class for the user database table.
 * 
 * CREATE TABLE `usuario` (
  `rut` int(11) NOT NULL DEFAULT '0',
  `digito` char(1) NOT NULL DEFAULT '',
  `nombres` varchar(50) DEFAULT NULL,
  `paterno` varchar(50) DEFAULT NULL,
  `materno` varchar(50) DEFAULT NULL,
  `perfil` int(11) DEFAULT NULL COMMENT '0=Administrador, 1=jefe, 2, Administrativo, 3=operario',
  `clave` varchar(30) NOT NULL COMMENT 'Contrasena de los usuartio al sistema',
  PRIMARY KEY (`rut`,`digito`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 * 
 */
@Entity
@Table(name="usuario")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "rut")
	private Integer rut;
	@Column (name = "digito")
	private Character digito;
	@Column (name = "nombres")
	private String nombres;
	@Column (name = "paterno")
	private String paterno;
	@Column (name = "materno")
	private String materno;
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "perfil")
//	private Perfil perfil;
	@Column (name = "clave")
	private String clave;
	@Column (name = "perfil")
	private Integer perfil;
	
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
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
//	public Perfil getPerfil() {
//		return perfil;
//	}
//	public void setPerfil(Perfil perfil) {
//		this.perfil = perfil;
//	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Integer getPerfil() {
		return perfil;
	}
	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}
	
	
}