package cl.devap.ictModel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cl.devap.ict.exception.IctException;
import cl.devap.ict.exception.IctExceptionEnum;
import cl.devap.ictModel.model.Plantel;
import cl.devap.ictModel.model.PreParametro;

@Repository
public class ParametroDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void delete(PreParametro object){
		try {			
			manager.remove(manager.contains(object) ? object : manager.merge(object));
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		
	}
		
	public boolean create(PreParametro object) {
		boolean save=false;		
		try {
	        manager.persist(object);	        
	        save=true;
		} catch (Exception e) {
			System.out.println(e);			
		}finally{
			
		}
		return save;
    }
	
	@SuppressWarnings("unchecked")
	public List<PreParametro> find(Long id) throws IctException {		
		try {			
			Query query = manager.createQuery("SELECT preParametro FROM PreParametro AS preParametro WHERE preParametro.id=:id");
	        query.setParameter("id", id.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<PreParametro> findAll() {		
		try {			
			Query query = manager.createQuery("SELECT preParametro FROM PreParametro AS preParametro");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}
	return null;
    }
	
	public List<PreParametro> findById(Long id) {		
		try {			
			Query query = manager.createQuery("SELECT preParametro FROM PreParametro AS preParametro WHERE preParametro.id=:id");
			query.setParameter("id", id.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}
	return null;
    }
	
    public boolean update(PreParametro object) {
    	boolean exito=false;
    	try {			
	        manager.merge(object);	        
	        exito=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}
    	return exito;
    }
   
}
