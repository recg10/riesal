/**
 * 
 */
package cl.devap.ictCommon.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rcastro
 *
 */
public class PreGuiaDespachoDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idGuiaDespacho;	
	private Integer rutProveedor;	
	private Integer numeroGuia;
	private Integer usuarioRut;
	
	private List<PreGuiaDespachoDetalleDTO> listPreGuiaDespachoDetalleDTO = new ArrayList<PreGuiaDespachoDetalleDTO>();
	
	
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
	@Override
	public String toString() {
		return "PreGuiaDespachoDTO [idGuiaDespacho=" + idGuiaDespacho + ", rutProveedor=" + rutProveedor
				+ ", numeroGuia=" + numeroGuia + ", usuarioRut=" + usuarioRut + "]";
	}
	public List<PreGuiaDespachoDetalleDTO> getListPreGuiaDespachoDetalleDTO() {
		return listPreGuiaDespachoDetalleDTO;
	}
	public void setListPreGuiaDespachoDetalleDTO(List<PreGuiaDespachoDetalleDTO> listPreGuiaDespachoDetalleDTO) {
		this.listPreGuiaDespachoDetalleDTO = listPreGuiaDespachoDetalleDTO;
	}
	
		
}
