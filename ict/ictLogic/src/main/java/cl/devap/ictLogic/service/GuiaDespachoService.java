package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreGuiaDespachoDTO;

public interface GuiaDespachoService  {
	
	public Integer save(PreGuiaDespachoDTO dto) throws IctException;
	public boolean delete(Integer id) throws IctException;
	public List<PreGuiaDespachoDTO> find(Long id) throws IctException;
	public List<PreGuiaDespachoDTO> findAll() throws IctException;
	public boolean update(PreGuiaDespachoDTO obj);
	
}
