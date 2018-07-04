/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class ProveedorDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer rut;	
	private Character digito;		
	private String razonSocial;	
	private String direccion;	
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
	@Override
	public String toString() {
		return "UserDTO [rut=" + rut + ", digito=" + digito + ", razonSocial=" + razonSocial + ", direccion="
				+ direccion + ", comuna=" + comuna + "]";
	}
	
	
	

}
