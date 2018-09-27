package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreCotizacionDTO;

public interface PreCotizacionService  {
	
	public Integer save(PreCotizacionDTO dto) throws IctException;
	public boolean delete(Integer id) throws IctException;
	public List<PreCotizacionDTO> find(Long id) throws IctException;
	public List<PreCotizacionDTO> findAll() throws IctException;
	public boolean update(PreCotizacionDTO obj);
	
}
