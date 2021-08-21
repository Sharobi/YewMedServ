package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class PurchaseDetailsForReturnDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "purchase_id" })
	private int purchaseId;
	
	@Expose
	@MapToData(columnAliases = { "purchase_inv_no" })
	private String purchaseInvNo;
	
	@Expose
	@MapToData(columnAliases = { "purchase_inv_date" })
	private Date purchaseInvDate;
	
	
	@Expose
	@MapToData(columnAliases = { "purchase_inv_mode_name" })
	private String purchaseInvModeName;

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
	@MapToData(columnAliases = { "cst" })
	private double cst;
	
	@Expose
	@MapToData(columnAliases = { "vat_diff" })
	private double vatDiff;

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
	@MapToData(columnAliases = { "lot_adj_amount" })
	private double lotAdjAmount;
	
	@Expose
	@MapToData(columnAliases = { "spec_disc_per" })
	private double specDiscPer;
	
	@Expose
	@MapToData(columnAliases = { "spec_disc_amount" })
	private double specDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "roundoff" })
	private double roundOff;
	
	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "total_mrp"})
	private double totalMrp;
	
	@Expose
	@MapToData(columnAliases = { "distributor_id"})
	private int distributorId;
	
	@Expose
	@MapToData(columnAliases = { "distributor_name"})
	private String distributorName;
	
	
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
	@MapToData(columnAliases = { "free_qty" })
	private double freeQty;
	

	@Expose
	@MapToData(columnAliases = { "mrp" })
	private double mrp;

	@Expose
	@MapToData(columnAliases = { "rate" })
	private double rate;
	
	@Expose
	@MapToData(columnAliases = { "amount" })
	private double amount;
	
	@Expose
	@MapToData(columnAliases = { "loose_qty" })
	private int looseQty;
	
	
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
	@MapToData(columnAliases = { "bill_no" })
	private String billNo;
	
	@Expose
	@MapToData(columnAliases = { "group_id" })
	private int grpId;
	
	@Expose
	@MapToData(columnAliases = { "group_name" })
	private String grpName;
	
	@Expose
	@MapToData(columnAliases = { "schedule_id" })
	private int scheduleId;
	
	@Expose
	@MapToData(columnAliases = { "schedule_name" })
	private String scheduleName;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_id" })
	private int manufacturerId;
	
	@Expose
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;
	
	@Expose
	@MapToData(columnAliases = { "stock_qty" })
	private String stockQty;
	
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


	public String getStockQty() {
		return stockQty;
	}


	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}


	public String getItemUniqueKey() {
		return itemUniqueKey;
	}


	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}


	public int getGrpId() {
		return grpId;
	}


	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}


	public String getGrpName() {
		return grpName;
	}


	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}


	public int getScheduleId() {
		return scheduleId;
	}


	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}


	public String getScheduleName() {
		return scheduleName;
	}


	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}


	public int getManufacturerId() {
		return manufacturerId;
	}


	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
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


	public int getPurchaseId() {
		return purchaseId;
	}


	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}


	public String getPurchaseInvNo() {
		return purchaseInvNo;
	}


	public void setPurchaseInvNo(String purchaseInvNo) {
		this.purchaseInvNo = purchaseInvNo;
	}


	public Date getPurchaseInvDate() {
		return purchaseInvDate;
	}


	public void setPurchaseInvDate(Date purchaseInvDate) {
		this.purchaseInvDate = purchaseInvDate;
	}


	public String getPurchaseInvModeName() {
		return purchaseInvModeName;
	}


	public void setPurchaseInvModeName(String purchaseInvModeName) {
		this.purchaseInvModeName = purchaseInvModeName;
	}


	public double getCst() {
		return cst;
	}


	public void setCst(double cst) {
		this.cst = cst;
	}


	public double getVatDiff() {
		return vatDiff;
	}


	public void setVatDiff(double vatDiff) {
		this.vatDiff = vatDiff;
	}


	public double getLotAdjAmount() {
		return lotAdjAmount;
	}


	public void setLotAdjAmount(double lotAdjAmount) {
		this.lotAdjAmount = lotAdjAmount;
	}


	public double getSpecDiscPer() {
		return specDiscPer;
	}


	public void setSpecDiscPer(double specDiscPer) {
		this.specDiscPer = specDiscPer;
	}


	public double getSpecDiscAmount() {
		return specDiscAmount;
	}


	public void setSpecDiscAmount(double specDiscAmount) {
		this.specDiscAmount = specDiscAmount;
	}


	public double getTotalMrp() {
		return totalMrp;
	}


	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}


	public int getDistributorId() {
		return distributorId;
	}


	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}


	public String getDistributorName() {
		return distributorName;
	}


	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}


	public double getFreeQty() {
		return freeQty;
	}


	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}


	public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
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
		result = prime * result + ((billNo == null) ? 0 : billNo.hashCode());
		result = prime * result + calculateLooseQty;
		result = prime * result
				+ ((contentName == null) ? 0 : contentName.hashCode());
		result = prime * result + conversion;
		temp = Double.doubleToLongBits(cst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(disc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + distributorId;
		result = prime * result
				+ ((distributorName == null) ? 0 : distributorName.hashCode());
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
		temp = Double.doubleToLongBits(freeQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(grossAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + grpId;
		result = prime * result + ((grpName == null) ? 0 : grpName.hashCode());
		result = prime * result + hideLooseQty;
		result = prime * result + hidePackQty;
		result = prime * result + itemId;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((itemUniqueKey == null) ? 0 : itemUniqueKey.hashCode());
		result = prime * result + looseQty;
		temp = Double.doubleToLongBits(lotAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime
				* result
				+ ((manufacturerCode == null) ? 0 : manufacturerCode.hashCode());
		result = prime * result + manufacturerId;
		result = prime
				* result
				+ ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + packQty;
		result = prime * result + packUnitId;
		result = prime * result
				+ ((packUnitName == null) ? 0 : packUnitName.hashCode());
		result = prime * result + prevReturnLooseQty;
		result = prime * result + prevReturnPackQty;
		result = prime * result + purchaseId;
		result = prime * result
				+ ((purchaseInvDate == null) ? 0 : purchaseInvDate.hashCode());
		result = prime
				* result
				+ ((purchaseInvModeName == null) ? 0 : purchaseInvModeName
						.hashCode());
		result = prime * result
				+ ((purchaseInvNo == null) ? 0 : purchaseInvNo.hashCode());
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(roundOff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + scheduleId;
		result = prime * result
				+ ((scheduleName == null) ? 0 : scheduleName.hashCode());
		temp = Double.doubleToLongBits(specDiscAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(specDiscPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((stockQty == null) ? 0 : stockQty.hashCode());
		temp = Double.doubleToLongBits(tax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalMrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vatAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vatDiff);
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
		PurchaseDetailsForReturnDTO other = (PurchaseDetailsForReturnDTO) obj;
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
		if (billNo == null) {
			if (other.billNo != null)
				return false;
		} else if (!billNo.equals(other.billNo))
			return false;
		if (calculateLooseQty != other.calculateLooseQty)
			return false;
		if (contentName == null) {
			if (other.contentName != null)
				return false;
		} else if (!contentName.equals(other.contentName))
			return false;
		if (conversion != other.conversion)
			return false;
		if (Double.doubleToLongBits(cst) != Double.doubleToLongBits(other.cst))
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
		if (distributorId != other.distributorId)
			return false;
		if (distributorName == null) {
			if (other.distributorName != null)
				return false;
		} else if (!distributorName.equals(other.distributorName))
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
		if (Double.doubleToLongBits(freeQty) != Double
				.doubleToLongBits(other.freeQty))
			return false;
		if (Double.doubleToLongBits(grossAmount) != Double
				.doubleToLongBits(other.grossAmount))
			return false;
		if (grpId != other.grpId)
			return false;
		if (grpName == null) {
			if (other.grpName != null)
				return false;
		} else if (!grpName.equals(other.grpName))
			return false;
		if (hideLooseQty != other.hideLooseQty)
			return false;
		if (hidePackQty != other.hidePackQty)
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemUniqueKey == null) {
			if (other.itemUniqueKey != null)
				return false;
		} else if (!itemUniqueKey.equals(other.itemUniqueKey))
			return false;
		if (looseQty != other.looseQty)
			return false;
		if (Double.doubleToLongBits(lotAdjAmount) != Double
				.doubleToLongBits(other.lotAdjAmount))
			return false;
		if (manufacturerCode == null) {
			if (other.manufacturerCode != null)
				return false;
		} else if (!manufacturerCode.equals(other.manufacturerCode))
			return false;
		if (manufacturerId != other.manufacturerId)
			return false;
		if (manufacturerName == null) {
			if (other.manufacturerName != null)
				return false;
		} else if (!manufacturerName.equals(other.manufacturerName))
			return false;
		if (Double.doubleToLongBits(mrp) != Double.doubleToLongBits(other.mrp))
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
		if (purchaseId != other.purchaseId)
			return false;
		if (purchaseInvDate == null) {
			if (other.purchaseInvDate != null)
				return false;
		} else if (!purchaseInvDate.equals(other.purchaseInvDate))
			return false;
		if (purchaseInvModeName == null) {
			if (other.purchaseInvModeName != null)
				return false;
		} else if (!purchaseInvModeName.equals(other.purchaseInvModeName))
			return false;
		if (purchaseInvNo == null) {
			if (other.purchaseInvNo != null)
				return false;
		} else if (!purchaseInvNo.equals(other.purchaseInvNo))
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (Double.doubleToLongBits(roundOff) != Double
				.doubleToLongBits(other.roundOff))
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (scheduleName == null) {
			if (other.scheduleName != null)
				return false;
		} else if (!scheduleName.equals(other.scheduleName))
			return false;
		if (Double.doubleToLongBits(specDiscAmount) != Double
				.doubleToLongBits(other.specDiscAmount))
			return false;
		if (Double.doubleToLongBits(specDiscPer) != Double
				.doubleToLongBits(other.specDiscPer))
			return false;
		if (stockQty == null) {
			if (other.stockQty != null)
				return false;
		} else if (!stockQty.equals(other.stockQty))
			return false;
		if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double
				.doubleToLongBits(other.taxAmount))
			return false;
		if (Double.doubleToLongBits(taxPer) != Double
				.doubleToLongBits(other.taxPer))
			return false;
		if (Double.doubleToLongBits(totAmount) != Double
				.doubleToLongBits(other.totAmount))
			return false;
		if (Double.doubleToLongBits(totalMrp) != Double
				.doubleToLongBits(other.totalMrp))
			return false;
		if (Double.doubleToLongBits(vat) != Double.doubleToLongBits(other.vat))
			return false;
		if (Double.doubleToLongBits(vatAmount) != Double
				.doubleToLongBits(other.vatAmount))
			return false;
		if (Double.doubleToLongBits(vatDiff) != Double
				.doubleToLongBits(other.vatDiff))
			return false;
		if (Double.doubleToLongBits(vatPer) != Double
				.doubleToLongBits(other.vatPer))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PurchaseDetailsForReturnDTO [purchaseId=" + purchaseId
				+ ", purchaseInvNo=" + purchaseInvNo + ", purchaseInvDate="
				+ purchaseInvDate + ", purchaseInvModeName="
				+ purchaseInvModeName + ", grossAmount=" + grossAmount
				+ ", edAmount=" + edAmount + ", discAmount=" + discAmount
				+ ", cst=" + cst + ", vatDiff=" + vatDiff + ", vatAmount="
				+ vatAmount + ", taxAmount=" + taxAmount + ", adjAmount="
				+ adjAmount + ", lotAdjAmount=" + lotAdjAmount
				+ ", specDiscPer=" + specDiscPer + ", specDiscAmount="
				+ specDiscAmount + ", roundOff=" + roundOff + ", netAmount="
				+ netAmount + ", totalMrp=" + totalMrp + ", distributorId="
				+ distributorId + ", distributorName=" + distributorName
				+ ", itemId=" + itemId + ", itemName=" + itemName
				+ ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", expiryDateFormat=" + expiryDateFormat + ", packUnitId="
				+ packUnitId + ", packUnitName=" + packUnitName + ", packQty="
				+ packQty + ", conversion=" + conversion + ", freeQty="
				+ freeQty + ", mrp=" + mrp + ", rate=" + rate + ", amount="
				+ amount + ", looseQty=" + looseQty + ", edPer=" + edPer
				+ ", ed=" + ed + ", taxPer=" + taxPer + ", tax=" + tax
				+ ", vatPer=" + vatPer + ", vat=" + vat + ", discPer="
				+ discPer + ", disc=" + disc + ", totAmount=" + totAmount
				+ ", calculateLooseQty=" + calculateLooseQty
				+ ", prevReturnPackQty=" + prevReturnPackQty
				+ ", prevReturnLooseQty=" + prevReturnLooseQty
				+ ", manufacturerName=" + manufacturerName + ", contentName="
				+ contentName + ", manufacturerCode=" + manufacturerCode
				+ ", hidePackQty=" + hidePackQty + ", hideLooseQty="
				+ hideLooseQty + ", billNo=" + billNo + ", grpId=" + grpId
				+ ", grpName=" + grpName + ", scheduleId=" + scheduleId
				+ ", scheduleName=" + scheduleName + ", manufacturerId="
				+ manufacturerId + ", itemUniqueKey=" + itemUniqueKey
				+ ", stockQty=" + stockQty + "]";
	}
	
	
	
}

