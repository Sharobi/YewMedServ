package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;


@XmlRootElement
public class PurchaseOrderDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;
	
	@Expose
	@MapToData(columnAliases = { "item_name" })
	private String itemName;
	
	@Expose
	@MapToData(columnAliases = { "pack_unit_id" })
	private int packUnitId;
	
	@Expose
	@MapToData(columnAliases = { "pack_qty" })
	private int packQty;
	
	@Expose
	@MapToData(columnAliases = { "conversion" })
	private int conversion;
	
	@Expose
	@MapToData(columnAliases = { "loose_qty" })
	private int looseQty;
	
	@Expose
	@MapToData(columnAliases = { "free_qty" })
	private double freeQty;
	
	@Expose
	@MapToData(columnAliases = { "rec_pack_qty" })
	private int recPackQty;
	
	@Expose
	@MapToData(columnAliases = { "rec_loose_qty" })
	private int recLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "mrp" })
	private double mrp;
	
	@Expose
	@MapToData(columnAliases = { "rate" })
	private double rate;
	
	@Expose
	@MapToData(columnAliases = { "sale_rate" })
	private double saleRate;

	@Expose
	@MapToData(columnAliases = { "gross_amount" })
	private double grossAmount;
	
	@Expose
	@MapToData(columnAliases = { "disc_per" })
	private double discPer;

	@Expose
	@MapToData(columnAliases = { "disc" })
	private double disc;
	
	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "tmp_id" })
	private int	tmpId;
	
	@Expose
	@MapToData(columnAliases = { "group_id" })
	private int	groupId;
	
	@Expose
	@MapToData(columnAliases = { "group_name" })
	private String	groupName;
	
	@Expose
	@MapToData(columnAliases = { "schedule_id" })
	private int	scheduleId;
	
	@Expose
	@MapToData(columnAliases = { "schedule_name" })
	private String	scheduleName;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_id" })
	private int	manufacturerId;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_name" })
	private String	manufacturerName;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_code" })
	private String	manufacturerCode;
	
	@Expose
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;
	
	@Expose
	@MapToData(columnAliases = { "tax_name" })
	private String	taxName;
	
	@Expose
	@MapToData(columnAliases = { "tax_percentage" })
	private double taxPercentage;
	
	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;
	
	@Expose
	@MapToData(columnAliases = { "tax_mode" })
	private String taxMode;
	
	@Expose
	@MapToData(columnAliases = { "is_group_tax" })
	private int isGroupTax;
	
	@Expose
	@MapToData(columnAliases = { "SKU" })
	private String sku;
	
	@Expose
	@MapToData(columnAliases = { "HSN_code" })
	private String hsnCode;
	
	@Expose
	@MapToData(columnAliases = { "inv_type" })
	private String invType;
	
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;
	
	@Expose
	@MapToData(columnAliases = { "purchase_order_id" })
	private int purchaseOrderId;
	
	@Expose
	@MapToData(columnAliases = { "item_total_mrp" })
	private double itemTotalMrp;
	
	@Expose
	@MapToData(columnAliases = { "distributor_id" })
	private int distributorId;
	
	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String distributorName;
	
	@Expose
	@MapToData(columnAliases = { "order_pack_qty" })
	private int orderPackQty;
	
	@Expose
	@MapToData(columnAliases = { "order_loose_qty" })
	private int orderLooseQty;
	
	///////////
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
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;
	
	@Expose
	@MapToData(columnAliases = { "pack_unit_name" })
	private String packUnitName;
	
	@Expose
	@MapToData(columnAliases = { "pending_pack_qty" })
	private int pendingPackQty;
	
	@Expose
	@MapToData(columnAliases = { "pending_rec_loose_qty" })
	private int pendingRecLooseQty;
	
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
	@MapToData(columnAliases = { "item_lot_adj_amount" })
	private double itemLotAdjAmount;
	
	@Expose
	@MapToData(columnAliases = { "tot_amount" })
	private double totAmount;
	
	@Expose
	@MapToData(columnAliases = { "taxable_rate" })
	private double taxableRate;
	
	@Expose
	@MapToData(columnAliases = { "is_tax_on_mrp" })
	private int isTaxOnMrp;
	
	@Expose
	@MapToData(columnAliases = { "purchase_net_amount" })
	private double purchaseNetAmount;
	
	
	
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

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}

	public String getPackUnitName() {
		return packUnitName;
	}

	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}

	public int getPendingPackQty() {
		return pendingPackQty;
	}

	public void setPendingPackQty(int pendingPackQty) {
		this.pendingPackQty = pendingPackQty;
	}

	

	public int getPendingRecLooseQty() {
		return pendingRecLooseQty;
	}

	public void setPendingRecLooseQty(int pendingRecLooseQty) {
		this.pendingRecLooseQty = pendingRecLooseQty;
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

	public double getItemLotAdjAmount() {
		return itemLotAdjAmount;
	}

	public void setItemLotAdjAmount(double itemLotAdjAmount) {
		this.itemLotAdjAmount = itemLotAdjAmount;
	}

	public double getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(double totAmount) {
		this.totAmount = totAmount;
	}

	public double getTaxableRate() {
		return taxableRate;
	}

	public void setTaxableRate(double taxableRate) {
		this.taxableRate = taxableRate;
	}

	public int getIsTaxOnMrp() {
		return isTaxOnMrp;
	}

	public void setIsTaxOnMrp(int isTaxOnMrp) {
		this.isTaxOnMrp = isTaxOnMrp;
	}

	public double getPurchaseNetAmount() {
		return purchaseNetAmount;
	}

	public void setPurchaseNetAmount(double purchaseNetAmount) {
		this.purchaseNetAmount = purchaseNetAmount;
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

	public int getOrderPackQty() {
		return orderPackQty;
	}

	public void setOrderPackQty(int orderPackQty) {
		this.orderPackQty = orderPackQty;
	}

	public int getOrderLooseQty() {
		return orderLooseQty;
	}

	public void setOrderLooseQty(int orderLooseQty) {
		this.orderLooseQty = orderLooseQty;
	}

	public double getItemTotalMrp() {
		return itemTotalMrp;
	}

	public void setItemTotalMrp(double itemTotalMrp) {
		this.itemTotalMrp = itemTotalMrp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
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

	public int getPackUnitId() {
		return packUnitId;
	}

	public void setPackUnitId(int packUnitId) {
		this.packUnitId = packUnitId;
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

	public double getFreeQty() {
		return freeQty;
	}

	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}

	public int getRecPackQty() {
		return recPackQty;
	}

	public void setRecPackQty(int recPackQty) {
		this.recPackQty = recPackQty;
	}

	public int getRecLooseQty() {
		return recLooseQty;
	}

	public void setRecLooseQty(int recLooseQty) {
		this.recLooseQty = recLooseQty;
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

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
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

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public int getTmpId() {
		return tmpId;
	}

	public void setTmpId(int tmpId) {
		this.tmpId = tmpId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

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

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTaxMode() {
		return taxMode;
	}

	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public int getIsGroupTax() {
		return isGroupTax;
	}

	public void setIsGroupTax(int isGroupTax) {
		this.isGroupTax = isGroupTax;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + conversion;
		temp = Double.doubleToLongBits(disc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + distributorId;
		result = prime * result
				+ ((distributorName == null) ? 0 : distributorName.hashCode());
		temp = Double.doubleToLongBits(ed);
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
		result = prime * result + groupId;
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((hsnCode == null) ? 0 : hsnCode.hashCode());
		result = prime * result + id;
		result = prime * result + ((invType == null) ? 0 : invType.hashCode());
		result = prime * result + isGroupTax;
		result = prime * result + isTaxOnMrp;
		result = prime * result + itemId;
		temp = Double.doubleToLongBits(itemLotAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		temp = Double.doubleToLongBits(itemTotalMrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((itemUniqueKey == null) ? 0 : itemUniqueKey.hashCode());
		result = prime * result + looseQty;
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
		result = prime * result + orderLooseQty;
		result = prime * result + orderPackQty;
		result = prime * result + packQty;
		result = prime * result + packUnitId;
		result = prime * result
				+ ((packUnitName == null) ? 0 : packUnitName.hashCode());
		result = prime * result + pendingPackQty;
		result = prime * result + pendingRecLooseQty;
		temp = Double.doubleToLongBits(purchaseNetAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + purchaseOrderId;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + recLooseQty;
		result = prime * result + recPackQty;
		temp = Double.doubleToLongBits(saleRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + scheduleId;
		result = prime * result
				+ ((scheduleName == null) ? 0 : scheduleName.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
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
		temp = Double.doubleToLongBits(taxableRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + tmpId;
		temp = Double.doubleToLongBits(totAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vat);
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
		PurchaseOrderDetailsDTO other = (PurchaseOrderDetailsDTO) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (conversion != other.conversion)
			return false;
		if (Double.doubleToLongBits(disc) != Double
				.doubleToLongBits(other.disc))
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
		if (groupId != other.groupId)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (hsnCode == null) {
			if (other.hsnCode != null)
				return false;
		} else if (!hsnCode.equals(other.hsnCode))
			return false;
		if (id != other.id)
			return false;
		if (invType == null) {
			if (other.invType != null)
				return false;
		} else if (!invType.equals(other.invType))
			return false;
		if (isGroupTax != other.isGroupTax)
			return false;
		if (isTaxOnMrp != other.isTaxOnMrp)
			return false;
		if (itemId != other.itemId)
			return false;
		if (Double.doubleToLongBits(itemLotAdjAmount) != Double
				.doubleToLongBits(other.itemLotAdjAmount))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(itemTotalMrp) != Double
				.doubleToLongBits(other.itemTotalMrp))
			return false;
		if (itemUniqueKey == null) {
			if (other.itemUniqueKey != null)
				return false;
		} else if (!itemUniqueKey.equals(other.itemUniqueKey))
			return false;
		if (looseQty != other.looseQty)
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
		if (orderLooseQty != other.orderLooseQty)
			return false;
		if (orderPackQty != other.orderPackQty)
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
		if (pendingPackQty != other.pendingPackQty)
			return false;
		if (pendingRecLooseQty != other.pendingRecLooseQty)
			return false;
		if (Double.doubleToLongBits(purchaseNetAmount) != Double
				.doubleToLongBits(other.purchaseNetAmount))
			return false;
		if (purchaseOrderId != other.purchaseOrderId)
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (recLooseQty != other.recLooseQty)
			return false;
		if (recPackQty != other.recPackQty)
			return false;
		if (Double.doubleToLongBits(saleRate) != Double
				.doubleToLongBits(other.saleRate))
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (scheduleName == null) {
			if (other.scheduleName != null)
				return false;
		} else if (!scheduleName.equals(other.scheduleName))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
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
		if (Double.doubleToLongBits(taxableRate) != Double
				.doubleToLongBits(other.taxableRate))
			return false;
		if (tmpId != other.tmpId)
			return false;
		if (Double.doubleToLongBits(totAmount) != Double
				.doubleToLongBits(other.totAmount))
			return false;
		if (Double.doubleToLongBits(vat) != Double.doubleToLongBits(other.vat))
			return false;
		if (Double.doubleToLongBits(vatPer) != Double
				.doubleToLongBits(other.vatPer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderDetailsDTO [itemId=" + itemId + ", itemName="
				+ itemName + ", packUnitId=" + packUnitId + ", packQty="
				+ packQty + ", conversion=" + conversion + ", looseQty="
				+ looseQty + ", freeQty=" + freeQty + ", recPackQty="
				+ recPackQty + ", recLooseQty=" + recLooseQty + ", mrp=" + mrp
				+ ", rate=" + rate + ", saleRate=" + saleRate
				+ ", grossAmount=" + grossAmount + ", discPer=" + discPer
				+ ", disc=" + disc + ", netAmount=" + netAmount + ", tmpId="
				+ tmpId + ", groupId=" + groupId + ", groupName=" + groupName
				+ ", scheduleId=" + scheduleId + ", scheduleName="
				+ scheduleName + ", manufacturerId=" + manufacturerId
				+ ", manufacturerName=" + manufacturerName
				+ ", manufacturerCode=" + manufacturerCode + ", taxId=" + taxId
				+ ", taxName=" + taxName + ", taxPercentage=" + taxPercentage
				+ ", taxAmount=" + taxAmount + ", taxMode=" + taxMode
				+ ", isGroupTax=" + isGroupTax + ", sku=" + sku + ", hsnCode="
				+ hsnCode + ", invType=" + invType + ", id=" + id
				+ ", purchaseOrderId=" + purchaseOrderId + ", itemTotalMrp="
				+ itemTotalMrp + ", distributorId=" + distributorId
				+ ", distributorName=" + distributorName + ", orderPackQty="
				+ orderPackQty + ", orderLooseQty=" + orderLooseQty
				+ ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", expiryDateFormat=" + expiryDateFormat + ", itemUniqueKey="
				+ itemUniqueKey + ", packUnitName=" + packUnitName
				+ ", pendingPackQty=" + pendingPackQty
				+ ", pendingRecLooseQty=" + pendingRecLooseQty + ", amount="
				+ amount + ", edPer=" + edPer + ", ed=" + ed + ", taxPer="
				+ taxPer + ", tax=" + tax + ", vatPer=" + vatPer + ", vat="
				+ vat + ", itemLotAdjAmount=" + itemLotAdjAmount
				+ ", totAmount=" + totAmount + ", taxableRate=" + taxableRate
				+ ", isTaxOnMrp=" + isTaxOnMrp + ", purchaseNetAmount="
				+ purchaseNetAmount + "]";
	}

	

}