package com.sharobi.pharmacy.procurement.webservice;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.procurement.model.DistributorPayment;
import com.sharobi.pharmacy.procurement.model.Purchase;
import com.sharobi.pharmacy.procurement.model.PurchaseOrder;
import com.sharobi.pharmacy.procurement.model.PurchaseReturn;

public interface ProcurementWS {

	public String getPurchase(CommonResultSetMapper mapper);

	public String getAllPurchase(CommonResultSetMapper mapper);

	public String getPurchaseDetailsById(CommonResultSetMapper mapper);
	public String createOrUpdatePurchaseInvoice(Purchase purchase);
	public String getPurchaseInvoiceDetailsByItemId(CommonResultSetMapper mapper);
	public String deletePurchaseInvoice(CommonResultSetMapper mapper);
	public String getLastPurchaseInvoiceDetailsByDistId(CommonResultSetMapper mapper);
	public String postPurchaseInvoice(CommonResultSetMapper mapper);
	public String getPurchaseReturnHeaderById(CommonResultSetMapper mapper);
	public String getPurchaseReturnHeaderAll(CommonResultSetMapper mapper);
	public String getPurchaseReturnDetailsById(CommonResultSetMapper mapper);
	public String getPurchaseDetailsForReturnByInv(CommonResultSetMapper mapper);
	public String getPurchaseDetailsForReturnByItem(CommonResultSetMapper mapper);
	public String postPurchaseReturn(CommonResultSetMapper mapper);
	public String deletePurchaseReturn(CommonResultSetMapper mapper);
	public String createOrUpdatePurchaseReturn(PurchaseReturn purchase);
	public String getPaymentsDetailsAll(CommonResultSetMapper mapper);
	public String getPaymentHeaderById(CommonResultSetMapper mapper);
	public String getPaymentsDetailsById(CommonResultSetMapper mapper);
	public String getPendingPaymentBySupplier(CommonResultSetMapper mapper);
	public String createOrUpdateDistributorPayment(DistributorPayment distributorPayment);
	public String postDistributorPayment(CommonResultSetMapper mapper);
	public String deleteDistributorPayment(CommonResultSetMapper mapper);
	public String getAdjPurchaseReturn(CommonResultSetMapper mapper);
	public String getAdjPurchaseReturnByPurchaseId(CommonResultSetMapper mapper);
	public String getPurchaseHistoryByItem(CommonResultSetMapper mapper);
	public String getPurchaseInvoiceDetailsByItemSku(CommonResultSetMapper mapper);
	public String getAllPurchaseOrderDetails(CommonResultSetMapper mapper);
	public String getPurchaseOrderHeaderById(CommonResultSetMapper mapper);
	public String getPurchaseOrderDetailsById(CommonResultSetMapper mapper);
	public String createOrUpdatePurchaseOrder(PurchaseOrder purchaseOrder);
	

}

/**
 * rajarshi
 */
