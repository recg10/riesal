package cl.devap.ictModel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * The persistent class for the user database table.
 * CREATE TABLE `pre_cotizacion` (
  `ID_COTIZACION` int(11) NOT NULL AUTO_INCREMENT,
  `EMPRESA` varchar(11) NOT NULL,
  `AREA` int(100) NOT NULL,
  `PLANTEL` int(11) NOT NULL,
  `DIRECCION` varchar(200) NOT NULL,
  `SUPERVISOR` varchar(200) NOT NULL,
  `CODIGO` varchar(100) NOT NULL,
  `FECHA` date NOT NULL,
  `TRABAJO` varchar(1000) NOT NULL,
  `DETALLE_TRABAJO` varchar(2000) NOT NULL,
  `ESTADO` int(11) NOT NULL COMMENT '0 = peniente 1=Teminada',
  `TRASLADO_PLANTEL_CANTIDAD` int(11) NOT NULL,
  `TRASLADO_PLANTEL_VALOR` int(11) NOT NULL,
  `GASTO_OPERACIONAL_CANTIDAD` int(11) NOT NULL,
  `GASTO_OPERACIONAL_VALOR` int(11) NOT NULL,
  `PREVENCION_CANTIDAD` int(11) NOT NULL,
  `PREVENCION_VALOR` int(11) NOT NULL,
  `UTILIDAD_RIESAL_PORC` int(11) NOT NULL,
  `UTILIDAD_RIESAL_VALOR` int(11) NOT NULL,
  `OBSERVACIONES` varchar(1000) DEFAULT NULL,
  `UNIDAD_COTIZACION` int(11) NOT NULL,
  `MONTO_UNIDAD_COTIZACION` int(11) NOT NULL,
  PRIMARY KEY (`ID_COTIZACION`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
 * 
 */
@Entity
@Table(name="pre_cotizacion")
public class PreCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID_COTIZACION", nullable = false, insertable = true)
	private Integer idCotizacion;
	@Column (name = "EMPRESA")
	private String empresa;
	@Column (name = "AREA")
	private Integer area;
	@Column (name = "PLANTEL")
	private Integer plantel;
	@Column (name = "DIRECCION")
	private String direccion;
	@Column (name = "SUPERVISOR")
	private String supervisor;
	@Column (name = "CODIGO")
	private String codigo;
	@Column (name = "FECHA")
	private Date fecha;
	@Column (name = "TRABAJO")
	private String trabajo;
	@Column (name = "DETALLE_TRABAJO")
	private String detalleTrabajo;
	@Column (name = "ESTADO")
	private Integer estado;
	@Column (name = "MO_PORC")
	private Double moPorc;
	@Column (name = "MO_RESULT")
	private Long moResult;
	@Column (name = "MATERIALES_PORC")
	private Double materialesPorc;
	@Column (name = "MATERIALES_RESULT")
	private Long materialesResult;
	@Column (name = "TRASLADO_VALOR")
	private Long trasladoValor;
	@Column (name = "TRASLADO_CANTIDAD")
	private Integer trasladoCantidad;
	@Column (name = "GO_PORC")
	private Double goPorc;
	@Column (name = "GO_RESULT")
	private Long goResult;
	@Column (name = "UTILIDAD_PORC")
	private Double utilidadPorc;
	@Column (name = "UTILIDAD_RESULT")
	private Long utilidadResult;
	@Column (name = "TOTAL")
	private Long total;
	@Column (name = "TOTAL_NETO_PRESUPUESTO")
	private Long totalNetoPresupuesto;
	@Column (name = "TOTAL_PRESUPUESTO")
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
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
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