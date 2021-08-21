package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ExpiryDetailsDTO implements Serializable {
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
	@MapToData(columnAliases = { "loose_qty" })
	private int looseQty;
	
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
	@MapToData(columnAliases = { "distributor_id" })
	private int distributorId;
	
	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String distributorName;
	
	@Expose
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;
	
	@Expose
	@Transient
	private String lang;
	
	@Expose
	@MapToData(columnAliases = { "net_content" })
	private String netContent;
	
	@Expose
	@MapToData(columnAliases = { "calculate_loose_qty" })
	private int calculateLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "stock_qty" })
	private String stockQty;
	
	@Expose
	@MapToData(columnAliases = { "rack_name" })
	private String rackName;
	
	@Expose
	@MapToData(columnAliases = { "rack_id" })
	private int rackId;
	
	@Expose
	@MapToData(columnAliases = { "expiry_id" })
	private int expiryId;
	
	@Expose
	@MapToData(columnAliases = { "expiry_details_id" })
	private int expiryDetailsId;
	
	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;
	
	@Expose
	@MapToData(columnAliases = {"inv_date"})
	private Date invDate;
	
	@Expose
	@MapToData(columnAliases = { "is_mrp" })
	private int isMrp;
	
	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "adj_amount" })
	private double adjAmount;
	
	private static final long serialVersionUID = 1L;
	
	
	public int getExpiryId() {
		return expiryId;
	}


	public void setExpiryId(int expiryId) {
		this.expiryId = expiryId;
	}


	public int getExpiryDetailsId() {
		return expiryDetailsId;
	}


	public void setExpiryDetailsId(int expiryDetailsId) {
		this.expiryDetailsId = expiryDetailsId;
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


	public int getIsMrp() {
		return isMrp;
	}


	public void setIsMrp(int isMrp) {
		this.isMrp = isMrp;
	}


	public double getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}


	public double getAdjAmount() {
		return adjAmount;
	}


	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}


	public String getNetContent() {
		return netContent;
	}


	public void setNetContent(String netContent) {
		this.netContent = netContent;
	}


	public int getCalculateLooseQty() {
		return calculateLooseQty;
	}


	public void setCalculateLooseQty(int calculateLooseQty) {
		this.calculateLooseQty = calculateLooseQty;
	}


	public String getStockQty() {
		return stockQty;
	}


	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}


	public String getRackName() {
		return rackName;
	}


	public void setRackName(String rackName) {
		this.rackName = rackName;
	}


	public int getRackId() {
		return rackId;
	}


	public void setRackId(int rackId) {
		this.rackId = rackId;
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


	public double getFreeQty() {
		return freeQty;
	}


	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
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


	public String getItemUniqueKey() {
		return itemUniqueKey;
	}


	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}


	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
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
		result = prime * result + conversion;
		result = prime * result + distributorId;
		result = prime * result
				+ ((distributorName == null) ? 0 : distributorName.hashCode());
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		result = prime * result + expiryDetailsId;
		result = prime * result + expiryId;
		temp = Double.doubleToLongBits(freeQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isMrp;
		result = prime * result + itemId;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((itemUniqueKey == null) ? 0 : itemUniqueKey.hashCode());
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime * result + looseQty;
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((netContent == null) ? 0 : netContent.hashCode());
		result = prime * result + packQty;
		result = prime * result + packUnitId;
		result = prime * result
				+ ((packUnitName == null) ? 0 : packUnitName.hashCode());
		result = prime * result + rackId;
		result = prime * result
				+ ((rackName == null) ? 0 : rackName.hashCode());
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((stockQty == null) ? 0 : stockQty.hashCode());
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
		ExpiryDetailsDTO other = (ExpiryDetailsDTO) obj;
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
		if (conversion != other.conversion)
			return false;
		if (distributorId != other.distributorId)
			return false;
		if (distributorName == null) {
			if (other.distributorName != null)
				return false;
		} else if (!distributorName.equals(other.distributorName))
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
		if (expiryDetailsId != other.expiryDetailsId)
			return false;
		if (expiryId != other.expiryId)
			return false;
		if (Double.doubleToLongBits(freeQty) != Double
				.doubleToLongBits(other.freeQty))
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
		if (isMrp != other.isMrp)
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
		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		if (looseQty != other.looseQty)
			return false;
		if (Double.doubleToLongBits(mrp) != Double.doubleToLongBits(other.mrp))
			return false;
		if (Double.doubleToLongBits(netAmount) != Double
				.doubleToLongBits(other.netAmount))
			return false;
		if (netContent == null) {
			if (other.netContent != null)
				return false;
		} else if (!netContent.equals(other.netContent))
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
		if (rackId != other.rackId)
			return false;
		if (rackName == null) {
			if (other.rackName != null)
				return false;
		} else if (!rackName.equals(other.rackName))
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (stockQty == null) {
			if (other.stockQty != null)
				return false;
		} else if (!stockQty.equals(other.stockQty))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ExpiryDetailsDTO [itemId=" + itemId + ", itemName=" + itemName
				+ ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", expiryDateFormat=" + expiryDateFormat + ", packUnitId="
				+ packUnitId + ", packUnitName=" + packUnitName + ", packQty="
				+ packQty + ", conversion=" + conversion + ", looseQty="
				+ looseQty + ", freeQty=" + freeQty + ", mrp=" + mrp
				+ ", rate=" + rate + ", amount=" + amount + ", distributorId="
				+ distributorId + ", distributorName=" + distributorName
				+ ", itemUniqueKey=" + itemUniqueKey + ", lang=" + lang
				+ ", netContent=" + netContent + ", calculateLooseQty="
				+ calculateLooseQty + ", stockQty=" + stockQty + ", rackName="
				+ rackName + ", rackId=" + rackId + ", expiryId=" + expiryId
				+ ", expiryDetailsId=" + expiryDetailsId + ", invNo=" + invNo
				+ ", invDate=" + invDate + ", isMrp=" + isMrp + ", netAmount="
				+ netAmount + ", adjAmount=" + adjAmount + "]";
	}
	
	
	
}