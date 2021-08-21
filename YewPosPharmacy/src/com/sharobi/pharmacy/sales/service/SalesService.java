package com.sharobi.pharmacy.sales.service;

import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.model.EsiCodeMaster;
import com.sharobi.pharmacy.common.model.TypeMaster;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.sales.dao.SalesDAO;
import com.sharobi.pharmacy.sales.dao.impl.SalesDAOImpl;
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
import com.sharobi.pharmacy.sales.model.Sales;
import com.sharobi.pharmacy.sales.model.TaxDetailsSaleBillDTO;

public class SalesService {

	private SalesDAO salesDAO = new SalesDAOImpl();

	public SalesService() {

	}
	
	public List<CustomerInfoDTO> getCustWithCreditLimitByName(CommonResultSetMapper mapper) throws ServiceException {

		List<CustomerInfoDTO> custDTO = null;
		try {

			custDTO = salesDAO.getCustWithCreditLimitByName(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get cust credit limit by name", e);

		}
		return custDTO;
	}
	
	public CustPaymentDetailsAllDTO getCustPaymentHeaderById(CommonResultSetMapper mapper) throws ServiceException {

		CustPaymentDetailsAllDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getCustPaymentHeaderById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get cust payment header", e);

		}
		return saleHeaderDTO;
	}
	
	public SaleHeaderDTO getSalesHeaderForBill(CommonResultSetMapper mapper) throws ServiceException {

		SaleHeaderDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesHeaderForBill(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale header for bill", e);

		}
		return saleHeaderDTO;
	}
	
	public SaleHeaderDTO getSalesHeader(CommonResultSetMapper mapper) throws ServiceException {

		SaleHeaderDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesHeader(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale header", e);

		}
		return saleHeaderDTO;
	}
	
	public SaleHeaderDTO getSalesHeaderByInvNo(CommonResultSetMapper mapper) throws ServiceException {

		SaleHeaderDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesHeaderByInvNo(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale header by inv no.", e);

		}
		return saleHeaderDTO;
	}
	
	public String postSalesInvoice(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postSalesInvoice(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting sales invoice", e);

		}
		return stockInId;
	}
	
	public String postCustPayment(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postCustPayment(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting cust payment", e);

		}
		return stockInId;
	}
	
	public String postSalesReturn(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postSalesReturn(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting sales return", e);

		}
		return stockInId;
	}
	
	/*public int printSaleBill(String storeId, String saleId)
			throws ServiceException {
		int stockInId = 0;
		try {
			
			stockInId = salesDAO.printSaleBill(storeId,saleId);
			

		} catch (DAOException e) {
			throw new ServiceException("error printing sale bill", e);

		}
		return stockInId;
	}*/
	
	public int incrementPrintCount(String id)
			throws ServiceException {
		int stockInId = 0;
		try {
			
			stockInId = salesDAO.incrementPrintCount(id);
			

		} catch (DAOException e) {
			throw new ServiceException("error incrementing print/reprint count", e);

		}
		return stockInId;
	}
	
	public String deleteCustPayment(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			
			status = salesDAO.deleteCustPayment(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error deleting cust payment", e);

		}
		return status;
	}
	
	public String deleteSalesInvoice(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			
			status = salesDAO.deleteSalesInvoice(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error deleting sales invoice", e);

		}
		return status;
	}
	
	public String deleteSalesReturn(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			
			status = salesDAO.deleteSalesReturn(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error deleting sales return", e);

		}
		return status;
	}
	
	public List<SaleDetailsDTO> getSalesDetailsByIdForBill(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesDetailsByIdForBill(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale details fr bill", e);

		}
		return saleHeaderDTO;
	}
	
	public List<EsiCodeMaster> getEsiCodes(CommonResultSetMapper mapper) throws ServiceException {

		List<EsiCodeMaster> type = null;
		try {

			type = salesDAO.getEsiCodes(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get esi codes", e);

		}
		return type;
	}
	
	public List<TypeMaster> getTypes(CommonResultSetMapper mapper) throws ServiceException {

		List<TypeMaster> type = null;
		try {

			type = salesDAO.getTypes(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get types", e);

		}
		return type;
	}
	
	public List<TaxDetailsSaleBillDTO> getTaxDetailsForSaleBill(CommonResultSetMapper mapper) throws ServiceException {

		List<TaxDetailsSaleBillDTO> taxes = null;
		try {

			taxes = salesDAO.getTaxDetailsForSaleBill(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get tax details", e);

		}
		return taxes;
	}
	
	public List<CommonResultSetMapper> getAutoRemarks(CommonResultSetMapper mapper) throws ServiceException {

		List<CommonResultSetMapper> list = null;
		try {

			list = salesDAO.getAutoRemarks(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get auto remarks", e);

		}
		return list;
	}
	
	public List<SaleItemDetailsDTO> getSaleItemDetailsByItemId(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleItemDetailsDTO> detailsDTOs = null;
		try {

			detailsDTOs = salesDAO.getSaleItemDetailsByItemId(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale item details by item id", e);

		}
		return detailsDTOs;
	}
	
	public List<SaleDetailsDTO> getSalesDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale details", e);

		}
		return saleHeaderDTO;
	}
	
	public List<PaymentMode> getPaymentModes(CommonResultSetMapper mapper) throws ServiceException {

		List<PaymentMode> paymentModes = null;
		try {

			paymentModes = salesDAO.getPaymentModes(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get payment modes", e);

		}
		return paymentModes;
	}
	
	
	
	public List<SaleDetailsDTO> getSalesDetailsByInvNo(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesDetailsByInvNo(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale details by inv no.", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleReturnDTO> getAllSalesReturnDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleReturnDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getAllSalesReturnDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return details", e);

		}
		return saleHeaderDTO;
	}
	
	public SaleReturnDTO getSaleReturnHeader(CommonResultSetMapper mapper) throws ServiceException {

		SaleReturnDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSaleReturnHeader(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return header", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleReturnDetailsDTO> getSaleReturnDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleReturnDetailsDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSaleReturnDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return details by id", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturnByItem(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsForReturnDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSaleDetailsForReturnByItem(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return details for return by inv no.", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturn(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsForReturnDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSaleDetailsForReturn(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return details for return by inv no.", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleReturnDTO> getAdjSaleReturn(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleReturnDTO> returnAdjDTOs = null;
		try {

			returnAdjDTOs = salesDAO.getAdjSaleReturn(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return adjustment by inv no.", e);

		}
		return returnAdjDTOs;
	}
	
	
	
	public List<SaleReturnDTO> getAdjSaleReturnBySaleId(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleReturnDTO> returnAdjDTOs = null;
		try {

			returnAdjDTOs = salesDAO.getAdjSaleReturnBySaleId(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return adjustment by sale id", e);

		}
		return returnAdjDTOs;
	}
	
	public List<CustPaymentDetailsByIdDTO> getCustPaymentDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<CustPaymentDetailsByIdDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getCustPaymentDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get cust payment details by id", e);

		}
		return saleHeaderDTO;
	}
	
	public List<CustPaymentDetailsByIdDTO> getPendingPaymentByCustomer(CommonResultSetMapper mapper) throws ServiceException {

		List<CustPaymentDetailsByIdDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getPendingPaymentByCustomer(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get pending payment by cust", e);

		}
		return saleHeaderDTO;
	}
	
	public List<CustPaymentDetailsAllDTO> getAllCustPaymentDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<CustPaymentDetailsAllDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getAllCustPaymentDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all cust payment details", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleDetailsAllDTO> getAllSaleDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsAllDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getAllSaleDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all sale details", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleHeaderDTO> getLastSaleByCustomer(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleHeaderDTO> lastSales = null;
		try {

			lastSales = salesDAO.getLastSaleByCustomer(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get last sale by customer", e);

		}
		return lastSales;
	}
	
	public List<CustomerMaster> getAllCustomerByNameOrPh(CommonResultSetMapper mapper) throws ServiceException {

		List<CustomerMaster> customer = null;
		try {

			customer = salesDAO.getAllCustomerByNameOrPh(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all customer", e);

		}
		return customer;
	}
	
	public String createOrUpdateSalesInvoice(Sales sales)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.createOrUpdateSalesInvoice(sales);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating sales invoice", e);

		}
		return stockInId;
	}
	
	public String createOrUpdateCustPayment(CustomerPayment customerPayment)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.createOrUpdateCustPayment(customerPayment);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating cust payment", e);

		}
		return stockInId;
	}
	
	public String createOrUpdateSalesReturn(SaleReturn sales)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.createOrUpdateSalesReturn(sales);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating sales invoice", e);

		}
		return stockInId;
	}

	public SalesDAO getSalesDAO() {
		return salesDAO;
	}

	public void setSalesDAO(SalesDAO salesDAO) {
		this.salesDAO = salesDAO;
	}

	public String postALLSalesInvoice(Sales sales) throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postALLSalesInvoice(sales);
			

		} catch (DAOException e) {
			throw new ServiceException("error postALLSalesInvoice", e);

		}
		return stockInId;
	}

	public String postALLReturnSalesInvoice(SaleReturn saleReturn) throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postALLReturnSalesInvoice(saleReturn);
			

		} catch (DAOException e) {
			throw new ServiceException("error postALLReturnSalesInvoice", e);

		}
		return stockInId;
	}
	
}
