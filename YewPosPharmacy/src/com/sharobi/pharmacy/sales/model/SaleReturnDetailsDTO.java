package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SaleReturnDetailsDTO implements Serializable {
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
	@MapToData(columnAliases = { "sale_id" })
	private int saleId;
	
	@Expose
	@MapToData(columnAliases = { "sale_inv_no" })
	private String saleInvNo;
	
	@Expose
	@MapToData(columnAliases = { "mrp_per_unit" })
	private double mrpPerUnit;

	@Expose
	@MapToData(columnAliases = { "rate_per_unit" })
	private double ratePerUnit;
	
	@Expose
	@MapToData(columnAliases = { "hide_pack_qty" })
	private int hidePackQty;
	
	@Expose
	@MapToData(columnAliases = { "hide_loose_qty" })
	private int hideLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_name" })
	private String manufacturerName;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_code" })
	private String manufacturerCode;
	
	@Expose
	@MapToData(columnAliases = { "content_name" })
	private String contentName;
	
	@Expose
	@MapToData(columnAliases = { "remaining_pack_qty" })
	private int remainingPackQty;
	
	@Expose
	@MapToData(columnAliases = { "remaining_loose_qty" })
	private int remainingLooseQty;
	
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
	@MapToData(columnAliases = { "reason_id" })
	private int reasonId;
	
	@Expose
	@MapToData(columnAliases = { "reason_type_name" })
	private String reasonTypeName;
	
	private static final long serialVersionUID = 1L;
	
	
	
	public int getReasonId() {
		return reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}

	public String getReasonTypeName() {
		return reasonTypeName;
	}

	public void setReasonTypeName(String reasonTypeName) {
		this.reasonTypeName = reasonTypeName;
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

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public int getRemainingPackQty() {
		return remainingPackQty;
	}

	public void setRemainingPackQty(int remainingPackQty) {
		this.remainingPackQty = remainingPackQty;
	}

	public int getRemainingLooseQty() {
		return remainingLooseQty;
	}

	public void setRemainingLooseQty(int remainingLooseQty) {
		this.remainingLooseQty = remainingLooseQty;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result
				+ ((contentName == null) ? 0 : contentName.hashCode());
		result = prime * result + conversion;
		temp = Double.doubleToLongBits(disc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(edPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		result = prime * result + hideLooseQty;
		result = prime * result + hidePackQty;
		result = prime * result + ((hsnCode == null) ? 0 : hsnCode.hashCode());
		result = prime * result + isGroupTax;
		result = prime * result + itemId;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
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
		result = prime * result + packQty;
		result = prime * result + packUnitId;
		result = prime * result
				+ ((packUnitName == null) ? 0 : packUnitName.hashCode());
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ratePerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reasonId;
		result = prime * result
				+ ((reasonTypeName == null) ? 0 : reasonTypeName.hashCode());
		result = prime * result + remainingLooseQty;
		result = prime * result + remainingPackQty;
		result = prime * result + saleId;
		result = prime * result
				+ ((saleInvNo == null) ? 0 : saleInvNo.hashCode());
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
		SaleReturnDetailsDTO other = (SaleReturnDetailsDTO) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (contentName == null) {
			if (other.contentName != null)
				return false;
		} else if (!contentName.equals(other.contentName))
			return false;
		if (conversion != other.conversion)
			return false;
		if (Double.doubleToLongBits(disc) != Double
				.doubleToLongBits(other.disc))
			return false;
		if (Double.doubleToLongBits(discPer) != Double
				.doubleToLongBits(other.discPer))
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
		if (packQty != other.packQty)
			return false;
		if (packUnitId != other.packUnitId)
			return false;
		if (packUnitName == null) {
			if (other.packUnitName != null)
				return false;
		} else if (!packUnitName.equals(other.packUnitName))
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (Double.doubleToLongBits(ratePerUnit) != Double
				.doubleToLongBits(other.ratePerUnit))
			return false;
		if (reasonId != other.reasonId)
			return false;
		if (reasonTypeName == null) {
			if (other.reasonTypeName != null)
				return false;
		} else if (!reasonTypeName.equals(other.reasonTypeName))
			return false;
		if (remainingLooseQty != other.remainingLooseQty)
			return false;
		if (remainingPackQty != other.remainingPackQty)
			return false;
		if (saleId != other.saleId)
			return false;
		if (saleInvNo == null) {
			if (other.saleInvNo != null)
				return false;
		} else if (!saleInvNo.equals(other.saleInvNo))
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
		if (Double.doubleToLongBits(vatPer) != Double
				.doubleToLongBits(other.vatPer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SaleReturnDetailsDTO [itemId=" + itemId + ", itemName="
				+ itemName + ", batchNo=" + batchNo + ", expiryDate="
				+ expiryDate + ", expiryDateFormat=" + expiryDateFormat
				+ ", packUnitId=" + packUnitId + ", packUnitName="
				+ packUnitName + ", packQty=" + packQty + ", conversion="
				+ conversion + ", looseUnitId=" + looseUnitId
				+ ", looseUnitName=" + looseUnitName + ", looseQty=" + looseQty
				+ ", mrp=" + mrp + ", rate=" + rate + ", amount=" + amount
				+ ", edPer=" + edPer + ", ed=" + ed + ", taxPer=" + taxPer
				+ ", tax=" + tax + ", vatPer=" + vatPer + ", vat=" + vat
				+ ", discPer=" + discPer + ", disc=" + disc + ", totAmount="
				+ totAmount + ", saleId=" + saleId + ", saleInvNo=" + saleInvNo
				+ ", mrpPerUnit=" + mrpPerUnit + ", ratePerUnit=" + ratePerUnit
				+ ", hidePackQty=" + hidePackQty + ", hideLooseQty="
				+ hideLooseQty + ", manufacturerName=" + manufacturerName
				+ ", manufacturerCode=" + manufacturerCode + ", contentName="
				+ contentName + ", remainingPackQty=" + remainingPackQty
				+ ", remainingLooseQty=" + remainingLooseQty
				+ ", itemUniqueKey=" + itemUniqueKey + ", specialDiscPer="
				+ specialDiscPer + ", specialDiscAmount=" + specialDiscAmount
				+ ", taxId=" + taxId + ", taxName=" + taxName
				+ ", taxPercentage=" + taxPercentage + ", taxAmount="
				+ taxAmount + ", isGroupTax=" + isGroupTax + ", taxMode="
				+ taxMode + ", sku=" + sku + ", hsnCode=" + hsnCode
				+ ", reasonId=" + reasonId + ", reasonTypeName="
				+ reasonTypeName + "]";
	}


	
}