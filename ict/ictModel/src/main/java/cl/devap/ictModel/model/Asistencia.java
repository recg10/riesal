package cl.devap.ictModel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="fm_asistencia")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "id")
	private int id;
	@Column (name = "rut")
	private int rut;
	@Column (name = "fecha")
	private Date fecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
}