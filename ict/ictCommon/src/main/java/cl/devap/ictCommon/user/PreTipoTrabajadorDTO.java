/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class PreTipoTrabajadorDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPreTipoTrabajador;	
	private String descripcion;	
	private Integer valorHora;
	
	public Integer getIdPreTipoTrabajador() {
		return idPreTipoTrabajador;
	}
	public void setIdPreTipoTrabajador(Integer idPreTipoTrabajador) {
		this.idPreTipoTrabajador = idPreTipoTrabajador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getValorHora() {
		return valorHora;
	}
	public void setValorHora(Integer valorHora) {
		this.valorHora = valorHora;
	}
	@Override
	public String toString() {
		return "PreTipoTrabajadorDTO [idPreTipoTrabajador=" + idPreTipoTrabajador + ", descripcion=" + descripcion
				+ ", valorHora=" + valorHora + "]";
	}
		
}
