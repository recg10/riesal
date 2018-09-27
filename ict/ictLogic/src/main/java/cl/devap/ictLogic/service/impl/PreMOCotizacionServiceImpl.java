package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreMOCotizacionDTO;
import cl.devap.ictLogic.service.PreMOCotizacionService;
import cl.devap.ictModel.dao.PreMOCotizacionDAO;
import cl.devap.ictModel.model.PreMOCotizacion;

@Service
public class PreMOCotizacionServiceImpl implements PreMOCotizacionService{
	
final static Logger logger = Logger.getLogger(PreMOCotizacionServiceImpl.class);
	
	@Autowired
	PreMOCotizacionDAO preMOCotizacionDAO;
	
	@Transactional
	public boolean save(PreMOCotizacionDTO dto) throws IctException {
		PreMOCotizacion ent = new PreMOCotizacion();
		ent.setCantidad(dto.getCantidad());
		ent.setIdCotizacion(dto.getIdCotizacion());
		ent.setIdCotizacionItem(dto.getIdCotizacionItem());
		ent.setValorHora(dto.getValorHora());
		ent.setHoras(dto.getHoras());
		ent.setCantidad(dto.getCantidad());
		ent.setIdTrabajdor(dto.getIdTrabajdor());
		ent.setIdPreMoCotizacion(dto.getIdPreMoCotizacion());
		
		return preMOCotizacionDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreMOCotizacion preMOCotizacion = new PreMOCotizacion();		
			preMOCotizacion.setIdPreMoCotizacion(id);	
			preMOCotizacionDAO.delete(preMOCotizacion);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public List<PreMOCotizacionDTO> find(Long idCotizacion) throws IctException{
		List<PreMOCotizacionDTO> listPreMOCotizacionDTO = new ArrayList<PreMOCotizacionDTO>();		
		List<PreMOCotizacion> list = preMOCotizacionDAO.find(idCotizacion);
		if (list!=null && list.size()>0){
			for (PreMOCotizacion obj : list) {
				PreMOCotizacionDTO dto = new PreMOCotizacionDTO();
				dto.setCantidad(obj.getCantidad());
				dto.setIdCotizacion(obj.getIdCotizacion());
				dto.setValorHora(obj.getValorHora());
				dto.setHoras(obj.getHoras());
				dto.setIdCotizacionItem(obj.getIdCotizacionItem());
				dto.setIdTrabajdor(obj.getIdTrabajdor());
				dto.setIdPreMoCotizacion(obj.getIdPreMoCotizacion());
				if(obj.getValorHora()!=null && obj.getCantidad()!=null && obj.getHoras()!=null){
					dto.setSubTotal(new Long(obj.getValorHora()*obj.getCantidad()*obj.getHoras()));
				}else{
					dto.setSubTotal(0L);
				}
				
				listPreMOCotizacionDTO.add(dto);
			}			
		}
		return listPreMOCotizacionDTO; 
	}
	
	public List<PreMOCotizacionDTO> find(Long idCotizacion, Long id) throws IctException{
		List<PreMOCotizacionDTO> listPreMOCotizacionDTO = new ArrayList<PreMOCotizacionDTO>();		
		List<PreMOCotizacion> list = preMOCotizacionDAO.find(idCotizacion, id);
		if (list!=null && list.size()>0){
			for (PreMOCotizacion obj : list) {
				PreMOCotizacionDTO dto = new PreMOCotizacionDTO();
				dto.setCantidad(obj.getCantidad());
				dto.setIdCotizacion(obj.getIdCotizacion());
				dto.setIdCotizacionItem(obj.getIdCotizacionItem());
				dto.setValorHora(obj.getValorHora());
				dto.setHoras(obj.getHoras());
				dto.setIdTrabajdor(obj.getIdTrabajdor());
				dto.setIdPreMoCotizacion(obj.getIdPreMoCotizacion());
				if(obj.getValorHora()!=null && obj.getCantidad()!=null && obj.getHoras()!=null){
					dto.setSubTotal(new Long(obj.getValorHora()*obj.getCantidad()*obj.getHoras()));
				}else{
					dto.setSubTotal(0L);
				}
				
				listPreMOCotizacionDTO.add(dto);
			}			
		}
		return listPreMOCotizacionDTO; 
	}
	
	@Transactional
	public boolean update(PreMOCotizacionDTO dto) throws IctException{
    	boolean exito=false;
    	try {
    		PreMOCotizacion ent = new PreMOCotizacion();		
    		ent.setCantidad(dto.getCantidad());
    		ent.setIdCotizacion(dto.getIdCotizacion());
    		ent.setIdCotizacionItem(dto.getIdCotizacionItem());
    		ent.setValorHora(dto.getValorHora());
    		ent.setHoras(dto.getHoras());
    		ent.setCantidad(dto.getCantidad());
    		ent.setIdTrabajdor(dto.getIdTrabajdor());
    		ent.setIdPreMoCotizacion(dto.getIdPreMoCotizacion());	
			preMOCotizacionDAO.update(ent);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }
}
