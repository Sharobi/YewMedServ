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
 * Entity implementation class for Entity: pur_t_purchase_order
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pur_t_purchase_order")
public class PurchaseOrder implements Serializable {

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
	@Column(name = "due_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;

	@Expose
	@Column(name = "inv_type")
	private String invType;

	@Expose
	@Column(name = "distributor_id")
	private int distributorId;

	@Expose
	@Column(name = "distributor_disc_per")
	private double distributorDiscPer;

	@Expose
	@Column(name = "gross_amount")
	private double grossAmount;

	@Expose
	@Column(name = "disc_amount")
	private double discAmount;

	@Expose
	@Column(name = "adj_amount")
	private double adjAmount;

	@Expose
	@Column(name = "tax_amount")
	private double taxAmount;

	@Expose
	@Column(name = "roundoff")
	private double roundoff;

	@Expose
	@Column(name = "net_amount")
	private double netAmount;

	@Expose
	@Column(name = "total_mrp")
	private double totalMrp;

	@Expose
	@Column(name = "remarks")
	private String remarks;

	@Expose
	@Column(name = "is_canceled")
	private int isCanceled;

	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;

	@Expose
	@Column(name = "status")
	private int status;

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
	private String finyrCode;

	@Expose
	@Transient
	private List<PurchaseOrderDetails> purchaseOrderDetails;
	
	@Expose
	@Column(name = "is_posted")
	private int isPosted;
	
	
	
	public int getIsPosted() {
		return isPosted;
	}

	@XmlElement
	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	public String getFinyrCode() {
		return finyrCode;
	}

	@XmlElement
	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
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

	public Date getDueDate() {
		return dueDate;
	}

	@XmlElement
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getInvType() {
		return invType;
	}

	@XmlElement
	public void setInvType(String invType) {
		this.invType = invType;
	}

	public int getDistributorId() {
		return distributorId;
	}

	@XmlElement
	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public double getDistributorDiscPer() {
		return distributorDiscPer;
	}

	@XmlElement
	public void setDistributorDiscPer(double distributorDiscPer) {
		this.distributorDiscPer = distributorDiscPer;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	@XmlElement
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getDiscAmount() {
		return discAmount;
	}

	@XmlElement
	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}

	public double getAdjAmount() {
		return adjAmount;
	}

	@XmlElement
	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	@XmlElement
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getRoundoff() {
		return roundoff;
	}

	@XmlElement
	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}

	public double getNetAmount() {
		return netAmount;
	}

	@XmlElement
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getTotalMrp() {
		return totalMrp;
	}

	@XmlElement
	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public String getRemarks() {
		return remarks;
	}

	@XmlElement
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getIsCanceled() {
		return isCanceled;
	}

	@XmlElement
	public void setIsCanceled(int isCanceled) {
		this.isCanceled = isCanceled;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	@XmlElement
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(int status) {
		this.status = status;
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

	public List<PurchaseOrderDetails> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(
			List<PurchaseOrderDetails> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}
	
	

}
