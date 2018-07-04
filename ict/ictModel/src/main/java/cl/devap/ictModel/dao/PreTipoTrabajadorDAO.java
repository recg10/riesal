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
import cl.devap.ictModel.model.PreTipoTrabajador;

@Repository
public class PreTipoTrabajadorDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void delete(PreTipoTrabajador object){
		try {
			
			
			
			manager.remove(manager.contains(object) ? object : manager.merge(object));					
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		
	}
		
	public Integer create(PreTipoTrabajador object) {
		int save = 0;		
		try {
			
	        
	        manager.persist(object);
	        
	        save = object.getIdPreTipoTrabajador();
	       
		} catch (Exception e) {
			System.out.println(e);			
		}finally{
			
		}
		return save;
    }
	
	@SuppressWarnings("unchecked")
	public List<PreTipoTrabajador> find(Long id) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT plantel FROM PreTipoTrabajador AS preTipoTrabajador WHERE preTipoTrabajador.idPreTipoTrabajador=:id");
	        query.setParameter("id", id.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<PreTipoTrabajador> findAll() {		
		try {
			
			Query query = manager.createQuery("SELECT preTipoTrabajador FROM PreTipoTrabajador AS preTipoTrabajador");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}
	return null;
    }
	
    public boolean update(PreTipoTrabajador object) {
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
