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
import cl.devap.ictModel.model.PreDetalleCotizacion;
import cl.devap.ictModel.model.PreGuiaDespacho;

@Repository
public class PreGuiaDespachoDAO {
	
	@PersistenceContext
	private EntityManager manager;
		
	public void delete(PreGuiaDespacho object){
		try {
						
			
			manager.remove(manager.contains(object) ? object : manager.merge(object));					
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
		
	public Integer create(PreGuiaDespacho object) {
		Integer save=null;
		
		try {
			 
	        
	        manager.persist(object);
	        
	        save = object.getIdGuiaDespacho();
		} catch (Exception e) {
			System.out.println(e);			
		}finally{
			
		}
		return save;
    }
	
	@SuppressWarnings("unchecked")
	public List<PreGuiaDespacho> find(Long id) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preGuiaDespacho FROM PreGuiaDespacho AS preGuiaDespacho WHERE preGuiaDespacho.numeroGuia=:id");
	        query.setParameter("id", id.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<PreGuiaDespacho> findAll() {		
		try {			
			Query query = manager.createQuery("SELECT preGuiaDespacho FROM PreGuiaDespacho AS preGuiaDespacho ORDER BY idGuiaDespacho DESC");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}
	return null;
    }
	
    public boolean update(PreGuiaDespacho object) {
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
