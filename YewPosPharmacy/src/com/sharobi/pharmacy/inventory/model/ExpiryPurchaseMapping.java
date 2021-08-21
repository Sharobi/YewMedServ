package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: pur_t_expiry_mapping
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pur_t_expiry_mapping")
public class ExpiryPurchaseMapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "purchase_id")
	private int purchaseId;

	@Expose
	@Column(name = "purchase_inv_no")
	private int purchaseInvNo;

	@Expose
	@Column(name = "purchase_inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseInvDate;

	@Expose
	@Column(name = "expiry_id")
	private int expiryId;

	@Expose
	@Column(name = "expiry_details_id")
	private int expiryDetailsId;

	@Expose
	@Column(name = "expiry_inv_no")
	private String expiryInvNo;

	@Expose
	@Column(name = "expiry_inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryInvDate;

	@Expose
	@Column(name = "item_id")
	private int itemId;

	@Expose
	@Column(name = "batch_no")
	private String batchNo;

	@Expose
	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

	@Expose
	@Column(name = "pack_qty")
	private int packQty;

	@Expose
	@Column(name = "conversion")
	private int conversion;

	@Expose
	@Column(name = "loose_qty")
	private int looseQty;

	@Expose
	@Column(name = "free_qty")
	private double freeQty;

	@Expose
	@Column(name = "mrp")
	private double mrp;

	@Expose
	@Column(name = "rate")
	private double rate;

	@Expose
	@Column(name = "is_mrp")
	private int isMrp;

	@Expose
	@Column(name = "net_amount")
	private double netAmount;

	@Expose
	@Column(name = "adj_amount")
	private double adjAmount;

	@Expose
	@Transient
	private String lang;
	
	@Expose
	@Transient
	private String expiryDateFormat;
	
	

	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}

	@XmlElement
	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	@XmlElement
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getPurchaseInvNo() {
		return purchaseInvNo;
	}

	@XmlElement
	public void setPurchaseInvNo(int purchaseInvNo) {
		this.purchaseInvNo = purchaseInvNo;
	}

	public Date getPurchaseInvDate() {
		return purchaseInvDate;
	}

	@XmlElement
	public void setPurchaseInvDate(Date purchaseInvDate) {
		this.purchaseInvDate = purchaseInvDate;
	}

	public int getExpiryId() {
		return expiryId;
	}

	@XmlElement
	public void setExpiryId(int expiryId) {
		this.expiryId = expiryId;
	}

	public int getExpiryDetailsId() {
		return expiryDetailsId;
	}

	@XmlElement
	public void setExpiryDetailsId(int expiryDetailsId) {
		this.expiryDetailsId = expiryDetailsId;
	}

	public String getExpiryInvNo() {
		return expiryInvNo;
	}

	@XmlElement
	public void setExpiryInvNo(String expiryInvNo) {
		this.expiryInvNo = expiryInvNo;
	}

	public Date getExpiryInvDate() {
		return expiryInvDate;
	}

	@XmlElement
	public void setExpiryInvDate(Date expiryInvDate) {
		this.expiryInvDate = expiryInvDate;
	}

	public int getItemId() {
		return itemId;
	}

	@XmlElement
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	@XmlElement
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	@XmlElement
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getPackQty() {
		return packQty;
	}

	@XmlElement
	public void setPackQty(int packQty) {
		this.packQty = packQty;
	}

	public int getConversion() {
		return conversion;
	}

	@XmlElement
	public void setConversion(int conversion) {
		this.conversion = conversion;
	}

	public int getLooseQty() {
		return looseQty;
	}

	@XmlElement
	public void setLooseQty(int looseQty) {
		this.looseQty = looseQty;
	}

	public double getFreeQty() {
		return freeQty;
	}

	@XmlElement
	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}

	public double getMrp() {
		return mrp;
	}

	@XmlElement
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getRate() {
		return rate;
	}

	@XmlElement
	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getIsMrp() {
		return isMrp;
	}

	@XmlElement
	public void setIsMrp(int isMrp) {
		this.isMrp = isMrp;
	}

	public double getNetAmount() {
		return netAmount;
	}

	@XmlElement
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getAdjAmount() {
		return adjAmount;
	}

	@XmlElement
	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}

	public String getLang() {
		return lang;
	}

	@XmlElement
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
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + conversion;
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		result = prime * result + expiryDetailsId;
		result = prime * result + expiryId;
		result = prime * result
				+ ((expiryInvDate == null) ? 0 : expiryInvDate.hashCode());
		result = prime * result
				+ ((expiryInvNo == null) ? 0 : expiryInvNo.hashCode());
		temp = Double.doubleToLongBits(freeQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + isMrp;
		result = prime * result + itemId;
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime * result + looseQty;
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + packQty;
		result = prime * result + purchaseId;
		result = prime * result
				+ ((purchaseInvDate == null) ? 0 : purchaseInvDate.hashCode());
		result = prime * result + purchaseInvNo;
		temp = Double.doubleToLongBits(rate);
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
		ExpiryPurchaseMapping other = (ExpiryPurchaseMapping) obj;
		if (Double.doubleToLongBits(adjAmount) != Double
				.doubleToLongBits(other.adjAmount))
			return false;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (conversion != other.conversion)
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
		if (expiryInvDate == null) {
			if (other.expiryInvDate != null)
				return false;
		} else if (!expiryInvDate.equals(other.expiryInvDate))
			return false;
		if (expiryInvNo == null) {
			if (other.expiryInvNo != null)
				return false;
		} else if (!expiryInvNo.equals(other.expiryInvNo))
			return false;
		if (Double.doubleToLongBits(freeQty) != Double
				.doubleToLongBits(other.freeQty))
			return false;
		if (id != other.id)
			return false;
		if (isMrp != other.isMrp)
			return false;
		if (itemId != other.itemId)
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
		if (packQty != other.packQty)
			return false;
		if (purchaseId != other.purchaseId)
			return false;
		if (purchaseInvDate == null) {
			if (other.purchaseInvDate != null)
				return false;
		} else if (!purchaseInvDate.equals(other.purchaseInvDate))
			return false;
		if (purchaseInvNo != other.purchaseInvNo)
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExpiryPurchaseMapping [id=" + id + ", purchaseId=" + purchaseId
				+ ", purchaseInvNo=" + purchaseInvNo + ", purchaseInvDate="
				+ purchaseInvDate + ", expiryId=" + expiryId
				+ ", expiryDetailsId=" + expiryDetailsId + ", expiryInvNo="
				+ expiryInvNo + ", expiryInvDate=" + expiryInvDate
				+ ", itemId=" + itemId + ", batchNo=" + batchNo
				+ ", expiryDate=" + expiryDate + ", packQty=" + packQty
				+ ", conversion=" + conversion + ", looseQty=" + looseQty
				+ ", freeQty=" + freeQty + ", mrp=" + mrp + ", rate=" + rate
				+ ", isMrp=" + isMrp + ", netAmount=" + netAmount
				+ ", adjAmount=" + adjAmount + ", lang=" + lang
				+ ", expiryDateFormat=" + expiryDateFormat + "]";
	}
	
	
}
