package cl.devap.ictModel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="fm_alumno")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "rut")
	private int rut;
	@Column (name = "digito")
	private String digito;
	@Column (name = "nombre")
	private String nombre;
	@Column (name = "apellidos")
	private String apellidos;
	@Column (name = "perfil")
	private String perfil;
	@Column (name = "curso")
	private int curso;
	@Column (name = "direccion")
	private String direccion;
	@Column (name = "comuna")
	private int comuna;
	@Column (name = "telefono")
	private int telefono;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public String getDigito() {
		return digito;
	}
	public void setDigito(String digito) {
		this.digito = digito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getComuna() {
		return comuna;
	}
	public void setComuna(int comuna) {
		this.comuna = comuna;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
}