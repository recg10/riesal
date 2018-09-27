package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreCotizacionItemDTO;

public interface PreCotizacionItemService  {
	
	public boolean save(PreCotizacionItemDTO dto) throws IctException;
	public boolean delete(Long id) throws IctException;
	public boolean update(PreCotizacionItemDTO dto) throws IctException;	
	public List<PreCotizacionItemDTO> find(Long id) throws IctException;
	public List<PreCotizacionItemDTO> findAll() throws IctException;
	
}
