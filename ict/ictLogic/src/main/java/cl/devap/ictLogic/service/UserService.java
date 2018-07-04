package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.UserDTO;

public interface UserService  {
	
	public boolean save(UserDTO userDTO) throws IctException;
	public boolean delete(int rut) throws IctException;
	public UserDTO login(String rut, String pass)  throws IctException;
	public List<UserDTO> getUser() throws IctException;
	public boolean update(UserDTO userDTO) throws IctException;
	
}
