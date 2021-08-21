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
 * Entity implementation class for Entity: exp_t_expiry_details
 * 
 */

@XmlRootElement
@Entity
@Table(name = "exp_t_expiry_details")
public class ExpiryDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "expiry_id")
	private int expiryId;

	@Expose
	@Column(name = "inv_no")
	private String invNo;
	
	@Expose
	@Column(name = "inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invDate;
	
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
	@Column(name = "pack_unit_id")
	private int packUnitId;
	
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
	@Column(name = "amount")
	private double amount;
	
	@Expose
	@Column(name = "distributor_id")
	private int distributorId;
	
	
	@Expose
	@Column(name = "finyr_id")
	private int finyrId;

	@Expose
	@Column(name = "company_id")
	private int companyId;
	

	@Expose
	@Column(name = "store_id")
	private int storeId;
	
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

	public int getExpiryId() {
		return expiryId;
	}

	@XmlElement
	public void setExpiryId(int expiryId) {
		this.expiryId = expiryId;
	}

	public String getInvNo() {
		return invNo;
	}

	@XmlElement
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public Date getInvDate() {
		return invDate;
	}

	@XmlElement
	public void setInvDate(Date invDate) {
		this.invDate = invDate;
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

	public int getPackUnitId() {
		return packUnitId;
	}

	@XmlElement
	public void setPackUnitId(int packUnitId) {
		this.packUnitId = packUnitId;
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

	public double getAmount() {
		return amount;
	}

	@XmlElement
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDistributorId() {
		return distributorId;
	}

	@XmlElement
	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public int getCompanyId() {
		return companyId;
	}

	@XmlElement
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStoreId() {
		return storeId;
	}

	@XmlElement
	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + companyId;
		result = prime * result + conversion;
		result = prime * result + distributorId;
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		result = prime * result + expiryId;
		result = prime * result + finyrId;
		temp = Double.doubleToLongBits(freeQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime * result + looseQty;
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + packQty;
		result = prime * result + packUnitId;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + storeId;
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
		ExpiryDetails other = (ExpiryDetails) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (companyId != other.companyId)
			return false;
		if (conversion != other.conversion)
			return false;
		if (distributorId != other.distributorId)
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
		if (expiryId != other.expiryId)
			return false;
		if (finyrId != other.finyrId)
			return false;
		if (Double.doubleToLongBits(freeQty) != Double
				.doubleToLongBits(other.freeQty))
			return false;
		if (id != other.id)
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
		if (packQty != other.packQty)
			return false;
		if (packUnitId != other.packUnitId)
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (storeId != other.storeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExpiryDetails [id=" + id + ", expiryId=" + expiryId
				+ ", invNo=" + invNo + ", invDate=" + invDate + ", itemId="
				+ itemId + ", batchNo=" + batchNo + ", expiryDate="
				+ expiryDate + ", packUnitId=" + packUnitId + ", packQty="
				+ packQty + ", conversion=" + conversion + ", looseQty="
				+ looseQty + ", freeQty=" + freeQty + ", mrp=" + mrp
				+ ", rate=" + rate + ", amount=" + amount + ", distributorId="
				+ distributorId + ", finyrId=" + finyrId + ", companyId="
				+ companyId + ", storeId=" + storeId + ", lang=" + lang
				+ ", expiryDateFormat=" + expiryDateFormat + "]";
	}

	


}