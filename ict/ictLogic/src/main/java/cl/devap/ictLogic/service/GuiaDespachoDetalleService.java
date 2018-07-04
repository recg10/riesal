package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreGuiaDespachoDetalleDTO;

public interface GuiaDespachoDetalleService  {
	
	public Integer save(PreGuiaDespachoDetalleDTO dto) throws IctException;
	public boolean delete(Integer id) throws IctException;
	public List<PreGuiaDespachoDetalleDTO> find(Long id) throws IctException;
	public List<PreGuiaDespachoDetalleDTO> findAll() throws IctException;
	public List<PreGuiaDespachoDetalleDTO> findByIdGuia(Long idGuia) throws IctException;
	public boolean update(PreGuiaDespachoDetalleDTO obj);
	
}
