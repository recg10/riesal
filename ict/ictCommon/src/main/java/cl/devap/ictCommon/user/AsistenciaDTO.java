/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author rcastro
 *
 */
public class AsistenciaDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int rut;
	private Character digito;
	private Date fecha;
	
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Character getDigito() {
		return digito;
	}
	public void setDigito(Character digito) {
		this.digito = digito;
	}
		
}
