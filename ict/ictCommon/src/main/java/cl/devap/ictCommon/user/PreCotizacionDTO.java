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
public class PreCotizacionDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idCotizacion;	
	private String empresa;	
	private Integer area;
	private Integer plantel;
	private String direccion;
	private String supervisor;
	private String codigo;
	private Date fecha;
	private String trabajo;
	private String detalleTrabajo;
	private Integer estado;
	
	
	private Double moPorc;
	private Long moResult;
	
	private Double materialesPorc;
	private Long materialesResult;
	
	private Long trasladoValor;
	private Integer trasladoCantidad;
	private Long trasladoTotal;
	
	private Double goPorc;
	private Long goResult;
	
	private Double utilidadPorc;
	private Long utilidadResult;
	
	private Long total;
	private Long totalNetoPresupuesto;
	private Long totalPresupuesto;
	

	
	public Integer getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Integer getPlantel() {
		return plantel;
	}
	public void setPlantel(Integer plantel) {
		this.plantel = plantel;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	public String getDetalleTrabajo() {
		return detalleTrabajo;
	}
	public void setDetalleTrabajo(String detalleTrabajo) {
		this.detalleTrabajo = detalleTrabajo;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Double getMoPorc() {
		return moPorc;
	}
	public void setMoPorc(Double moPorc) {
		this.moPorc = moPorc;
	}
	public Long getMoResult() {
		return moResult;
	}
	public void setMoResult(Long moResult) {
		this.moResult = moResult;
	}
	public Double getMaterialesPorc() {
		return materialesPorc;
	}
	public void setMaterialesPorc(Double materialesPorc) {
		this.materialesPorc = materialesPorc;
	}
	public Long getMaterialesResult() {
		return materialesResult;
	}
	public void setMaterialesResult(Long materialesResult) {
		this.materialesResult = materialesResult;
	}
	public Long getTrasladoValor() {
		return trasladoValor;
	}
	public void setTrasladoValor(Long trasladoValor) {
		this.trasladoValor = trasladoValor;
	}
	public Integer getTrasladoCantidad() {
		return trasladoCantidad;
	}
	public void setTrasladoCantidad(Integer trasladoCantidad) {
		this.trasladoCantidad = trasladoCantidad;
	}
	public Double getGoPorc() {
		return goPorc;
	}
	public void setGoPorc(Double goPorc) {
		this.goPorc = goPorc;
	}
	public Long getGoResult() {
		return goResult;
	}
	public void setGoResult(Long goResult) {
		this.goResult = goResult;
	}
	public Double getUtilidadPorc() {
		return utilidadPorc;
	}
	public void setUtilidadPorc(Double utilidadPorc) {
		this.utilidadPorc = utilidadPorc;
	}
	public Long getUtilidadResult() {
		return utilidadResult;
	}
	public void setUtilidadResult(Long utilidadResult) {
		this.utilidadResult = utilidadResult;
	}
	public Long getTotal() {
		total=(long) 0;
		if (trasladoTotal!=null){
			total = total + getTrasladoTotal();
		}
		if (goResult!=null){
			total = total + getGoResult();
		}
		if (materialesResult!=null){
			total = total + getMaterialesResult();
		}
		if (utilidadResult!=null){
			total = total + getUtilidadResult();
		}
		if (moResult!=null){
			total = total + getMoResult();
		}		
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getTrasladoTotal() {
		trasladoTotal=(long) 0;
		if (trasladoCantidad!=null && trasladoValor!=null){
			trasladoTotal = trasladoCantidad * trasladoValor;
		}		
		return trasladoTotal;
	}
	public void setTrasladoTotal(Long trasladoTotal) {
		this.trasladoTotal = trasladoTotal;
	}
	public Long getTotalNetoPresupuesto() {
		return totalNetoPresupuesto;
	}
	public void setTotalNetoPresupuesto(Long totalNetoPresupuesto) {
		this.totalNetoPresupuesto = totalNetoPresupuesto;
	}
	public Long getTotalPresupuesto() {
		return totalPresupuesto;
	}
	public void setTotalPresupuesto(Long totalPresupuesto) {
		this.totalPresupuesto = totalPresupuesto;
	}
	
}
