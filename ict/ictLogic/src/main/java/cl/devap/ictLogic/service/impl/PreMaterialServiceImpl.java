package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PreMaterialCotizacionDTO;
import cl.devap.ictCommon.user.PreMaterialTipoDTO;
import cl.devap.ictLogic.service.PreMaterialService;
import cl.devap.ictModel.dao.PreMaterialCotizacionDAO;
import cl.devap.ictModel.model.PreMaterialCotizacion;
import cl.devap.ictModel.model.PreMaterialTipo;
import cl.devap.ictModel.model.Proveedor;

@Service
public class PreMaterialServiceImpl implements PreMaterialService{
	
	final static Logger logger = Logger.getLogger(PreMaterialServiceImpl.class);
	
	@Autowired
	private PreMaterialCotizacionDAO preMaterialCotizacionDAO;
	
	@Transactional
	public Integer save(PreMaterialCotizacionDTO dto) throws IctException{
		PreMaterialCotizacion ent = new PreMaterialCotizacion();
		ent.setDescripcion(dto.getDescripcion());		
		ent.setPrecio(dto.getPrecio()!=null?dto.getPrecio():new Integer(0));		
		ent.setStock(dto.getStock()!=null?dto.getStock():new Integer(0));
		ent.setStockCritico(dto.getStockCritico()!=null?dto.getStockCritico():new Integer(0));
		PreMaterialTipo preMaterialTipo = new PreMaterialTipo();
		preMaterialTipo.setIdMaterialTipo(dto.getPreMaterialTipoDTO().getIdMaterialTipo());
		preMaterialTipo.setDescripcion(dto.getPreMaterialTipoDTO().getDescripcion());
		ent.setPreMaterialTipo(preMaterialTipo);
		if ( dto.getProveedorRut()!=null ){
			Proveedor proveedor = new Proveedor();
			proveedor.setRut(dto.getProveedorRut());
			ent.setProveedor(proveedor );				
		}
		return preMaterialCotizacionDAO.create(ent);		 
	}
	
	@Transactional
	public boolean delete(Integer id) throws IctException{
		try {
			PreMaterialCotizacion PreMaterialCotizacion = new PreMaterialCotizacion();		
			PreMaterialCotizacion.setIdMaterialCotizacion(id);	
			preMaterialCotizacionDAO.delete(PreMaterialCotizacion);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	@Transactional
	public List<PreMaterialCotizacionDTO> find(Long id) throws IctException{
		List<PreMaterialCotizacionDTO> listPreMaterialCotizacionDTO = new ArrayList<PreMaterialCotizacionDTO>();		
		List<PreMaterialCotizacion> list = preMaterialCotizacionDAO.find(id);
		if (list!=null && list.size()>0){
			for (PreMaterialCotizacion obj : list) {
				PreMaterialCotizacionDTO dto = new PreMaterialCotizacionDTO();
				dto.setIdMaterialCotizacion(obj.getIdMaterialCotizacion());
				dto.setDescripcion(obj.getDescripcion());		
				dto.setPrecio(obj.getPrecio());
				dto.setStock(obj.getStock());
				dto.setStockCritico(obj.getStockCritico());
				PreMaterialTipoDTO preMaterialTipoDTO = new PreMaterialTipoDTO();
				preMaterialTipoDTO.setIdMaterialTipo(obj.getPreMaterialTipo().getIdMaterialTipo());
				preMaterialTipoDTO.setDescripcion(obj.getPreMaterialTipo().getDescripcion());
				dto.setPreMaterialTipoDTO(preMaterialTipoDTO);
				if ( obj.getProveedor()!=null ){
					dto.setProveedorRut(obj.getProveedor().getRut());
					dto.setNombreProveedor(obj.getProveedor().getRazonSocial());
				}
				listPreMaterialCotizacionDTO.add(dto);
			}
		}
		return listPreMaterialCotizacionDTO; 
	}
	@Transactional
	public List<PreMaterialCotizacionDTO> findAll() throws IctException{
		List<PreMaterialCotizacionDTO> listPreMaterialCotizacionDTO = new ArrayList<PreMaterialCotizacionDTO>();		
		List<PreMaterialCotizacion> list = preMaterialCotizacionDAO.findAll();
		if (list!=null && list.size()>0){
			for (PreMaterialCotizacion obj : list) {
				PreMaterialCotizacionDTO dto = new PreMaterialCotizacionDTO();
				dto.setIdMaterialCotizacion(obj.getIdMaterialCotizacion());
				dto.setDescripcion(obj.getDescripcion());		
				dto.setPrecio(obj.getPrecio());
				dto.setStock(obj.getStock());
				dto.setStockCritico(obj.getStockCritico());
				PreMaterialTipoDTO preMaterialTipoDTO = new PreMaterialTipoDTO();
				if (obj.getPreMaterialTipo()!=null){
					preMaterialTipoDTO.setIdMaterialTipo(obj.getPreMaterialTipo().getIdMaterialTipo());
					preMaterialTipoDTO.setDescripcion(obj.getPreMaterialTipo().getDescripcion());	
				}				
				dto.setPreMaterialTipoDTO(preMaterialTipoDTO);
				if ( obj.getProveedor()!=null ){
					dto.setProveedorRut(obj.getProveedor().getRut());
					dto.setNombreProveedor(obj.getProveedor().getRazonSocial());
				}
				listPreMaterialCotizacionDTO.add(dto);
			}			
		}
		return listPreMaterialCotizacionDTO; 
	}
	
	@Transactional
	public boolean update(PreMaterialCotizacionDTO dto) {
    	boolean exito=false;
    	try {
    		PreMaterialCotizacion obj = new PreMaterialCotizacion();    		
    		obj.setIdMaterialCotizacion(dto.getIdMaterialCotizacion());
    		obj.setDescripcion(dto.getDescripcion());		
    		obj.setPrecio(dto.getPrecio()!=null?dto.getPrecio():new Integer(0));
    		obj.setStock(dto.getStock()!=null?dto.getStock():new Integer(0));
    		obj.setStockCritico(dto.getStockCritico()!=null?dto.getStockCritico():new Integer(0));
    		
    		PreMaterialTipo preMaterialTipo = new PreMaterialTipo();
    		preMaterialTipo.setIdMaterialTipo(dto.getPreMaterialTipoDTO().getIdMaterialTipo());
    		preMaterialTipo.setDescripcion(dto.getPreMaterialTipoDTO().getDescripcion());
    		obj.setPreMaterialTipo(preMaterialTipo);
    		if ( dto.getProveedorRut()!=null ){
				Proveedor proveedor = new Proveedor();
				proveedor.setRut(dto.getProveedorRut());
				obj.setProveedor(proveedor );				
			}
			preMaterialCotizacionDAO.update(obj);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }

}
