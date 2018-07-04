package cl.devap.ictModel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cl.devap.ict.exception.IctException;
import cl.devap.ict.exception.IctExceptionEnum;
import cl.devap.ictModel.model.PreDetalleCotizacion;

@Repository
public class PreDetalleCotizacionDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void delete(PreDetalleCotizacion object){
		try {
			
			
			PreDetalleCotizacion obj = (PreDetalleCotizacion)object;
			
			manager.remove(manager.contains(obj) ? obj : manager.merge(obj));					
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		
	}
		
	public boolean create(PreDetalleCotizacion object) {
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
	public List<PreDetalleCotizacion> find(Long idCotizacion) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preDetalleCotizacion FROM PreDetalleCotizacion AS preDetalleCotizacion WHERE preDetalleCotizacion.idCotizacion=:idCotizacion");
	        query.setParameter("idCotizacion", idCotizacion.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	@SuppressWarnings("unchecked")
	public List<PreDetalleCotizacion> findByItem(Long idCotizacion, Long idItem) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preDetalleCotizacion FROM PreDetalleCotizacion AS preDetalleCotizacion WHERE preDetalleCotizacion.idCotizacion=:idCotizacion AND preDetalleCotizacion.idCotizacionItem=:idItem ");
	        query.setParameter("idCotizacion", idCotizacion.intValue());
	        query.setParameter("idItem", idItem);
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<PreDetalleCotizacion> find() {		
		try {
			
			Query query = manager.createQuery("SELECT preDetalleCotizacion FROM PreDetalleCotizacion AS preDetalleCotizacion");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}
	return null;
    }
	
    public boolean update(PreDetalleCotizacion object) {
    	boolean exito=false;
    	try {
			
			PreDetalleCotizacion doc = (PreDetalleCotizacion) object;
	        
	        manager.merge(doc);
	        
	        exito=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}	
    	return exito;
    }
   
}
