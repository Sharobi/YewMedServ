package com.sharobi.pharmacy.procurement.dao.impl;

import java.io.InputStream;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.PurchaseInvoiceExcelDTO;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.common.model.ExcelUploadResultObj;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.commonutil.DateUtil;
import com.sharobi.pharmacy.commonutil.StoredProcedures;
import com.sharobi.pharmacy.commonutil.XlsToXml;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.inventory.dao.impl.InventoryDAOImpl;
import com.sharobi.pharmacy.inventory.model.AccountDTO;
import com.sharobi.pharmacy.procurement.dao.ProcurementDAO;
import com.sharobi.pharmacy.procurement.model.DistributorPayment;
import com.sharobi.pharmacy.procurement.model.PaymentDetailsAllDTO;
import com.sharobi.pharmacy.procurement.model.PaymentDetailsByIdDTO;
import com.sharobi.pharmacy.procurement.model.Purchase;
import com.sharobi.pharmacy.procurement.model.PurchaseDetails;
import com.sharobi.pharmacy.procurement.model.PurchaseDetailsForReturnDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseHistoryDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseOrder;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderDetailsDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderQtyDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseReturn;
import com.sharobi.pharmacy.procurement.model.PurchaseReturnDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseReturnDetailsDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseReturnLedger;

import net.sf.resultsetmapper.ReflectionResultSetMapper;

/**
 * rajarshi
 */
public class ProcurementDAOImpl implements ProcurementDAO {

	private final static Logger logger = LogManager
			.getLogger(ProcurementDAOImpl.class);

	private EntityManagerFactory entityManagerFactory = PersistenceListener.getEntityManager();

	public ProcurementDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Purchase getPurchase(CommonResultSetMapper mapper)
			throws DAOException {

		Purchase purchase = new Purchase();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			int purInvId = mapper.getPurInvId();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_HEADER);
			callableStatement.setInt(1, purInvId);

			callableStatement.execute();
			rs = callableStatement.getResultSet();

			while (rs.next()) {
				purchase.setId(rs.getInt(1));
				purchase.setInvNo(rs.getString(2));
				purchase.setInvDate(rs.getDate(3));
				purchase.setInvMode(rs.getInt(4));
				purchase.setInvModeName(rs.getString(5));
				purchase.setPoOrderId(rs.getInt(6));
				purchase.setBillNo(rs.getString(7));
				purchase.setGrossAmount(rs.getDouble(8));
				purchase.setEdAmount(rs.getDouble(9));
				purchase.setDiscAmount(rs.getDouble(10));
				purchase.setCst(rs.getDouble(11));
				purchase.setVatDiff(rs.getDouble(12));
				purchase.setVatAmount(rs.getDouble(13));
				purchase.setTaxAmount(rs.getDouble(14));
				purchase.setAdjAmount(rs.getDouble(15));
				purchase.setAdvAmount(rs.getDouble(16));
				purchase.setDistributorBillAmount(rs.getDouble(17));
				purchase.setOtherAdjAmount(rs.getDouble(18));
				purchase.setLotAdjAmount(rs.getDouble(19));
				purchase.setSpecDiscPer(rs.getDouble(20));
				purchase.setSpecDiscAmount(rs.getDouble(21));
				purchase.setRoundoff(rs.getDouble(22));
				purchase.setNetAmount(rs.getDouble(23));
				purchase.setTotalMrp(rs.getDouble(24));
				purchase.setRemarks(rs.getString(25));
				purchase.setDistributorId(rs.getInt(26));
				purchase.setDistName(rs.getString(27));
				purchase.setDistDiscPer(rs.getDouble(28));
				purchase.setIsPosted(rs.getInt(29));
				purchase.setExpiryAdjAmount(rs.getDouble(30));
				purchase.setDueDate(rs.getDate(31));
				purchase.setPurchaseOrderInvNo(rs.getString(32));
				

			}

			logger.info("purchase header fetched");

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

		return purchase;
	}
	
	@Override
	public PurchaseReturnDTO getPurchaseReturnHeaderById(CommonResultSetMapper mapper)
			throws DAOException {

		PurchaseReturnDTO purchase = new PurchaseReturnDTO();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_RETURN_HEADER_BY_ID);
			callableStatement.setInt(1, mapper.getPurchaseReturnId());

			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseReturnDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseReturnDTO>(
					PurchaseReturnDTO.class);
			while(rs.next()){
				
				purchase = resultSetMapper.mapRow(rs);
				
			}

			logger.info("purchase return header by id fetched");

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

		return purchase;
	}
	
	@Override
	public List<PurchaseOrderDTO> getAllPurchaseOrderDetails(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseOrderDTO> list = new ArrayList<PurchaseOrderDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			String invNo = mapper.getInvoiceNo();
			int distId  = mapper.getDistributorId();
			String distName = mapper.getDistributorName();		
				
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_PURCHASE_ORDER_DETAILS);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, invNo);
			callableStatement.setInt(7, distId);
			callableStatement.setString(8, distName);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseOrderDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseOrderDTO>(
					PurchaseOrderDTO.class);
			while(rs.next()){
				PurchaseOrderDTO rurchseRtrn=new PurchaseOrderDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			logger.info("purchase all purchase order details fetched");

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
	public ExcelUploadResultObj uploadPurInv(InputStream fileInputStream, PurchaseInvoiceExcelDTO mapper) throws DAOException {

		String status1=null;
		EntityManager em = null;
		Connection connection = null;
		String invNo=null;
		String result=""+0;
		ExcelUploadResultObj resultObj=new ExcelUploadResultObj();
		
		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			XlsToXml xlsToXml = new XlsToXml();
			Purchase purchase = xlsToXml.toPurchaseInvXml(fileInputStream,mapper);
			//check if any item
			if(purchase.getPurchaseDetails().size()>0){
				status1=createOrUpdatePurchaseInvoice(purchase);
				if(status1!=null){
					if(!status1.equalsIgnoreCase("0")){
						CommonResultSetMapper mapper2=new CommonResultSetMapper();
						mapper2.setPurInvId(Integer.parseInt(status1));
						Purchase purchase2=getPurchase(mapper2);
						invNo=purchase2.getInvNo();
						result=invNo;
						
					}
				}
				
			}
			else {
				result=""+0;
			}
			resultObj.setResult(result);
			resultObj.setFailedItemList(purchase.getItemNotFndList());
			
			System.out.println("result is:: "+result);
			logger.info("stock fetched");

		} catch (Exception e) {
			result=""+0;
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(connection != null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return resultObj;
	}
	
	@Override
	public PurchaseOrderDTO getPurchaseOrderHeaderById(CommonResultSetMapper mapper)
			throws DAOException {

		//List<PurchaseOrderDTO> list = new ArrayList<PurchaseOrderDTO>();
		PurchaseOrderDTO rurchseRtrn=new PurchaseOrderDTO();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_ORDER_HEADER_BY_ID);
			callableStatement.setInt(1, mapper.getPurchaseOrderId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseOrderDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseOrderDTO>(
					PurchaseOrderDTO.class);
			while(rs.next()){
				
				rurchseRtrn = resultSetMapper.mapRow(rs);
			
				
			}

			logger.info("purchase purchase order header by id fetched");

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

		return rurchseRtrn;
	}
	
	@Override
	public List<PurchaseOrderDetailsDTO> getPurchaseOrderDetailsById(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseOrderDetailsDTO> list = new ArrayList<PurchaseOrderDetailsDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_ORDER_DETAILS_BY_ID);
			callableStatement.setInt(1, mapper.getPurchaseOrderId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseOrderDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseOrderDetailsDTO>(
					PurchaseOrderDetailsDTO.class);
			while(rs.next()){
				PurchaseOrderDetailsDTO rurchseRtrn=new PurchaseOrderDetailsDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			logger.info("purchase purchase order details by id fetched");

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
	public List<PurchaseOrderDetailsDTO> getPendingPurchaseOrderDetails(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseOrderDetailsDTO> list = new ArrayList<PurchaseOrderDetailsDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PENDING_PURCHASE_ORDER_DETAILS_BY_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setString(4, mapper.getInvoiceNo());
			callableStatement.setInt(5, mapper.getDistributorId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseOrderDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseOrderDetailsDTO>(
					PurchaseOrderDetailsDTO.class);
			while(rs.next()){
				PurchaseOrderDetailsDTO rurchseRtrn=new PurchaseOrderDetailsDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			logger.info("pending purchase order details by inv no. fetched");

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
	public List<PurchaseOrderDetailsDTO> generatePurchaseOrderByType(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseOrderDetailsDTO> list = new ArrayList<PurchaseOrderDetailsDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GENERATE_PURCHASE_ORDER_BY_TYPE);
			callableStatement.setString(1, mapper.getPoGenType());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(2, asonDate);
			}
			else {
				callableStatement.setDate(2, null);
			}
			callableStatement.setInt(3, mapper.getCompanyId());
			callableStatement.setInt(4, mapper.getStoreId());
			callableStatement.setInt(5, mapper.getFinYrId());
			callableStatement.setInt(6, mapper.getDistributorId());
			callableStatement.setInt(7, mapper.getManuId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseOrderDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseOrderDetailsDTO>(
					PurchaseOrderDetailsDTO.class);
			while(rs.next()){
				PurchaseOrderDetailsDTO rurchseRtrn=new PurchaseOrderDetailsDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			logger.info("generate PO by type");

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
	public PurchaseOrderQtyDTO getPurchaseOrderQty(CommonResultSetMapper mapper)
			throws DAOException {

		
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		PurchaseOrderQtyDTO orderQtyDTO = new PurchaseOrderQtyDTO();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_ORDER_QTY);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getItemId());
			callableStatement.setInt(4, mapper.getLastSaleDays());
			callableStatement.setInt(5, mapper.getComingPurchaseDays());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(6, asonDate);
			}
			else {
				callableStatement.setDate(6, null);
			}

			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseOrderQtyDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseOrderQtyDTO>(PurchaseOrderQtyDTO.class);
			while(rs.next()){
				
				orderQtyDTO = resultSetMapper.mapRow(rs);
				
			}

			logger.info("purchase order qty fetched");

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

		return orderQtyDTO;
	}
	
	@Override
	public PaymentDetailsAllDTO getPaymentHeaderById(CommonResultSetMapper mapper)
			throws DAOException {

		PaymentDetailsAllDTO payment = new PaymentDetailsAllDTO();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_PAYMENT_HEADER_BY_ID);
			callableStatement.setInt(1, mapper.getPaymentId());

			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PaymentDetailsAllDTO> resultSetMapper = new ReflectionResultSetMapper<PaymentDetailsAllDTO>(
					PaymentDetailsAllDTO.class);
			while(rs.next()){
				
				payment = resultSetMapper.mapRow(rs);
				
			}

			logger.info("payment header by id fetched");

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

		return payment;
	}
	
	@Override
	public List<PurchaseReturnDetailsDTO> getPurchaseReturnDetailsById(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseReturnDetailsDTO> purchaseLst = new ArrayList<PurchaseReturnDetailsDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_RETURN_DETAILS_BY_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getPurchaseReturnId());

			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseReturnDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseReturnDetailsDTO>(
					PurchaseReturnDetailsDTO.class);
			while(rs.next()){
				PurchaseReturnDetailsDTO purchase=new PurchaseReturnDetailsDTO();
				purchase = resultSetMapper.mapRow(rs);
				purchaseLst.add(purchase);
				
			}

			logger.info("purchase return details by id fetched");

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

		return purchaseLst;
	}
	
	@Override
	public List<PurchaseReturnDTO> getPurchaseReturnHeaderAll(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseReturnDTO> list = new ArrayList<PurchaseReturnDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			String invNo = mapper.getInvoiceNo();
			int distId  = mapper.getDistributorId();
			String distName = mapper.getDistributorName();		
				
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_RETURN_HEADER_ALL);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, invNo);
			callableStatement.setInt(7, distId);
			callableStatement.setString(8, distName);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseReturnDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseReturnDTO>(
					PurchaseReturnDTO.class);
			while(rs.next()){
				PurchaseReturnDTO rurchseRtrn=new PurchaseReturnDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			logger.info("purchase all purchase return header fetched");

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
	public List<PaymentDetailsAllDTO> getPaymentsDetailsAll(CommonResultSetMapper mapper)
			throws DAOException {

		List<PaymentDetailsAllDTO> list = new ArrayList<PaymentDetailsAllDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			String invNo = mapper.getInvoiceNo();
			int distId  = mapper.getDistributorId();
			String distName = mapper.getDistributorName();		
				
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_PAYMENT_DETAILS_ALL);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, invNo);
			callableStatement.setInt(7, distId);
			callableStatement.setString(8, distName);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PaymentDetailsAllDTO> resultSetMapper = new ReflectionResultSetMapper<PaymentDetailsAllDTO>(
					PaymentDetailsAllDTO.class);
			while(rs.next()){
				PaymentDetailsAllDTO payment=new PaymentDetailsAllDTO();
				payment = resultSetMapper.mapRow(rs);
				list.add(payment);
				
			}

			logger.info("purchase all purchase payment details");

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
	public List<PaymentDetailsByIdDTO> getPaymentsDetailsById(CommonResultSetMapper mapper)
			throws DAOException {

		List<PaymentDetailsByIdDTO> list = new ArrayList<PaymentDetailsByIdDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
		
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_PAYMENT_DETAILS_BY_ID);
			callableStatement.setInt(1, mapper.getPaymentId());
			callableStatement.setInt(2, mapper.getCompanyId());
			callableStatement.setInt(3, mapper.getStoreId());
			callableStatement.setInt(4, mapper.getFinYrId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PaymentDetailsByIdDTO> resultSetMapper = new ReflectionResultSetMapper<PaymentDetailsByIdDTO>(
					PaymentDetailsByIdDTO.class);
			while(rs.next()){
				PaymentDetailsByIdDTO payment=new PaymentDetailsByIdDTO();
				payment = resultSetMapper.mapRow(rs);
				list.add(payment);
				
			}

			logger.info("purchase all purchase payment details by id");

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
	public List<PaymentDetailsByIdDTO> getPendingPaymentBySupplier(CommonResultSetMapper mapper)
			throws DAOException {

		List<PaymentDetailsByIdDTO> list = new ArrayList<PaymentDetailsByIdDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			java.sql.Date pmntDt = DateUtil.convertStringDateToSqlDate(
					mapper.getPaymentDate(), "yyyy-MM-dd");
		
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_PAYMENT_PENDING_BY_DISTRIBUTOR);
			callableStatement.setInt(1, mapper.getDistributorId());
			callableStatement.setDate(2, pmntDt);
			callableStatement.setInt(3, mapper.getCompanyId());
			callableStatement.setInt(4, mapper.getStoreId());
			callableStatement.setInt(5, mapper.getFinYrId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PaymentDetailsByIdDTO> resultSetMapper = new ReflectionResultSetMapper<PaymentDetailsByIdDTO>(
					PaymentDetailsByIdDTO.class);
			while(rs.next()){
				PaymentDetailsByIdDTO payment=new PaymentDetailsByIdDTO();
				payment = resultSetMapper.mapRow(rs);
				list.add(payment);
				
			}

			logger.info("purchase payment pending by supplier");

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
	public List<PurchaseDetailsForReturnDTO> getPurchaseDetailsForReturnByInv(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseDetailsForReturnDTO> list = new ArrayList<PurchaseDetailsForReturnDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			String invNo = mapper.getInvoiceNo();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_DETAILS_RETURN_INV_NO);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setString(3, invNo);
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseDetailsForReturnDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseDetailsForReturnDTO>(
					PurchaseDetailsForReturnDTO.class);
			while(rs.next()){
				PurchaseDetailsForReturnDTO rurchseRtrn=new PurchaseDetailsForReturnDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			logger.info("purchase all purchase return details by inv no. fetched");

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
	public List<PurchaseDetailsForReturnDTO> getPurchaseDetailsForReturnByItem(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseDetailsForReturnDTO> list = new ArrayList<PurchaseDetailsForReturnDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_DETAILS_RETURN_ITEM);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, mapper.getItemId());
			callableStatement.setInt(4, mapper.getDistributorId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseDetailsForReturnDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseDetailsForReturnDTO>(
					PurchaseDetailsForReturnDTO.class);
			while(rs.next()){
				PurchaseDetailsForReturnDTO rurchseRtrn=new PurchaseDetailsForReturnDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			logger.info("purchase all purchase return details by item fetched");

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
	public List<PurchaseDetailsForReturnDTO> getPurchaseDetailsForReturnBySku(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseDetailsForReturnDTO> list = new ArrayList<PurchaseDetailsForReturnDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_DETAILS_RETURN_SKU);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setString(3, mapper.getSku());
			callableStatement.setInt(4, mapper.getDistributorId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseDetailsForReturnDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseDetailsForReturnDTO>(
					PurchaseDetailsForReturnDTO.class);
			while(rs.next()){
				PurchaseDetailsForReturnDTO rurchseRtrn=new PurchaseDetailsForReturnDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			logger.info("purchase all purchase return details by sku fetched");

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
	public List<PurchaseHistoryDTO> getPurchaseHistoryByItem(CommonResultSetMapper mapper)
			throws DAOException {

		List<PurchaseHistoryDTO> list = new ArrayList<PurchaseHistoryDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_HISTORY);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, mapper.getItemId());
			callableStatement.setInt(4, mapper.getNoOfRows());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<PurchaseHistoryDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseHistoryDTO>(
					PurchaseHistoryDTO.class);
			while(rs.next()){
				PurchaseHistoryDTO rurchseRtrn=new PurchaseHistoryDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			logger.info("purchase all purchase hist by item fetched");

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
	public List<Purchase> getAllPurchase(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<Purchase> details = new ArrayList<Purchase>();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			String invNo = mapper.getInvoiceNo();
			String purOrdNo = mapper.getPurOrderNo();
			String distributorName = mapper.getDistributorName();

			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_PURCHASE_ALL);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, invNo);
			callableStatement.setString(7, purOrdNo);
			callableStatement.setInt(8, mapper.getDistributorId());
			callableStatement.setString(9, distributorName);

			callableStatement.execute();
			rs = callableStatement.getResultSet();

			while (rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setId(rs.getInt(1));
				purchase.setInvNo(rs.getString(2));
				purchase.setInvDate(rs.getDate(3));
				purchase.setInvMode(rs.getInt(4));
				purchase.setInvModeName(rs.getString(5));
				purchase.setPoOrderId(rs.getInt(6));
				purchase.setBillNo(rs.getString(7));
				purchase.setGrossAmount(rs.getInt(8));
				purchase.setEdAmount(rs.getDouble(9));
				purchase.setDiscAmount(rs.getDouble(10));
				purchase.setCst(rs.getDouble(11));
				purchase.setVatDiff(rs.getDouble(12));
				purchase.setVatAmount(rs.getDouble(13));
				purchase.setTaxAmount(rs.getDouble(14));
				purchase.setAdjAmount(rs.getDouble(15));
				purchase.setLotAdjAmount(rs.getDouble(16));
				purchase.setRoundoff(rs.getDouble(17));
				purchase.setNetAmount(rs.getDouble(18));
				purchase.setTotalMrp(rs.getDouble(19));
				purchase.setDistributorId(rs.getInt(20));
				purchase.setDistName(rs.getString(21));
				purchase.setRemarks(rs.getString(22));
				purchase.setIsPosted(rs.getInt(23));
				purchase.setExpiryAdjAmount(rs.getDouble(24));
				purchase.setDistributorBillAmount(rs.getDouble(25));
				purchase.setOtherAdjAmount(rs.getDouble(26));

				// add to list
				details.add(purchase);

			}

			logger.info("purchase details fetched");

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

		return details;
	}

	@Override
	public List<PurchaseDetails> getPurchaseDetailsById(
			CommonResultSetMapper mapper) throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<PurchaseDetails> details = new ArrayList<PurchaseDetails>();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			int purInvId = mapper.getPurInvId();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_PURCHASE_DETAILS_BY_ID);
			callableStatement.setInt(1, purInvId);
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			while (rs.next()) {
				PurchaseDetails purchaseDetails = new PurchaseDetails();
				purchaseDetails.setItemId(rs.getInt(1));
				purchaseDetails.setItemName(rs.getString(2));
				purchaseDetails.setBatchNo(rs.getString(3));
				purchaseDetails.setExpiryDate(rs.getDate(4));
				purchaseDetails.setExpiryDateFormat(rs.getString(5));
				purchaseDetails.setPackUnitId(rs.getInt(6));
				purchaseDetails.setPackUnitName(rs.getString(7));
				purchaseDetails.setPackQty(rs.getInt(8));
				purchaseDetails.setConversion(rs.getInt(9));
				purchaseDetails.setLooseQty(rs.getInt(10));
				purchaseDetails.setFreeQty(rs.getDouble(11));
				purchaseDetails.setMrp(rs.getDouble(12));
				purchaseDetails.setRate(rs.getDouble(13));
				purchaseDetails.setAmount(rs.getDouble(14));
				purchaseDetails.setEdPer(rs.getDouble(15));
				purchaseDetails.setEd(rs.getDouble(16));
				purchaseDetails.setTaxPer(rs.getDouble(17));
				purchaseDetails.setTax(rs.getDouble(18));
				purchaseDetails.setVatPer(rs.getDouble(19));
				purchaseDetails.setVat(rs.getDouble(20));
				purchaseDetails.setDiscPer(rs.getDouble(21));
				purchaseDetails.setDisc(rs.getDouble(22));
				purchaseDetails.setItemLotAdjAmount(rs.getDouble(23));
				purchaseDetails.setTotAmount(rs.getDouble(24));
				purchaseDetails.setGrpId(rs.getInt(25));
				purchaseDetails.setGrpName(rs.getString(26));
				purchaseDetails.setSchdId(rs.getInt(27));
				purchaseDetails.setSchdName(rs.getString(28));
				purchaseDetails.setManuId(rs.getInt(29));
				purchaseDetails.setManuName(rs.getString(30));
				purchaseDetails.setManuCode(rs.getString(31));
				purchaseDetails.setItemUniqueKey(rs.getString(32));
				purchaseDetails.setTaxId(rs.getInt(33));
				purchaseDetails.setTaxName(rs.getString(34));
				purchaseDetails.setTaxPercentage(rs.getDouble(35));
				purchaseDetails.setTaxAmount(rs.getDouble(36));
				purchaseDetails.setTaxableRate(rs.getDouble(37));
				purchaseDetails.setTaxMode(rs.getString(38));
				purchaseDetails.setIsGroupTax(rs.getInt(39));
				purchaseDetails.setIsTaxOnMrp(rs.getInt(40));
				purchaseDetails.setSku(rs.getString(41));
				purchaseDetails.setHsnCode(rs.getString(42));
				purchaseDetails.setPurchaseNetAmount(rs.getDouble(43));
				purchaseDetails.setSaleRate(rs.getDouble(44));
				purchaseDetails.setPurchaseOrderId(rs.getInt(45));
				purchaseDetails.setPurchaseOrderInvNo(rs.getString(46));

				// add to list
				details.add(purchaseDetails);

			}

			logger.info("purchase details by id fetched");

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

		return details;
	}
	
	@Override
	public List<PurchaseDetails> getLastPurchaseInvoiceDetailsByDistId(
			CommonResultSetMapper mapper) throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<PurchaseDetails> details = new ArrayList<PurchaseDetails>();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			int distid = mapper.getDistributorId();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_LAST_PURCHASE_DETAILS_BY_DIST_ID);
			callableStatement.setInt(1, distid);
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			while (rs.next()) {
				PurchaseDetails purchaseDetails = new PurchaseDetails();
				purchaseDetails.setItemId(rs.getInt(1));
				purchaseDetails.setItemName(rs.getString(2));
				purchaseDetails.setBatchNo(rs.getString(3));
				purchaseDetails.setExpiryDate(rs.getDate(4));
				purchaseDetails.setExpiryDateFormat(rs.getString(5));
				purchaseDetails.setPackUnitId(rs.getInt(6));
				purchaseDetails.setPackUnitName(rs.getString(7));
				purchaseDetails.setPackQty(rs.getInt(8));
				purchaseDetails.setConversion(rs.getInt(9));
				purchaseDetails.setLooseQty(rs.getInt(10));
				purchaseDetails.setFreeQty(rs.getDouble(11));
				purchaseDetails.setMrp(rs.getDouble(12));
				purchaseDetails.setRate(rs.getDouble(13));
				purchaseDetails.setAmount(rs.getDouble(14));
				purchaseDetails.setEdPer(rs.getDouble(15));
				purchaseDetails.setEd(rs.getDouble(16));
				purchaseDetails.setTaxPer(rs.getDouble(17));
				purchaseDetails.setTax(rs.getDouble(18));
				purchaseDetails.setVatPer(rs.getDouble(19));
				purchaseDetails.setVat(rs.getDouble(20));
				purchaseDetails.setDiscPer(rs.getDouble(21));
				purchaseDetails.setDisc(rs.getDouble(22));
				purchaseDetails.setTotAmount(rs.getDouble(23));
				purchaseDetails.setGrpId(rs.getInt(24));
				purchaseDetails.setGrpName(rs.getString(25));
				purchaseDetails.setSchdId(rs.getInt(26));
				purchaseDetails.setSchdName(rs.getString(27));
				purchaseDetails.setManuId(rs.getInt(28));
				purchaseDetails.setManuName(rs.getString(29));
				purchaseDetails.setManuCode(rs.getString(30));

				// add to list
				details.add(purchaseDetails);

			}

			logger.info("last purchase details by dist id fetched");

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

		return details;
	}

	@Override
	public List<PurchaseDetails> getPurchaseInvoiceDetailsByItemId(
			CommonResultSetMapper mapper) throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<PurchaseDetails> details = new ArrayList<PurchaseDetails>();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			int itemId = mapper.getItemId();
			int distId = mapper.getDistributorId();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_PURCHASE_DETAILS_BY_ITEM_ID);
			callableStatement.setInt(1, itemId);
			callableStatement.setInt(2, distId);
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			while (rs.next()) {
				PurchaseDetails purchaseDetails = new PurchaseDetails();
				purchaseDetails.setItemId(rs.getInt(1));
				purchaseDetails.setItemName(rs.getString(2));
				purchaseDetails.setBatchNo(rs.getString(3));
				purchaseDetails.setExpiryDate(rs.getDate(4));
				purchaseDetails.setExpiryDateFormat(rs.getString(5));
				purchaseDetails.setPackUnitId(rs.getInt(6));
				purchaseDetails.setPackUnitName(rs.getString(7));
				purchaseDetails.setPackQty(rs.getInt(8));
				purchaseDetails.setConversion(rs.getInt(9));
				purchaseDetails.setLooseQty(rs.getInt(10));
				purchaseDetails.setFreeQty(rs.getDouble(11));
				purchaseDetails.setMrp(rs.getDouble(12));
				purchaseDetails.setRate(rs.getDouble(13));
				purchaseDetails.setAmount(rs.getDouble(14));
				purchaseDetails.setEdPer(rs.getDouble(15));
				purchaseDetails.setEd(rs.getDouble(16));
				purchaseDetails.setTaxPer(rs.getDouble(17));
				purchaseDetails.setTax(rs.getDouble(18));
				purchaseDetails.setVatPer(rs.getDouble(19));
				purchaseDetails.setVat(rs.getDouble(20));
				purchaseDetails.setDiscPer(rs.getDouble(21));
				purchaseDetails.setDisc(rs.getDouble(22));
				purchaseDetails.setTotAmount(rs.getDouble(23));
				purchaseDetails.setGrpId(rs.getInt(24));
				purchaseDetails.setGrpName(rs.getString(25));
				purchaseDetails.setSchdId(rs.getInt(26));
				purchaseDetails.setSchdName(rs.getString(27));
				purchaseDetails.setManuId(rs.getInt(28));
				purchaseDetails.setManuName(rs.getString(29));
				purchaseDetails.setManuCode(rs.getString(30));
				purchaseDetails.setTaxId(rs.getInt(31));
				purchaseDetails.setTaxName(rs.getString(32));
				purchaseDetails.setTaxPercentage(rs.getDouble(33));
				purchaseDetails.setTaxableRate(rs.getDouble(34));
				purchaseDetails.setTaxMode(rs.getString(35));
				purchaseDetails.setIsGroupTax(rs.getInt(36));
				purchaseDetails.setIsTaxOnMrp(rs.getInt(37));
				purchaseDetails.setSku(rs.getString(38));
				purchaseDetails.setHsnCode(rs.getString(39));
				purchaseDetails.setSaleRate(rs.getDouble(40));

				// add to list
				details.add(purchaseDetails);

			}

			logger.info("purchase details by item id fetched");

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

		return details;
	}
	
	
	public List<PurchaseDetails> getPurchaseInvoiceDetailsByItemIdForBarcode(
			int itemId, int distId ) throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<PurchaseDetails> details = new ArrayList<PurchaseDetails>();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			//int itemId = mapper.getItemId();
			//int distId = mapper.getDistributorId();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_PURCHASE_DETAILS_BY_ITEM_ID);
			callableStatement.setInt(1, itemId);
			callableStatement.setInt(2, distId);
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			while (rs.next()) {
				PurchaseDetails purchaseDetails = new PurchaseDetails();
				purchaseDetails.setItemId(rs.getInt(1));
				purchaseDetails.setItemName(rs.getString(2));
				purchaseDetails.setBatchNo(rs.getString(3));
				purchaseDetails.setExpiryDate(rs.getDate(4));
				purchaseDetails.setExpiryDateFormat(rs.getString(5));
				purchaseDetails.setPackUnitId(rs.getInt(6));
				purchaseDetails.setPackUnitName(rs.getString(7));
				purchaseDetails.setPackQty(rs.getInt(8));
				purchaseDetails.setConversion(rs.getInt(9));
				purchaseDetails.setLooseQty(rs.getInt(10));
				purchaseDetails.setFreeQty(rs.getDouble(11));
				purchaseDetails.setMrp(rs.getDouble(12));
				purchaseDetails.setRate(rs.getDouble(13));
				purchaseDetails.setAmount(rs.getDouble(14));
				purchaseDetails.setEdPer(rs.getDouble(15));
				purchaseDetails.setEd(rs.getDouble(16));
				purchaseDetails.setTaxPer(rs.getDouble(17));
				purchaseDetails.setTax(rs.getDouble(18));
				purchaseDetails.setVatPer(rs.getDouble(19));
				purchaseDetails.setVat(rs.getDouble(20));
				purchaseDetails.setDiscPer(rs.getDouble(21));
				purchaseDetails.setDisc(rs.getDouble(22));
				purchaseDetails.setTotAmount(rs.getDouble(23));
				purchaseDetails.setGrpId(rs.getInt(24));
				purchaseDetails.setGrpName(rs.getString(25));
				purchaseDetails.setSchdId(rs.getInt(26));
				purchaseDetails.setSchdName(rs.getString(27));
				purchaseDetails.setManuId(rs.getInt(28));
				purchaseDetails.setManuName(rs.getString(29));
				purchaseDetails.setManuCode(rs.getString(30));
				purchaseDetails.setTaxId(rs.getInt(31));
				purchaseDetails.setTaxName(rs.getString(32));
				purchaseDetails.setTaxPercentage(rs.getDouble(33));
				purchaseDetails.setTaxableRate(rs.getDouble(34));
				purchaseDetails.setTaxMode(rs.getString(35));
				purchaseDetails.setIsGroupTax(rs.getInt(36));
				purchaseDetails.setIsTaxOnMrp(rs.getInt(37));
				purchaseDetails.setSku(rs.getString(38));
				purchaseDetails.setHsnCode(rs.getString(39));
				purchaseDetails.setSaleRate(rs.getDouble(40));

				// add to list
				details.add(purchaseDetails);

			}

			logger.info("purchase details by item id fetched");

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

		return details;
	}
	
	@Override
	public List<PurchaseDetails> getPurchaseInvoiceDetailsByItemSku(
			CommonResultSetMapper mapper) throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<PurchaseDetails> details = new ArrayList<PurchaseDetails>();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int distId = mapper.getDistributorId();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_PURCHASE_DETAILS_BY_ITEM_SKU);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getSku());
			callableStatement.setInt(4, distId);
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			while (rs.next()) {
				PurchaseDetails purchaseDetails = new PurchaseDetails();
				purchaseDetails.setItemId(rs.getInt(1));
				purchaseDetails.setItemName(rs.getString(2));
				purchaseDetails.setBatchNo(rs.getString(3));
				purchaseDetails.setExpiryDate(rs.getDate(4));
				purchaseDetails.setExpiryDateFormat(rs.getString(5));
				purchaseDetails.setPackUnitId(rs.getInt(6));
				purchaseDetails.setPackUnitName(rs.getString(7));
				purchaseDetails.setPackQty(rs.getInt(8));
				purchaseDetails.setConversion(rs.getInt(9));
				purchaseDetails.setLooseQty(rs.getInt(10));
				purchaseDetails.setFreeQty(rs.getDouble(11));
				purchaseDetails.setMrp(rs.getDouble(12));
				purchaseDetails.setRate(rs.getDouble(13));
				purchaseDetails.setAmount(rs.getDouble(14));
				purchaseDetails.setEdPer(rs.getDouble(15));
				purchaseDetails.setEd(rs.getDouble(16));
				purchaseDetails.setTaxPer(rs.getDouble(17));
				purchaseDetails.setTax(rs.getDouble(18));
				purchaseDetails.setVatPer(rs.getDouble(19));
				purchaseDetails.setVat(rs.getDouble(20));
				purchaseDetails.setDiscPer(rs.getDouble(21));
				purchaseDetails.setDisc(rs.getDouble(22));
				purchaseDetails.setTotAmount(rs.getDouble(23));
				purchaseDetails.setGrpId(rs.getInt(24));
				purchaseDetails.setGrpName(rs.getString(25));
				purchaseDetails.setSchdId(rs.getInt(26));
				purchaseDetails.setSchdName(rs.getString(27));
				purchaseDetails.setManuId(rs.getInt(28));
				purchaseDetails.setManuName(rs.getString(29));
				purchaseDetails.setManuCode(rs.getString(30));
				purchaseDetails.setTaxId(rs.getInt(31));
				purchaseDetails.setTaxName(rs.getString(32));
				purchaseDetails.setTaxPercentage(rs.getDouble(33));
				purchaseDetails.setTaxableRate(rs.getDouble(34));
				purchaseDetails.setTaxMode(rs.getString(35));
				purchaseDetails.setIsGroupTax(rs.getInt(36));
				purchaseDetails.setIsTaxOnMrp(rs.getInt(37));
				purchaseDetails.setSku(rs.getString(38));
				purchaseDetails.setHsnCode(rs.getString(39));
				purchaseDetails.setSaleRate(rs.getDouble(40));

				// add to list
				details.add(purchaseDetails);

			}

			logger.info("purchase details by item id fetched");

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

		return details;
	}
	
	@Override
	public List<PurchaseReturnDTO> getAdjPurchaseReturn(CommonResultSetMapper mapper) throws DAOException {

		
		List<PurchaseReturnDTO> list=new ArrayList<PurchaseReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_RETURN_ADJ_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
			callableStatement.setInt(4, mapper.getDistributorId());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<PurchaseReturnDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseReturnDTO>(
					PurchaseReturnDTO.class);
			while(rs.next()){
				PurchaseReturnDTO sales = new PurchaseReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("adjustment purchase return by inv no. fetched");

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
	public List<PurchaseReturnDTO> getAdjPurchaseReturnByPurchaseId(CommonResultSetMapper mapper) throws DAOException {

		
		List<PurchaseReturnDTO> list=new ArrayList<PurchaseReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PURCHASE_RETURN_ADJ_PURCHASE_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getPurInvId());
			
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<PurchaseReturnDTO> resultSetMapper = new ReflectionResultSetMapper<PurchaseReturnDTO>(
					PurchaseReturnDTO.class);
			while(rs.next()){
				PurchaseReturnDTO sales = new PurchaseReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			logger.info("adjustment purchase return by purchase id fetched");

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
	public String createOrUpdatePurchaseInvoice(Purchase purchase)
			throws DAOException {
		
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		InventoryDAOImpl inventoryDAOImpl = new InventoryDAOImpl();
		CommonResultSetMapper mapper = new CommonResultSetMapper();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			if(purchase.getIs_account()==1)
			{
				List<PurchaseReturnLedger> purlrs = new ArrayList<>();
				
				if(purchase.getDuties_ledger_id()!=0)
				{
					purlrs.add(new PurchaseReturnLedger("dr", purchase.getDuties_ledger_id(), purchase.getTaxAmount()));
				}
				if(purchase.getRound_ledger_id()!=0)
				{
					String type="";
					if(purchase.getRoundoff()>0)
						type="dr";//debit
					else
						type="cr";//credit
					
					purlrs.add(new PurchaseReturnLedger(type, purchase.getRound_ledger_id(), Math.abs(purchase.getRoundoff())));
				}
				if(purchase.getPurchase_ledger_id()!=0)
				{
					purlrs.add(new PurchaseReturnLedger("dr", purchase.getPurchase_ledger_id(), purchase.getGrossAmount()));
				}
				if(purchase.getDiscount_ledger_id()!=0)
				{
					purlrs.add(new PurchaseReturnLedger("cr", purchase.getDiscount_ledger_id(), purchase.getDiscAmount()));
				}
				
				
				if(purchase.getCredior_ledger_id()!=0)
				{
					purlrs.add(new PurchaseReturnLedger("cr", purchase.getCredior_ledger_id(), purchase.getCreditor_amt()));
					
					if(purchase.getAdvAmount()>0) // in case of advance amount
					{
						mapper.setCompanyId(purchase.getCompanyId());
						mapper.setStoreId(purchase.getStoreId());
						mapper.setGroupCode("CIH");
						/*mapper.setAccountID(mapper.getAccountID());
						mapper.setReferenceID(mapper.getReferenceID());*/
						
						List<AccountDTO> accountDTOs = inventoryDAOImpl.getLedgerDetailsByCode(mapper);
						System.out.println("Cash In Hand ID = "+accountDTOs.get(0).getId());
						
						purlrs.add(new PurchaseReturnLedger("cr", accountDTOs.get(0).getId(), purchase.getAdvAmount()));
					}
					
					if(purchase.getOtherAdjAmount()!=0)
					{
						mapper.setCompanyId(purchase.getCompanyId());
						mapper.setStoreId(purchase.getStoreId());
						mapper.setGroupCode("BAD");
						/*mapper.setAccountID(mapper.getAccountID());
						mapper.setReferenceID(mapper.getReferenceID());*/
						
						List<AccountDTO> accountDTOs = inventoryDAOImpl.getLedgerDetailsByCode(mapper);
						System.out.println("OtherAdjID = "+accountDTOs.get(0).getId());
						
						if(purchase.getOtherAdjAmount()>0)
							purlrs.add(new PurchaseReturnLedger("cr", accountDTOs.get(0).getId(), Math.abs(purchase.getOtherAdjAmount())));
						else if(purchase.getOtherAdjAmount()<0)
							purlrs.add(new PurchaseReturnLedger("dr", accountDTOs.get(0).getId(), Math.abs(purchase.getOtherAdjAmount())));
					}
					
				}
				if(purchase.getLotadjas_ledger_id()!=0)
				{
					purlrs.add(new PurchaseReturnLedger("cr", purchase.getLotadjas_ledger_id(), purchase.getLotAdjAmount()));
				}
				
				
				purchase.setPrls(purlrs);
				
			}

			try {
				StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-10-04\\file_purchase_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Purchase.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchase, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(purchase, sw);
				String result = sw.toString();
				System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_PURCHASE_INVOICE);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "purchase");
				callableStatement.setString(3, "purchaseDetails");
				/*callableStatement.registerOutParameter(4,
						java.sql.Types.VARCHAR);*/
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
		return ""+status;

	}
	
	@Override
	public ResponseObj createOrUpdatePurchaseOrder(PurchaseOrder purchaseOrder)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj=new ResponseObj();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-07-14\\file_purchase_order_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(PurchaseOrder.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchaseOrder, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(purchaseOrder, sw);
				String result = sw.toString();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_PURCHASE_ORDER);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "purchaseOrder");
				callableStatement.setString(3, "purchaseOrderDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				
				status = callableStatement.getInt(4);
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record save successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not saved successfully.");
					
				}

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
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
		return responseObj;

	}
	
	@Override
	public String createOrUpdateDistributorPayment(DistributorPayment distributorPayment)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;


		if(distributorPayment.getIs_account()!=1)
		{
			distributorPayment.setCr_account_id(0);
			distributorPayment.setDr_account_id(0);
			distributorPayment.setCr_amount(0);
			distributorPayment.setDr_amount(0);
		}
		
		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-03-20\\file_distributor_payment_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(DistributorPayment.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(distributorPayment, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(distributorPayment, sw);
				String result = sw.toString();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_DISTRIBUTOR_PAYMENT);
				
				System.out.println("xml = "+result);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "distributorPayment");
				callableStatement.setString(3, "distributorPaymentDetails");
				
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
		return ""+status;

	}
	
	@Override
	public String createOrUpdatePurchaseReturn(PurchaseReturn purchaseReturn)
			throws DAOException {
		/*Round of Account (-)Credit/(+)Debit*/
		System.out.println("createOrUpdatePurchaseReturn purcahse "+purchaseReturn);
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		if(purchaseReturn.getIs_account()==1)
		{
			List<PurchaseReturnLedger> purchaseReturnLedgers = new ArrayList<>();
			
			if(purchaseReturn.getDuties_ledger_id()!=0)
			{
				purchaseReturnLedgers.add(new PurchaseReturnLedger("cr", purchaseReturn.getDuties_ledger_id(), purchaseReturn.getTaxAmount()));
			}
			if(purchaseReturn.getRound_ledger_id()!=0)
			{
				String type="";
				if(purchaseReturn.getRoundoff()>0)
					type = "cr";
				else
					type="dr";
				
				purchaseReturnLedgers.add(new PurchaseReturnLedger(type, purchaseReturn.getRound_ledger_id(), Math.abs(purchaseReturn.getRoundoff())));
			}
			if(purchaseReturn.getPurchase_ledger_id()!=0)
			{
				purchaseReturnLedgers.add(new PurchaseReturnLedger("cr", purchaseReturn.getPurchase_ledger_id(), purchaseReturn.getGrossAmount()));
			}
			if(purchaseReturn.getDiscount_ledger_id()!=0)
			{
				purchaseReturnLedgers.add(new PurchaseReturnLedger("dr", purchaseReturn.getDiscount_ledger_id(), purchaseReturn.getDiscAmount()));
			}
			if(purchaseReturn.getCreditor_ledger_id()!=0)
			{
				purchaseReturnLedgers.add(new PurchaseReturnLedger("dr", purchaseReturn.getCreditor_ledger_id(), purchaseReturn.getNetAmount()));
			}
			if(purchaseReturn.getLot_ledger_id()!=0)
			{
				purchaseReturnLedgers.add(new PurchaseReturnLedger("dr", purchaseReturn.getLot_ledger_id(), purchaseReturn.getLotAdjAmount()));
			}
			
			purchaseReturn.setPrls(purchaseReturnLedgers);
			
		}
		
		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				// File file = new File("D:\\2017-02-28\\file_purchase_return_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(PurchaseReturn.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				 //jaxbMarshaller.marshal(purchaseReturn, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(purchaseReturn, sw);
				String result = sw.toString();
				System.out.println("PurchaseReturn xml:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_PURCHASE_RETURN);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "purchaseReturn");
				callableStatement.setString(3, "purchaseReturnDetails");
				/*callableStatement.registerOutParameter(4,
						java.sql.Types.VARCHAR);*/
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
		return ""+status;

	}

	@Override
	public String deletePurchaseInvoice(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int purchaseId=mapper.getPurInvId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_PURCHASE_INVOICE);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, purchaseId);
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
		return ""+status;

	}
	
	@Override
	public ResponseObj deletePurchaseOrder(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj=new ResponseObj();
		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int purchaseId=mapper.getPurchaseOrderId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_PURCHASE_ORDER);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, purchaseId);
				callableStatement.setInt(4, mapper.getDeletedBy());
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(5);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("PO deleted successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("PO not deleted successfully.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("PO not deleted successfully.");
				throw new DAOException("Check data to be deleted", e);
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
		return responseObj;

	}
	
	@Override
	public String deletePurchaseReturn(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
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
						.prepareCall(StoredProcedures.PROC_DELETE_PURCHASE_RETURN);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, mapper.getPurchaseReturnId());
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
		return ""+status;

	}
	
	@Override
	public String deleteDistributorPayment(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
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
						.prepareCall(StoredProcedures.PROC_DELETE_DISTRIBUTOR_PAYMENT);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, mapper.getPaymentId());
				callableStatement.setInt(4, mapper.getDistributorId());
				callableStatement.setInt(5, mapper.getDeletedBy());
				callableStatement.registerOutParameter(6,java.sql.Types.INTEGER);
				
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
		return ""+status;

	}
	
	@Override
	public String postPurchaseInvoice(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int purchaseId=mapper.getPurInvId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_PURCHASE_INVOICE);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, purchaseId);
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
		return ""+status;

	}
	
	@Override
	public String getDuplicateBill(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int distId=mapper.getDistributorId();
				String billNo=mapper.getBillNo();
				int storeId=mapper.getStoreId();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_DUPLICATE_BILL);
				callableStatement.setInt(1, distId);
				callableStatement.setString(2, billNo);
				callableStatement.setInt(3, cmpnyId);
				callableStatement.setInt(4, storeId);
				callableStatement.setInt(5, mapper.getFinYrId());
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
			throw new DAOException("Check data to be fetched", e);
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
		return ""+status;

	}
	
	@Override
	public String postAllPurchase(Purchase purchase)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-11-02\\file_post_all__purchase_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Purchase.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchase, file);
				//jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(purchase, sw);
				String result = sw.toString();
				// System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_ALL_PURCHASE);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "purchase");
				callableStatement.setString(3, "purchaseDetails");
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
		return ""+status;

	}
	
	@Override
	public String postAllPurchaseReturn(PurchaseReturn purchaseReturn)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-11-02\\file_post_all_purchase_return_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(PurchaseReturn.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchaseReturn, file);
				//jaxbMarshaller.marshal(purchaseReturn, System.out);
				jaxbMarshaller.marshal(purchaseReturn, sw);
				String result = sw.toString();
				// System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_ALL_PURCHASE_RETURN);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "purchaseReturn");
				callableStatement.setString(3, "purchaseReturnDetails");
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
		return ""+status;

	}
	
	@Override
	public ResponseObj postPurchaseOrder(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj = new ResponseObj();
		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int purchaseId=mapper.getPurchaseOrderId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_PURCHASE_ORDER);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, purchaseId);
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(4);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Data posted successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Data not posted successfully.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Data not posted successfully.");
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
		return responseObj;

	}
	
	@Override
	public ResponseObj closePurchaseOrder(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj = new ResponseObj();
		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int purchaseId=mapper.getPurchaseOrderId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CLOSE_PURCHASE_ORDER);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, purchaseId);
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(5);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("PO closed successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("PO not closed successfully.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("PO not closed successfully.");
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
		return responseObj;

	}
	
	@Override
	public ResponseObj insertTempPurchaseFromSale(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj=new ResponseObj();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				String invDate = mapper.getInvDate();
				java.sql.Date invDate1 = DateUtil.convertStringDateToSqlDate(
						invDate, "yyyy-MM-dd");
				int cmpnyId=mapper.getCompanyId();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_INSERT_TEMP_PUR_FRM_SALE);
				callableStatement.setDate(1, invDate1);
				callableStatement.setInt(2, mapper.getItemId());
				callableStatement.setInt(3, cmpnyId);
				callableStatement.setInt(4, mapper.getStoreId());
				callableStatement.setDouble(5, mapper.getFinYrId());
				callableStatement.registerOutParameter(6,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(6);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record save successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not saved successfully.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be saved", e);
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
		return responseObj;

	}
	
	@Override
	public ResponseObj assignTaxToItem(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj=new ResponseObj();

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_ASSIGN_TAX_ITEM);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, mapper.getItemId());
				callableStatement.setInt(3, mapper.getTaxId());
				callableStatement.setDouble(4, mapper.getTaxPer());
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(5);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record save successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not saved successfully.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
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
		return responseObj;

	}
	
	@Override
	public String postDistributorPayment(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				//int purchaseId=mapper.getPaymentId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_DISTRIBUTOR_PAYMENT);
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
		return ""+status;

	}
	
	@Override
	public String postPurchaseReturn(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int purchaseRtrnId=mapper.getPurchaseReturnId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_PURCHASE_RETURN);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, purchaseRtrnId);
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
		return ""+status;

	}

}