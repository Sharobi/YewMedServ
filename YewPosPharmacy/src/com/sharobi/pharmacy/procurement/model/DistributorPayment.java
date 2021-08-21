package com.sharobi.pharmacy.procurement.model;

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
 * Entity implementation class for Entity: pay_t_distributor
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pay_t_distributor")
public class DistributorPayment implements Serializable {

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
	@Column(name = "inv_mode")
	private int invMode;
	
	@Expose
	@Column(name = "distributor_id")
	private int distributorId;
	
	
	@Expose
	@Column(name = "payable_amount")
	private double payableAmount;

	@Expose
	@Column(name = "outstanding_amount")
	private double outstandingAmount;

	@Expose
	@Column(name = "net_amount")
	private double netAmount;

	@Expose
	@Column(name = "roundoff")
	private double roundoff;

	@Expose
	@Column(name = "pay_amount")
	private double payAmount;

	@Expose
	@Column(name = "remaining_amount")
	private double remainingAmount;
	
	@Expose
	@Column(name = "card_no")
	private String cardNo;

	@Expose
	@Column(name = "cheque_no")
	private String chequeNo;

	@Expose
	@Column(name = "cheque_date")
	private Date chequeDate;
	
	@Expose
	@Column(name = "bank_name")
	private String bankName;
	
	@Expose
	@Column(name = "remarks")
	private String remarks;
	
	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;
	
	@Expose
	@Column(name = "is_posted")
	private int isPosted;
	
	@Expose
	@Column(name = "pst_id")
	private int pstId;
	
	@Expose
	@Column(name = "pst_no")
	private String pstNo;
	
	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	@Expose
	@Column(name = "store_id")
	private int storeId;
	
	@Expose
	@Column(name = "finyr_id")
	private int finyrId;
	
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
	private List<DistributorPaymentDetails> distributorPaymentDetails;
	
	@Expose
	@Transient
	private String finyrCode;
	
	//02.03.2018
	
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
	
	
	//02.03.2018
	
	//05.04.2018
	@Expose
	@Transient
	private int is_account;

	private static final long serialVersionUID = 1L;
	
	
	public String getFinyrCode() {
		return finyrCode;
	}

	@XmlElement
	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}

	public List<DistributorPaymentDetails> getDistributorPaymentDetails() {
		return distributorPaymentDetails;
	}

	public void setDistributorPaymentDetails(
			List<DistributorPaymentDetails> distributorPaymentDetails) {
		this.distributorPaymentDetails = distributorPaymentDetails;
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

	public int getInvMode() {
		return invMode;
	}

	@XmlElement
	public void setInvMode(int invMode) {
		this.invMode = invMode;
	}

	public int getDistributorId() {
		return distributorId;
	}

	@XmlElement
	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

	@XmlElement
	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
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

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
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
	

	public int getIs_account() {
		return is_account;
	}

	@XmlElement
	public void setIs_account(int is_account) {
		this.is_account = is_account;
	}

	@Override
	public String toString() {
		return "DistributorPayment [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", invMode=" + invMode
				+ ", distributorId=" + distributorId + ", payableAmount=" + payableAmount + ", outstandingAmount="
				+ outstandingAmount + ", netAmount=" + netAmount + ", roundoff=" + roundoff + ", payAmount=" + payAmount
				+ ", remainingAmount=" + remainingAmount + ", cardNo=" + cardNo + ", chequeNo=" + chequeNo
				+ ", chequeDate=" + chequeDate + ", bankName=" + bankName + ", remarks=" + remarks + ", isDeleted="
				+ isDeleted + ", isPosted=" + isPosted + ", pstId=" + pstId + ", pstNo=" + pstNo + ", companyId="
				+ companyId + ", storeId=" + storeId + ", finyrId=" + finyrId + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", distributorPaymentDetails=" + distributorPaymentDetails + ", finyrCode=" + finyrCode
				+ ", cr_amount=" + cr_amount + ", dr_amount=" + dr_amount + ", cr_account_id=" + cr_account_id
				+ ", dr_account_id=" + dr_account_id + ", qs=" + qs + ", is_account=" + is_account + "]";
	}

}