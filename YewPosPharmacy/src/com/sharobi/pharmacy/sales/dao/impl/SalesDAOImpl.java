package com.sharobi.pharmacy.sales.dao.impl;

import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.model.EsiCodeMaster;
import com.sharobi.pharmacy.common.model.TypeMaster;
import com.sharobi.pharmacy.commonutil.DateUtil;
import com.sharobi.pharmacy.commonutil.StoredProcedures;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.sales.dao.SalesDAO;
import com.sharobi.pharmacy.sales.model.CustPaymentDetailsAllDTO;
import com.sharobi.pharmacy.sales.model.CustPaymentDetailsByIdDTO;
import com.sharobi.pharmacy.sales.model.CustomerInfoDTO;
import com.sharobi.pharmacy.sales.model.CustomerPayment;
import com.sharobi.pharmacy.sales.model.PaymentMode;
import com.sharobi.pharmacy.sales.model.SaleDetailsAllDTO;
import com.sharobi.pharmacy.sales.model.SaleDetailsDTO;
import com.sharobi.pharmacy.sales.model.SaleDetailsForReturnDTO;
import com.sharobi.pharmacy.sales.model.SaleHeaderDTO;
import com.sharobi.pharmacy.sales.model.SaleItemDetailsDTO;
import com.sharobi.pharmacy.sales.model.SaleReturn;
import com.sharobi.pharmacy.sales.model.SaleReturnDTO;
import com.sharobi.pharmacy.sales.model.SaleReturnDetailsDTO;
import com.sharobi.pharmacy.sales.model.SaleReturnLedger;
import com.sharobi.pharmacy.sales.model.Sales;
import com.sharobi.pharmacy.sales.model.TaxDetailsSaleBillDTO;

import net.sf.resultsetmapper.ReflectionResultSetMapper;

/**
 * rajarshi
 */
public class SalesDAOImpl implements SalesDAO {

	private final static Logger logger = LogManager
			.getLogger(SalesDAOImpl.class);

	private EntityManagerFactory entityManagerFactory = PersistenceListener.getEntityManager();;

	public SalesDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SaleHeaderDTO getSalesHeader(CommonResultSetMapper mapper) throws DAOException {

		SaleHeaderDTO sales = new SaleHeaderDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_HEADER);
			callableStatement.setInt(1, mapper.getSaleId());			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleHeaderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleHeaderDTO>(
					SaleHeaderDTO.class);
			while(rs.next()){
				sales = resultSetMapper.mapRow(rs);
			}
			logger.info("sale header fetched");

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

		return sales;
	}
	
	@Override
	public CustPaymentDetailsAllDTO getCustPaymentHeaderById(CommonResultSetMapper mapper) throws DAOException {

		CustPaymentDetailsAllDTO custPay = new CustPaymentDetailsAllDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_PAYMENT_HEADER);
			callableStatement.setInt(1, mapper.getPaymentId());			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustPaymentDetailsAllDTO> resultSetMapper = new ReflectionResultSetMapper<CustPaymentDetailsAllDTO>(
					CustPaymentDetailsAllDTO.class);
			while(rs.next()){
				custPay = resultSetMapper.mapRow(rs);
			}
			logger.info("cust payment header fetched");

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

		return custPay;
	}
	
	@Override
	public List<CustomerInfoDTO> getCustWithCreditLimitByName(CommonResultSetMapper mapper) throws DAOException {

		List<CustomerInfoDTO> custInfoList = new ArrayList<CustomerInfoDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_CREDIT_LIMIT_BY_NAME);
			callableStatement.setInt(1, mapper.getCompanyId());	
			callableStatement.setInt(2, mapper.getStoreId());	
			callableStatement.setInt(3, mapper.getFinYrId());	
			callableStatement.setString(4, mapper.getCustName());	
			callableStatement.setString(5, mapper.getCustPh());	
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(6, asonDate);
			}
			else {
				callableStatement.setDate(6, null);
			}
			callableStatement.setInt(7, mapper.getSaleId());	
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustomerInfoDTO> resultSetMapper = new ReflectionResultSetMapper<CustomerInfoDTO>(
					CustomerInfoDTO.class);
			while(rs.next()){
				CustomerInfoDTO customerInfoDTO=new CustomerInfoDTO();
				customerInfoDTO = resultSetMapper.mapRow(rs);
				custInfoList.add(customerInfoDTO);
				
			}
			logger.info("cust credit limit by name fetched");

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

		return custInfoList;
	}
	
	@Override
	public SaleHeaderDTO getSalesHeaderByInvNo(CommonResultSetMapper mapper) throws DAOException {

		SaleHeaderDTO sales = new SaleHeaderDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_HEADER_BY_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleHeaderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleHeaderDTO>(
					SaleHeaderDTO.class);
			while(rs.next()){
				sales = resultSetMapper.mapRow(rs);
			}
			logger.info("sale header by inv no. fetched");

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

		return sales;
	}
	
	@Override
	public List<SaleDetailsDTO> getSalesDetailsById(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsDTO> list=new ArrayList<SaleDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS);
			callableStatement.setInt(1, mapper.getSaleId());			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsDTO>(
					SaleDetailsDTO.class);
			while(rs.next()){
				SaleDetailsDTO sales = new SaleDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("sale details fetched");

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
	public List<SaleItemDetailsDTO> getSaleItemDetailsByItemId(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleItemDetailsDTO> list=new ArrayList<SaleItemDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_ITEM_DETAILS_BY_ITEM_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getItemId());
			callableStatement.setInt(4, mapper.getNoOfDays());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleItemDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleItemDetailsDTO>(
					SaleItemDetailsDTO.class);
			while(rs.next()){
				SaleItemDetailsDTO sales = new SaleItemDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("sale item details fetched");

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
	public List<CommonResultSetMapper> getAutoRemarks(CommonResultSetMapper mapper) throws DAOException {

		
		List<CommonResultSetMapper> list=new ArrayList<CommonResultSetMapper>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_AUTO_REMARKS);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getRemarks());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			while(rs.next()){
				CommonResultSetMapper mapper2=new CommonResultSetMapper();
				mapper2.setRemarks(rs.getString("remarks"));
				list.add(mapper2);
			}
			logger.info("all remarks fetched");

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
	public List<TaxDetailsSaleBillDTO> getTaxDetailsForSaleBill(CommonResultSetMapper mapper) throws DAOException {

		
		List<TaxDetailsSaleBillDTO> list=new ArrayList<TaxDetailsSaleBillDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_TAX_DETAILS_SALE_BILL);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getSaleId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<TaxDetailsSaleBillDTO> resultSetMapper = new ReflectionResultSetMapper<TaxDetailsSaleBillDTO>(
					TaxDetailsSaleBillDTO.class);
			while(rs.next()){
				TaxDetailsSaleBillDTO tax = new TaxDetailsSaleBillDTO();
				tax = resultSetMapper.mapRow(rs);
				list.add(tax);
			}
			logger.info("tax details fetched");

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
	public List<SaleDetailsDTO> getSalesDetailsByIdForBill(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsDTO> list=new ArrayList<SaleDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_FOR_BILL);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getSaleId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsDTO>(
					SaleDetailsDTO.class);
			while(rs.next()){
				SaleDetailsDTO sales = new SaleDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("sale details for bill fetched");

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
	public List<PaymentMode> getPaymentModes(CommonResultSetMapper mapper) throws DAOException {

		List<PaymentMode> paymentTypeLst = new ArrayList<PaymentMode>();
		EntityManager em = null;
		try {
			int comnyId=mapper.getCompanyId();
			int storeId=mapper.getStoreId();
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();
			
			TypedQuery<PaymentMode> qry = em
					.createQuery("SELECT p FROM PaymentMode p where p.companyId=:companyId and p.storeId=:storeId", PaymentMode.class);
			qry.setParameter("companyId", comnyId);
			qry.setParameter("storeId", storeId);
			paymentTypeLst = (List<PaymentMode>) qry.getResultList();
			

			/*Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<PaymentMode>>() {
			}.getType();
			String json = gson.toJson(paymentTypeLst, type);*/
			
			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of getPaymentModes", e);

		} finally {
			if(em != null) em.close();
		}
		return paymentTypeLst;
	}
	
	@Override
	public List<TypeMaster> getTypes(CommonResultSetMapper mapper) throws DAOException {

		List<TypeMaster> types = new ArrayList<TypeMaster>();
		EntityManager em = null;
		try {
			
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();
			
			TypedQuery<TypeMaster> qry = em
					.createQuery("SELECT t FROM TypeMaster t", TypeMaster.class);
			
			types = qry.getResultList();
			

			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<TypeMaster>>() {
			}.getType();
			String json = gson.toJson(types, type);
			
			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of types", e);

		} finally {
			if(em != null) em.close();
		}
		return types;
	}
	
	@Override
	public List<EsiCodeMaster> getEsiCodes(CommonResultSetMapper mapper) throws DAOException {

		List<EsiCodeMaster> codes = new ArrayList<EsiCodeMaster>();
		EntityManager em = null;
		try {
			
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();
			
			TypedQuery<EsiCodeMaster> qry = em
					.createQuery("SELECT e FROM EsiCodeMaster e", EsiCodeMaster.class);
			
			codes = qry.getResultList();
			

			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<EsiCodeMaster>>() {
			}.getType();
			String json = gson.toJson(codes, type);
			
			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of types", e);

		} finally {
			if(em != null) em.close();
		}
		return codes;
	}
	
	@Override
	public List<SaleDetailsDTO> getSalesDetailsByInvNo(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsDTO> list=new ArrayList<SaleDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_BY_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsDTO>(
					SaleDetailsDTO.class);
			while(rs.next()){
				SaleDetailsDTO sales = new SaleDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("sale details by inv no. fetched");

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
	public List<SaleReturnDTO> getAllSalesReturnDetails(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleReturnDTO> list=new ArrayList<SaleReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					mapper.getStartDate(), "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(mapper.getEndDate(),
					"yyyy-MM-dd");
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_DETAILS);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, mapper.getInvoiceNo());
			callableStatement.setInt(7, mapper.getCustId());
			callableStatement.setString(8, mapper.getCustName());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDTO>(
					SaleReturnDTO.class);
			while(rs.next()){
				SaleReturnDTO sales = new SaleReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("sale return details fetched");

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
	public SaleReturnDTO getSaleReturnHeader(CommonResultSetMapper mapper) throws DAOException {

	
		SaleReturnDTO sales = new SaleReturnDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_HEADER);
			callableStatement.setInt(1, mapper.getSaleReturnId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDTO>(
					SaleReturnDTO.class);
			while(rs.next()){
				
				sales = resultSetMapper.mapRow(rs);
				
			}
			logger.info("sale return header fetched");

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

		return sales;
	}
	
	@Override
	public List<SaleReturnDetailsDTO> getSaleReturnDetails(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleReturnDetailsDTO> list=new ArrayList<SaleReturnDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_DETAILS_BY_ID);
			callableStatement.setInt(1, mapper.getSaleReturnId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDetailsDTO>(
					SaleReturnDetailsDTO.class);
			while(rs.next()){
				SaleReturnDetailsDTO sales = new SaleReturnDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("sale return details by id fetched");

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
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturnByItem(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsForReturnDTO> list=new ArrayList<SaleDetailsForReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_FOR_RETURN_BY_ITEM);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getItemId());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, asonDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
			
			callableStatement.setInt(5, mapper.getNoOfMonthBefore());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsForReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsForReturnDTO>(
					SaleDetailsForReturnDTO.class);
			while(rs.next()){
				SaleDetailsForReturnDTO sales = new SaleDetailsForReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("sale details for return by inv no. fetched");

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
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturn(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsForReturnDTO> list=new ArrayList<SaleDetailsForReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_FOR_RETURN_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
		
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsForReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsForReturnDTO>(
					SaleDetailsForReturnDTO.class);
			while(rs.next()){
				SaleDetailsForReturnDTO sales = new SaleDetailsForReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("sale details for return by inv no. fetched");

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
	public List<SaleReturnDTO> getAdjSaleReturn(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleReturnDTO> list=new ArrayList<SaleReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_ADJ_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
			callableStatement.setInt(4, mapper.getCustId());
			callableStatement.setString(5, mapper.getCustPh());
		
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDTO>(
					SaleReturnDTO.class);
			while(rs.next()){
				SaleReturnDTO sales = new SaleReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("adjustment sale return by inv no. fetched");

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
	public List<SaleReturnDTO> getAdjSaleReturnBySaleId(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleReturnDTO> list=new ArrayList<SaleReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_ADJ_SALEID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getSaleId());
		
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDTO>(
					SaleReturnDTO.class);
			while(rs.next()){
				SaleReturnDTO sales = new SaleReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("adjustment sale return by sale id fetched");

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
	public List<SaleDetailsAllDTO> getAllSaleDetails(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsAllDTO> list=new ArrayList<SaleDetailsAllDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_ALL);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			String invNo = mapper.getInvoiceNo();
			int custId  = mapper.getCustId();
			String custName = mapper.getCustName();		
			int rePrint = mapper.getStatus();	
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, invNo);
			callableStatement.setInt(7, custId);
			callableStatement.setString(8, custName);
			callableStatement.setInt(9, rePrint);
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsAllDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsAllDTO>(
					SaleDetailsAllDTO.class);
			while(rs.next()){
				SaleDetailsAllDTO sales = new SaleDetailsAllDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("all sale details fetched");

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
	public List<CustPaymentDetailsAllDTO> getAllCustPaymentDetails(CommonResultSetMapper mapper) throws DAOException {

		
		List<CustPaymentDetailsAllDTO> list=new ArrayList<CustPaymentDetailsAllDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_PAYMENT_DETAILS_ALL);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			String invNo = mapper.getInvoiceNo();
			int custId  = mapper.getCustId();
			String custName = mapper.getCustName();		
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, invNo);
			callableStatement.setInt(7, custId);
			callableStatement.setString(8, custName);
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustPaymentDetailsAllDTO> resultSetMapper = new ReflectionResultSetMapper<CustPaymentDetailsAllDTO>(
					CustPaymentDetailsAllDTO.class);
			while(rs.next()){
				CustPaymentDetailsAllDTO custPayment = new CustPaymentDetailsAllDTO();
				custPayment = resultSetMapper.mapRow(rs);
				list.add(custPayment);
			}
			logger.info("all cust payment details fetched");

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
	public List<CustPaymentDetailsByIdDTO> getCustPaymentDetailsById(CommonResultSetMapper mapper) throws DAOException {

		
		List<CustPaymentDetailsByIdDTO> list=new ArrayList<CustPaymentDetailsByIdDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_PAYMENT_DETAILS_BY_ID);
			int payId = mapper.getPaymentId();
			
			callableStatement.setInt(1, payId);
			callableStatement.setInt(2, mapper.getCompanyId());
			callableStatement.setInt(3, mapper.getStoreId());
			callableStatement.setInt(4, mapper.getFinYrId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustPaymentDetailsByIdDTO> resultSetMapper = new ReflectionResultSetMapper<CustPaymentDetailsByIdDTO>(
					CustPaymentDetailsByIdDTO.class);
			while(rs.next()){
				CustPaymentDetailsByIdDTO custPayment = new CustPaymentDetailsByIdDTO();
				custPayment = resultSetMapper.mapRow(rs);
				
				list.add(custPayment);
			}
			logger.info("cust payment details by id fetched");

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
	public List<CustPaymentDetailsByIdDTO> getPendingPaymentByCustomer(CommonResultSetMapper mapper) throws DAOException {

		
		List<CustPaymentDetailsByIdDTO> list=new ArrayList<CustPaymentDetailsByIdDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_PAYMENT_PENDING);
			//int payId = mapper.getPaymentId();
			java.sql.Date paymntDt = DateUtil.convertStringDateToSqlDate(
					mapper.getPaymentDate(), "yyyy-MM-dd");
			callableStatement.setInt(1, mapper.getCustId());
			callableStatement.setDate(2, paymntDt);
			callableStatement.setInt(3, mapper.getCompanyId());
			callableStatement.setInt(4, mapper.getStoreId());
			callableStatement.setInt(5, mapper.getFinYrId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustPaymentDetailsByIdDTO> resultSetMapper = new ReflectionResultSetMapper<CustPaymentDetailsByIdDTO>(
					CustPaymentDetailsByIdDTO.class);
			while(rs.next()){
				CustPaymentDetailsByIdDTO custPayment = new CustPaymentDetailsByIdDTO();
				custPayment = resultSetMapper.mapRow(rs);
				list.add(custPayment);
			}
			logger.info("cust payment pending details fetched");

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
	public List<SaleHeaderDTO> getLastSaleByCustomer(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleHeaderDTO> list=new ArrayList<SaleHeaderDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_LAST_SALE_BY_CUSTOMER);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int custId = mapper.getCustId();
			
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, custId);
			callableStatement.setString(4, mapper.getCustPh());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleHeaderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleHeaderDTO>(
					SaleHeaderDTO.class);
			while(rs.next()){
				SaleHeaderDTO sales = new SaleHeaderDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("last sale details by cust fetched");

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
	public List<CustomerMaster> getAllCustomerByNameOrPh(CommonResultSetMapper mapper) throws DAOException {

		
		List<CustomerMaster> list=new ArrayList<CustomerMaster>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUSTOMER_PHONE_OR_NAME);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			String custName = mapper.getCustName();
			String custPh = mapper.getCustPh();
			
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setString(3, custName);
			callableStatement.setString(4, custPh);
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			while(rs.next()){
				CustomerMaster cust = new CustomerMaster();
				cust.setId(rs.getInt(1));
				cust.setName(rs.getString(2));
				cust.setPhoneNo(rs.getString(3));
				cust.setCreditLimit(rs.getDouble(4));
				list.add(cust);
			}
			logger.info("fetched all customer");

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
	public String createOrUpdateSalesInvoice(Sales sales)
			throws DAOException {
		System.out.println("createOrUpdateSalesInvoice Sales = " + sales);
		EntityManager em = null;
		int status = 0;
		
		if(sales.getIs_account()==1)
		{
			List<SaleReturnLedger> sls = new ArrayList<>();
			
			if(sales.getDuties_ledger_id()!=0)
			{
				sls.add(new SaleReturnLedger("cr", sales.getDuties_ledger_id(), sales.getTaxAmount()));
			}
			if(sales.getRound_ledger_id()!=0)
			{
				String type="";
				if(sales.getRoundoff()>0)
					type="cr";
				else
					type="dr";
				
				sls.add(new SaleReturnLedger(type, sales.getRound_ledger_id(), Math.abs(sales.getRoundoff())));
			}
			
			if(sales.getAdjAmount()>0)
			{
				if(sales.getSale_ledger_id()!=0)
				{
					String type="";
					if((sales.getGrossAmount() - sales.getAdjAmount()) > 0)
						type="cr";
					else
						type="dr";
					
					if(sales.getIsExclusive()==0){
						sls.add(new SaleReturnLedger(type, sales.getSale_ledger_id(), Math.abs(sales.getGrossAmount() - sales.getTaxAmount() - sales.getAdjAmount())));
					} else if(sales.getIsExclusive()==1){
						sls.add(new SaleReturnLedger(type, sales.getSale_ledger_id(), Math.abs(sales.getGrossAmount() - sales.getAdjAmount())));
					}
					//sls.add(new SaleReturnLedger("cr", sales.getSale_ledger_id(), sales.getGrossAmount() - sales.getAdjAmount()));
				}
			}
			else
			{
				if(sales.getSale_ledger_id()!=0)
				{
					if(sales.getIsExclusive()==0){
						sls.add(new SaleReturnLedger("cr", sales.getSale_ledger_id(), sales.getGrossAmount() - sales.getTaxAmount()));
					} else if(sales.getIsExclusive()==0){
						sls.add(new SaleReturnLedger("cr", sales.getSale_ledger_id(), sales.getGrossAmount()));
					}
				}
			}
			
			if(sales.getDiscount_ledger_id()!=0)
			{
				sls.add(new SaleReturnLedger("dr", sales.getDiscount_ledger_id(), sales.getDiscAmount()));
			}
			
			/*if(sales.getCustomerId()==0)
			{
				double amt = 0D;
				amt = sales.getNetAmount() - sales.getCardAmount();
				System.out.println("cust id = 0; amt = "+amt );
			}*/
			if(sales.getCustomerId()!=0) {//when customer present
				
				if(sales.getCashAmount() == sales.getNetAmount())//full cash payment
				{
					if(sales.getDebitor_cash_ledger_id()!=0 && sales.getCashAmount()>0)
					{
						sls.add(new SaleReturnLedger("dr", sales.getDebitor_cash_ledger_id(), sales.getNetAmount() - sales.getAdjAmount()));// - sales.getAdjAmount()
					}
				}
				else //when part payment
				{
					if(sales.getCard_ledger_id()!=0 && sales.getCardAmount() != 0)
					{
						sls.add(new SaleReturnLedger("dr", sales.getCard_ledger_id(), sales.getCardAmount()));
					}
					
					if(sales.getDebitor_ledger_id()!=0 && sales.getCreditAmount()>0)
					{
						sls.add(new SaleReturnLedger("dr", sales.getDebitor_ledger_id(), sales.getCreditAmount()));
					}
					if(sales.getDebitor_cash_ledger_id()!=0 && sales.getCashAmount()>0)
					{
						sls.add(new SaleReturnLedger("dr", sales.getDebitor_cash_ledger_id(), sales.getCashAmount()));
					}
				}
				
			}
			
			if(sales.getCustomerId()==0) //when customer not present
			{
				sls.add(new SaleReturnLedger("dr", sales.getDebitor_ledger_id(), sales.getNetAmount() - sales.getAdjAmount() - sales.getCardAmount()));// - sales.getAdjAmount()
				
				if(sales.getCard_ledger_id()!=0 && sales.getCardAmount() != 0)
				{
					sls.add(new SaleReturnLedger("dr", sales.getCard_ledger_id(), sales.getCardAmount()));
				}
				
			}
			
			
			
			sales.setSalels(sls);
		}
			
		
    Connection connection = null;
    CallableStatement callableStatement = null;
    
		try {
			
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-08-24\\file_sales_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Sales.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(sales, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(sales, sw);
				String result = sw.toString();
				// System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_SALES_INVOICE);
				
				System.out.println("createOrUpdateSalesInvoice xml = "+result);
				
				callableStatement.setString(1, result);
				callableStatement.setString(2, "sales");
				callableStatement.setString(3, "salesDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				//invNo = callableStatement.getString(4);
				status = callableStatement.getInt(4);
				/*if (status == 0) {
					result1 = "" + status;
				} else if (status == 1) {
					result1 = invNo;
				}*/
				// result=result.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
				// System.out.println("formatted output::: "+result);

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
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
		return String.valueOf(status);

	}
	
	@Override
	public String createOrUpdateCustPayment(CustomerPayment customerPayment)
			throws DAOException {
		
		/*EntityManager em = null;
		//entityManagerFactory = PersistenceListener.getEntityManager();
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		StoredProcedureQuery query = em.crea
		query.registerStoredProcedureParameter("x", Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("y", Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("sum", Double.class, ParameterMode.OUT);
		
		// set input parameter
		query.setParameter("x", 1.23d);
		query.setParameter("y", 4d);

		// call the stored procedure and get the result
		query.execute();*/
		
		
		System.out.println("dao customerPayment = "+customerPayment);
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		if(customerPayment.getIs_account()!=1)
		{
			customerPayment.setCr_account_id(0);
			customerPayment.setDr_account_id(0);
			customerPayment.setCr_amount(0);
			customerPayment.setDr_amount(0);
		}
		
		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-06-06\\file_cust_payment_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(CustomerPayment.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(customerPayment, file);
				jaxbMarshaller.marshal(customerPayment, sw);
				String result = sw.toString();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_CUST_PAYMENT);
				System.out.println("dao customerPayment XML = "+result);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "customerPayment");
				callableStatement.setString(3, "customerPaymentDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(4);
			
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
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
		return String.valueOf(status);

	}
	
	@Override
	public String createOrUpdateSalesReturn(SaleReturn sales)
			throws DAOException {
		/*Round of Account (-)Credit/(+)Debit*/
		System.out.println("createOrUpdateSalesReturn sales "+sales);
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		List<SaleReturnLedger> saleReturnLedgers = new ArrayList<SaleReturnLedger>();
		
		if(sales.getIs_account()==1)
		{
			if(sales.getDuties_ledger_id()!=0)
			{
				saleReturnLedgers.add(new SaleReturnLedger("dr", sales.getDuties_ledger_id(), sales.getTaxAmount()));
			}
			if(sales.getRound_ledger_id()!=0)
			{
				String type="";
				if(sales.getRoundoff()>0)
					type="dr";// debit
				else
					type="cr";//credit
				
				
				saleReturnLedgers.add(new SaleReturnLedger(type, sales.getRound_ledger_id(), Math.abs(sales.getRoundoff())));
			}
			if(sales.getSales_ledger_id()!=0)
			{
				saleReturnLedgers.add(new SaleReturnLedger("dr", sales.getSales_ledger_id(), sales.getSale_account_credit_amt()));
			}
			if(sales.getDebitor_ledger_id()!=0)
			{
				saleReturnLedgers.add(new SaleReturnLedger("cr", sales.getDebitor_ledger_id(), sales.getDebitor_credit_amt()));
			}
				
			
			sales.setSrls(saleReturnLedgers);
		}
		
		try {
			
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-05-05\\file_sales_return_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(SaleReturn.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(sales, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(sales, sw);
				String result = sw.toString();
				// System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_SALES_RETURN);
				
				System.out.println("salesReturn xml = "+result);
				
				callableStatement.setString(1, result);
				callableStatement.setString(2, "saleReturn");
				callableStatement.setString(3, "saleReturnDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(4);
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
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
		return String.valueOf(status);

	}
	
	@Override
	public String postSalesInvoice(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int saleId=mapper.getSaleId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_SALES_INVOICE);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, saleId);
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(4);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
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
		return String.valueOf(status);

	}
	
	@Override
	public String postCustPayment(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_CUST_PAYMENT);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, mapper.getPaymentId());
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(4);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
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
		return String.valueOf(status);

	}
	
	@Override
	public String postSalesReturn(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int saleRtrnId=mapper.getSaleReturnId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_SALES_RETURN);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, saleRtrnId);
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(4);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
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
		return String.valueOf(status);

	}
	
	@Override
	public int incrementPrintCount(String id)	throws DAOException {
		EntityManager em = null;
		Sales sales=null;
		int printCount=0;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			int id1=Integer.parseInt(id);
				TypedQuery<Sales> qry = em
						.createQuery("SELECT s FROM Sales s WHERE s.id=:id and s.isDeleted=0", Sales.class);

				qry.setParameter("id", id1);
				sales = qry.getSingleResult();
				sales.setPrintCount(sales.getPrintCount()+1);
				em.merge(sales);
			
			em.getTransaction().commit();
			printCount=sales.getPrintCount();

		} catch (Exception e) {
			printCount=0;
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			if(em != null) em.close();
		}
		
		return printCount;

	}
	
	/*@Override
	public int printSaleBill(String id, String saleId)	throws DAOException {
		EntityManager em = null;
		String status = "";
		Sales sales=null;
		int printCount=0;

		try {
			int storeid=Integer.parseInt(id);
			int saleid=Integer.parseInt(saleId);
			BillPosPrinterMain billPosPrinterMain=new BillPosPrinterMain();
			billPosPrinterMain.a(storeid, saleid);
			System.out.println("print success");
			

		} catch (Exception e) {
			
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			//if(em != null) em.close();
		}
		
		return printCount;

	}*/
	
	@Override
	public String deleteSalesInvoice(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int saleid=mapper.getSaleId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_SALES_INVOICE);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, saleid);
				callableStatement.setInt(4, mapper.getDeletedBy());
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(5);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be deleted", e);
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
		return String.valueOf(status);

	}
	
	@Override
	public String deleteCustPayment(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
			
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_CUST_PAYMENT);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, mapper.getPaymentId());
				callableStatement.setInt(4, mapper.getCustId());
				callableStatement.setInt(5, mapper.getDeletedBy());
				callableStatement.registerOutParameter(6,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(6);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be deleted", e);
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
		return String.valueOf(status);

	}
	
	@Override
	public String deleteSalesReturn(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int saleid=mapper.getSaleReturnId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_SALES_RETURN);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, saleid);
				callableStatement.setInt(4, mapper.getDeletedBy());
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(5);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be deleted", e);
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
		return String.valueOf(status);

	}
	
	@Override
	public SaleHeaderDTO getSalesHeaderForBill(CommonResultSetMapper mapper) throws DAOException {

		SaleHeaderDTO sales = new SaleHeaderDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_HEADER_FOR_BILL);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getSaleId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleHeaderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleHeaderDTO>(
					SaleHeaderDTO.class);
			while(rs.next()){
				sales = resultSetMapper.mapRow(rs);
			}
			logger.info("sale header for bill fetched");

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

		return sales;
	}

	@Override
	public String postALLSalesInvoice(Sales sales) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-08-24\\file_sales_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Sales.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(sales, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(sales, sw);
				String result = sw.toString();
				// System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_ALL_SALES_INVOICE);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "sales");
				callableStatement.setString(3, "salesDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				//invNo = callableStatement.getString(4);
				status = callableStatement.getInt(4);
				/*if (status == 0) {
					result1 = "" + status;
				} else if (status == 1) {
					result1 = invNo;
				}*/
				// result=result.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
				// System.out.println("formatted output::: "+result);

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
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
		return String.valueOf(status);
	}
	@Override
	public String postALLReturnSalesInvoice(SaleReturn saleReturn) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-08-24\\file_sales_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Sales.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(sales, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(saleReturn, sw);
				String result = sw.toString();
				// System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_ALL_SALES_RETURN_INVOICE);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "saleReturn");
				callableStatement.setString(3, "saleReturnDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				//invNo = callableStatement.getString(4);
				status = callableStatement.getInt(4);
				/*if (status == 0) {
					result1 = "" + status;
				} else if (status == 1) {
					result1 = invNo;
				}*/
				// result=result.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
				// System.out.println("formatted output::: "+result);

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
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
		return String.valueOf(status);
	}

}
