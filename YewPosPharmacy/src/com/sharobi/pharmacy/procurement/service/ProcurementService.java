package com.sharobi.pharmacy.procurement.service;

import java.io.InputStream;
import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PurchaseInvoiceExcelDTO;
import com.sharobi.pharmacy.common.model.ExcelUploadResultObj;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.procurement.dao.ProcurementDAO;
import com.sharobi.pharmacy.procurement.dao.impl.ProcurementDAOImpl;
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

public class ProcurementService {

	private ProcurementDAO procurementDAO = new ProcurementDAOImpl();

	public ProcurementService() {

	}
	
	public Purchase getPurchase(CommonResultSetMapper mapper) throws ServiceException {

		Purchase purchase = null;
		try {

			purchase = procurementDAO.getPurchase(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase", e);

		}
		return purchase;
	}
	
	public List<PurchaseOrderDetailsDTO> generatePurchaseOrderByType(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseOrderDetailsDTO> purchase = null;
		try {

			purchase = procurementDAO.generatePurchaseOrderByType(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to generate po by type", e);

		}
		return purchase;
	}
	
	public List<PurchaseOrderDetailsDTO> getPendingPurchaseOrderDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseOrderDetailsDTO> purchase = null;
		try {

			purchase = procurementDAO.getPendingPurchaseOrderDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get pending purchase order details by inv no.", e);

		}
		return purchase;
	}
	
	public List<PurchaseOrderDetailsDTO> getPurchaseOrderDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseOrderDetailsDTO> purchase = null;
		try {

			purchase = procurementDAO.getPurchaseOrderDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase order details by id", e);

		}
		return purchase;
	}
	
	public ExcelUploadResultObj uploadPurInv(InputStream fileInputStream,PurchaseInvoiceExcelDTO mapper) throws ServiceException {

		ExcelUploadResultObj resultObj= null;
		try {

			resultObj = procurementDAO.uploadPurInv(fileInputStream,mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to upload purcahse inv", e);

		}
		return resultObj;
	}
	
	public PurchaseOrderDTO getPurchaseOrderHeaderById(CommonResultSetMapper mapper) throws ServiceException {

		PurchaseOrderDTO purchase = null;
		try {

			purchase = procurementDAO.getPurchaseOrderHeaderById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase order header", e);

		}
		return purchase;
	}
	
	public List<PurchaseOrderDTO> getAllPurchaseOrderDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseOrderDTO> purchase = null;
		try {

			purchase = procurementDAO.getAllPurchaseOrderDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase order details", e);

		}
		return purchase;
	}
	
	public PurchaseReturnDTO getPurchaseReturnHeaderById(CommonResultSetMapper mapper) throws ServiceException {

		PurchaseReturnDTO purchase = null;
		try {

			purchase = procurementDAO.getPurchaseReturnHeaderById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase return header by id", e);

		}
		return purchase;
	}
	
	public PurchaseOrderQtyDTO getPurchaseOrderQty(CommonResultSetMapper mapper) throws ServiceException {

		PurchaseOrderQtyDTO dto = null;
		try {

			dto = procurementDAO.getPurchaseOrderQty(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase order qty", e);

		}
		return dto;
	}
	
	public PaymentDetailsAllDTO getPaymentHeaderById(CommonResultSetMapper mapper) throws ServiceException {

		PaymentDetailsAllDTO pamnt = null;
		try {

			pamnt = procurementDAO.getPaymentHeaderById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get payment header by id", e);

		}
		return pamnt;
	}
	
	public List<PurchaseReturnDetailsDTO> getPurchaseReturnDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseReturnDetailsDTO> purchaseLst = null;
		try {

			purchaseLst = procurementDAO.getPurchaseReturnDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase return details by id", e);

		}
		return purchaseLst;
	}
	
	public List<PurchaseReturnDTO>  getPurchaseReturnHeaderAll(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseReturnDTO>  list = null;
		try {

			list = procurementDAO.getPurchaseReturnHeaderAll(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all purchase return header", e);

		}
		return list;
	}
	
	public List<PaymentDetailsAllDTO>  getPaymentsDetailsAll(CommonResultSetMapper mapper) throws ServiceException {

		List<PaymentDetailsAllDTO>  list = null;
		try {

			list = procurementDAO.getPaymentsDetailsAll(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all payment details", e);

		}
		return list;
	}
	
	public List<PaymentDetailsByIdDTO>  getPaymentsDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<PaymentDetailsByIdDTO>  list = null;
		try {

			list = procurementDAO.getPaymentsDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get payment details by id", e);

		}
		return list;
	}
	
	public List<PaymentDetailsByIdDTO>  getPendingPaymentBySupplier(CommonResultSetMapper mapper) throws ServiceException {

		List<PaymentDetailsByIdDTO>  list = null;
		try {

			list = procurementDAO.getPendingPaymentBySupplier(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get pending payment by supplier", e);

		}
		return list;
	}
	
	public List<PurchaseDetailsForReturnDTO>  getPurchaseDetailsForReturnByInv(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseDetailsForReturnDTO>  list = null;
		try {

			list = procurementDAO.getPurchaseDetailsForReturnByInv(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all purchase return details by inv no.", e);

		}
		return list;
	}
	
	public List<PurchaseDetailsForReturnDTO>  getPurchaseDetailsForReturnBySku(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseDetailsForReturnDTO>  list = null;
		try {

			list = procurementDAO.getPurchaseDetailsForReturnBySku(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all purchase return details by sku", e);

		}
		return list;
	}
	
	public List<PurchaseDetailsForReturnDTO>  getPurchaseDetailsForReturnByItem(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseDetailsForReturnDTO>  list = null;
		try {

			list = procurementDAO.getPurchaseDetailsForReturnByItem(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all purchase return details by inv no.", e);

		}
		return list;
	}
	
	public List<PurchaseHistoryDTO> getPurchaseHistoryByItem(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseHistoryDTO> details=null;
		try {

			details = procurementDAO.getPurchaseHistoryByItem(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase history", e);

		}
		return details;
	}
	
	public List<Purchase> getAllPurchase(CommonResultSetMapper mapper) throws ServiceException {

		List<Purchase> details=null;
		try {

			details = procurementDAO.getAllPurchase(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase details", e);

		}
		return details;
	}
	
	public List<PurchaseDetails> getPurchaseDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseDetails> details=null;
		try {

			details = procurementDAO.getPurchaseDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase details", e);

		}
		return details;
	}
	
	public List<PurchaseDetails> getLastPurchaseInvoiceDetailsByDistId(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseDetails> details=null;
		try {

			details = procurementDAO.getLastPurchaseInvoiceDetailsByDistId(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get last purchase details by dist id", e);

		}
		return details;
	}
	
	public List<PurchaseDetails> getPurchaseInvoiceDetailsByItemSku(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseDetails> details=null;
		try {

			details = procurementDAO.getPurchaseInvoiceDetailsByItemSku(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase details", e);

		}
		return details;
	}
	
	public List<PurchaseDetails> getPurchaseInvoiceDetailsByItemId(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseDetails> details=null;
		try {

			details = procurementDAO.getPurchaseInvoiceDetailsByItemId(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase details", e);

		}
		return details;
	}
	
	public ResponseObj createOrUpdatePurchaseOrder(PurchaseOrder purchaseOrder)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = procurementDAO.createOrUpdatePurchaseOrder(purchaseOrder);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating Purchase order", e);

		}
		return status;
	}
	
	public String createOrUpdatePurchaseInvoice(Purchase purchase)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = procurementDAO.createOrUpdatePurchaseInvoice(purchase);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating Purchase stock in", e);

		}
		return stockInId;
	}
	
	public String createOrUpdateDistributorPayment(DistributorPayment distributorPayment)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = procurementDAO.createOrUpdateDistributorPayment(distributorPayment);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating distributor payment", e);

		}
		return stockInId;
	}
	
	public String createOrUpdatePurchaseReturn(PurchaseReturn purchase)
			throws ServiceException {
		String purchseRturnId = "";
		try {
			
			purchseRturnId = procurementDAO.createOrUpdatePurchaseReturn(purchase);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating Purchase return", e);

		}
		return purchseRturnId;
	}
	
	public ResponseObj insertTempPurchaseFromSale(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = procurementDAO.insertTempPurchaseFromSale(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error inserting temp purchase from sale", e);

		}
		return status;
	}
	
	public ResponseObj assignTaxToItem(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = procurementDAO.assignTaxToItem(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error assignng tax to item", e);

		}
		return status;
	}
	
	public ResponseObj closePurchaseOrder(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj responseObj = new ResponseObj();
		try {
			
			responseObj = procurementDAO.closePurchaseOrder(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error closing PO", e);

		}
		return responseObj;
	}
	
	public ResponseObj postPurchaseOrder(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj responseObj = new ResponseObj();
		try {
			
			responseObj = procurementDAO.postPurchaseOrder(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting PO", e);

		}
		return responseObj;
	}
	
	public String getDuplicateBill(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = procurementDAO.getDuplicateBill(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error gettting duplicate bill", e);

		}
		return stockInId;
	}
	
	public String postAllPurchaseReturn(PurchaseReturn purchaseReturn)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = procurementDAO.postAllPurchaseReturn(purchaseReturn);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting purchase return all", e);

		}
		return stockInId;
	}
	
	public String postAllPurchase(Purchase purchase)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = procurementDAO.postAllPurchase(purchase);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting purchase all", e);

		}
		return stockInId;
	}
	
	public String postPurchaseInvoice(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = procurementDAO.postPurchaseInvoice(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting invoice", e);

		}
		return stockInId;
	}
	
	public String postDistributorPayment(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = procurementDAO.postDistributorPayment(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting distributor paymnt", e);

		}
		return stockInId;
	}
	
	public String postPurchaseReturn(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = procurementDAO.postPurchaseReturn(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting purchase return", e);

		}
		return stockInId;
	}
	
	public ResponseObj deletePurchaseOrder(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj responseObj=new ResponseObj();
		try {
			
			responseObj = procurementDAO.deletePurchaseOrder(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error deleting Purchase order", e);

		}
		return responseObj;
	}
	
	public String deletePurchaseInvoice(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			
			status = procurementDAO.deletePurchaseInvoice(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error deleting Purchase invoice", e);

		}
		return status;
	}
	
	public String deletePurchaseReturn(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			
			status = procurementDAO.deletePurchaseReturn(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error deleting Purchase return", e);

		}
		return status;
	}
	
	public String deleteDistributorPayment(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			
			status = procurementDAO.deleteDistributorPayment(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error deleting distributor payment", e);

		}
		return status;
	}
	
	public List<PurchaseReturnDTO> getAdjPurchaseReturn(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseReturnDTO> returnAdjDTOs = null;
		try {

			returnAdjDTOs = procurementDAO.getAdjPurchaseReturn(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase return adjustment by inv no.", e);

		}
		return returnAdjDTOs;
	}
	
	public List<PurchaseReturnDTO> getAdjPurchaseReturnByPurchaseId(CommonResultSetMapper mapper) throws ServiceException {

		List<PurchaseReturnDTO> returnAdjDTOs = null;
		try {

			returnAdjDTOs = procurementDAO.getAdjPurchaseReturnByPurchaseId(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase return adjustment by purchase id.", e);

		}
		return returnAdjDTOs;
	}

	public ProcurementDAO getProcurementDAO() {
		return procurementDAO;
	}

	public void setProcurementDAO(ProcurementDAO procurementDAO) {
		this.procurementDAO = procurementDAO;
	}

}
