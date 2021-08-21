package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * Entity implementation class for Entity: exp_t_expiry
 * 
 */

@XmlRootElement
@Entity
@Table(name = "exp_t_expiry")
public class Expiry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "inv_no")
	private String invNo;
	
	@Expose
	@Column(name = "inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invDate;
	
	@Expose
	@Column(name = "from_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromDate;
	
	@Expose
	@Column(name = "to_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date toDate;
	
	@Expose
	@Column(name = "remarks")
	private String remarks;
	
	@Expose
	@Column(name = "is_posted")
	private int isPosted;
	
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
	@Column(name = "created_by")
	private int createdBy;

	@Expose
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Expose
	@Column(name = "updated_by")
	private int updatedBy;

	@Expose
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Expose
	@Transient
	private String lang;
	
	@Expose
	@Transient
	private List<ExpiryDetails> expiryDetails;
	
	@Expose
	@Transient
	private String finyrCode;
	
	@Expose
	@Transient
	private double cr_amount;
	@Expose
	@Transient
	private double dr_amount;
	@Expose
	@Transient
	private int cr_account_id;
	@Expose
	@Transient
	private int dr_account_id;
	@Expose
	@Transient
	private String qs;
	
	public Expiry() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFinyrCode() {
		return finyrCode;
	}

	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}

	public List<ExpiryDetails> getExpiryDetails() {
		return expiryDetails;
	}

	public void setExpiryDetails(List<ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
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

	public Date getFromDate() {
		return fromDate;
	}

	@XmlElement
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	@XmlElement
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getRemarks() {
		return remarks;
	}

	@XmlElement
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getIsPosted() {
		return isPosted;
	}

	@XmlElement
	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
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

	public int getCreatedBy() {
		return createdBy;
	}

	@XmlElement
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	@XmlElement
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	@XmlElement
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	@XmlElement
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	
	public double getCr_amount() {
		return cr_amount;
	}

	@XmlElement
	public void setCr_amount(double cr_amount) {
		this.cr_amount = cr_amount;
	}

	public double getDr_amount() {
		return dr_amount;
	}

	@XmlElement
	public void setDr_amount(double dr_amount) {
		this.dr_amount = dr_amount;
	}

	public int getCr_account_id() {
		return cr_account_id;
	}

	@XmlElement
	public void setCr_account_id(int cr_account_id) {
		this.cr_account_id = cr_account_id;
	}

	public int getDr_account_id() {
		return dr_account_id;
	}

	@XmlElement
	public void setDr_account_id(int dr_account_id) {
		this.dr_account_id = dr_account_id;
	}
	
	public String getQs() {
		return qs;
	}

	@XmlElement
	public void setQs(String qs) {
		this.qs = qs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
		result = prime * result + createdBy;
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result
				+ ((expiryDetails == null) ? 0 : expiryDetails.hashCode());
		result = prime * result
				+ ((finyrCode == null) ? 0 : finyrCode.hashCode());
		result = prime * result + finyrId;
		result = prime * result
				+ ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isPosted;
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + storeId;
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		result = prime * result + updatedBy;
		result = prime * result
				+ ((updatedDate == null) ? 0 : updatedDate.hashCode());
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
		Expiry other = (Expiry) obj;
		if (companyId != other.companyId)
			return false;
		if (createdBy != other.createdBy)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (expiryDetails == null) {
			if (other.expiryDetails != null)
				return false;
		} else if (!expiryDetails.equals(other.expiryDetails))
			return false;
		if (finyrCode == null) {
			if (other.finyrCode != null)
				return false;
		} else if (!finyrCode.equals(other.finyrCode))
			return false;
		if (finyrId != other.finyrId)
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
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
		if (storeId != other.storeId)
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expiry [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", remarks=" + remarks + ", isPosted=" + isPosted + ", finyrId=" + finyrId + ", companyId="
				+ companyId + ", storeId=" + storeId + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", lang=" + lang + ", expiryDetails="
				+ expiryDetails + ", finyrCode=" + finyrCode + ", cr_amount=" + cr_amount + ", dr_amount=" + dr_amount
				+ ", cr_account_id=" + cr_account_id + ", dr_account_id=" + dr_account_id + ", qs=" + qs + "]";
	}

	public Expiry(int id, String invNo, Date invDate, Date fromDate, Date toDate, String remarks, int isPosted,
			int finyrId, int companyId, int storeId, int createdBy, Date createdDate, int updatedBy, Date updatedDate,
			String lang, List<ExpiryDetails> expiryDetails, String finyrCode, double cr_amount, double dr_amount,
			int cr_account_id, int dr_account_id, String qs) {
		super();
		this.id = id;
		this.invNo = invNo;
		this.invDate = invDate;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.remarks = remarks;
		this.isPosted = isPosted;
		this.finyrId = finyrId;
		this.companyId = companyId;
		this.storeId = storeId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.lang = lang;
		this.expiryDetails = expiryDetails;
		this.finyrCode = finyrCode;
		this.cr_amount = cr_amount;
		this.dr_amount = dr_amount;
		this.cr_account_id = cr_account_id;
		this.dr_account_id = dr_account_id;
		this.qs = qs;
	}

}