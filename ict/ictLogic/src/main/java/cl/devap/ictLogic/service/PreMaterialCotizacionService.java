package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreMaterialCotizacionDTO;

public interface PreMaterialCotizacionService  {
	
	public Integer save(PreMaterialCotizacionDTO dto) throws IctException;
	public boolean delete(Integer id) throws IctException;
	public List<PreMaterialCotizacionDTO> find(Long id) throws IctException;
	public List<PreMaterialCotizacionDTO> findAll() throws IctException;
	public boolean update(PreMaterialCotizacionDTO obj);
	
}
