package cl.devap.ictLogic.service;

import java.util.List;

import cl.devap.ict.exception.IctException;
import cl.devap.ictCommon.user.PlantelDTO;

public interface PlantelService  {
	
	public List<PlantelDTO> findAll() throws IctException;
	
}
