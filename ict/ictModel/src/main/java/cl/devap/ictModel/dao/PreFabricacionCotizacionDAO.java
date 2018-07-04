package cl.devap.ictModel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cl.devap.ict.exception.IctException;
import cl.devap.ict.exception.IctExceptionEnum;
import cl.devap.ictModel.model.PreFabricacionCotizacion;

@Repository
public class PreFabricacionCotizacionDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void delete(PreFabricacionCotizacion object){
		try {
			
			PreFabricacionCotizacion obj = (PreFabricacionCotizacion)object;
			
			manager.remove(manager.contains(obj) ? obj : manager.merge(obj));					
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		
	}
		
	public boolean create(PreFabricacionCotizacion object) {
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
	public List<PreFabricacionCotizacion> find(Long idCotizacion) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preFabricacionCotizacion FROM PreFabricacionCotizacion AS preFabricacionCotizacion WHERE preFabricacionCotizacion.idCotizacion=:idCotizacion");
	        query.setParameter("idCotizacion", idCotizacion.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	@SuppressWarnings("unchecked")
	public List<PreFabricacionCotizacion> findByItem(Long idCotizacion, Long idItem) throws IctException {		
		try {		
			Query query = manager.createQuery("SELECT preFabricacionCotizacion FROM PreFabricacionCotizacion AS preFabricacionCotizacion WHERE preFabricacionCotizacion.idCotizacion=:idCotizacion AND preFabricacionCotizacion.idCotizacionItem=:idItem ");
	        query.setParameter("idCotizacion", idCotizacion.intValue());
	        query.setParameter("idItem", idItem);
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	@SuppressWarnings("unchecked")
	public List<PreFabricacionCotizacion> findByItemTipo(Long idCotizacion, Long idItem, Integer tipo) throws IctException {		
		try {			
			Query query = manager.createQuery("SELECT preFabricacionCotizacion FROM PreFabricacionCotizacion AS preFabricacionCotizacion WHERE preFabricacionCotizacion.idCotizacion=:idCotizacion AND preFabricacionCotizacion.idCotizacionItem=:idItem AND preFabricacionCotizacion.tipo=:tipo");
	        query.setParameter("idCotizacion", idCotizacion.intValue());
	        query.setParameter("idItem", idItem);
	        query.setParameter("tipo", tipo);
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<PreFabricacionCotizacion> find() {		
		try {			
			Query query = manager.createQuery("SELECT preFabricacionCotizacion FROM PreFabricacionCotizacion AS preFabricacionCotizacion");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}	
	return null;
    }
	
    public boolean update(PreFabricacionCotizacion object) {
    	boolean exito=false;
    	try {
			
			PreFabricacionCotizacion doc = (PreFabricacionCotizacion) object;
	        
	        manager.merge(doc);
	        
	        exito=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}	
    	return exito;
    }
   
}
