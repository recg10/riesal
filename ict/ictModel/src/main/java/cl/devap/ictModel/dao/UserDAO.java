package cl.devap.ictModel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cl.devap.ict.exception.IctException;
import cl.devap.ict.exception.IctExceptionEnum;
import cl.devap.ictModel.model.User;
import cl.devap.ictModel.model.Usuario;

@Repository
public class UserDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void delete(User object){
		try {
			User doc = (User)object;
			
			manager.remove(manager.contains(doc) ? doc : manager.merge(doc));					
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
		}
		
	}
		
	public boolean create(User object) {
		boolean save=false;
		
		try {
			User doc =(User)object; 
	        
	        manager.persist(doc);
	        
	        save=true;
		} catch (Exception e) {
			System.out.println(e);			
		}finally{
		}
		return save;
    }
	
	public List<Usuario> find(User object) throws IctException {		
		try {
			Query query = manager.createQuery("SELECT usuario FROM Usuario AS usuario WHERE usuario.rut=:rut AND usuario.clave=:password");
	        query.setParameter("rut", new Integer(object.getRut()));
	        query.setParameter("password", object.getClave());
	        return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IctException(IctExceptionEnum.ACT_0001);
		}finally{
		}
    }
	
	public List<User> find() {		
		try {
			Query query = manager.createQuery("SELECT user FROM User AS user");	       
	        return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
		}	
	return null;
    }
	
    public boolean update(User object) {
    	boolean exito=false;
    	try {
			User doc = (User) object;
	        
	        manager.merge(doc);
	        
	        exito=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
		}		
    	return exito;
    }
   
}
