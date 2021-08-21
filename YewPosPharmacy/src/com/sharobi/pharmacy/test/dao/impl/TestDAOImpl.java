package com.sharobi.pharmacy.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.inventory.model.CountryMaster;
import com.sharobi.pharmacy.test.dao.TestDAO;

@Repository
public class TestDAOImpl implements TestDAO {

	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public List<CountryMaster> getAllaccgroups() {
		List<CountryMaster> countryMasters = new ArrayList<>();
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Query qry = em
					.createQuery("SELECT cm FROM CountryMaster cm");

			countryMasters = (List<CountryMaster>) qry.getResultList();

			//logger.info("CountryMaster fetched");

		} catch (Exception e) {
			e.printStackTrace();
			//throw new DAOException("In DAOException", e);

		} finally {
			em.close();
		}
		System.out.println("DAO cms = "+countryMasters);
		return countryMasters;
	}

	@Override
	public List<CountryMaster> getspeccntris(CountryMaster cm) {
		List<CountryMaster> countryMasters = new ArrayList<>();
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Query qry = em.createQuery("SELECT cm FROM CountryMaster cm where cm.id>:id");
			qry.setParameter("id", cm.getId());
			
			countryMasters = (List<CountryMaster>) qry.getResultList();

			//logger.info("CountryMaster fetched");

		} catch (Exception e) {
			e.printStackTrace();
			//throw new DAOException("In DAOException", e);

		} finally {
			em.close();
		}
		System.out.println("DAO cms = "+countryMasters);
		return countryMasters;
	}
	
}
