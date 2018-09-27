package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreTipoTrabajadorDTO;

public interface PreTipoTrabajadorService  {
	
	public Integer save(PreTipoTrabajadorDTO dto) throws IctException;
	public boolean delete(Integer id) throws IctException;
	public List<PreTipoTrabajadorDTO> find(Long id) throws IctException;
	public List<PreTipoTrabajadorDTO> findAll() throws IctException;
	public boolean update(PreTipoTrabajadorDTO obj);
	
}
