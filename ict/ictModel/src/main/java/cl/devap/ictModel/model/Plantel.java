package cl.devap.ictModel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * The persistent class for the user database table.
 * CREATE TABLE `plantel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seccion` int(11) DEFAULT NULL,
  `plantel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
 * 
 */
@Entity
@Table(name="plantel")
public class Plantel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "id", nullable = false, insertable = true)
	private Integer id;
	@Column (name = "seccion")
	private Integer seccion;
	@Column (name = "plantel")
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
	
}