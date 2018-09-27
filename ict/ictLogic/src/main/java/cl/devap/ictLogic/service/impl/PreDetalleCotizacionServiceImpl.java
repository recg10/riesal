package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreDetalleCotizacionDTO;
import cl.devap.ictLogic.service.PreDetalleCotizacionService;
import cl.devap.ictModel.dao.PreDetalleCotizacionDAO;
import cl.devap.ictModel.model.PreDetalleCotizacion;

@Service
public class PreDetalleCotizacionServiceImpl implements PreDetalleCotizacionService{
	
	final static Logger logger = Logger.getLogger(PreDetalleCotizacionServiceImpl.class);
	
	@Autowired
	PreDetalleCotizacionDAO preDetalleCotizacionDAO;
	
	@Transactional
	public boolean save(PreDetalleCotizacionDTO dto) {
		PreDetalleCotizacion ent = new PreDetalleCotizacion();
		ent.setCantidad(dto.getCantidad());
		ent.setIdCotizacion(dto.getIdCotizacion());
		ent.setIdCotizacionItem(dto.getIdCotizacionItem());
		ent.setIdDetalleCotizacion(dto.getIdDetalleCotizacion());
		ent.setIdMaterialCotizacion(dto.getIdMaterialCotizacion());
		ent.setValorUnitario(dto.getValorUnitario());
		return preDetalleCotizacionDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreDetalleCotizacion preDetalleCotizacion = new PreDetalleCotizacion();		
			preDetalleCotizacion.setIdDetalleCotizacion(id);	
			preDetalleCotizacionDAO.delete(preDetalleCotizacion);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}

	
	public List<PreDetalleCotizacionDTO> find(Long idCotizacion) throws IctException{
		List<PreDetalleCotizacionDTO> listPreDetalleCotizacionDTO = new ArrayList<PreDetalleCotizacionDTO>();
		
		List<PreDetalleCotizacion> list = preDetalleCotizacionDAO.find(idCotizacion);
		if (list!=null && list.size()>0){
			for (PreDetalleCotizacion obj : list) {
				PreDetalleCotizacionDTO preDetalleCotizacionDTO = new PreDetalleCotizacionDTO();
				preDetalleCotizacionDTO.setCantidad(obj.getCantidad());
				preDetalleCotizacionDTO.setIdCotizacion(obj.getIdCotizacion());
				preDetalleCotizacionDTO.setIdDetalleCotizacion(obj.getIdDetalleCotizacion());
				preDetalleCotizacionDTO.setIdMaterialCotizacion(obj.getIdMaterialCotizacion());
				preDetalleCotizacionDTO.setValorUnitario(obj.getValorUnitario());
				preDetalleCotizacionDTO.setSubTotal(new Long(obj.getValorUnitario()*obj.getCantidad()));
				listPreDetalleCotizacionDTO.add(preDetalleCotizacionDTO);
			}			
		}
		return listPreDetalleCotizacionDTO; 
	}
	
	public List<PreDetalleCotizacionDTO> findByItem(Long idCotizacion, Long idItem) throws IctException{		
		List<PreDetalleCotizacionDTO> listPreDetalleCotizacionDTO = new ArrayList<PreDetalleCotizacionDTO>();		
		List<PreDetalleCotizacion> list = preDetalleCotizacionDAO.findByItem(idCotizacion, idItem);
		if (list!=null && list.size()>0){
			for (PreDetalleCotizacion obj : list) {
				PreDetalleCotizacionDTO preDetalleCotizacionDTO = new PreDetalleCotizacionDTO();
				preDetalleCotizacionDTO.setCantidad(obj.getCantidad());
				preDetalleCotizacionDTO.setIdCotizacion(obj.getIdCotizacion());
				preDetalleCotizacionDTO.setIdCotizacionItem(obj.getIdCotizacionItem());
				preDetalleCotizacionDTO.setIdDetalleCotizacion(obj.getIdDetalleCotizacion());
				preDetalleCotizacionDTO.setIdMaterialCotizacion(obj.getIdMaterialCotizacion());
				preDetalleCotizacionDTO.setValorUnitario(obj.getValorUnitario());
				preDetalleCotizacionDTO.setSubTotal(new Long(obj.getValorUnitario()*obj.getCantidad()));
				listPreDetalleCotizacionDTO.add(preDetalleCotizacionDTO);
			}			
		}
		return listPreDetalleCotizacionDTO; 
	}
	
	@Transactional
	public boolean update(PreDetalleCotizacionDTO dto) {
    	boolean exito=false;
    	try {
    		PreDetalleCotizacion ent = new PreDetalleCotizacion();
    		ent.setCantidad(dto.getCantidad());
    		ent.setIdCotizacion(dto.getIdCotizacion());
    		ent.setIdDetalleCotizacion(dto.getIdDetalleCotizacion());
    		ent.setIdMaterialCotizacion(dto.getIdMaterialCotizacion());
    		ent.setValorUnitario(dto.getValorUnitario());
    		ent.setIdCotizacionItem(dto.getIdCotizacionItem());
    		preDetalleCotizacionDAO.update(ent);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }
}
