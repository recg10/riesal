package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreCotizacionItemDTO;
import cl.devap.ictCommon.user.PreDetalleCotizacionDTO;
import cl.devap.ictCommon.user.PreFabricacionCotizacionDTO;
import cl.devap.ictCommon.user.PreMOCotizacionDTO;
import cl.devap.ictLogic.service.PreCotizacionItemService;
import cl.devap.ictLogic.service.PreDetalleCotizacionService;
import cl.devap.ictLogic.service.PreFabricacionCotizacionService;
import cl.devap.ictLogic.service.PreMOCotizacionService;
import cl.devap.ictModel.dao.PreCotizacionItemDAO;
import cl.devap.ictModel.model.PreCotizacionItem;

@Service
public class PreCotizacionItemServiceImpl implements PreCotizacionItemService{
	
final static Logger logger = Logger.getLogger(PreCotizacionItemServiceImpl.class);
	
	@Autowired
	PreCotizacionItemDAO preCotizacionItemDAO;

	@Autowired PreDetalleCotizacionService preDetalleCotizacionService;
	@Autowired PreMOCotizacionService preMOCotizacionService;
	@Autowired PreFabricacionCotizacionService preFabricacionCotizacionService;
	
	@Transactional
	public boolean save(PreCotizacionItemDTO dto) throws IctException{
		PreCotizacionItem ent = new PreCotizacionItem();
		ent.setIdCotizacion(dto.getIdCotizacion());
		ent.setCantidad(dto.getCantidad());
		ent.setIdItem(dto.getIdItem());
		ent.setDescripcion(dto.getDescripcion());		
		
		
		
		return preCotizacionItemDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Long id) throws IctException{
		try {
			PreCotizacionItem preCotizacion = new PreCotizacionItem();		
			preCotizacion.setId(id);	
			preCotizacionItemDAO.delete(preCotizacion);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public List<PreCotizacionItemDTO> find(Long idCotizacion) throws IctException{
		List<PreCotizacionItemDTO> listPreCotizacionItemDTO = new ArrayList<PreCotizacionItemDTO>();		
		List<PreCotizacionItem> list = preCotizacionItemDAO.find(idCotizacion);
		if (list!=null && list.size()>0){
			for (PreCotizacionItem obj : list) {
				PreCotizacionItemDTO dto = new PreCotizacionItemDTO();
				dto.setIdCotizacion(obj.getIdCotizacion());
				dto.setCantidad(obj.getCantidad());
				dto.setId(obj.getId());
				dto.setIdItem(obj.getIdItem());
				dto.setDescripcion(obj.getDescripcion());
				List<PreDetalleCotizacionDTO> listTotalMeteriales = preDetalleCotizacionService.findByItem(idCotizacion, obj.getId());
				Long totalMaterialNeto = new Long(0);
				for (PreDetalleCotizacionDTO dtoMaterial : listTotalMeteriales) {
					totalMaterialNeto += (dtoMaterial.getSubTotal()!=null ? dtoMaterial.getSubTotal() : new Long(0));
				}
				
				List<PreMOCotizacionDTO> listTotal = preMOCotizacionService.find(idCotizacion, obj.getId());
				Long totalMONeto = new Long(0);
				for (PreMOCotizacionDTO dtoMO : listTotal) {
					totalMONeto += (dtoMO.getSubTotal()!=null ? dtoMO.getSubTotal() : new Long(0));
				}
				
				List<PreFabricacionCotizacionDTO> listTotalFabricaicion = preFabricacionCotizacionService.findByItem(idCotizacion, obj.getId());
				Long totalFabricacionNeto = new Long(0);
				for (PreFabricacionCotizacionDTO dtoF : listTotalFabricaicion) {
					totalFabricacionNeto += (dtoF.getSubTotal()!=null ? dtoF.getSubTotal() : new Long(0));
				}
				
				dto.setTotalNeto(totalMaterialNeto+totalMONeto+totalFabricacionNeto);
				dto.setValorUnitario((dto.getTotalNeto())/obj.getCantidad());
				
				
				
				
				
				
				listPreCotizacionItemDTO.add(dto);
			}			
		}
		return listPreCotizacionItemDTO; 
	}
	
	public List<PreCotizacionItemDTO> findAll() throws IctException{
		List<PreCotizacionItemDTO> listPreCotizacionItemDTO = new ArrayList<PreCotizacionItemDTO>();		
		List<PreCotizacionItem> list = preCotizacionItemDAO.findAll();
		if (list!=null && list.size()>0){
			for (PreCotizacionItem obj : list) {
				PreCotizacionItemDTO dto = new PreCotizacionItemDTO();
				dto.setIdCotizacion(obj.getIdCotizacion());
				dto.setCantidad(dto.getCantidad());
				dto.setIdItem(obj.getIdItem());
				dto.setDescripcion(obj.getDescripcion());					
				listPreCotizacionItemDTO.add(dto);
			}			
		}
		return listPreCotizacionItemDTO; 
	}
	
	@Transactional
	public boolean update(PreCotizacionItemDTO dto) {
    	boolean exito=false;
    	try {
    		PreCotizacionItem ent = new PreCotizacionItem();
    		ent.setIdCotizacion(dto.getIdCotizacion());
    		ent.setId(dto.getId());
    		ent.setIdItem(dto.getIdItem());
    		ent.setCantidad(dto.getCantidad());
    		ent.setDescripcion(dto.getDescripcion());
    		
			preCotizacionItemDAO.update(ent);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }
}
