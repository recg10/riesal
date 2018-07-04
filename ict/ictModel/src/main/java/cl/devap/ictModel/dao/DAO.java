package cl.devap.ictModel.dao;


public interface DAO<T>{	
	public void create (T object);
	public void delete (T object);
	public void update (T object);
	public T[] list ();
	public T listById (String id);
}
