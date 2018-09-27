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
 CREATE TABLE `pre_guiadespacho` (
  `ID_GUIA_DESPACHO` int(11) NOT NULL AUTO_INCREMENT,
  `RUT_PROVEEDOR` int(11) DEFAULT NULL,
  `NUMERO_GUIA` int(11) DEFAULT NULL,
  `USUARIO_RUT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GUIA_DESPACHO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 * 
 */
@Entity
@Table(name="pre_guiadespacho")
public class PreGuiaDespacho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID_GUIA_DESPACHO", nullable = false, insertable = true)
	private Integer idGuiaDespacho;
	@Column (name = "RUT_PROVEEDOR")
	private Integer rutProveedor;
	@Column (name = "NUMERO_GUIA")
	private Integer numeroGuia;
	@Column (name = "USUARIO_RUT")
	private Integer usuarioRut;
	
	
	public Integer getIdGuiaDespacho() {
		return idGuiaDespacho;
	}
	public void setIdGuiaDespacho(Integer idGuiaDespacho) {
		this.idGuiaDespacho = idGuiaDespacho;
	}
	public Integer getRutProveedor() {
		return rutProveedor;
	}
	public void setRutProveedor(Integer rutProveedor) {
		this.rutProveedor = rutProveedor;
	}
	public Integer getNumeroGuia() {
		return numeroGuia;
	}
	public void setNumeroGuia(Integer numeroGuia) {
		this.numeroGuia = numeroGuia;
	}
	public Integer getUsuarioRut() {
		return usuarioRut;
	}
	public void setUsuarioRut(Integer usuarioRut) {
		this.usuarioRut = usuarioRut;
	}
	
	
}