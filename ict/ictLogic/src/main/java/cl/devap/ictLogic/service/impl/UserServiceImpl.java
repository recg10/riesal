package cl.devap.ictLogic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.UserDTO;
import cl.devap.ictLogic.service.UserService;
import cl.devap.ictModel.dao.UserDAO;
import cl.devap.ictModel.model.User;
import cl.devap.ictModel.model.Usuario;

@Service
public class UserServiceImpl implements UserService{
	
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDAO userDao;
	@Override
	public boolean save(UserDTO userDTO) {
		User user = new User();
		user.setClave(userDTO.getClave());			
		user.setRut(userDTO.getRut());
		user.setDigito(userDTO.getDigito());
		user.setNombres(userDTO.getNombres());
		user.setMaterno(userDTO.getMaterno());
		user.setPaterno(userDTO.getPaterno());	
		user.setPerfil(userDTO.getPerfil());
		return userDao.create(user);		 
	}
	
	@Transactional
	public boolean delete(int rut) throws IctException{
		try {
			User user = new User();		
			user.setRut(rut);	
			userDao.delete(user);	
			return true;
		} catch (Exception e) {
			logger.error("Error delete", e);
			return false;
		}
			 
	}
	
	public UserDTO login(String rut, String pass)  throws IctException{
		logger.debug("logeando: rut"+rut +" pass"+pass );
		UserDTO userDTO = null;
		User user = new User();
		user.setClave(pass);
		user.setRut(new Integer(rut));
		List<Usuario> list = userDao.find(user);
		if (list!=null && list.size()>0){
			userDTO = new UserDTO();
			Usuario userVO = list.get(0);
			userDTO.setClave(userVO.getClave());				
			userDTO.setRut(userVO.getRut());
			userDTO.setDigito(userVO.getDigito());
			userDTO.setNombres(userVO.getNombres());
			userDTO.setMaterno(userVO.getMaterno());
			userDTO.setPaterno(userVO.getPaterno());
			userDTO.setPerfil(userVO.getPerfil());
		}
		return userDTO; 
		
		
	}
	
	public List<UserDTO> getUser() throws IctException {
		List<UserDTO> listUserDTO = new ArrayList<>();		
		List<User> list = userDao.find();
		if (list!=null && list.size()>0){
			for (User user : list) {
				UserDTO userDTO = new UserDTO();
				userDTO.setClave(user.getClave());				
				userDTO.setRut(user.getRut());
				userDTO.setDigito(user.getDigito());
				userDTO.setNombres(user.getNombres());
				userDTO.setMaterno(user.getMaterno());
				userDTO.setPaterno(user.getPaterno());
				userDTO.setPerfil(user.getPerfil());
//				userDTO.setPerfil(user.getIdPerfil().getId());
				listUserDTO.add(userDTO);
			}			
		}
		return listUserDTO; 
	}
	
	@Transactional
	public boolean update(UserDTO userDTO) throws IctException{
    	boolean exito=false;
    	try {
			User user = new User();			
			user.setClave(userDTO.getClave());			
			user.setRut(userDTO.getRut());
			user.setDigito(userDTO.getDigito());
			user.setNombres(userDTO.getNombres());
			user.setMaterno(userDTO.getMaterno());
			user.setPaterno(userDTO.getPaterno());
			user.setPerfil(userDTO.getPerfil());
			userDao.update(user);	
			exito=true;
		} catch (Exception e) {
			logger.error("Error update", e);
			return false;
		}
    	return exito;
    }

}
