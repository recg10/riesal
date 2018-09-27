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
import cl.devap.ictModel.model.PreGuiaDespacho;
import cl.devap.ictModel.model.PreGuiaDespachoDetalle;

@Repository
public class PreGuiaDespachoDetalleDAO {
	
	@PersistenceContext
	private EntityManager manager;
		
	public void delete(PreGuiaDespachoDetalle object){
		try {
			
			manager.remove(manager.contains(object) ? object : manager.merge(object));					
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		
	}
		
	public Integer create(PreGuiaDespachoDetalle object) {
		Integer save=null;
		
		try {
			
	        
	        manager.persist(object);
	        
	        save = object.getIdGuiaDespachoDetalle();
		} catch (Exception e) {
			System.out.println(e);			
		}finally{
			
		}
		return save;
    }
	
	@SuppressWarnings("unchecked")
	public List<PreGuiaDespachoDetalle> find(Long id) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preGuiaDespachoDetalle FROM PreGuiaDespachoDetalle AS preGuiaDespachoDetalle WHERE preGuiaDespachoDetalle.idGuiaDespachoDetalle=:id");
	        query.setParameter("id", id.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	@SuppressWarnings("unchecked")
	public List<PreGuiaDespachoDetalle> findByIdGuia(Long idGuia) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preGuiaDespachoDetalle FROM PreGuiaDespachoDetalle AS preGuiaDespachoDetalle WHERE preGuiaDespachoDetalle.idGuia=:idGuia");
	        query.setParameter("idGuia", idGuia.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<PreGuiaDespachoDetalle> findAll() {		
		try {
			
			Query query = manager.createQuery("SELECT preGuiaDespachoDetalle FROM PreGuiaDespachoDetalle AS preGuiaDespachoDetalle");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}	
	return null;
    }
	
    public boolean update(PreGuiaDespachoDetalle object) {
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
