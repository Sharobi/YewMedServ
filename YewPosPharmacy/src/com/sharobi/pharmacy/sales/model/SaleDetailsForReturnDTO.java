package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SaleDetailsForReturnDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "sale_id" })
	private int saleId;
	
	@Expose
	@MapToData(columnAliases = { "sale_inv_no" })
	private String saleInvNo;
	
	@Expose
	@MapToData(columnAliases = { "sale_inv_date" })
	private Date saleInvDate;
	
	@Expose
	@MapToData(columnAliases = { "sale_inv_time" })
	private String saleInvTime;

	@Expose
	@MapToData(columnAliases = { "sale_inv_mode_name" })
	private String saleInvModeName;

	@Expose
	@MapToData(columnAliases = { "gross_amount" })
	private double grossAmount;

	@Expose
	@MapToData(columnAliases = { "ed_amount" })
	private double edAmount;

	@Expose
	@MapToData(columnAliases = { "disc_amount" })
	private double discAmount;

	@Expose
	@MapToData(columnAliases = { "vat_amount" })
	private double vatAmount;

	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;

	@Expose
	@MapToData(columnAliases = { "adj_amount" })
	private double adjAmount;
	
	@Expose
	@MapToData(columnAliases = { "roundoff" })
	private double roundOff;
	
	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "cash_amount" })
	private double cashAmount;
	
	@Expose
	@MapToData(columnAliases = { "card_amount" })
	private double cardAmount;
	
	@Expose
	@MapToData(columnAliases = { "credit_amount" })
	private double creditAmount;
	
	@Expose
	@MapToData(columnAliases = { "customer_id" })
	private int customerId;

	@Expose
	@MapToData(columnAliases = { "customer_name" })
	private String customerName;

	@Expose
	@MapToData(columnAliases = { "customer_phone" })
	private String customerPhone;

	@Expose
	@MapToData(columnAliases = { "customer_address" })
	private String customerAddress;
	
	@Expose
	@MapToData(columnAliases = { "doctor_id" })
	private int doctorId;

	@Expose
	@MapToData(columnAliases = { "doctor_name" })
	private String doctorName;
	
	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;

	@Expose
	@MapToData(columnAliases = { "item_name" })
	private String itemName;

	@Expose
	@MapToData(columnAliases = { "batch_no" })
	private String batchNo;

	@Expose
	@MapToData(columnAliases = { "expiry_date" })
	private Date expiryDate;

	@Expose
	@MapToData(columnAliases = { "expiry_date_format" })
	private String expiryDateFormat;

	@Expose
	@MapToData(columnAliases = { "pack_unit_id" })
	private int packUnitId;

	@Expose
	@MapToData(columnAliases = { "pack_unit_name" })
	private String packUnitName;

	@Expose
	@MapToData(columnAliases = { "pack_qty" })
	private int packQty;

	@Expose
	@MapToData(columnAliases = { "conversion" })
	private int conversion;
	
	@Expose
	@MapToData(columnAliases = { "loose_unit_id" })
	private int looseUnitId;
	 
	@Expose
	@MapToData(columnAliases = { "loose_unit_name" })
	private String looseUnitName;

	@Expose
	@MapToData(columnAliases = { "loose_qty" })
	private int looseQty;
	
	@Expose
	@MapToData(columnAliases = { "mrp" })
	private double mrp;

	@Expose
	@MapToData(columnAliases = { "rate" })
	private double rate;
	
	@Expose
	@MapToData(columnAliases = { "mrp_per_unit" })
	private double mrpPerUnit;

	@Expose
	@MapToData(columnAliases = { "rate_per_unit" })
	private double ratePerUnit;

	@Expose
	@MapToData(columnAliases = { "amount" })
	private double amount;

	@Expose
	@MapToData(columnAliases = { "ed_per" })
	private double edPer;

	@Expose
	@MapToData(columnAliases = { "ed" })
	private double ed;

	@Expose
	@MapToData(columnAliases = { "tax_per" })
	private double taxPer;

	@Expose
	@MapToData(columnAliases = { "tax" })
	private double tax;

	@Expose
	@MapToData(columnAliases = { "vat_per" })
	private double vatPer;

	@Expose
	@MapToData(columnAliases = { "vat" })
	private double vat;

	@Expose
	@MapToData(columnAliases = { "disc_per" })
	private double discPer;

	@Expose
	@MapToData(columnAliases = { "disc" })
	private double disc;

	@Expose
	@MapToData(columnAliases = { "tot_amount" })
	private double totAmount;
	
	@Expose
	@MapToData(columnAliases = { "calculate_loose_qty" })
	private int calculateLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "prev_return_pack_qty" })
	private int prevReturnPackQty;
	
	@Expose
	@MapToData(columnAliases = { "prev_return_loose_qty" })
	private int prevReturnLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_name" })
	private String manufacturerName;
	
	@Expose
	@MapToData(columnAliases = { "content_name" })
	private String contentName;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_code" })
	private String manufacturerCode;
	
	@Expose
	@MapToData(columnAliases = { "hide_pack_qty" })
	private int hidePackQty;
	
	@Expose
	@MapToData(columnAliases = { "hide_loose_qty" })
	private int hideLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_per" })
	private double specialDiscPer;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_amount" })
	private double specialDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;
	
	@Expose
	@MapToData(columnAliases = { "tax_name" })
	private String taxName;
	
	@Expose
	@MapToData(columnAliases = { "tax_percentage" })
	private double taxPercentage;
	
	@Expose
	@MapToData(columnAliases = { "item_tax_amount" })
	private double itemTaxAmount;
	
	@Expose
	@MapToData(columnAliases = { "is_group_tax" })
	private int isGroupTax;
	
	@Expose
	@MapToData(columnAliases = { "tax_mode" })
	private String taxMode;
	
	@Expose
	@MapToData(columnAliases = { "SKU" })
	private String sku;
	
	@Expose
	@MapToData(columnAliases = { "HSN_code" })
	private String hsnCode;

	private static final long serialVersionUID = 1L;
	
	
	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public double getItemTaxAmount() {
		return itemTaxAmount;
	}

	public void setItemTaxAmount(double itemTaxAmount) {
		this.itemTaxAmount = itemTaxAmount;
	}

	public int getIsGroupTax() {
		return isGroupTax;
	}

	public void setIsGroupTax(int isGroupTax) {
		this.isGroupTax = isGroupTax;
	}

	public String getTaxMode() {
		return taxMode;
	}

	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public double getSpecialDiscPer() {
		return specialDiscPer;
	}

	public void setSpecialDiscPer(double specialDiscPer) {
		this.specialDiscPer = specialDiscPer;
	}

	public double getSpecialDiscAmount() {
		return specialDiscAmount;
	}

	public void setSpecialDiscAmount(double specialDiscAmount) {
		this.specialDiscAmount = specialDiscAmount;
	}

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}
	
	public int getHidePackQty() {
		return hidePackQty;
	}


	public void setHidePackQty(int hidePackQty) {
		this.hidePackQty = hidePackQty;
	}


	public int getHideLooseQty() {
		return hideLooseQty;
	}


	public void setHideLooseQty(int hideLooseQty) {
		this.hideLooseQty = hideLooseQty;
	}


	public String getManufacturerCode() {
		return manufacturerCode;
	}


	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}


	public String getManufacturerName() {
		return manufacturerName;
	}


	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}


	public String getContentName() {
		return contentName;
	}


	public void setContentName(String contentName) {
		this.contentName = contentName;
	}


	public int getSaleId() {
		return saleId;
	}


	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}


	public String getSaleInvNo() {
		return saleInvNo;
	}


	public void setSaleInvNo(String saleInvNo) {
		this.saleInvNo = saleInvNo;
	}


	public Date getSaleInvDate() {
		return saleInvDate;
	}


	public void setSaleInvDate(Date saleInvDate) {
		this.saleInvDate = saleInvDate;
	}


	public String getSaleInvTime() {
		return saleInvTime;
	}


	public void setSaleInvTime(String saleInvTime) {
		this.saleInvTime = saleInvTime;
	}


	public String getSaleInvModeName() {
		return saleInvModeName;
	}


	public void setSaleInvModeName(String saleInvModeName) {
		this.saleInvModeName = saleInvModeName;
	}


	public double getGrossAmount() {
		return grossAmount;
	}


	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}


	public double getEdAmount() {
		return edAmount;
	}


	public void setEdAmount(double edAmount) {
		this.edAmount = edAmount;
	}


	public double getDiscAmount() {
		return discAmount;
	}


	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}


	public double getVatAmount() {
		return vatAmount;
	}


	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}


	public double getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}


	public double getAdjAmount() {
		return adjAmount;
	}


	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}


	public double getRoundOff() {
		return roundOff;
	}


	public void setRoundOff(double roundOff) {
		this.roundOff = roundOff;
	}


	public double getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}


	public double getCashAmount() {
		return cashAmount;
	}


	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}


	public double getCardAmount() {
		return cardAmount;
	}


	public void setCardAmount(double cardAmount) {
		this.cardAmount = cardAmount;
	}


	public double getCreditAmount() {
		return creditAmount;
	}


	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getBatchNo() {
		return batchNo;
	}


	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}


	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}


	public int getPackUnitId() {
		return packUnitId;
	}


	public void setPackUnitId(int packUnitId) {
		this.packUnitId = packUnitId;
	}


	public String getPackUnitName() {
		return packUnitName;
	}


	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}


	public int getPackQty() {
		return packQty;
	}


	public void setPackQty(int packQty) {
		this.packQty = packQty;
	}


	public int getConversion() {
		return conversion;
	}


	public void setConversion(int conversion) {
		this.conversion = conversion;
	}


	public int getLooseUnitId() {
		return looseUnitId;
	}


	public void setLooseUnitId(int looseUnitId) {
		this.looseUnitId = looseUnitId;
	}


	public String getLooseUnitName() {
		return looseUnitName;
	}


	public void setLooseUnitName(String looseUnitName) {
		this.looseUnitName = looseUnitName;
	}


	public int getLooseQty() {
		return looseQty;
	}


	public void setLooseQty(int looseQty) {
		this.looseQty = looseQty;
	}


	public double getMrp() {
		return mrp;
	}


	public void setMrp(double mrp) {
		this.mrp = mrp;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getEdPer() {
		return edPer;
	}


	public void setEdPer(double edPer) {
		this.edPer = edPer;
	}


	public double getEd() {
		return ed;
	}


	public void setEd(double ed) {
		this.ed = ed;
	}


	public double getTaxPer() {
		return taxPer;
	}


	public void setTaxPer(double taxPer) {
		this.taxPer = taxPer;
	}


	public double getTax() {
		return tax;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}


	public double getVatPer() {
		return vatPer;
	}


	public void setVatPer(double vatPer) {
		this.vatPer = vatPer;
	}


	public double getVat() {
		return vat;
	}


	public void setVat(double vat) {
		this.vat = vat;
	}


	public double getDiscPer() {
		return discPer;
	}


	public void setDiscPer(double discPer) {
		this.discPer = discPer;
	}


	public double getDisc() {
		return disc;
	}


	public void setDisc(double disc) {
		this.disc = disc;
	}


	public double getTotAmount() {
		return totAmount;
	}


	public void setTotAmount(double totAmount) {
		this.totAmount = totAmount;
	}


	public int getCalculateLooseQty() {
		return calculateLooseQty;
	}


	public void setCalculateLooseQty(int calculateLooseQty) {
		this.calculateLooseQty = calculateLooseQty;
	}


	public int getPrevReturnPackQty() {
		return prevReturnPackQty;
	}


	public void setPrevReturnPackQty(int prevReturnPackQty) {
		this.prevReturnPackQty = prevReturnPackQty;
	}


	public int getPrevReturnLooseQty() {
		return prevReturnLooseQty;
	}


	public void setPrevReturnLooseQty(int prevReturnLooseQty) {
		this.prevReturnLooseQty = prevReturnLooseQty;
	}


	public double getMrpPerUnit() {
		return mrpPerUnit;
	}


	public void setMrpPerUnit(double mrpPerUnit) {
		this.mrpPerUnit = mrpPerUnit;
	}


	public double getRatePerUnit() {
		return ratePerUnit;
	}


	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + calculateLooseQty;
		temp = Double.doubleToLongBits(cardAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cashAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((contentName == null) ? 0 : contentName.hashCode());
		result = prime * result + conversion;
		temp = Double.doubleToLongBits(creditAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + customerId;
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result
				+ ((customerPhone == null) ? 0 : customerPhone.hashCode());
		temp = Double.doubleToLongBits(disc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + doctorId;
		result = prime * result
				+ ((doctorName == null) ? 0 : doctorName.hashCode());
		temp = Double.doubleToLongBits(ed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(edAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(edPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		temp = Double.doubleToLongBits(grossAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + hideLooseQty;
		result = prime * result + hidePackQty;
		result = prime * result + ((hsnCode == null) ? 0 : hsnCode.hashCode());
		result = prime * result + isGroupTax;
		result = prime * result + itemId;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		temp = Double.doubleToLongBits(itemTaxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((itemUniqueKey == null) ? 0 : itemUniqueKey.hashCode());
		result = prime * result + looseQty;
		result = prime * result + looseUnitId;
		result = prime * result
				+ ((looseUnitName == null) ? 0 : looseUnitName.hashCode());
		result = prime
				* result
				+ ((manufacturerCode == null) ? 0 : manufacturerCode.hashCode());
		result = prime
				* result
				+ ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mrpPerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + packQty;
		result = prime * result + packUnitId;
		result = prime * result
				+ ((packUnitName == null) ? 0 : packUnitName.hashCode());
		result = prime * result + prevReturnLooseQty;
		result = prime * result + prevReturnPackQty;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ratePerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(roundOff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saleId;
		result = prime * result
				+ ((saleInvDate == null) ? 0 : saleInvDate.hashCode());
		result = prime * result
				+ ((saleInvModeName == null) ? 0 : saleInvModeName.hashCode());
		result = prime * result
				+ ((saleInvNo == null) ? 0 : saleInvNo.hashCode());
		result = prime * result
				+ ((saleInvTime == null) ? 0 : saleInvTime.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		temp = Double.doubleToLongBits(specialDiscAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(specialDiscPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + taxId;
		result = prime * result + ((taxMode == null) ? 0 : taxMode.hashCode());
		result = prime * result + ((taxName == null) ? 0 : taxName.hashCode());
		temp = Double.doubleToLongBits(taxPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vatAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vatPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleDetailsForReturnDTO other = (SaleDetailsForReturnDTO) obj;
		if (Double.doubleToLongBits(adjAmount) != Double
				.doubleToLongBits(other.adjAmount))
			return false;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (calculateLooseQty != other.calculateLooseQty)
			return false;
		if (Double.doubleToLongBits(cardAmount) != Double
				.doubleToLongBits(other.cardAmount))
			return false;
		if (Double.doubleToLongBits(cashAmount) != Double
				.doubleToLongBits(other.cashAmount))
			return false;
		if (contentName == null) {
			if (other.contentName != null)
				return false;
		} else if (!contentName.equals(other.contentName))
			return false;
		if (conversion != other.conversion)
			return false;
		if (Double.doubleToLongBits(creditAmount) != Double
				.doubleToLongBits(other.creditAmount))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
			return false;
		if (Double.doubleToLongBits(disc) != Double
				.doubleToLongBits(other.disc))
			return false;
		if (Double.doubleToLongBits(discAmount) != Double
				.doubleToLongBits(other.discAmount))
			return false;
		if (Double.doubleToLongBits(discPer) != Double
				.doubleToLongBits(other.discPer))
			return false;
		if (doctorId != other.doctorId)
			return false;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
			return false;
		if (Double.doubleToLongBits(ed) != Double.doubleToLongBits(other.ed))
			return false;
		if (Double.doubleToLongBits(edAmount) != Double
				.doubleToLongBits(other.edAmount))
			return false;
		if (Double.doubleToLongBits(edPer) != Double
				.doubleToLongBits(other.edPer))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (expiryDateFormat == null) {
			if (other.expiryDateFormat != null)
				return false;
		} else if (!expiryDateFormat.equals(other.expiryDateFormat))
			return false;
		if (Double.doubleToLongBits(grossAmount) != Double
				.doubleToLongBits(other.grossAmount))
			return false;
		if (hideLooseQty != other.hideLooseQty)
			return false;
		if (hidePackQty != other.hidePackQty)
			return false;
		if (hsnCode == null) {
			if (other.hsnCode != null)
				return false;
		} else if (!hsnCode.equals(other.hsnCode))
			return false;
		if (isGroupTax != other.isGroupTax)
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(itemTaxAmount) != Double
				.doubleToLongBits(other.itemTaxAmount))
			return false;
		if (itemUniqueKey == null) {
			if (other.itemUniqueKey != null)
				return false;
		} else if (!itemUniqueKey.equals(other.itemUniqueKey))
			return false;
		if (looseQty != other.looseQty)
			return false;
		if (looseUnitId != other.looseUnitId)
			return false;
		if (looseUnitName == null) {
			if (other.looseUnitName != null)
				return false;
		} else if (!looseUnitName.equals(other.looseUnitName))
			return false;
		if (manufacturerCode == null) {
			if (other.manufacturerCode != null)
				return false;
		} else if (!manufacturerCode.equals(other.manufacturerCode))
			return false;
		if (manufacturerName == null) {
			if (other.manufacturerName != null)
				return false;
		} else if (!manufacturerName.equals(other.manufacturerName))
			return false;
		if (Double.doubleToLongBits(mrp) != Double.doubleToLongBits(other.mrp))
			return false;
		if (Double.doubleToLongBits(mrpPerUnit) != Double
				.doubleToLongBits(other.mrpPerUnit))
			return false;
		if (Double.doubleToLongBits(netAmount) != Double
				.doubleToLongBits(other.netAmount))
			return false;
		if (packQty != other.packQty)
			return false;
		if (packUnitId != other.packUnitId)
			return false;
		if (packUnitName == null) {
			if (other.packUnitName != null)
				return false;
		} else if (!packUnitName.equals(other.packUnitName))
			return false;
		if (prevReturnLooseQty != other.prevReturnLooseQty)
			return false;
		if (prevReturnPackQty != other.prevReturnPackQty)
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (Double.doubleToLongBits(ratePerUnit) != Double
				.doubleToLongBits(other.ratePerUnit))
			return false;
		if (Double.doubleToLongBits(roundOff) != Double
				.doubleToLongBits(other.roundOff))
			return false;
		if (saleId != other.saleId)
			return false;
		if (saleInvDate == null) {
			if (other.saleInvDate != null)
				return false;
		} else if (!saleInvDate.equals(other.saleInvDate))
			return false;
		if (saleInvModeName == null) {
			if (other.saleInvModeName != null)
				return false;
		} else if (!saleInvModeName.equals(other.saleInvModeName))
			return false;
		if (saleInvNo == null) {
			if (other.saleInvNo != null)
				return false;
		} else if (!saleInvNo.equals(other.saleInvNo))
			return false;
		if (saleInvTime == null) {
			if (other.saleInvTime != null)
				return false;
		} else if (!saleInvTime.equals(other.saleInvTime))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (Double.doubleToLongBits(specialDiscAmount) != Double
				.doubleToLongBits(other.specialDiscAmount))
			return false;
		if (Double.doubleToLongBits(specialDiscPer) != Double
				.doubleToLongBits(other.specialDiscPer))
			return false;
		if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double
				.doubleToLongBits(other.taxAmount))
			return false;
		if (taxId != other.taxId)
			return false;
		if (taxMode == null) {
			if (other.taxMode != null)
				return false;
		} else if (!taxMode.equals(other.taxMode))
			return false;
		if (taxName == null) {
			if (other.taxName != null)
				return false;
		} else if (!taxName.equals(other.taxName))
			return false;
		if (Double.doubleToLongBits(taxPer) != Double
				.doubleToLongBits(other.taxPer))
			return false;
		if (Double.doubleToLongBits(taxPercentage) != Double
				.doubleToLongBits(other.taxPercentage))
			return false;
		if (Double.doubleToLongBits(totAmount) != Double
				.doubleToLongBits(other.totAmount))
			return false;
		if (Double.doubleToLongBits(vat) != Double.doubleToLongBits(other.vat))
			return false;
		if (Double.doubleToLongBits(vatAmount) != Double
				.doubleToLongBits(other.vatAmount))
			return false;
		if (Double.doubleToLongBits(vatPer) != Double
				.doubleToLongBits(other.vatPer))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SaleDetailsForReturnDTO [saleId=" + saleId + ", saleInvNo="
				+ saleInvNo + ", saleInvDate=" + saleInvDate + ", saleInvTime="
				+ saleInvTime + ", saleInvModeName=" + saleInvModeName
				+ ", grossAmount=" + grossAmount + ", edAmount=" + edAmount
				+ ", discAmount=" + discAmount + ", vatAmount=" + vatAmount
				+ ", taxAmount=" + taxAmount + ", adjAmount=" + adjAmount
				+ ", roundOff=" + roundOff + ", netAmount=" + netAmount
				+ ", cashAmount=" + cashAmount + ", cardAmount=" + cardAmount
				+ ", creditAmount=" + creditAmount + ", customerId="
				+ customerId + ", customerName=" + customerName
				+ ", customerPhone=" + customerPhone + ", customerAddress="
				+ customerAddress + ", doctorId=" + doctorId + ", doctorName="
				+ doctorName + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", expiryDateFormat=" + expiryDateFormat + ", packUnitId="
				+ packUnitId + ", packUnitName=" + packUnitName + ", packQty="
				+ packQty + ", conversion=" + conversion + ", looseUnitId="
				+ looseUnitId + ", looseUnitName=" + looseUnitName
				+ ", looseQty=" + looseQty + ", mrp=" + mrp + ", rate=" + rate
				+ ", mrpPerUnit=" + mrpPerUnit + ", ratePerUnit=" + ratePerUnit
				+ ", amount=" + amount + ", edPer=" + edPer + ", ed=" + ed
				+ ", taxPer=" + taxPer + ", tax=" + tax + ", vatPer=" + vatPer
				+ ", vat=" + vat + ", discPer=" + discPer + ", disc=" + disc
				+ ", totAmount=" + totAmount + ", calculateLooseQty="
				+ calculateLooseQty + ", prevReturnPackQty="
				+ prevReturnPackQty + ", prevReturnLooseQty="
				+ prevReturnLooseQty + ", manufacturerName=" + manufacturerName
				+ ", contentName=" + contentName + ", manufacturerCode="
				+ manufacturerCode + ", hidePackQty=" + hidePackQty
				+ ", hideLooseQty=" + hideLooseQty + ", itemUniqueKey="
				+ itemUniqueKey + ", specialDiscPer=" + specialDiscPer
				+ ", specialDiscAmount=" + specialDiscAmount + ", taxId="
				+ taxId + ", taxName=" + taxName + ", taxPercentage="
				+ taxPercentage + ", itemTaxAmount=" + itemTaxAmount
				+ ", isGroupTax=" + isGroupTax + ", taxMode=" + taxMode
				+ ", sku=" + sku + ", hsnCode=" + hsnCode + "]";
	}


}