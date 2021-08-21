package com.sharobi.pharmacy.procurement.dao;

import java.io.InputStream;
import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PurchaseInvoiceExcelDTO;
import com.sharobi.pharmacy.common.model.ExcelUploadResultObj;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.exceptions.DAOException;
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

public interface ProcurementDAO {

	public Purchase getPurchase(CommonResultSetMapper mapper)
			throws DAOException;
	
	public PurchaseOrderQtyDTO getPurchaseOrderQty(CommonResultSetMapper mapper)
			throws DAOException;
	
	public PaymentDetailsAllDTO getPaymentHeaderById(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PurchaseOrderDetailsDTO> generatePurchaseOrderByType(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PurchaseOrderDetailsDTO> getPendingPurchaseOrderDetails(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PurchaseOrderDetailsDTO> getPurchaseOrderDetailsById(CommonResultSetMapper mapper)
			throws DAOException;
	
	public PurchaseOrderDTO getPurchaseOrderHeaderById(CommonResultSetMapper mapper)
			throws DAOException;
	
	public ExcelUploadResultObj uploadPurInv(InputStream fileInputStream,PurchaseInvoiceExcelDTO mapper) throws DAOException;
	
	public List<PurchaseOrderDTO> getAllPurchaseOrderDetails(CommonResultSetMapper mapper)
			throws DAOException;
	
	public PurchaseReturnDTO getPurchaseReturnHeaderById(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PurchaseReturnDetailsDTO> getPurchaseReturnDetailsById(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PurchaseReturnDTO> getPurchaseReturnHeaderAll(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PaymentDetailsAllDTO> getPaymentsDetailsAll(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PaymentDetailsByIdDTO> getPaymentsDetailsById(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PaymentDetailsByIdDTO> getPendingPaymentBySupplier(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PurchaseDetailsForReturnDTO> getPurchaseDetailsForReturnByInv(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PurchaseDetailsForReturnDTO> getPurchaseDetailsForReturnBySku(CommonResultSetMapper mapper)
			throws DAOException;

	public List<PurchaseDetailsForReturnDTO> getPurchaseDetailsForReturnByItem(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PurchaseHistoryDTO> getPurchaseHistoryByItem(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<Purchase> getAllPurchase(CommonResultSetMapper mapper)
			throws DAOException;

	public List<PurchaseDetails> getPurchaseDetailsById(
			CommonResultSetMapper mapper) throws DAOException;
	
	public List<PurchaseDetails> getLastPurchaseInvoiceDetailsByDistId(
			CommonResultSetMapper mapper) throws DAOException;

	public ResponseObj createOrUpdatePurchaseOrder(PurchaseOrder purchaseOrder) throws DAOException;
	
	public String createOrUpdatePurchaseInvoice(Purchase purchase) throws DAOException;
	
	public String createOrUpdateDistributorPayment(DistributorPayment distributorPayment) throws DAOException;
	
	public String createOrUpdatePurchaseReturn(PurchaseReturn purchase) throws DAOException;
	
	public ResponseObj closePurchaseOrder(CommonResultSetMapper mapper) throws DAOException;
	
	public ResponseObj postPurchaseOrder(CommonResultSetMapper mapper) throws DAOException;
	
	public String getDuplicateBill(CommonResultSetMapper mapper) throws DAOException;
	
	public String postAllPurchaseReturn(PurchaseReturn purchaseReturn) throws DAOException;
	
	public String postAllPurchase(Purchase purchase) throws DAOException;
	
	public String postPurchaseInvoice(CommonResultSetMapper mapper) throws DAOException;
	
	public ResponseObj insertTempPurchaseFromSale(CommonResultSetMapper mapper) throws DAOException;
	
	public ResponseObj assignTaxToItem(CommonResultSetMapper mapper) throws DAOException;
	
	public String postDistributorPayment(CommonResultSetMapper mapper) throws DAOException;
	
	public String postPurchaseReturn(CommonResultSetMapper mapper) throws DAOException;
	
	public ResponseObj deletePurchaseOrder(CommonResultSetMapper mapper) throws DAOException;
	
	public String deletePurchaseInvoice(CommonResultSetMapper mapper) throws DAOException;
	
	public String deletePurchaseReturn(CommonResultSetMapper mapper) throws DAOException;
	
	public String deleteDistributorPayment(CommonResultSetMapper mapper) throws DAOException;
	
	public List<PurchaseDetails> getPurchaseInvoiceDetailsByItemSku(
			CommonResultSetMapper mapper) throws DAOException;
	
	public List<PurchaseDetails> getPurchaseInvoiceDetailsByItemId(
			CommonResultSetMapper mapper) throws DAOException;
	
	public List<PurchaseReturnDTO> getAdjPurchaseReturn(CommonResultSetMapper mapper) throws DAOException;
	public List<PurchaseReturnDTO> getAdjPurchaseReturnByPurchaseId(CommonResultSetMapper mapper) throws DAOException;

}

/**
 * rajarshi
 */
