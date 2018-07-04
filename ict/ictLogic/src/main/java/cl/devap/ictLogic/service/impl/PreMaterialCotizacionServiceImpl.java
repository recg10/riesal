package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreMaterialCotizacionDTO;
import cl.devap.ictLogic.service.PreMaterialCotizacionService;
import cl.devap.ictModel.dao.PreMaterialCotizacionDAO;
import cl.devap.ictModel.model.PreMaterialCotizacion;

@Service
public class PreMaterialCotizacionServiceImpl implements PreMaterialCotizacionService{
	
final static Logger logger = Logger.getLogger(PreMaterialCotizacionServiceImpl.class);
	
	@Autowired
	PreMaterialCotizacionDAO preMaterialCotizacionDAO;
	
	@Transactional
	public Integer save(PreMaterialCotizacionDTO dto) throws IctException{
		PreMaterialCotizacion ent = new PreMaterialCotizacion();
		ent.setDescripcion(dto.getDescripcion());		
		ent.setPrecio(dto.getPrecio());		
		ent.setStock(dto.getStock());
		ent.setStockCritico(dto.getStockCritico());
		return preMaterialCotizacionDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreMaterialCotizacion PreMaterialCotizacion = new PreMaterialCotizacion();		
			PreMaterialCotizacion.setIdMaterialCotizacion(id);	
			preMaterialCotizacionDAO.delete(PreMaterialCotizacion);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public List<PreMaterialCotizacionDTO> find(Long id) throws IctException{
		List<PreMaterialCotizacionDTO> listPreMaterialCotizacionDTO = new ArrayList<PreMaterialCotizacionDTO>();		
		List<PreMaterialCotizacion> list = preMaterialCotizacionDAO.find(id);
		if (list!=null && list.size()>0){
			for (PreMaterialCotizacion obj : list) {
				PreMaterialCotizacionDTO dto = new PreMaterialCotizacionDTO();
				dto.setIdMaterialCotizacion(obj.getIdMaterialCotizacion());
				dto.setDescripcion(obj.getDescripcion());		
				dto.setPrecio(obj.getPrecio());
				dto.setStock(obj.getStock());
				dto.setStockCritico(obj.getStockCritico());
				listPreMaterialCotizacionDTO.add(dto);
			}
		}
		return listPreMaterialCotizacionDTO; 
	}
	
	public List<PreMaterialCotizacionDTO> findAll() throws IctException{
		List<PreMaterialCotizacionDTO> listPreMaterialCotizacionDTO = new ArrayList<PreMaterialCotizacionDTO>();		
		List<PreMaterialCotizacion> list = preMaterialCotizacionDAO.findAll();
		if (list!=null && list.size()>0){
			for (PreMaterialCotizacion obj : list) {
				PreMaterialCotizacionDTO dto = new PreMaterialCotizacionDTO();
				dto.setIdMaterialCotizacion(obj.getIdMaterialCotizacion());
				dto.setDescripcion(obj.getDescripcion());		
				dto.setPrecio(obj.getPrecio());
				dto.setStock(obj.getStock());
				dto.setStockCritico(obj.getStockCritico());
				listPreMaterialCotizacionDTO.add(dto);
			}			
		}
		return listPreMaterialCotizacionDTO; 
	}
	
	@Transactional
	public boolean update(PreMaterialCotizacionDTO dto) {
    	boolean exito=false;
    	try {
    		PreMaterialCotizacion obj = new PreMaterialCotizacion();    		
    		obj.setIdMaterialCotizacion(dto.getIdMaterialCotizacion());
    		obj.setDescripcion(dto.getDescripcion());		
    		obj.setPrecio(dto.getPrecio());
    		obj.setStock(dto.getStock());
    		obj.setStockCritico(dto.getStockCritico());
			preMaterialCotizacionDAO.update(obj);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }
	
	
}
