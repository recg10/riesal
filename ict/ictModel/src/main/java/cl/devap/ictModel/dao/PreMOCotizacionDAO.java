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
import cl.devap.ictModel.model.PreDetalleCotizacion;
import cl.devap.ictModel.model.PreMOCotizacion;
import cl.devap.ictModel.model.User;
import cl.devap.ictModel.model.Usuario;

@Repository
public class PreMOCotizacionDAO {
	
	
	@PersistenceContext
	private EntityManager manager;

	public void delete(PreMOCotizacion object){
		try {
			
			manager.remove(manager.contains(object) ? object : manager.merge(object));					
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		
	}
		
	public boolean create(PreMOCotizacion object) {
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
	public List<PreMOCotizacion> find(Long idCotizacion) throws IctException {		
		try {
			Query query = manager.createQuery("SELECT preMOCotizacion FROM PreMOCotizacion AS preMOCotizacion WHERE preMOCotizacion.idCotizacion=:idCotizacion");
	        query.setParameter("idCotizacion", idCotizacion.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	@SuppressWarnings("unchecked")
	public List<PreMOCotizacion> find(Long idCotizacion, Long id) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preMOCotizacion FROM PreMOCotizacion AS preMOCotizacion WHERE preMOCotizacion.idCotizacion=:idCotizacion AND preMOCotizacion.idCotizacionItem=:id");
	        query.setParameter("idCotizacion", idCotizacion.intValue());
	        query.setParameter("id", id);
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<PreMOCotizacion> find() {		
		try {
			
			Query query = manager.createQuery("SELECT preMOCotizacion FROM PreMOCotizacion AS preMOCotizacion");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}
	return null;
    }
	
    public boolean update(PreMOCotizacion object) {
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
