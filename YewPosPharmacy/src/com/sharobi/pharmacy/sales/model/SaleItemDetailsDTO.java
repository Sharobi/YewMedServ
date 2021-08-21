package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SaleItemDetailsDTO implements Serializable {
	
	@Expose
	@MapToData(columnAliases = { "sale_id" })
	private int saleId;
	
	@Expose
	@MapToData(columnAliases = { "sale_details_id" })
	private int saleDetailsId;
	
	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;

	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;
	
	
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
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;

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
	@MapToData(columnAliases = { "loose_qty" })
	private int looseQty;

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
	@MapToData(columnAliases = { "mrp_per_unit" })
	private double mrpPerUnit;

	@Expose
	@MapToData(columnAliases = { "rate_per_unit" })
	private double ratePerUnit;
	
	@Expose
	@MapToData(columnAliases = { "amount" })
	private double amount;

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
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;
	
	@Expose
	@MapToData(columnAliases = { "tax_percentage" })
	private double taxPercentage;
	
	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;
	
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
	
	@Expose
	@MapToData(columnAliases = { "discount" })
	private double discount;
	
	@Expose
	@MapToData(columnAliases = { "is_discount" })
	private int isDiscount;
	
	@Expose
	@MapToData(columnAliases = { "max_discount_limit" })
	private double maxDiscountLimit;
	
	@Expose
	@MapToData(columnAliases = { "purchase_cost_per_unit" })
	private double purchaseCostPerUnit;
	
	@Expose
	@MapToData(columnAliases = { "item_total_mrp" })
	private double itemTotalMrp;
	
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
	
	private static final long serialVersionUID = 1L;

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getSaleDetailsId() {
		return saleDetailsId;
	}

	public void setSaleDetailsId(int saleDetailsId) {
		this.saleDetailsId = saleDetailsId;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
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

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
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

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(int isDiscount) {
		this.isDiscount = isDiscount;
	}

	public double getMaxDiscountLimit() {
		return maxDiscountLimit;
	}

	public void setMaxDiscountLimit(double maxDiscountLimit) {
		this.maxDiscountLimit = maxDiscountLimit;
	}

	public double getPurchaseCostPerUnit() {
		return purchaseCostPerUnit;
	}

	public void setPurchaseCostPerUnit(double purchaseCostPerUnit) {
		this.purchaseCostPerUnit = purchaseCostPerUnit;
	}

	public double getItemTotalMrp() {
		return itemTotalMrp;
	}

	public void setItemTotalMrp(double itemTotalMrp) {
		this.itemTotalMrp = itemTotalMrp;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + conversion;
		result = prime * result
				+ ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + customerId;
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result
				+ ((customerPhone == null) ? 0 : customerPhone.hashCode());
		temp = Double.doubleToLongBits(disc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + doctorId;
		result = prime * result
				+ ((doctorName == null) ? 0 : doctorName.hashCode());
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		result = prime * result + ((hsnCode == null) ? 0 : hsnCode.hashCode());
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isDiscount;
		result = prime * result + isGroupTax;
		result = prime * result + itemId;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		temp = Double.doubleToLongBits(itemTotalMrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((itemUniqueKey == null) ? 0 : itemUniqueKey.hashCode());
		result = prime * result + looseQty;
		temp = Double.doubleToLongBits(maxDiscountLimit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mrpPerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + packQty;
		result = prime * result + packUnitId;
		result = prime * result
				+ ((packUnitName == null) ? 0 : packUnitName.hashCode());
		temp = Double.doubleToLongBits(purchaseCostPerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ratePerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saleDetailsId;
		result = prime * result + saleId;
		temp = Double.doubleToLongBits(saleRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + taxId;
		result = prime * result + ((taxMode == null) ? 0 : taxMode.hashCode());
		temp = Double.doubleToLongBits(taxPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totAmount);
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
		SaleItemDetailsDTO other = (SaleItemDetailsDTO) obj;
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
		if (Double.doubleToLongBits(discPer) != Double
				.doubleToLongBits(other.discPer))
			return false;
		if (Double.doubleToLongBits(discount) != Double
				.doubleToLongBits(other.discount))
			return false;
		if (doctorId != other.doctorId)
			return false;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
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
		if (hsnCode == null) {
			if (other.hsnCode != null)
				return false;
		} else if (!hsnCode.equals(other.hsnCode))
			return false;
		if (invDate == null) {
			if (other.invDate != null)
				return false;
		} else if (!invDate.equals(other.invDate))
			return false;
		if (invNo == null) {
			if (other.invNo != null)
				return false;
		} else if (!invNo.equals(other.invNo))
			return false;
		if (isDiscount != other.isDiscount)
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
		if (Double.doubleToLongBits(maxDiscountLimit) != Double
				.doubleToLongBits(other.maxDiscountLimit))
			return false;
		if (Double.doubleToLongBits(mrp) != Double.doubleToLongBits(other.mrp))
			return false;
		if (Double.doubleToLongBits(mrpPerUnit) != Double
				.doubleToLongBits(other.mrpPerUnit))
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
		if (Double.doubleToLongBits(purchaseCostPerUnit) != Double
				.doubleToLongBits(other.purchaseCostPerUnit))
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (Double.doubleToLongBits(ratePerUnit) != Double
				.doubleToLongBits(other.ratePerUnit))
			return false;
		if (saleDetailsId != other.saleDetailsId)
			return false;
		if (saleId != other.saleId)
			return false;
		if (Double.doubleToLongBits(saleRate) != Double
				.doubleToLongBits(other.saleRate))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
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
		if (Double.doubleToLongBits(taxPercentage) != Double
				.doubleToLongBits(other.taxPercentage))
			return false;
		if (Double.doubleToLongBits(totAmount) != Double
				.doubleToLongBits(other.totAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SaleItemDetailsDTO [saleId=" + saleId + ", saleDetailsId="
				+ saleDetailsId + ", invNo=" + invNo + ", invDate=" + invDate
				+ ", itemId=" + itemId + ", itemName=" + itemName
				+ ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", expiryDateFormat=" + expiryDateFormat + ", itemUniqueKey="
				+ itemUniqueKey + ", packUnitId=" + packUnitId
				+ ", packUnitName=" + packUnitName + ", packQty=" + packQty
				+ ", conversion=" + conversion + ", looseQty=" + looseQty
				+ ", mrp=" + mrp + ", rate=" + rate + ", saleRate=" + saleRate
				+ ", mrpPerUnit=" + mrpPerUnit + ", ratePerUnit=" + ratePerUnit
				+ ", amount=" + amount + ", discPer=" + discPer + ", disc="
				+ disc + ", totAmount=" + totAmount + ", taxId=" + taxId
				+ ", taxPercentage=" + taxPercentage + ", taxAmount="
				+ taxAmount + ", isGroupTax=" + isGroupTax + ", taxMode="
				+ taxMode + ", sku=" + sku + ", hsnCode=" + hsnCode
				+ ", discount=" + discount + ", isDiscount=" + isDiscount
				+ ", maxDiscountLimit=" + maxDiscountLimit
				+ ", purchaseCostPerUnit=" + purchaseCostPerUnit
				+ ", itemTotalMrp=" + itemTotalMrp + ", customerId="
				+ customerId + ", customerName=" + customerName
				+ ", customerPhone=" + customerPhone + ", customerAddress="
				+ customerAddress + ", doctorId=" + doctorId + ", doctorName="
				+ doctorName + "]";
	}
	
	

}