package com.sharobi.pharmacy.sales.model;

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

import net.sf.resultsetmapper.MapToData;

/**
 * Entity implementation class for Entity: pay_t_customer
 * 
 */
@XmlRootElement
@Entity
@Table(name = "pay_t_customer")
public class CustomerPayment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name =  "inv_no")
	private int invNo;
	

	@Expose
	@Column(name =  "inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invDate;

	@Expose
	@Column(name =  "inv_mode")
	private int invMode;
	
	@Expose
	@Column(name =  "customer_id")
	private int customerId;
	
	@Expose
	@Column(name =  "payable_amount")
	private double paybleAmount;

	@Expose
	@Column(name =  "outstanding_amount")
	private double outstandingAmount;

	@Expose
	@Column(name =  "net_amount")
	private double netAmount;

	@Expose
	@Column(name =  "roundoff")
	private double roundoff;

	@Expose
	@Column(name =  "pay_amount")
	private double payAmount;

	@Expose
	@Column(name =  "remaining_amount")
	private double remainingAmount;
	
	@Expose
	@Column(name =  "card_no")
	private String cardNo;

	@Expose
	@Column(name =  "cheque_no")
	private String chequeNo;

	@Expose
	@Column(name =  "cheque_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date chequeDate;
	
	@Expose
	@Column(name =  "bank_name")
	private String bankName;
	
	@Expose
	@Column(name =  "remarks")
	private String remarks;
	
	@Expose
	@Column(name =  "is_deleted")
	private int isDeleted;
	
	@Expose
	@Column(name =  "is_posted")
	private int isPosted;
	
	@Expose
	@Column(name = "pst_id")
	private int pstId;

	@Expose
	@Column(name = "pst_no")
	private String pstNo;

	@Expose
	@Column(name = "finyr_id")
	private int finyrId;

	@Expose
	@Column(name = "store_id")
	private int storeId;

	@Expose
	@Column(name = "company_id")
	private int companyId;

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
	private List<CustomerPaymentDetails> customerPaymentDetails;
	
	@Expose
	@Transient
	private String finyrCode;
	
	
	/*
	* add on Mar 2, 2018
	*/

	@Expose
	@MapToData(columnAliases = { "cr_amount" })
	private double cr_amount;
	@Expose
	@MapToData(columnAliases = { "dr_amount" })
	private double dr_amount;
	@Expose
	@MapToData(columnAliases = { "cr_account_id" })
	private int cr_account_id;
	@Expose
	@MapToData(columnAliases = { "dr_account_id" })
	private int dr_account_id;
	
	@Expose
	@MapToData(columnAliases = { "qs" })
	private String qs;
	
	//05.04.2018
	@Expose
	@Transient
	private int is_account;
	
	public CustomerPayment() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFinyrCode() {
		return finyrCode;
	}

	@XmlElement
	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}
	

	public List<CustomerPaymentDetails> getCustomerPaymentDetails() {
		return customerPaymentDetails;
	}

	public void setCustomerPaymentDetails(
			List<CustomerPaymentDetails> customerPaymentDetails) {
		this.customerPaymentDetails = customerPaymentDetails;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getInvNo() {
		return invNo;
	}

	@XmlElement
	public void setInvNo(int invNo) {
		this.invNo = invNo;
	}

	public Date getInvDate() {
		return invDate;
	}

	@XmlElement
	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public int getInvMode() {
		return invMode;
	}

	@XmlElement
	public void setInvMode(int invMode) {
		this.invMode = invMode;
	}

	public int getCustomerId() {
		return customerId;
	}

	@XmlElement
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getPaybleAmount() {
		return paybleAmount;
	}

	@XmlElement
	public void setPaybleAmount(double paybleAmount) {
		this.paybleAmount = paybleAmount;
	}

	public double getOutstandingAmount() {
		return outstandingAmount;
	}

	@XmlElement
	public void setOutstandingAmount(double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public double getNetAmount() {
		return netAmount;
	}

	@XmlElement
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getRoundoff() {
		return roundoff;
	}

	@XmlElement
	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}

	public double getPayAmount() {
		return payAmount;
	}

	@XmlElement
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	@XmlElement
	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public String getCardNo() {
		return cardNo;
	}

	@XmlElement
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	@XmlElement
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	@XmlElement
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getBankName() {
		return bankName;
	}

	@XmlElement
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRemarks() {
		return remarks;
	}

	@XmlElement
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	@XmlElement
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getIsPosted() {
		return isPosted;
	}

	@XmlElement
	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	public int getPstId() {
		return pstId;
	}

	@XmlElement
	public void setPstId(int pstId) {
		this.pstId = pstId;
	}

	public String getPstNo() {
		return pstNo;
	}

	@XmlElement
	public void setPstNo(String pstNo) {
		this.pstNo = pstNo;
	}

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public int getStoreId() {
		return storeId;
	}

	@XmlElement
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getCompanyId() {
		return companyId;
	}

	@XmlElement
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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

	@XmlElement
	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getIs_account() {
		return is_account;
	}

	@XmlElement
	public void setIs_account(int is_account) {
		this.is_account = is_account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result
				+ ((chequeDate == null) ? 0 : chequeDate.hashCode());
		result = prime * result
				+ ((chequeNo == null) ? 0 : chequeNo.hashCode());
		result = prime * result + companyId;
		result = prime * result + createdBy;
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + customerId;
		result = prime * result + finyrId;
		result = prime * result + id;
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + invMode;
		result = prime * result + invNo;
		result = prime * result + isDeleted;
		result = prime * result + isPosted;
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		long temp;
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(outstandingAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(payAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(paybleAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pstId;
		result = prime * result + ((pstNo == null) ? 0 : pstNo.hashCode());
		temp = Double.doubleToLongBits(remainingAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		temp = Double.doubleToLongBits(roundoff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + storeId;
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
		CustomerPayment other = (CustomerPayment) obj;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (chequeDate == null) {
			if (other.chequeDate != null)
				return false;
		} else if (!chequeDate.equals(other.chequeDate))
			return false;
		if (chequeNo == null) {
			if (other.chequeNo != null)
				return false;
		} else if (!chequeNo.equals(other.chequeNo))
			return false;
		if (companyId != other.companyId)
			return false;
		if (createdBy != other.createdBy)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (customerId != other.customerId)
			return false;
		if (finyrId != other.finyrId)
			return false;
		if (id != other.id)
			return false;
		if (invDate == null) {
			if (other.invDate != null)
				return false;
		} else if (!invDate.equals(other.invDate))
			return false;
		if (invMode != other.invMode)
			return false;
		if (invNo != other.invNo)
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (isPosted != other.isPosted)
			return false;
		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		if (Double.doubleToLongBits(netAmount) != Double
				.doubleToLongBits(other.netAmount))
			return false;
		if (Double.doubleToLongBits(outstandingAmount) != Double
				.doubleToLongBits(other.outstandingAmount))
			return false;
		if (Double.doubleToLongBits(payAmount) != Double
				.doubleToLongBits(other.payAmount))
			return false;
		if (Double.doubleToLongBits(paybleAmount) != Double
				.doubleToLongBits(other.paybleAmount))
			return false;
		if (pstId != other.pstId)
			return false;
		if (pstNo == null) {
			if (other.pstNo != null)
				return false;
		} else if (!pstNo.equals(other.pstNo))
			return false;
		if (Double.doubleToLongBits(remainingAmount) != Double
				.doubleToLongBits(other.remainingAmount))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (Double.doubleToLongBits(roundoff) != Double
				.doubleToLongBits(other.roundoff))
			return false;
		if (storeId != other.storeId)
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

	public void setQs(String qs) {
		this.qs = qs;
	}

	@Override
	public String toString() {
		return "CustomerPayment [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", invMode=" + invMode
				+ ", customerId=" + customerId + ", paybleAmount=" + paybleAmount + ", outstandingAmount="
				+ outstandingAmount + ", netAmount=" + netAmount + ", roundoff=" + roundoff + ", payAmount=" + payAmount
				+ ", remainingAmount=" + remainingAmount + ", cardNo=" + cardNo + ", chequeNo=" + chequeNo
				+ ", chequeDate=" + chequeDate + ", bankName=" + bankName + ", remarks=" + remarks + ", isDeleted="
				+ isDeleted + ", isPosted=" + isPosted + ", pstId=" + pstId + ", pstNo=" + pstNo + ", finyrId="
				+ finyrId + ", storeId=" + storeId + ", companyId=" + companyId + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", lang=" + lang + ", customerPaymentDetails=" + customerPaymentDetails + ", finyrCode=" + finyrCode
				+ ", cr_amount=" + cr_amount + ", dr_amount=" + dr_amount + ", cr_account_id=" + cr_account_id
				+ ", dr_account_id=" + dr_account_id + ", qs=" + qs + ", is_account=" + is_account + "]";
	}

}