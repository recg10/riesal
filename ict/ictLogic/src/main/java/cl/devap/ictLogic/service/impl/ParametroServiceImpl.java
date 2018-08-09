package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.ParametroDTO;
import cl.devap.ictLogic.service.ParametroService;
import cl.devap.ictModel.dao.ParametroDAO;
import cl.devap.ictModel.model.PreParametro;

@Service
public class ParametroServiceImpl implements ParametroService{
	
final static Logger logger = Logger.getLogger(ParametroServiceImpl.class);
	
	@Autowired
	ParametroDAO parametroDAO;
	
	@Transactional
	public boolean save(ParametroDTO dto) throws IctException{
		PreParametro ent = new PreParametro();
		ent.setNumerico(dto.getNumerico());
		ent.setId(dto.getId());
		ent.setNombre(dto.getNombre());
		ent.setTexto(dto.getTexto());		
		return parametroDAO.create(ent);		 
	}
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreParametro preParametro = new PreParametro();		
			preParametro.setId(id);	
			parametroDAO.delete(preParametro);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public List<ParametroDTO> findAll() throws IctException{
		List<ParametroDTO> listDTO = new ArrayList<ParametroDTO>();		
		List<PreParametro> list = parametroDAO.findAll();
		if (list!=null && list.size()>0){
			for (PreParametro obj : list) {
				ParametroDTO dto = new ParametroDTO();
				dto.setId(obj.getId());
				dto.setTexto(obj.getTexto());
				dto.setNombre(obj.getNombre());				
				dto.setNumerico(obj.getNumerico());
				listDTO.add(dto);
			}			
		}
		return listDTO; 
	}
	
	
	public List<ParametroDTO> findById(Long id) throws IctException{
		List<ParametroDTO> listDTO = new ArrayList<ParametroDTO>();		
		List<PreParametro> list = parametroDAO.findById(id);
		if (list!=null && list.size()>0){
			for (PreParametro obj : list) {
				ParametroDTO dto = new ParametroDTO();
				dto.setId(obj.getId());
				dto.setTexto(obj.getTexto());
				dto.setNombre(obj.getNombre());				
				dto.setNumerico(obj.getNumerico());
				listDTO.add(dto);
			}			
		}
		return listDTO; 
	}
	
	@Transactional
	public boolean update(ParametroDTO dto) {
    	boolean exito=false;
    	try {
			PreParametro ent = new PreParametro();
			ent.setId(dto.getId());
			ent.setTexto(dto.getTexto());
			ent.setNombre(dto.getNombre());				
			ent.setNumerico(dto.getNumerico());			
			parametroDAO.update(ent);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }
}
