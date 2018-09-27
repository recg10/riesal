package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreTipoTrabajadorDTO;
import cl.devap.ictLogic.service.PreTipoTrabajadorService;
import cl.devap.ictModel.dao.PreTipoTrabajadorDAO;
import cl.devap.ictModel.model.PreTipoTrabajador;

@Service
public class PreTipoTrabajadorServiceImpl implements PreTipoTrabajadorService{
	

	@Autowired
	PreTipoTrabajadorDAO preTipoTrabajadorDAO;	
	final static Logger logger = Logger.getLogger(PreMaterialServiceImpl.class);
	
	@Transactional
	public Integer save(PreTipoTrabajadorDTO dto) throws IctException{
		PreTipoTrabajador ent = new PreTipoTrabajador();
		ent.setDescripcion(dto.getDescripcion());		
		ent.setDescripcion(dto.getDescripcion());		
		ent.setValorHora(dto.getValorHora());		
		return preTipoTrabajadorDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreTipoTrabajador preTipoTrabajador = new PreTipoTrabajador();		
			preTipoTrabajador.setIdPreTipoTrabajador(id);	
			preTipoTrabajadorDAO.delete(preTipoTrabajador);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public List<PreTipoTrabajadorDTO> find(Long id) throws IctException{
		List<PreTipoTrabajadorDTO> listPreTipoTrabajadorDTO = new ArrayList<PreTipoTrabajadorDTO>();		
		List<PreTipoTrabajador> list = preTipoTrabajadorDAO.find(id);
		if (list!=null && list.size()>0){
			for (PreTipoTrabajador obj : list) {
				PreTipoTrabajadorDTO dto = new PreTipoTrabajadorDTO();
				dto.setIdPreTipoTrabajador(obj.getIdPreTipoTrabajador());
				dto.setDescripcion(obj.getDescripcion());		
				dto.setValorHora(obj.getValorHora());				
				listPreTipoTrabajadorDTO.add(dto);
			}
		}
		return listPreTipoTrabajadorDTO; 
	}
	
	public List<PreTipoTrabajadorDTO> findAll() throws IctException{
		List<PreTipoTrabajadorDTO> listPreTipoTrabajadorDTO = new ArrayList<PreTipoTrabajadorDTO>();		
		List<PreTipoTrabajador> list = preTipoTrabajadorDAO.findAll();
		if (list!=null && list.size()>0){
			for (PreTipoTrabajador obj : list) {
				PreTipoTrabajadorDTO dto = new PreTipoTrabajadorDTO();
				dto.setIdPreTipoTrabajador(obj.getIdPreTipoTrabajador());
				dto.setDescripcion(obj.getDescripcion());		
				dto.setValorHora(obj.getValorHora());				
				listPreTipoTrabajadorDTO.add(dto);
			}
		}
		return listPreTipoTrabajadorDTO; 
	}
	
	@Transactional
	public boolean update(PreTipoTrabajadorDTO dto) {
    	boolean exito=false;
    	try {
    		PreTipoTrabajador obj = new PreTipoTrabajador();    		
    		obj.setIdPreTipoTrabajador(dto.getIdPreTipoTrabajador());
    		obj.setDescripcion(dto.getDescripcion());		
    		obj.setValorHora(dto.getValorHora());    		
    		preTipoTrabajadorDAO.update(obj);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }

}
