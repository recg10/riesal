package cl.devap.ictModel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cl.devap.ict.exception.IctException;
import cl.devap.ict.exception.IctExceptionEnum;
import cl.devap.ictModel.model.PreMaterialCotizacion;
import cl.devap.ictModel.model.PreMaterialTipo;

@Repository
public class PreMaterialTipoDAO {
	
	@PersistenceContext
	private EntityManager manager;
		
	public void delete(PreMaterialTipo object){
		try {
			manager.remove(manager.contains(object) ? object : manager.merge(object));			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
		}
		
	}
		
	public Integer create(PreMaterialTipo object) {
		Integer save=null;	
		try {
	        manager.persist(object);	       
	        save = object.getIdMaterialTipo();
		} catch (Exception e) {
			System.out.println(e);			
		}finally{
			
		}
		return save;
    }
	
	@SuppressWarnings("unchecked")
	public List<PreMaterialTipo> find(Long id) throws IctException {		
		try {
			
			Query query = manager.createQuery("SELECT preMaterialTipo FROM PreMaterialTipo AS preMaterialTipo WHERE preMaterialTipo.idMaterialTipo=:id");
	        query.setParameter("id", id.intValue());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<PreMaterialTipo> findAll() {		
		try {
			Query query = manager.createQuery("SELECT preMaterialTipo FROM PreMaterialTipo AS preMaterialTipo ORDER BY preMaterialTipo.descripcion ASC");
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}
	return null;
    }
	
    public boolean update(PreMaterialTipo object) {
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
