package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.ProveedorDTO;
import cl.devap.ictLogic.service.ProveedorService;
import cl.devap.ictModel.dao.ProveedorDAO;
import cl.devap.ictModel.model.Proveedor;

@Service
public class ProveedorServiceImpl implements ProveedorService{
	
	final static Logger logger = Logger.getLogger(ProveedorServiceImpl.class);
	
	@Autowired
	ProveedorDAO proveedorDao;
	
	@Override
	@Transactional
	public boolean save(ProveedorDTO dto) {
		Proveedor obj = new Proveedor();		
		obj.setRut(dto.getRut());
		obj.setDigito(dto.getDigito());
		obj.setRazonSocial(dto.getRazonSocial());
		obj.setDireccion(dto.getDireccion());
		obj.setComuna(dto.getComuna());	
		return proveedorDao.create(obj);		 
	}
	
	@Transactional
	public boolean delete(int rut) throws IctException{
		try {
			Proveedor obj = new Proveedor();	
			obj.setRut(rut);	
			proveedorDao.delete(obj);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}

//	public ProveedorDTO login(String rut, String pass)  throws IctException{
//		logger.debug("logeando: rut"+rut +" pass"+pass );
//			ProveedorDTO dto = null;
//			Proveedor proveedor = new Proveedor();			
//			proveedor.setRut(new Integer(rut));
//			List<Proveedor> list = proveedorDao.find(proveedor);
//			if (list!=null && list.size()>0){
//				dto = new ProveedorDTO();
//				Proveedor userVO = list.get(0);								
//				dto.setRut(userVO.getRut());
//				dto.setDigito(userVO.getDigito());
//				dto.setRazonSocial(userVO.getRazonSocial());
//				dto.setDireccion(userVO.getDireccion());
//				dto.setComuna(userVO.getComuna());
//			}
//			return dto; 
//		
//		
//	}
	
	public List<ProveedorDTO> find() throws IctException {
		List<ProveedorDTO> listUserDTO = new ArrayList<>();		
		List<Proveedor> list = proveedorDao.find();
		if (list!=null && list.size()>0){
			for (Proveedor obj : list) {
				ProveedorDTO userDTO = new ProveedorDTO();								
				userDTO.setRut(obj.getRut());
				userDTO.setDigito(obj.getDigito());
				userDTO.setRazonSocial(obj.getRazonSocial());
				userDTO.setDireccion(obj.getDireccion());
				userDTO.setComuna(obj.getComuna());
				listUserDTO.add(userDTO);
			}			
		}
		return listUserDTO; 
	}
	
	@Transactional
	public boolean update(ProveedorDTO dto) throws IctException{
    	boolean exito=false;
    	try {
    		Proveedor proveedor = new Proveedor();						
			proveedor.setRut(dto.getRut());
			proveedor.setDigito(dto.getDigito());
			proveedor.setRazonSocial(dto.getRazonSocial());
			proveedor.setDireccion(dto.getDireccion());
			proveedor.setComuna(dto.getComuna());
			proveedorDao.update(proveedor);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }

}
