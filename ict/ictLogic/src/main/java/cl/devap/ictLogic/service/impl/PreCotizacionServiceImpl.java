package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreCotizacionDTO;
import cl.devap.ictLogic.service.PreCotizacionService;
import cl.devap.ictModel.dao.PreCotizacionDAO;
import cl.devap.ictModel.model.PreCotizacion;

@Service
@Transactional
public class PreCotizacionServiceImpl implements PreCotizacionService{
	
final static Logger logger = Logger.getLogger(PreCotizacionService.class);
	
	@Autowired
	PreCotizacionDAO preCotizacionDAO;
	
	@Transactional
	public Integer save(PreCotizacionDTO dto) throws IctException{
		PreCotizacion ent = new PreCotizacion();
		ent.setArea(dto.getArea());
		ent.setEstado(dto.getEstado());
//		ent.setGastoOperacionalCantidad(dto.getGastoOperacionalCantidad());
//		ent.setGastoOperacionalValor(dto.getGastoOperacionalValor());
		ent.setIdCotizacion(dto.getIdCotizacion());
//		ent.setMontoUnidadCotizacion(dto.getMontoUnidadCotizacion());
		ent.setPlantel(dto.getPlantel());
//		ent.setPrevencionCantidad(dto.getPrevencionCantidad());
//		ent.setPrevencionValor(dto.getPrevencionValor());
//		ent.setTrasladoPlantelCantidad(dto.getTrasladoPlantelCantidad());
//		ent.setTrasladoPlantelValor(dto.getTrasladoPlantelValor());
//		ent.setUnidadCotizacion(dto.getUnidadCotizacion());
//		ent.setUtilidadRiesalPorc(dto.getUtilidadRiesalPorc());
//		ent.setUtilidadRiesalValor(dto.getUtilidadRiesalValor());
		ent.setCodigo(dto.getCodigo());
		ent.setDetalleTrabajo(dto.getDetalleTrabajo());
		ent.setDireccion(dto.getDireccion());
		ent.setEmpresa(dto.getEmpresa());
		ent.setFecha(dto.getFecha());
//		ent.setObservaciones(dto.getObservaciones());
		ent.setSupervisor(dto.getSupervisor());
		ent.setTrabajo(dto.getTrabajo());
		
		ent.setMoPorc(dto.getMoPorc());
		ent.setMoResult(dto.getMoResult());
		ent.setGoPorc(dto.getGoPorc());
		ent.setGoResult(dto.getGoResult());
		ent.setMaterialesPorc(dto.getMaterialesPorc());
		ent.setMaterialesResult(dto.getMaterialesResult());
		ent.setUtilidadPorc(dto.getUtilidadPorc());
		ent.setUtilidadResult(dto.getUtilidadResult());
		ent.setTrasladoCantidad(dto.getTrasladoCantidad());
		ent.setTrasladoValor(dto.getTrasladoValor());
		ent.setTotal(dto.getTotal());	
		ent.setTotalNetoPresupuesto(dto.getTotalNetoPresupuesto());
		ent.setTotalPresupuesto(dto.getTotalPresupuesto());
		
		
		return preCotizacionDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreCotizacion preCotizacion = new PreCotizacion();		
			preCotizacion.setIdCotizacion(id);	
			preCotizacionDAO.delete(preCotizacion);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public List<PreCotizacionDTO> find(Long idCotizacion) throws IctException{
		List<PreCotizacionDTO> listPreCotizacionDTO = new ArrayList<PreCotizacionDTO>();		
		List<PreCotizacion> list = preCotizacionDAO.find(idCotizacion);
		if (list!=null && list.size()>0){
			for (PreCotizacion obj : list) {
				PreCotizacionDTO dto = new PreCotizacionDTO();
				dto.setArea(obj.getArea());
				dto.setEstado(obj.getEstado());
//				dto.setGastoOperacionalCantidad(obj.getGastoOperacionalCantidad());
//				dto.setGastoOperacionalValor(obj.getGastoOperacionalValor());
				dto.setIdCotizacion(obj.getIdCotizacion());
//				dto.setMontoUnidadCotizacion(obj.getMontoUnidadCotizacion());
				dto.setPlantel(obj.getPlantel());
//				dto.setPrevencionCantidad(obj.getPrevencionCantidad());
//				dto.setPrevencionValor(obj.getPrevencionValor());
//				dto.setTrasladoPlantelCantidad(obj.getTrasladoPlantelCantidad());
//				dto.setTrasladoPlantelValor(obj.getTrasladoPlantelValor());
//				dto.setUnidadCotizacion(obj.getUnidadCotizacion());
//				dto.setUtilidadRiesalPorc(obj.getUtilidadRiesalPorc());
				dto.setCodigo(obj.getCodigo());
				dto.setDetalleTrabajo(obj.getDetalleTrabajo());
				dto.setDireccion(obj.getDireccion());
				dto.setEmpresa(obj.getEmpresa());
				dto.setFecha(obj.getFecha());
//				dto.setObservaciones(obj.getObservaciones());
				dto.setSupervisor(obj.getSupervisor());
				dto.setTrabajo(obj.getTrabajo());
				
				dto.setMoPorc(obj.getMoPorc());
				dto.setMoResult(obj.getMoResult());
				dto.setGoPorc(obj.getGoPorc());
				dto.setGoResult(obj.getGoResult());
				dto.setMaterialesPorc(obj.getMaterialesPorc());
				dto.setMaterialesResult(obj.getMaterialesResult());
				dto.setUtilidadPorc(obj.getUtilidadPorc());
				dto.setUtilidadResult(obj.getUtilidadResult());
				dto.setTrasladoCantidad(obj.getTrasladoCantidad());
				dto.setTrasladoValor(obj.getTrasladoValor());
				dto.setTotal(obj.getTotal());	
				dto.setTotalNetoPresupuesto(obj.getTotalNetoPresupuesto());
				dto.setTotalPresupuesto(obj.getTotalPresupuesto());
				
				
				listPreCotizacionDTO.add(dto);
			}			
		}
		return listPreCotizacionDTO; 
	}
	
	public List<PreCotizacionDTO> findAll() throws IctException{
		List<PreCotizacionDTO> listPreCotizacionDTO = new ArrayList<PreCotizacionDTO>();		
		List<PreCotizacion> list = preCotizacionDAO.findAll();
		if (list!=null && list.size()>0){
			for (PreCotizacion obj : list) {
				PreCotizacionDTO dto = new PreCotizacionDTO();
				dto.setArea(obj.getArea());
				dto.setEstado(obj.getEstado());
//				dto.setGastoOperacionalCantidad(obj.getGastoOperacionalCantidad());
//				dto.setGastoOperacionalValor(obj.getGastoOperacionalValor());
				dto.setIdCotizacion(obj.getIdCotizacion());
//				dto.setMontoUnidadCotizacion(obj.getMontoUnidadCotizacion());
				dto.setPlantel(obj.getPlantel());
//				dto.setPrevencionCantidad(obj.getPrevencionCantidad());
//				dto.setPrevencionValor(obj.getPrevencionValor());
//				dto.setTrasladoPlantelCantidad(obj.getTrasladoPlantelCantidad());
//				dto.setTrasladoPlantelValor(obj.getTrasladoPlantelValor());
//				dto.setUnidadCotizacion(obj.getUnidadCotizacion());
//				dto.setUtilidadRiesalPorc(obj.getUtilidadRiesalPorc());
				dto.setCodigo(obj.getCodigo());
				dto.setDetalleTrabajo(obj.getDetalleTrabajo());
				dto.setDireccion(obj.getDireccion());
				dto.setEmpresa(obj.getEmpresa());
				dto.setFecha(obj.getFecha());
//				dto.setObservaciones(obj.getObservaciones());
				dto.setSupervisor(obj.getSupervisor());
				dto.setTrabajo(obj.getTrabajo());	
				
				dto.setMoPorc(obj.getMoPorc());
				dto.setMoResult(obj.getMoResult());
				dto.setGoPorc(obj.getGoPorc());
				dto.setGoResult(obj.getGoResult());
				dto.setMaterialesPorc(obj.getMaterialesPorc());
				dto.setMaterialesResult(obj.getMaterialesResult());
				dto.setUtilidadPorc(obj.getUtilidadPorc());
				dto.setUtilidadResult(obj.getUtilidadResult());
				dto.setTrasladoCantidad(obj.getTrasladoCantidad());
				dto.setTrasladoValor(obj.getTrasladoValor());
				dto.setTotal(obj.getTotal());	
				dto.setTotalNetoPresupuesto(obj.getTotalNetoPresupuesto());
				dto.setTotalPresupuesto(obj.getTotalPresupuesto());
				
				
				listPreCotizacionDTO.add(dto);
			}			
		}
		return listPreCotizacionDTO; 
	}
	
	@Transactional
	public boolean update(PreCotizacionDTO obj) {
    	boolean exito=false;
    	try {
    		PreCotizacion ent = new PreCotizacion();
			ent.setArea(obj.getArea());
			ent.setEstado(obj.getEstado());
//			ent.setGastoOperacionalCantidad(obj.getGastoOperacionalCantidad());
//			ent.setGastoOperacionalValor(obj.getGastoOperacionalValor());
			ent.setIdCotizacion(obj.getIdCotizacion());
//			ent.setMontoUnidadCotizacion(obj.getMontoUnidadCotizacion());
			ent.setPlantel(obj.getPlantel());
//			ent.setPrevencionCantidad(obj.getPrevencionCantidad());
//			ent.setPrevencionValor(obj.getPrevencionValor());
//			ent.setTrasladoPlantelCantidad(obj.getTrasladoPlantelCantidad());
//			ent.setTrasladoPlantelValor(obj.getTrasladoPlantelValor());
//			ent.setUnidadCotizacion(obj.getUnidadCotizacion());
//			ent.setUtilidadRiesalPorc(obj.getUtilidadRiesalPorc());
			ent.setCodigo(obj.getCodigo());
			ent.setDetalleTrabajo(obj.getDetalleTrabajo());
			ent.setDireccion(obj.getDireccion());
			ent.setEmpresa(obj.getEmpresa());
			ent.setFecha(obj.getFecha());
//			ent.setObservaciones(obj.getObservaciones());
			ent.setSupervisor(obj.getSupervisor());
			ent.setTrabajo(obj.getTrabajo());	
			
			ent.setMoPorc(obj.getMoPorc());
    		ent.setMoResult(obj.getMoResult());
    		ent.setGoPorc(obj.getGoPorc());
    		ent.setGoResult(obj.getGoResult());
    		ent.setMaterialesPorc(obj.getMaterialesPorc());
    		ent.setMaterialesResult(obj.getMaterialesResult());
    		ent.setUtilidadPorc(obj.getUtilidadPorc());
    		ent.setUtilidadResult(obj.getUtilidadResult());
    		ent.setTrasladoCantidad(obj.getTrasladoCantidad());
    		ent.setTrasladoValor(obj.getTrasladoValor());
    		ent.setTotal(obj.getTotal());	
    		
    		ent.setTotalNetoPresupuesto(obj.getTotalNetoPresupuesto());
    		ent.setTotalPresupuesto(obj.getTotalPresupuesto());
			
			
			preCotizacionDAO.update(ent);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }

}
