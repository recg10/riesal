package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreMaterialTipoDTO;
import cl.devap.ictLogic.service.PreMaterialTipoService;
import cl.devap.ictModel.dao.PreMaterialTipoDAO;
import cl.devap.ictModel.model.PreMaterialTipo;

@Service
public class PreMaterialTipoServiceImpl implements PreMaterialTipoService{
	
	final static Logger logger = Logger.getLogger(PreMaterialTipoServiceImpl.class);
	
	@Autowired
	private PreMaterialTipoDAO preMaterialTipoDAO;
	
	@Transactional
	public Integer save(PreMaterialTipoDTO dto) throws IctException{
		PreMaterialTipo ent = new PreMaterialTipo();
		ent.setIdMaterialTipo(null);
		ent.setDescripcion(dto.getDescripcion());
		return preMaterialTipoDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreMaterialTipo preMaterialTipo = new PreMaterialTipo();		
			preMaterialTipo.setIdMaterialTipo(id);	
			preMaterialTipoDAO.delete(preMaterialTipo);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public List<PreMaterialTipoDTO> find(Long id) throws IctException{
				
		List<PreMaterialTipoDTO> listPreMaterialTipoDTO = new ArrayList<PreMaterialTipoDTO>();
		List<PreMaterialTipo> list = preMaterialTipoDAO.find(id);
		if (list!=null && list.size()>0){
			for (PreMaterialTipo obj : list) {
				PreMaterialTipoDTO dto = new PreMaterialTipoDTO();
				dto.setIdMaterialTipo(obj.getIdMaterialTipo());
				dto.setDescripcion(obj.getDescripcion());		
				listPreMaterialTipoDTO.add(dto);
			}
		}
		return listPreMaterialTipoDTO; 
	}
	
	public List<PreMaterialTipoDTO> findAll() throws IctException{
		List<PreMaterialTipoDTO> listPreMaterialTipoDTO = new ArrayList<PreMaterialTipoDTO>();
		List<PreMaterialTipo> list = preMaterialTipoDAO.findAll();
		if (list!=null && list.size()>0){
			for (PreMaterialTipo obj : list) {
				PreMaterialTipoDTO dto = new PreMaterialTipoDTO();
				dto.setIdMaterialTipo(obj.getIdMaterialTipo());
				dto.setDescripcion(obj.getDescripcion());		
				listPreMaterialTipoDTO.add(dto);
			}
		}
		return listPreMaterialTipoDTO;		
	}
	
	@Transactional
	public boolean update(PreMaterialTipoDTO dto) {
    	boolean exito=false;
    	try {
    		PreMaterialTipo ent = new PreMaterialTipo();
    		ent.setIdMaterialTipo(dto.getIdMaterialTipo());
    		ent.setDescripcion(dto.getDescripcion());    		
			preMaterialTipoDAO.update(ent);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }

}
