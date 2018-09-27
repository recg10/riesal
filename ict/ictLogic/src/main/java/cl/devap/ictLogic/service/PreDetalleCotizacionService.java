package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreDetalleCotizacionDTO;

public interface PreDetalleCotizacionService  {
	
	public boolean save(PreDetalleCotizacionDTO dto) throws IctException;
	
	public boolean delete(Integer id) throws IctException;
	
	public List<PreDetalleCotizacionDTO> find(Long idCotizacion) throws IctException;
	
	public List<PreDetalleCotizacionDTO> findByItem(Long idCotizacion, Long idItem) throws IctException;
	
	public boolean update(PreDetalleCotizacionDTO dto) throws IctException;
	
}
