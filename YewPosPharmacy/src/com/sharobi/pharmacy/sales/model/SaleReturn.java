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
 * Entity implementation class for Entity: sal_t_sale_return
 * 
 */

@XmlRootElement
@Entity
@Table(name = "sal_t_sale_return")
public class SaleReturn implements Serializable {

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
	@Column(name = "inv_time")
	private String invTime;

	@Expose
	@Column(name = "customer_id")
	private int customerId;

	@Expose
	@Column(name = "customer_name")
	private String customerName;

	@Expose
	@Column(name = "customer_address")
	private String customerAddress;

	@Expose
	@Column(name = "customer_phone")
	private String customerPhone;

	@Expose
	@Column(name = "doctor_id")
	private int doctorId;

	@Expose
	@Column(name = "doctor_name")
	private String doctorName;

	@Expose
	@Column(name = "inv_mode")
	private int invMode;

	@Expose
	@Column(name = "gross_amount")
	private double grossAmount;

	@Expose
	@Column(name = "ed_amount")
	private double edAmount;

	@Expose
	@Column(name = "disc_amount")
	private double discAmount;

	@Expose
	@Column(name = "tax_amount")
	private double taxAmount;

	@Expose
	@Column(name = "vat_amount")
	private double vatAmount;

	@Expose
	@Column(name = "net_amount")
	private double netAmount;

	@Expose
	@Column(name = "roundoff")
	private double roundoff;

	@Expose
	@Column(name = "remarks")
	private String remarks;

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
	@Column(name = "is_deleted")
	private int isDeleted;

	@Expose
	@Column(name = "is_posted")
	private int isposted;

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
	private List<SaleReturnDetails> saleReturnDetails;

	@Expose
	@Column(name = "adj_amount")
	private double adjAmount;

	
	
	@Expose
	@Transient
	private String finyrCode;

	@Expose
	@Column(name = "special_disc_per")
	private double specialDiscPer;

	@Expose
	@Column(name = "special_disc_amount")
	private double specialDiscAmount;
	
	//07.03.2018
	
	@Expose
	@Transient
	private List<SaleReturnLedger> srls;
		
	@Expose
	@Transient
	@MapToData(columnAliases = { "sale_account_credit_amt"})
	private double sale_account_credit_amt;
	@Expose
	@Transient
	@MapToData(columnAliases = { "debitor_credit_amt"})
	private double debitor_credit_amt;
	@Expose
	@Transient
	@MapToData(columnAliases = { "duties_ledger_id"})//dr
	private int duties_ledger_id;
	@Expose
	@Transient
	@MapToData(columnAliases = { "round_ledger_id"})//var
	private int round_ledger_id;
	@Expose
	@Transient
	@MapToData(columnAliases = { "sales_ledger_id"})//dr
	private int sales_ledger_id;
	@Expose
	@Transient
	@MapToData(columnAliases = { "debitor_ledger_id"})//cr
	private int debitor_ledger_id;
	@Expose
	@Transient
	@MapToData(columnAliases = { "qs"})
	private String qs;
	
	//06.04.2018
	@Expose
	@Transient
	private int is_account;

	public SaleReturn() {
	}

	public double getSpecialDiscPer() {
		return specialDiscPer;
	}

	@XmlElement
	public void setSpecialDiscPer(double specialDiscPer) {
		this.specialDiscPer = specialDiscPer;
	}

	public double getSpecialDiscAmount() {
		return specialDiscAmount;
	}

	@XmlElement
	public void setSpecialDiscAmount(double specialDiscAmount) {
		this.specialDiscAmount = specialDiscAmount;
	}

	public String getFinyrCode() {
		return finyrCode;
	}

	@XmlElement
	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}

	public double getAdjAmount() {
		return adjAmount;
	}

	@XmlElement
	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
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

	public String getInvTime() {
		return invTime;
	}

	@XmlElement
	public void setInvTime(String invTime) {
		this.invTime = invTime;
	}

	public int getCustomerId() {
		return customerId;
	}

	@XmlElement
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	@XmlElement
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	@XmlElement
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	@XmlElement
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public int getDoctorId() {
		return doctorId;
	}

	@XmlElement
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	@XmlElement
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getInvMode() {
		return invMode;
	}

	@XmlElement
	public void setInvMode(int invMode) {
		this.invMode = invMode;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	@XmlElement
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getEdAmount() {
		return edAmount;
	}

	@XmlElement
	public void setEdAmount(double edAmount) {
		this.edAmount = edAmount;
	}

	public double getDiscAmount() {
		return discAmount;
	}

	@XmlElement
	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	@XmlElement
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getVatAmount() {
		return vatAmount;
	}

	@XmlElement
	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
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

	public String getRemarks() {
		return remarks;
	}

	@XmlElement
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public int getIsDeleted() {
		return isDeleted;
	}

	@XmlElement
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
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

	public List<SaleReturnDetails> getSaleReturnDetails() {
		return saleReturnDetails;
	}

	public void setSaleReturnDetails(List<SaleReturnDetails> saleReturnDetails) {
		this.saleReturnDetails = saleReturnDetails;
	}

	public int getIsposted() {
		return isposted;
	}

	@XmlElement
	public void setIsposted(int isposted) {
		this.isposted = isposted;
	}

	public double getSale_account_credit_amt() {
		return sale_account_credit_amt;
	}

	@XmlElement
	public void setSale_account_credit_amt(double sale_account_credit_amt) {
		this.sale_account_credit_amt = sale_account_credit_amt;
	}

	public double getDebitor_credit_amt() {
		return debitor_credit_amt;
	}

	@XmlElement
	public void setDebitor_credit_amt(double debitor_credit_amt) {
		this.debitor_credit_amt = debitor_credit_amt;
	}

	public int getDuties_ledger_id() {
		return duties_ledger_id;
	}

	@XmlElement
	public void setDuties_ledger_id(int duties_ledger_id) {
		this.duties_ledger_id = duties_ledger_id;
	}

	public int getRound_ledger_id() {
		return round_ledger_id;
	}

	@XmlElement
	public void setRound_ledger_id(int round_ledger_id) {
		this.round_ledger_id = round_ledger_id;
	}

	public int getSales_ledger_id() {
		return sales_ledger_id;
	}

	@XmlElement
	public void setSales_ledger_id(int sales_ledger_id) {
		this.sales_ledger_id = sales_ledger_id;
	}

	public int getDebitor_ledger_id() {
		return debitor_ledger_id;
	}

	@XmlElement
	public void setDebitor_ledger_id(int debitor_ledger_id) {
		this.debitor_ledger_id = debitor_ledger_id;
	}

	public List<SaleReturnLedger> getSrls() {
		return srls;
	}

	public void setSrls(List<SaleReturnLedger> srls) {
		this.srls = srls;
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
		return "SaleReturn [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", invTime=" + invTime
				+ ", customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerPhone=" + customerPhone + ", doctorId=" + doctorId + ", doctorName="
				+ doctorName + ", invMode=" + invMode + ", grossAmount=" + grossAmount + ", edAmount=" + edAmount
				+ ", discAmount=" + discAmount + ", taxAmount=" + taxAmount + ", vatAmount=" + vatAmount
				+ ", netAmount=" + netAmount + ", roundoff=" + roundoff + ", remarks=" + remarks + ", pstId=" + pstId
				+ ", pstNo=" + pstNo + ", finyrId=" + finyrId + ", storeId=" + storeId + ", companyId=" + companyId
				+ ", isDeleted=" + isDeleted + ", isposted=" + isposted + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", lang=" + lang
				+ ", saleReturnDetails=" + saleReturnDetails + ", adjAmount=" + adjAmount + ", finyrCode=" + finyrCode
				+ ", specialDiscPer=" + specialDiscPer + ", specialDiscAmount=" + specialDiscAmount + ", srls=" + srls
				+ ", sale_account_credit_amt=" + sale_account_credit_amt + ", debitor_credit_amt=" + debitor_credit_amt
				+ ", duties_ledger_id=" + duties_ledger_id + ", round_ledger_id=" + round_ledger_id
				+ ", sales_ledger_id=" + sales_ledger_id + ", debitor_ledger_id=" + debitor_ledger_id + ", qs=" + qs
				+ ", is_account=" + is_account + "]";
	}

	public SaleReturn(int id, String invNo, Date invDate, String invTime, int customerId, String customerName,
			String customerAddress, String customerPhone, int doctorId, String doctorName, int invMode,
			double grossAmount, double edAmount, double discAmount, double taxAmount, double vatAmount,
			double netAmount, double roundoff, String remarks, int pstId, String pstNo, int finyrId, int storeId,
			int companyId, int isDeleted, int isposted, int createdBy, Date createdDate, int updatedBy,
			Date updatedDate, String lang, List<SaleReturnDetails> saleReturnDetails, double adjAmount,
			String finyrCode, double specialDiscPer, double specialDiscAmount, List<SaleReturnLedger> srls,
			double sale_account_credit_amt, double debitor_credit_amt, int duties_ledger_id, int round_ledger_id,
			int sales_ledger_id, int debitor_ledger_id, String qs, int is_account) {
		super();
		this.id = id;
		this.invNo = invNo;
		this.invDate = invDate;
		this.invTime = invTime;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.invMode = invMode;
		this.grossAmount = grossAmount;
		this.edAmount = edAmount;
		this.discAmount = discAmount;
		this.taxAmount = taxAmount;
		this.vatAmount = vatAmount;
		this.netAmount = netAmount;
		this.roundoff = roundoff;
		this.remarks = remarks;
		this.pstId = pstId;
		this.pstNo = pstNo;
		this.finyrId = finyrId;
		this.storeId = storeId;
		this.companyId = companyId;
		this.isDeleted = isDeleted;
		this.isposted = isposted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.lang = lang;
		this.saleReturnDetails = saleReturnDetails;
		this.adjAmount = adjAmount;
		this.finyrCode = finyrCode;
		this.specialDiscPer = specialDiscPer;
		this.specialDiscAmount = specialDiscAmount;
		this.srls = srls;
		this.sale_account_credit_amt = sale_account_credit_amt;
		this.debitor_credit_amt = debitor_credit_amt;
		this.duties_ledger_id = duties_ledger_id;
		this.round_ledger_id = round_ledger_id;
		this.sales_ledger_id = sales_ledger_id;
		this.debitor_ledger_id = debitor_ledger_id;
		this.qs = qs;
		this.is_account = is_account;
	}

}