package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.ProveedorDTO;

public interface ProveedorService  {
	
	public boolean save(ProveedorDTO userDTO) throws IctException;
	public boolean delete(int rut) throws IctException;
	public List<ProveedorDTO> find() throws IctException;
	public boolean update(ProveedorDTO userDTO) throws IctException;
	
}
