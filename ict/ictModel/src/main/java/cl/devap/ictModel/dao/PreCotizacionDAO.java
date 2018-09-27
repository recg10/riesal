package cl.devap.ictModel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.devap.ict.exception.IctException;
import cl.devap.ict.exception.IctExceptionEnum;
import cl.devap.ictModel.model.PreCotizacion;

@Repository
public class PreCotizacionDAO {
	
	@PersistenceContext
	private EntityManager manager;
		
	public void delete(PreCotizacion object){
		try {			
			
			manager.getTransaction().begin();
			manager.remove(manager.contains(object) ? object : manager.merge(object));					
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			
		}
		
	}
	
	public Integer create(PreCotizacion object) {
		Integer save=null;		
		try {
			manager.persist(object);
			manager.flush();
	        save = object.getIdCotizacion();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return save;
    }
	
	@SuppressWarnings("unchecked")
	public List<PreCotizacion> find(Long idCotizacion) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preCotizacion FROM PreCotizacion AS preCotizacion WHERE preCotizacion.idCotizacion=:idCotizacion");
	        query.setParameter("idCotizacion", idCotizacion.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally {
			
		}
    }
	
	public List<PreCotizacion> findAll() {		
		try {
			
			Query query = manager.createQuery("SELECT preCotizacion FROM PreCotizacion AS preCotizacion ORDER BY idCotizacion DESC");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			
		}	
	return null;
    }
	@Transactional
    public boolean update(PreCotizacion object) {
    	boolean exito=false;
    	try {
					
//	        manager.getTransaction().begin();
	        manager.merge(object);
	        manager.flush();
//	        manager.getTransaction().commit();
	        exito=true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			
		}		
    	return exito;
    }
   
}
