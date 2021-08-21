package com.sharobi.pharmacy.dashboard.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.commonutil.StoredProcedures;
import com.sharobi.pharmacy.dashboard.dao.DashboardDAO;
import com.sharobi.pharmacy.dashboard.model.Dashboard;
import com.sharobi.pharmacy.dashboard.model.GraphData;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.store.model.StoreMaster;

import net.sf.resultsetmapper.ReflectionResultSetMapper;

public class DashboardDAOImpl implements DashboardDAO {
	
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Dashboard getAllCount(CommonResultSetMapper cm) throws DAOException {
		EntityManager em = null;
		//int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		Dashboard dashboard=null;
		ResultSet rs = null;

		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			try {
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_GET_ALL_COUNT);
					
					callableStatement.setInt(1, cm.getCompanyId());
					
					if(cm.getId()==0)
						callableStatement.setInt(2, cm.getStoreId());
					else
						callableStatement.setInt(2, cm.getId());
					
					callableStatement.setInt(3, cm.getFinYrId());
					callableStatement.setString(4, cm.getStartDate());
					callableStatement.setString(5, cm.getEndDate());
					
					callableStatement.execute();
					rs = callableStatement.getResultSet();
					
					ReflectionResultSetMapper<Dashboard> resultSetMapper = new ReflectionResultSetMapper<Dashboard>(
							Dashboard.class);
					while(rs.next()){
						dashboard = resultSetMapper.mapRow(rs);					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("getTotalCount", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return dashboard;
	}

	@Override
	public GraphData getAllTransMonthWise(CommonResultSetMapper cm) throws DAOException {
		EntityManager em = null;
		//int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		GraphData graphData=new GraphData();
		ResultSet rs = null;

		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			try {
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_GET_All_TRANS_MONTHWISE);
					
					callableStatement.setInt(1, cm.getCompanyId());
					
					if(cm.getId()==0)
						callableStatement.setInt(2, cm.getStoreId());
					else
						callableStatement.setInt(2, cm.getId());
					
					callableStatement.setInt(3, cm.getFinYrId());
					callableStatement.setString(4, cm.getStartDate());
					callableStatement.setString(5, cm.getEndDate());
					
					callableStatement.execute();
					rs = callableStatement.getResultSet();
					
					//System.out.println("Sales = "+rs.getRowId(1));
					
					
					/*ReflectionResultSetMapper<GraphData> resultSetMapper = new ReflectionResultSetMapper<GraphData>(
							GraphData.class);*/
					int i=0;
					while(rs.next()) {
						//System.out.println("Sales = "+rs.getString(1));
						if(i==0)
						{
							graphData.setSales(rs.getString(1));
						}
						else
						{
							graphData.setSalesReturn(rs.getString(1));
						}
						//graphData = resultSetMapper.mapRow(rs);		
						i++;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("getAllTransMonthWise", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return graphData;
	}
	
	@Override
	public List<StoreMaster> getAllStore() throws DAOException {

		
		List<StoreMaster> list=new ArrayList<StoreMaster>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_STORE);
			
			//callableStatement.setInt(1, mapper.getCompanyId());			
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<StoreMaster> resultSetMapper = new ReflectionResultSetMapper<StoreMaster>(
					StoreMaster.class);
			while(rs.next()){
				StoreMaster storeMaster = new StoreMaster();
				storeMaster = resultSetMapper.mapRow(rs);
				list.add(storeMaster);
			}
//			logger.info("get Total Store details");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}

	@Override
	public GraphData getAllCountMonthWise(CommonResultSetMapper cm) throws DAOException {
		EntityManager em = null;
		//int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		GraphData graphData=new GraphData();
		ResultSet rs = null;

		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			try {
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_GET_All_COUNT_MONTHWISE);
					
					callableStatement.setInt(1, cm.getCompanyId());
					
					if(cm.getId()==0)
						callableStatement.setInt(2, cm.getStoreId());
					else
						callableStatement.setInt(2, cm.getId());
					
					callableStatement.setInt(3, cm.getFinYrId());
					callableStatement.setString(4, cm.getStartDate());
					callableStatement.setString(5, cm.getEndDate());
					
					callableStatement.execute();
					rs = callableStatement.getResultSet();
					
					//System.out.println("Sales = "+rs.getRowId(1));
					
					
					/*ReflectionResultSetMapper<GraphData> resultSetMapper = new ReflectionResultSetMapper<GraphData>(
							GraphData.class);*/
					int i=0;
					while(rs.next()) {
						//System.out.println("Sales = "+rs.getString(1));
						if(i==0)
						{
							graphData.setSales(rs.getString(1));
						}
						else
						{
							graphData.setSalesReturn(rs.getString(1));
						}
						//graphData = resultSetMapper.mapRow(rs);		
						i++;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("getAllCountMonthWise", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return graphData;
	}

	@Override
	public List<StoreMaster> getAllStoreByCompanyId(int companyId) throws DAOException {

		
		List<StoreMaster> list=new ArrayList<StoreMaster>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_STORE_BY_COMPANYID);
			
			callableStatement.setInt(1, companyId);
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<StoreMaster> resultSetMapper = new ReflectionResultSetMapper<StoreMaster>(
					StoreMaster.class);
			while(rs.next()){
				StoreMaster storeMaster = new StoreMaster();
				storeMaster = resultSetMapper.mapRow(rs);
				list.add(storeMaster);
			}
//			logger.info("get Total Store details");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}

}
