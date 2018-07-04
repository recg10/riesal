package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreMOCotizacionDTO;

public interface PreMOCotizacionService  {
	
	public boolean save(PreMOCotizacionDTO dto) throws IctException;
	public boolean delete(Integer id) throws IctException;	
	public List<PreMOCotizacionDTO> find(Long idCotizacion) throws IctException;
	public List<PreMOCotizacionDTO> find(Long idCotizacion, Long id) throws IctException;
	public boolean update(PreMOCotizacionDTO dto) throws IctException;
	
}
