package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.enums.TipoMaterial;
import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreFabricacionCotizacionDTO;
import cl.devap.ictLogic.service.PreFabricacionCotizacionService;
import cl.devap.ictModel.dao.PreFabricacionCotizacionDAO;
import cl.devap.ictModel.model.PreFabricacionCotizacion;

@Service
public class PreFabricacionCotizacionServiceImpl implements PreFabricacionCotizacionService{
	
	final static Logger logger = Logger.getLogger(PreFabricacionCotizacionServiceImpl.class);
	
	@Autowired
	PreFabricacionCotizacionDAO preFabricacionCotizacionDAO;
	
	@Transactional
	public boolean save(PreFabricacionCotizacionDTO dto) {
		PreFabricacionCotizacion ent = new PreFabricacionCotizacion();
		ent.setIdPreMaterialItem(dto.getIdPreMaterialItem());
		ent.setIdCotizacion(dto.getIdCotizacion());
		ent.setIdCotizacionItem(dto.getIdCotizacionItem());
		ent.setIdTrabajador(dto.getIdTrabajador());
		ent.setPrecio(dto.getPrecio());
		ent.setTipo(dto.getTipo());
		ent.setValorHora(dto.getValorHora());
		ent.setIdPreFabricacion(dto.getIdPreFabricacion());
		ent.setUnidad(dto.getUnidad());
		
		return preFabricacionCotizacionDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Long id) throws IctException{
		try {
			PreFabricacionCotizacion preFabricacionCotizacion = new PreFabricacionCotizacion();		
			preFabricacionCotizacion.setIdPreFabricacion(id);	
			preFabricacionCotizacionDAO.delete(preFabricacionCotizacion);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}

	
	public List<PreFabricacionCotizacionDTO> find(Long idCotizacion) throws IctException{
		List<PreFabricacionCotizacionDTO> listPreFabricacionCotizacionDTO = new ArrayList<PreFabricacionCotizacionDTO>();
		
		List<PreFabricacionCotizacion> list = preFabricacionCotizacionDAO.find(idCotizacion);
		if (list!=null && list.size()>0){
			for (PreFabricacionCotizacion ent : list) {
				PreFabricacionCotizacionDTO dto = new PreFabricacionCotizacionDTO();				
				dto.setIdPreMaterialItem(ent.getIdPreMaterialItem());
				dto.setIdCotizacion(ent.getIdCotizacion());
				dto.setIdCotizacionItem(ent.getIdCotizacionItem());
				dto.setIdTrabajador(ent.getIdTrabajador());
				dto.setPrecio(ent.getPrecio());
				dto.setTipo(ent.getTipo());
				dto.setValorHora(ent.getValorHora());
				dto.setIdPreFabricacion(ent.getIdPreFabricacion());
				dto.setUnidad(ent.getUnidad());	
				if (ent.getTipo()==TipoMaterial.MATERIAL.getId()){
					dto.setSubTotal(new Long(ent.getPrecio()*ent.getUnidad()));
				}else{
					dto.setSubTotal(new Long(ent.getPrecio()*ent.getUnidad()*ent.getValorHora()));
				}
				listPreFabricacionCotizacionDTO.add(dto);
			}			
		}
		return listPreFabricacionCotizacionDTO; 
	}
	
	public List<PreFabricacionCotizacionDTO> findByItem(Long idCotizacion, Long idItem) throws IctException{		
		List<PreFabricacionCotizacionDTO> listPreFabricacionCotizacionDTO = new ArrayList<PreFabricacionCotizacionDTO>();		
		List<PreFabricacionCotizacion> list = preFabricacionCotizacionDAO.findByItem(idCotizacion, idItem);
		if (list!=null && list.size()>0){
			for (PreFabricacionCotizacion ent : list) {
				PreFabricacionCotizacionDTO dto = new PreFabricacionCotizacionDTO();				
				dto.setIdPreMaterialItem(ent.getIdPreMaterialItem());
				dto.setIdCotizacion(ent.getIdCotizacion());
				dto.setIdCotizacionItem(ent.getIdCotizacionItem());
				dto.setIdTrabajador(ent.getIdTrabajador());
				dto.setPrecio(ent.getPrecio());
				dto.setTipo(ent.getTipo());
				dto.setValorHora(ent.getValorHora());
				dto.setIdPreFabricacion(ent.getIdPreFabricacion());
				dto.setUnidad(ent.getUnidad());				
				listPreFabricacionCotizacionDTO.add(dto);
			}			
		}
		return listPreFabricacionCotizacionDTO; 
	}
	
	public List<PreFabricacionCotizacionDTO> findByItem(Long idCotizacion, Long idItem, Integer tipo) throws IctException{		
		List<PreFabricacionCotizacionDTO> listPreFabricacionCotizacionDTO = new ArrayList<PreFabricacionCotizacionDTO>();		
		List<PreFabricacionCotizacion> list = preFabricacionCotizacionDAO.findByItemTipo(idCotizacion, idItem, tipo);
		if (list!=null && list.size()>0){
			for (PreFabricacionCotizacion ent : list) {
				PreFabricacionCotizacionDTO dto = new PreFabricacionCotizacionDTO();				
				dto.setIdPreMaterialItem(ent.getIdPreMaterialItem());
				dto.setIdCotizacion(ent.getIdCotizacion());
				dto.setIdCotizacionItem(ent.getIdCotizacionItem());
				dto.setIdTrabajador(ent.getIdTrabajador());
				dto.setPrecio(ent.getPrecio());
				dto.setTipo(ent.getTipo());
				dto.setValorHora(ent.getValorHora());
				dto.setIdPreFabricacion(ent.getIdPreFabricacion());
				dto.setUnidad(ent.getUnidad());
				if (tipo==TipoMaterial.MATERIAL.getId()){
					dto.setSubTotal(new Long(ent.getPrecio()*ent.getUnidad()));
				}else{
					dto.setSubTotal(new Long(ent.getPrecio()*ent.getUnidad()*ent.getValorHora()));
				}
				
				listPreFabricacionCotizacionDTO.add(dto);
			}			
		}
		return listPreFabricacionCotizacionDTO; 
	}
	
	@Transactional
	public boolean update(PreFabricacionCotizacionDTO dto) {
    	boolean exito=false;
    	try {
    		PreFabricacionCotizacion ent = new PreFabricacionCotizacion();
    		ent.setIdPreMaterialItem(dto.getIdPreMaterialItem());
    		ent.setIdCotizacion(dto.getIdCotizacion());
    		ent.setIdCotizacionItem(dto.getIdCotizacionItem());
    		ent.setIdTrabajador(dto.getIdTrabajador());
    		ent.setPrecio(dto.getPrecio());
    		ent.setTipo(dto.getTipo());
    		ent.setValorHora(dto.getValorHora());
    		ent.setIdPreFabricacion(dto.getIdPreFabricacion());
    		ent.setUnidad(dto.getUnidad());
    		preFabricacionCotizacionDAO.update(ent);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }
}
