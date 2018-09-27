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
CREATE TABLE `pre_tipo_trabajador` (
  `ID_PRE_TIPO_TRABAJADOR` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  `VALOR_HORA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PRE_TIPO_TRABAJADOR`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
 * 
 */
@Entity
@Table(name="pre_tipo_trabajador")
public class PreTipoTrabajador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID_PRE_TIPO_TRABAJADOR", nullable = false, insertable = true)
	private Integer idPreTipoTrabajador;
	@Column (name = "DESCRIPCION")
	private String descripcion;
	@Column (name = "VALOR_HORA")
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
	
}