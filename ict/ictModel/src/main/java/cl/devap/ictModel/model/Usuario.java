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
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Column (name = "clave")
	private String clave;
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
//    @JoinColumn(name = "idPerfil")
//	private Perfil idPerfil;
	private Integer perfil;
	
	
//	public Perfil getIdPerfil() {
//		return idPerfil;
//	}
//	public void setIdPerfil(Perfil idPerfil) {
//		this.idPerfil = idPerfil;
//	}
	public Character getDigito() {
		return digito;
	}
	public void setDigito(Character digito) {
		this.digito = digito;
	}
	public Integer getRut() {
		return rut;
	}
	public void setRut(Integer rut) {
		this.rut = rut;
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