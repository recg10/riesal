/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class ParametroDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String nombre;	
	private String texto;	
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
	@Override
	public String toString() {
		return "ParametroDTO [id=" + id + ", nombre=" + nombre + ", texto=" + texto + ", numerico=" + numerico + "]";
	}
	
}
