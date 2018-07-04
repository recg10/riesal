/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class PlantelDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer seccion;
	private String plantel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSeccion() {
		return seccion;
	}
	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}
	public String getPlantel() {
		return plantel;
	}
	public void setPlantel(String plantel) {
		this.plantel = plantel;
	}
	
	@Override
	public String toString() {
		return "PlantelDTO [id=" + id + ", seccion=" + seccion + ", plantel=" + plantel + "]";
	}
	
	
}
