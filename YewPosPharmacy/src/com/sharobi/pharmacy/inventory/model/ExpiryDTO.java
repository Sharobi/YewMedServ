package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ExpiryDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "expiry_id" })
	private int expiryId;

	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;
	
	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;
	
	@Expose
	@MapToData(columnAliases = { "from_date" })
	private Date fromDate;
	
	@Expose
	@MapToData(columnAliases = { "to_date" })
	private Date toDate;
	
	@Expose
	@MapToData(columnAliases = { "remarks" })
	private String remarks;

	@Expose
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;
	
	@Expose
	@Transient
	private String lang;


	private static final long serialVersionUID = 1L;
	
	


	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}


	public int getExpiryId() {
		return expiryId;
	}


	public void setExpiryId(int expiryId) {
		this.expiryId = expiryId;
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


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public int getIsPosted() {
		return isPosted;
	}


	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + expiryId;
		result = prime * result
				+ ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isPosted;
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
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
		ExpiryDTO other = (ExpiryDTO) obj;
		if (expiryId != other.expiryId)
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
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
		if (isPosted != other.isPosted)
			return false;
		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ExpiryAllDTO [expiryId=" + expiryId + ", invNo=" + invNo
				+ ", invDate=" + invDate + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", remarks=" + remarks + ", isPosted="
				+ isPosted + ", lang=" + lang + "]";
	}


	
}