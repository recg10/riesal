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
@Table(name="fm_perfil")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "id")
	private int id;
	@Column (name = "descripcion")
	private String descripcion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}