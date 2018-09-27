package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreGuiaDespachoDTO;
import cl.devap.ictLogic.service.GuiaDespachoService;
import cl.devap.ictModel.dao.PreGuiaDespachoDAO;
import cl.devap.ictModel.model.PreGuiaDespacho;

@Service
public class GuiaDespachoServiceImpl implements GuiaDespachoService{
	
	final static Logger logger = Logger.getLogger(GuiaDespachoServiceImpl.class);
	
	@Autowired
	PreGuiaDespachoDAO preGuiaDespachoDAO;
	
	@Transactional
	public Integer save(PreGuiaDespachoDTO dto) throws IctException{
		PreGuiaDespacho ent = new PreGuiaDespacho();
		ent.setUsuarioRut(dto.getUsuarioRut());
		ent.setNumeroGuia(dto.getNumeroGuia());
		ent.setRutProveedor(dto.getRutProveedor());
		return preGuiaDespachoDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreGuiaDespacho ent = new PreGuiaDespacho();		
			ent.setIdGuiaDespacho(id);	
			preGuiaDespachoDAO.delete(ent);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public List<PreGuiaDespachoDTO> find(Long id) throws IctException{
		List<PreGuiaDespachoDTO> listPreGuiaDespachoDTO = new ArrayList<PreGuiaDespachoDTO>();		
		List<PreGuiaDespacho> list = preGuiaDespachoDAO.find(id);
		if (list!=null && list.size()>0){
			for (PreGuiaDespacho obj : list) {
				PreGuiaDespachoDTO dto = new PreGuiaDespachoDTO();
				dto.setUsuarioRut(obj.getUsuarioRut());
				dto.setNumeroGuia(obj.getNumeroGuia());
				dto.setRutProveedor(obj.getRutProveedor());
				dto.setIdGuiaDespacho(obj.getIdGuiaDespacho());
				listPreGuiaDespachoDTO.add(dto);
			}			
		}
		return listPreGuiaDespachoDTO; 
	}
	
	public List<PreGuiaDespachoDTO> findAll() throws IctException{
		List<PreGuiaDespachoDTO> listPreGuiaDespachoDTO = new ArrayList<PreGuiaDespachoDTO>();		
		List<PreGuiaDespacho> list = preGuiaDespachoDAO.findAll();
		if (list!=null && list.size()>0){
			for (PreGuiaDespacho obj : list) {
				PreGuiaDespachoDTO dto = new PreGuiaDespachoDTO();
				dto.setUsuarioRut(obj.getUsuarioRut());
				dto.setNumeroGuia(obj.getNumeroGuia());
				dto.setRutProveedor(obj.getRutProveedor());
				dto.setIdGuiaDespacho(obj.getIdGuiaDespacho());
				listPreGuiaDespachoDTO.add(dto);
			}			
		}
		return listPreGuiaDespachoDTO; 
	}
	
	@Transactional
	public boolean update(PreGuiaDespachoDTO dto) {
    	boolean exito=false;
    	try {
    		PreGuiaDespacho ent = new PreGuiaDespacho();
    		ent.setUsuarioRut(dto.getUsuarioRut());
    		ent.setNumeroGuia(dto.getNumeroGuia());
    		ent.setRutProveedor(dto.getRutProveedor());
			preGuiaDespachoDAO.update(ent);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }
}
