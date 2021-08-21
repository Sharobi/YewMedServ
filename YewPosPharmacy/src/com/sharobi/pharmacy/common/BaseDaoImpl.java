/**
 * 
 */
package com.sharobi.pharmacy.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * @author habib
 *
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	/**
	 * logger for logging purpose
	 */
	public static final Log daoLogger = LogFactory.getLog(BaseDaoImpl.class);
	
	private EntityManagerFactory entityManagerFactory = PersistenceListener.getEntityManager();
	

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public T save(T obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T add(T obj) throws Exception {
		// TODO Auto-generated method stub
		daoLogger.info("in :add method");
		//this.entityManagerFactory=PersistenceListener.getEntityManager();
		EntityManager em=this.entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		daoLogger.info("trying to save : " + obj.toString());
		em.persist(obj);
		em.getTransaction().commit();
		return obj;
	}

	@Override
	public T update(T obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteObject(T obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getObject(int id, int storeId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getObjects(String searchClause) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getObjects(T obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
