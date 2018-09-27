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
import cl.devap.ictModel.model.Proveedor;
import cl.devap.ictModel.model.User;
import cl.devap.ictModel.model.Usuario;

@Repository
public class ProveedorDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void delete(Proveedor object){		
		try {
			entityManager.remove(entityManager.contains(object) ? object : entityManager.merge(object));
		} catch (Exception e) {
			System.out.println(e);
		}finally{			
		}
	}
		
	public boolean create(Proveedor object) {
		boolean save=false;		
		try {
	        entityManager.persist(object);	        
	        save=true;
		} catch (Exception e) {
			System.out.println(e);			
		}finally{
		}
		return save;
    }
	
	public List<Proveedor> find(Proveedor object) throws IctException {		
		try {
			Query query = entityManager.createQuery("SELECT proveedor FROM Proveedor AS proveedor WHERE proveedor.rut=:rut");
	        query.setParameter("rut", new Integer(object.getRut()));	       
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
			
		}
    }
	
	public List<Proveedor> find() {		
		try {			
			Query query = entityManager.createQuery("SELECT proveedor FROM Proveedor AS proveedor");	       
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}	
	return null;
    }
	
    public boolean update(Proveedor object) {
    	boolean exito=false;
    	try {
			entityManager.merge(object);			
	        exito=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			
		}		
    	return exito;
    }
   
}
