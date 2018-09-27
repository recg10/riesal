package cl.devap.ictModel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cl.devap.ict.exception.IctException;
import cl.devap.ict.exception.IctExceptionEnum;
import cl.devap.ictModel.model.PreCotizacion;
import cl.devap.ictModel.model.PreCotizacionItem;

@Repository
public class PreCotizacionItemDAO {
	
	@PersistenceContext
	private EntityManager manager;
		
	public void delete(PreCotizacionItem object){
		try {						
			
			manager.remove(manager.contains(object) ? object : manager.merge(object));					
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
		
	public boolean create(PreCotizacionItem object) {
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
	public List<PreCotizacionItem> find(Long idCotizacion) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preCotizacionItem FROM PreCotizacionItem AS preCotizacionItem WHERE preCotizacionItem.idCotizacion=:idCotizacion");
	        query.setParameter("idCotizacion", idCotizacion.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<PreCotizacionItem> findAll() {		
		try {			
			Query query = manager.createQuery("SELECT preCotizacionItem FROM PreCotizacionItem AS preCotizacionItem");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}	
	return null;
    }
	
    public boolean update(PreCotizacionItem object) {
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
