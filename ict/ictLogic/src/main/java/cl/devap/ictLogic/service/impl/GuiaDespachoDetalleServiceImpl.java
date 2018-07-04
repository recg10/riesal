package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreGuiaDespachoDetalleDTO;
import cl.devap.ictLogic.service.GuiaDespachoDetalleService;
import cl.devap.ictModel.dao.PreGuiaDespachoDetalleDAO;
import cl.devap.ictModel.model.PreGuiaDespachoDetalle;

@Service
public class GuiaDespachoDetalleServiceImpl implements GuiaDespachoDetalleService{
	
final static Logger logger = Logger.getLogger(GuiaDespachoDetalleServiceImpl.class);
	
	@Autowired
	PreGuiaDespachoDetalleDAO preGuiaDespachoDetalleDAO;
	
	@Transactional
	public Integer save(PreGuiaDespachoDetalleDTO dto) throws IctException{
		PreGuiaDespachoDetalle ent = new PreGuiaDespachoDetalle();		
//		ent.setIdGuiaDespachoDetalle(dto.getIdGuiaDespachoDetalle());
		ent.setCantidad(dto.getCantidad());
		ent.setIdGuia(dto.getIdGuia());
		ent.setCodigo(dto.getCodigo());
		ent.setDescuento(dto.getDescuento());
		ent.setTotal(dto.getTotal());
		ent.setValor(dto.getValor());		
		return preGuiaDespachoDetalleDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreGuiaDespachoDetalle ent = new PreGuiaDespachoDetalle();		
			ent.setIdGuiaDespachoDetalle(id);	
			preGuiaDespachoDetalleDAO.delete(ent);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public List<PreGuiaDespachoDetalleDTO> find(Long id) throws IctException{
		List<PreGuiaDespachoDetalleDTO> listPreGuiaDespachoDetalleDTO = new ArrayList<PreGuiaDespachoDetalleDTO>();		
		List<PreGuiaDespachoDetalle> list = preGuiaDespachoDetalleDAO.find(id);
		if (list!=null && list.size()>0){
			for (PreGuiaDespachoDetalle obj : list) {
				PreGuiaDespachoDetalleDTO dto = new PreGuiaDespachoDetalleDTO();
				dto.setIdGuiaDespachoDetalle(obj.getIdGuiaDespachoDetalle());
				dto.setIdGuia(obj.getIdGuia());
				dto.setCantidad(obj.getCantidad());
				dto.setCodigo(obj.getCodigo());
				dto.setDescuento(obj.getDescuento());
				dto.setTotal(obj.getTotal());
				dto.setValor(obj.getValor());	
				listPreGuiaDespachoDetalleDTO.add(dto);
			}			
		}
		return listPreGuiaDespachoDetalleDTO; 
	}
	
	public List<PreGuiaDespachoDetalleDTO> findAll() throws IctException{
		List<PreGuiaDespachoDetalleDTO> listPreGuiaDespachoDetalleDTO = new ArrayList<PreGuiaDespachoDetalleDTO>();		
		List<PreGuiaDespachoDetalle> list = preGuiaDespachoDetalleDAO.findAll();
		if (list!=null && list.size()>0){
			for (PreGuiaDespachoDetalle obj : list) {
				PreGuiaDespachoDetalleDTO dto = new PreGuiaDespachoDetalleDTO();
				dto.setIdGuiaDespachoDetalle(obj.getIdGuiaDespachoDetalle());
				dto.setCantidad(obj.getCantidad());
				dto.setIdGuia(obj.getIdGuia());
				dto.setCodigo(obj.getCodigo());
				dto.setDescuento(obj.getDescuento());
				dto.setTotal(obj.getTotal());
				dto.setValor(obj.getValor());	
				listPreGuiaDespachoDetalleDTO.add(dto);
			}			
		}
		return listPreGuiaDespachoDetalleDTO; 
	}
	
	public List<PreGuiaDespachoDetalleDTO> findByIdGuia(Long idGuia) throws IctException{
		List<PreGuiaDespachoDetalleDTO> listPreGuiaDespachoDetalleDTO = new ArrayList<PreGuiaDespachoDetalleDTO>();		
		List<PreGuiaDespachoDetalle> list = preGuiaDespachoDetalleDAO.findByIdGuia(idGuia);
		if (list!=null && list.size()>0){
			for (PreGuiaDespachoDetalle obj : list) {
				PreGuiaDespachoDetalleDTO dto = new PreGuiaDespachoDetalleDTO();
				dto.setIdGuiaDespachoDetalle(obj.getIdGuiaDespachoDetalle());
				dto.setIdGuia(obj.getIdGuia());
				dto.setCantidad(obj.getCantidad());
				dto.setCodigo(obj.getCodigo());
				dto.setDescuento(obj.getDescuento());
				dto.setTotal(obj.getTotal());
				dto.setValor(obj.getValor());	
				listPreGuiaDespachoDetalleDTO.add(dto);
			}			
		}
		return listPreGuiaDespachoDetalleDTO; 
	}
	
	@Transactional
	public boolean update(PreGuiaDespachoDetalleDTO dto) {
    	boolean exito=false;
    	try {
    		PreGuiaDespachoDetalle ent = new PreGuiaDespachoDetalle();
    		ent.setIdGuiaDespachoDetalle(dto.getIdGuiaDespachoDetalle());
    		ent.setIdGuia(dto.getIdGuia());
    		ent.setCantidad(dto.getCantidad());
    		ent.setCodigo(dto.getCodigo());
    		ent.setDescuento(dto.getDescuento());
    		ent.setTotal(dto.getTotal());
    		ent.setValor(dto.getValor());		
			preGuiaDespachoDetalleDAO.update(ent);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }
}
