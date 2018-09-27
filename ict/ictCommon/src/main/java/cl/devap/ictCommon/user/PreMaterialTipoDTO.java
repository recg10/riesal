/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class PreMaterialTipoDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idMaterialTipo;	
	private String descripcion;
	
	
	public Integer getIdMaterialTipo() {
		return idMaterialTipo;
	}
	public void setIdMaterialTipo(Integer idMaterialTipo) {
		this.idMaterialTipo = idMaterialTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "PreMaterialTipoDTO [idMaterialTipo=" + idMaterialTipo + ", descripcion=" + descripcion + "]";
	}
	
		
	
}
