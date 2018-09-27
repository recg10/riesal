package cl.devap.ictModel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cl.devap.ict.exception.IctException;
import cl.devap.ict.exception.IctExceptionEnum;
import cl.devap.ictModel.model.Plantel;

@Repository
public class PlantelDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void delete(Plantel object){
		try {
			
			manager.remove(manager.contains(object) ? object : manager.merge(object));					
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		
	}
		
	public boolean create(Plantel object) {
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
	public List<Plantel> find(Long idCotizacion) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT plantel FROM Plantel AS plantel WHERE plantel.seccion=:seccion");
	        query.setParameter("seccion", idCotizacion.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<Plantel> findAll() {		
		try {
			
			Query query = manager.createQuery("SELECT plantel FROM Plantel AS plantel");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}
	return null;
    }
	
    public boolean update(Plantel object) {
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
