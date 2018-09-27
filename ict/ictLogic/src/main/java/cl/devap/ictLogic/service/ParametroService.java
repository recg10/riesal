package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.ParametroDTO;

public interface ParametroService  {
	
	public boolean save(ParametroDTO dto) throws IctException;	
	public boolean delete(Integer id) throws IctException;	
	public List<ParametroDTO> findAll() throws IctException;	
	public List<ParametroDTO> findById(Long id) throws IctException;
	public boolean update(ParametroDTO dto);
}
