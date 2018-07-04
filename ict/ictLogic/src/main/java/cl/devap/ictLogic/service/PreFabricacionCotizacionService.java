package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreFabricacionCotizacionDTO;

public interface PreFabricacionCotizacionService  {
	
public boolean save(PreFabricacionCotizacionDTO dto) throws IctException;
	
	public boolean delete(Long id) throws IctException;
	
	public List<PreFabricacionCotizacionDTO> find(Long idCotizacion) throws IctException;
	
	public List<PreFabricacionCotizacionDTO> findByItem(Long idCotizacion, Long idItem) throws IctException;
	
	public List<PreFabricacionCotizacionDTO> findByItem(Long idCotizacion, Long idItem, Integer tipo) throws IctException;
	
	public boolean update(PreFabricacionCotizacionDTO dto) throws IctException;
	
}
