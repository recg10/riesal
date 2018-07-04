package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PlantelDTO;
import cl.devap.ictLogic.service.PlantelService;
import cl.devap.ictModel.dao.PlantelDAO;
import cl.devap.ictModel.model.Plantel;

@Service
public class PlantelServiceImpl implements PlantelService{
	
final static Logger logger = Logger.getLogger(PlantelServiceImpl.class);
	
	@Autowired
	PlantelDAO plantelDAO;
	
//	public boolean save(PreCotizacionDTO dto) throws IctException{
//		PreCotizacion ent = new PreCotizacion();
//		ent.setArea(dto.getArea());
//		ent.setEstado(dto.getEstado());
//		ent.setGastoOperacionalCantidad(dto.getGastoOperacionalCantidad());
//		ent.setGastoOperacionalValor(dto.getGastoOperacionalValor());
//		ent.setIdCotizacion(dto.getIdCotizacion());
//		ent.setMontoUnidadCotizacion(dto.getMontoUnidadCotizacion());
//		ent.setPlantel(dto.getPlantel());
//		ent.setPrevencionCantidad(dto.getPrevencionCantidad());
//		ent.setPrevencionValor(dto.getPrevencionValor());
//		ent.setTrasladoPlantelCantidad(dto.getTrasladoPlantelCantidad());
//		ent.setTrasladoPlantelValor(dto.getTrasladoPlantelValor());
//		ent.setUnidadCotizacion(dto.getUnidadCotizacion());
//		ent.setUtilidadRiesalPorc(dto.getUtilidadRiesalPorc());
//		ent.setCodigo(dto.getCodigo());
//		ent.setDetalleTrabajo(dto.getDetalleTrabajo());
//		ent.setDireccion(dto.getDireccion());
//		ent.setEmpresa(dto.getEmpresa());
//		ent.setFecha(dto.getFecha());
//		ent.setObservaciones(dto.getObservaciones());
//		ent.setSupervisor(dto.getSupervisor());
//		ent.setTrabajo(dto.getTrabajo());		
//		return preCotizacionDAO.create(ent);		 
//	}
	
//	public boolean delete(Integer id) throws IctException{
//		try {
//			PreCotizacion preCotizacion = new PreCotizacion();		
//			preCotizacion.setIdCotizacion(id);	
//			preCotizacionDAO.delete(preCotizacion);	
//			return true;
//		} catch (Exception e) {
//			logger.error("Error delete", e);
//			return false;
//		}
//			 
//	}
	
	public List<PlantelDTO> findAll() throws IctException{
		List<PlantelDTO> listDTO = new ArrayList<PlantelDTO>();		
		List<Plantel> list = plantelDAO.findAll();
		if (list!=null && list.size()>0){
			for (Plantel obj : list) {
				PlantelDTO dto = new PlantelDTO();
				dto.setId(obj.getId());
				dto.setPlantel(obj.getPlantel());
				dto.setSeccion(obj.getSeccion());				
				listDTO.add(dto);
			}			
		}
		return listDTO; 
	}
	
//	public boolean update(UserDTO object) {
//    	boolean exito=false;
//    	try {
//			User user = new User();		
//			user.setRut(object.getRut());	
//			user.setDigito(object.getDigito());
//			user.setPassword(object.getPassword());
//			user.setNick(object.getUsername());			
//			userDao.update(user);	
//			exito=true;
//		} catch (Exception e) {
//			logger.error("Error update", e);
//			return false;
//		}
//    	return exito;
//    }
}
