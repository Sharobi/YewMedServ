package com.sharobi.pharmacy.store.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.ws.rs.core.Context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.EmailBean;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.common.WriteToExcelDTO;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.commonutil.SendEmail;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.inventory.model.DistributorMaster;
import com.sharobi.pharmacy.procurement.dao.ProcurementDAO;
import com.sharobi.pharmacy.procurement.dao.impl.ProcurementDAOImpl;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderDetailsDTO;
import com.sharobi.pharmacy.store.dao.StoreDAO;
import com.sharobi.pharmacy.store.model.FinYrMaster;
import com.sharobi.pharmacy.store.model.StoreMaster;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class StoreDAOImpl implements StoreDAO {
	private final static Logger logger = LogManager
			.getLogger(StoreDAOImpl.class);

	private EntityManagerFactory entityManagerFactory = PersistenceListener.getEntityManager();

	public StoreDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public StoreMaster getStoreDetails(String storeId) throws DAOException {

		StoreMaster storeMaster = null;
		EntityManager em = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			int storeid = Integer.parseInt(storeId);
			TypedQuery<StoreMaster> qrygetstore = em
					.createQuery("SELECT s FROM StoreMaster s WHERE s.id=:storeid and s.isDeleted=0", StoreMaster.class);

			qrygetstore.setParameter("storeid", storeid);
			storeMaster = (StoreMaster) qrygetstore.getSingleResult();
			
			logger.info("Store fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return storeMaster;
	}
	
	public FinYrMaster getFinYrDetailsById(String id) throws DAOException {

		FinYrMaster finYrMaster = null;
		EntityManager em = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			int id1 = Integer.parseInt(id);
			TypedQuery<FinYrMaster> qrygetstore = em
					.createQuery("SELECT s FROM FinYrMaster s WHERE s.id=:id1 and s.isDeleted=0", FinYrMaster.class);

			qrygetstore.setParameter("id1", id1);
			finYrMaster = (FinYrMaster) qrygetstore.getSingleResult();
			
			logger.info("fin year fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return finYrMaster;
	}
	
	public List<FinYrMaster> getFinYrList(CommonResultSetMapper comm) throws DAOException {

		List<FinYrMaster> finYrMasters = null;
		EntityManager em = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<FinYrMaster> qrygetstore = em
					.createQuery("SELECT s FROM FinYrMaster s WHERE s.storeId=:storeId and s.isDeleted=0", FinYrMaster.class);
			qrygetstore.setParameter("storeId", comm.getStoreId());
			finYrMasters = qrygetstore.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);
		} finally {
			if(em != null) em.close();
		}
		return finYrMasters;
	}
	
	@Override
	public ResponseObj sendEmail(EmailBean emailBean,HttpServletRequest request) throws DAOException {

		StoreMaster storeMaster = null;
		EntityManager em = null;
		Connection connection = null;
		ResponseObj responseObj=new ResponseObj();
		String name="";
		String address="";
		String distAddr="";
		int distId=0;
		int transId=0;
		String mailPwd="";
		String mailPort="";
		String mailSmtp="";
		String phone="";
		String pincode="";
		String distPhone="";
		String distPincode="";
		String distCity="";
		ProcurementDAO dao=new ProcurementDAOImpl();
		PurchaseOrderDTO poDto=new PurchaseOrderDTO();
		DistributorMaster distributorMaster=new DistributorMaster();
		

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			int storeid = emailBean.getStoreId();
			transId=emailBean.getTransId();
			TypedQuery<StoreMaster> qrygetstore = em
					.createQuery("SELECT s FROM StoreMaster s WHERE s.id=:storeid and s.isDeleted=0", StoreMaster.class);

			qrygetstore.setParameter("storeid", storeid);
			storeMaster = (StoreMaster) qrygetstore.getSingleResult();
			mailPort=storeMaster.getMailPort();
			mailPwd=storeMaster.getMailPassword();
			mailSmtp=storeMaster.getMailSmtp();
			if("PO".equals(emailBean.getTransType()))
			{	
			
			name=storeMaster.getName();
			address=storeMaster.getAddress();
			phone=storeMaster.getPhone();
			pincode=storeMaster.getPostcode();
			
			CommonResultSetMapper mapper=new CommonResultSetMapper();
			mapper.setPurchaseOrderId(transId);
			poDto=dao.getPurchaseOrderHeaderById(mapper);
			distId=poDto.getDistributorId();
			TypedQuery<DistributorMaster> qry = em
					.createQuery("SELECT d FROM DistributorMaster d WHERE d.id=:id and d.isDeleted=0", DistributorMaster.class);

			qry.setParameter("id", distId);
			distributorMaster = (DistributorMaster) qry.getSingleResult();
			distAddr=distributorMaster.getAddress();
			distPhone=distributorMaster.getPhoneNo1();
			distPincode=distributorMaster.getPin();
			distCity=distributorMaster.getCity();
			String retailerAddr="ADD:"+address+","+"Ph:"+phone;
			String disAdd="TO:"+distributorMaster.getName()+","+distAddr+","+distCity+"-"+distPincode+","+"PH:"+distPhone;
			String invDetls="Invoice No.:"+poDto.getInvNo()+","+"Invoice Dt.:"+poDto.getInvDate()+","+"Due Dt.:"+poDto.getDueDate();
			List<String> header=new ArrayList<String>();
			header.add("SL");
			header.add("ITEM NAME");
			header.add("CONVERSION");
			header.add("MFG");
			header.add("MRP");
			header.add("RATE");
			header.add("QTY");
			header.add("DIS%");
			header.add("TAX%");
			header.add("AMT");
			List<PurchaseOrderDetailsDTO> detailsDTOs=dao.getPurchaseOrderDetailsById(mapper);
			//create excel
			WriteToExcelDTO excelDTO=new WriteToExcelDTO();
			excelDTO.setFirstData(name);
			excelDTO.setSecondData(retailerAddr);
			excelDTO.setThirdData(disAdd);
			excelDTO.setFourthData(invDetls);
			excelDTO.setHeaderList(header);
			excelDTO.setValueList(detailsDTOs);
			excelDTO.writeToExcel();
			}
			if("SI".equals(emailBean.getTransType()))
			{
				// get connection object from entity manager
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				String fileName = null;
				String jasperFile = null;
				
				Map<String, Object> parameters = new HashMap<String, Object>();

				parameters.put("W_CompanyID", emailBean.getCompanyId());
				parameters.put("W_StoreID", storeid);
				parameters.put("W_SaleID", transId);
				parameters.put("W_IsReprint", 0);
				parameters.put("W_ReprintCount", 0);
				parameters.put("W_Logo_Path", request.getRealPath("/images/dava_dost.png"));
				parameters.put("W_Note1", "");
				parameters.put("W_Note2", "");
				fileName = "yewmedsalebill2100mm";
				jasperFile = "yewmedsalebill2100mm.jrxml";
				fileName = fileName + ".pdf";
				generatePDF(request, fileName, parameters, connection, jasperFile);
			}
			//send email
			emailBean.setFromAddr(storeMaster.getEmail());
			emailBean.setMailPort(mailPort);
			emailBean.setMailPwd(mailPwd);
			emailBean.setMailSmtp(mailSmtp);
			//emailBean.setAttchmntData(attchmentData);
			
			SendEmail email=new SendEmail();
			int status=email.sendEmail(emailBean,request);
			
			if (status >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(status);
				responseObj.setReason("Email sent successfully");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(status);
				responseObj.setReason("Email not sent successfully");
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Email not sent successfully.");
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return responseObj;
	}
	
	// method to generate pdf
		public void generatePDF(HttpServletRequest request, String fileName,
				Map<String, Object> parameters, Connection connection, String jasperFile)
				throws FileNotFoundException, IOException {

			try {

				//File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);

				JasperReport report;

				report = JasperCompileManager.compileReport(request.getRealPath("/jasper") + "/sales/" + jasperFile);
				JasperPrint print = JasperFillManager.fillReport(report, parameters, connection);
				JasperExportManager.exportReportToPdfFile(print, request.getRealPath("/") + "/jasper/sales/" + fileName);

			}

			catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}

			
		}
}

/**
 * rajarshi
 */
