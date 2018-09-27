package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreMaterialCotizacionDTO;
import cl.devap.ictCommon.user.PreMaterialTipoDTO;

public interface PreMaterialTipoService  {
	
	public Integer save(PreMaterialTipoDTO dto) throws IctException;
	public boolean delete(Integer id) throws IctException;
	public List<PreMaterialTipoDTO> find(Long id) throws IctException;
	public List<PreMaterialTipoDTO> findAll() throws IctException;
	public boolean update(PreMaterialTipoDTO obj);
	
}
