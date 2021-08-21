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

/**
 * Entity implementation class for Entity: sal_t_sale
 * 
 */

@XmlRootElement
@Entity
@Table(name = "sal_t_sale")
public class Sales implements Serializable {

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
	@Column(name = "adj_amount")
	private double adjAmount;

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
	private List<SalesDetails> salesDetails;

	@Expose
	@Transient
	private String finyrCode;

	@Expose
	@Column(name = "cash_amount")
	private double cashAmount;

	@Expose
	@Column(name = "card_amount")
	private double cardAmount;

	@Expose
	@Column(name = "credit_amount")
	private double creditAmount;

	@Expose
	@Column(name = "card_four_digit")
	private String cardFourDigit;

	@Expose
	@Column(name = "card_exp_date")
	private String cardExpDate;

	@Expose
	@Column(name = "tender_amount")
	private double tenderAmount;

	@Expose
	@Column(name = "print_count")
	private int printCount;

	@Expose
	@Column(name = "hold_flag")
	private int holdFlag;

	@Expose
	@Column(name = "is_posted")
	private int isposted;

	@Expose
	@Column(name = "customer_disc_per")
	private double customerDiscPer;

	@Expose
	@Transient
	private String dateText;

	@Expose
	@Column(name = "sale_return_id")
	private int saleReturnId;

	@Expose
	@Column(name = "sale_return_inv_no")
	private String saleReturnInvNo;
	
	@Expose
	@Transient
	private List<SaleReturn> saleReturns;
	
	@Expose
	@Column(name = "special_disc_per")
	private double specialDiscPer;
	
	@Expose
	@Column(name = "special_disc_amount")
	private double specialDiscAmount;
	
	@Expose
	@Column(name = "total_mrp")
	private double totalMrp;
	
	@Expose
	@Column(name = "prescription_reg_no")
	private String prescriptionRegNo;
	
	@Expose
	@Column(name = "prescription_issue_date")
	private Date prescriptionIssueDate;
	
	@Expose
	@Column(name = "slip_no")
	private String slipNo;
	
	@Expose
	@Column(name = "esi_code")
	private String esiCode;
	
	@Expose
	@Column(name = "esi_type")
	private String esiType;
	
	
	//06.03.2018
	@Expose
	@Transient
	private String debitor_code;
	@Expose
	@Transient
	private String saleacc_code;
	@Expose
	@Transient
	private String dutiesandtax_code;
	@Expose
	@Transient
	private String roundof_code;
	@Expose
	@Transient
	private String discount_code;
	
	//09.03.2018
	@Expose
	@Transient
	private int duties_ledger_id;
	@Expose
	@Transient
	private int round_ledger_id;
	@Expose
	@Transient
	private int sale_ledger_id;
	@Expose
	@Transient
	private int discount_ledger_id;
	@Expose
	@Transient
	private int debitor_ledger_id;
	@Expose
	@Transient
	private int debitor_cash_ledger_id;
	@Expose
	@Transient
	private String qs;
	
	@Expose
	@Transient
	List<SaleReturnLedger> salels;
	
	@Expose
	@Transient
	private int card_ledger_id;
	
	//06.04.2018
	@Expose
	@Transient
	private int is_account;
	
	//22.03.2019
	@Expose
	@Transient
	private int isExclusive;
	
	public Sales() { }
	
	public String getEsiType() {
		return esiType;
	}

	@XmlElement
	public void setEsiType(String esiType) {
		this.esiType = esiType;
	}

	
	public String getPrescriptionRegNo() {
		return prescriptionRegNo;
	}

	@XmlElement
	public void setPrescriptionRegNo(String prescriptionRegNo) {
		this.prescriptionRegNo = prescriptionRegNo;
	}

	public Date getPrescriptionIssueDate() {
		return prescriptionIssueDate;
	}

	@XmlElement
	public void setPrescriptionIssueDate(Date prescriptionIssueDate) {
		this.prescriptionIssueDate = prescriptionIssueDate;
	}

	public String getSlipNo() {
		return slipNo;
	}

	@XmlElement
	public void setSlipNo(String slipNo) {
		this.slipNo = slipNo;
	}

	public String getEsiCode() {
		return esiCode;
	}

	@XmlElement
	public void setEsiCode(String esiCode) {
		this.esiCode = esiCode;
	}

	public double getTotalMrp() {
		return totalMrp;
	}

	@XmlElement
	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
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

	public List<SaleReturn> getSaleReturns() {
		return saleReturns;
	}

	public void setSaleReturns(List<SaleReturn> saleReturns) {
		this.saleReturns = saleReturns;
	}

	public int getSaleReturnId() {
		return saleReturnId;
	}

	@XmlElement
	public void setSaleReturnId(int saleReturnId) {
		this.saleReturnId = saleReturnId;
	}

	public String getSaleReturnInvNo() {
		return saleReturnInvNo;
	}

	@XmlElement
	public void setSaleReturnInvNo(String saleReturnInvNo) {
		this.saleReturnInvNo = saleReturnInvNo;
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}

	public double getCustomerDiscPer() {
		return customerDiscPer;
	}

	public void setCustomerDiscPer(double customerDiscPer) {
		this.customerDiscPer = customerDiscPer;
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

	public double getAdjAmount() {
		return adjAmount;
	}

	@XmlElement
	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
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

	public List<SalesDetails> getSalesDetails() {
		return salesDetails;
	}

	public void setSalesDetails(List<SalesDetails> salesDetails) {
		this.salesDetails = salesDetails;
	}

	public double getCashAmount() {
		return cashAmount;
	}

	@XmlElement
	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public double getCardAmount() {
		return cardAmount;
	}

	@XmlElement
	public void setCardAmount(double cardAmount) {
		this.cardAmount = cardAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	@XmlElement
	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getCardFourDigit() {
		return cardFourDigit;
	}

	@XmlElement
	public void setCardFourDigit(String cardFourDigit) {
		this.cardFourDigit = cardFourDigit;
	}

	public String getCardExpDate() {
		return cardExpDate;
	}

	@XmlElement
	public void setCardExpDate(String cardExpDate) {
		this.cardExpDate = cardExpDate;
	}

	public double getTenderAmount() {
		return tenderAmount;
	}

	@XmlElement
	public void setTenderAmount(double tenderAmount) {
		this.tenderAmount = tenderAmount;
	}

	public int getPrintCount() {
		return printCount;
	}

	@XmlElement
	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}

	public int getHoldFlag() {
		return holdFlag;
	}

	@XmlElement
	public void setHoldFlag(int holdFlag) {
		this.holdFlag = holdFlag;
	}

	public int getIsposted() {
		return isposted;
	}

	@XmlElement
	public void setIsposted(int isposted) {
		this.isposted = isposted;
	}

	//06.03.2018
	
	public String getDebitor_code() {
		return debitor_code;
	}

	@XmlElement
	public void setDebitor_code(String debitor_code) {
		this.debitor_code = debitor_code;
	}

	public String getSaleacc_code() {
		return saleacc_code;
	}

	@XmlElement
	public void setSaleacc_code(String saleacc_code) {
		this.saleacc_code = saleacc_code;
	}

	public String getDutiesandtax_code() {
		return dutiesandtax_code;
	}

	@XmlElement
	public void setDutiesandtax_code(String dutiesandtax_code) {
		this.dutiesandtax_code = dutiesandtax_code;
	}

	public String getRoundof_code() {
		return roundof_code;
	}

	@XmlElement
	public void setRoundof_code(String roundof_code) {
		this.roundof_code = roundof_code;
	}

	public String getDiscount_code() {
		return discount_code;
	}

	@XmlElement
	public void setDiscount_code(String discount_code) {
		this.discount_code = discount_code;
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

	public int getSale_ledger_id() {
		return sale_ledger_id;
	}

	@XmlElement
	public void setSale_ledger_id(int sale_ledger_id) {
		this.sale_ledger_id = sale_ledger_id;
	}

	public int getDiscount_ledger_id() {
		return discount_ledger_id;
	}

	@XmlElement
	public void setDiscount_ledger_id(int discount_ledger_id) {
		this.discount_ledger_id = discount_ledger_id;
	}

	public int getDebitor_ledger_id() {
		return debitor_ledger_id;
	}

	@XmlElement
	public void setDebitor_ledger_id(int debitor_ledger_id) {
		this.debitor_ledger_id = debitor_ledger_id;
	}
	
	public int getDebitor_cash_ledger_id() {
		return debitor_cash_ledger_id;
	}

	@XmlElement
	public void setDebitor_cash_ledger_id(int debitor_cash_ledger_id) {
		this.debitor_cash_ledger_id = debitor_cash_ledger_id;
	}

	public String getQs() {
		return qs;
	}

	@XmlElement
	public void setQs(String qs) {
		this.qs = qs;
	}

	public List<SaleReturnLedger> getSalels() {
		return salels;
	}

	public void setSalels(List<SaleReturnLedger> salels) {
		this.salels = salels;
	}

	public int getCard_ledger_id() {
		return card_ledger_id;
	}

	@XmlElement
	public void setCard_ledger_id(int card_ledger_id) {
		this.card_ledger_id = card_ledger_id;
	}

	public int getIs_account() {
		return is_account;
	}

	@XmlElement
	public void setIs_account(int is_account) {
		this.is_account = is_account;
	}

	public int getIsExclusive() {
		return isExclusive;
	}

	@XmlElement
	public void setIsExclusive(int isExclusive) {
		this.isExclusive = isExclusive;
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", invTime=" + invTime
				+ ", customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerPhone=" + customerPhone + ", doctorId=" + doctorId + ", doctorName="
				+ doctorName + ", invMode=" + invMode + ", grossAmount=" + grossAmount + ", edAmount=" + edAmount
				+ ", discAmount=" + discAmount + ", taxAmount=" + taxAmount + ", vatAmount=" + vatAmount
				+ ", adjAmount=" + adjAmount + ", netAmount=" + netAmount + ", roundoff=" + roundoff + ", remarks="
				+ remarks + ", pstId=" + pstId + ", pstNo=" + pstNo + ", finyrId=" + finyrId + ", storeId=" + storeId
				+ ", companyId=" + companyId + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", lang=" + lang + ", salesDetails=" + salesDetails + ", finyrCode=" + finyrCode + ", cashAmount="
				+ cashAmount + ", cardAmount=" + cardAmount + ", creditAmount=" + creditAmount + ", cardFourDigit="
				+ cardFourDigit + ", cardExpDate=" + cardExpDate + ", tenderAmount=" + tenderAmount + ", printCount="
				+ printCount + ", holdFlag=" + holdFlag + ", isposted=" + isposted + ", customerDiscPer="
				+ customerDiscPer + ", dateText=" + dateText + ", saleReturnId=" + saleReturnId + ", saleReturnInvNo="
				+ saleReturnInvNo + ", saleReturns=" + saleReturns + ", specialDiscPer=" + specialDiscPer
				+ ", specialDiscAmount=" + specialDiscAmount + ", totalMrp=" + totalMrp + ", prescriptionRegNo="
				+ prescriptionRegNo + ", prescriptionIssueDate=" + prescriptionIssueDate + ", slipNo=" + slipNo
				+ ", esiCode=" + esiCode + ", esiType=" + esiType + ", debitor_code=" + debitor_code + ", saleacc_code="
				+ saleacc_code + ", dutiesandtax_code=" + dutiesandtax_code + ", roundof_code=" + roundof_code
				+ ", discount_code=" + discount_code + ", duties_ledger_id=" + duties_ledger_id + ", round_ledger_id="
				+ round_ledger_id + ", sale_ledger_id=" + sale_ledger_id + ", discount_ledger_id=" + discount_ledger_id
				+ ", debitor_ledger_id=" + debitor_ledger_id + ", debitor_cash_ledger_id=" + debitor_cash_ledger_id
				+ ", qs=" + qs + ", salels=" + salels + ", card_ledger_id=" + card_ledger_id + ", is_account="
				+ is_account + ", isExclusive=" + isExclusive + "]";
	}

	public Sales(int id, String invNo, Date invDate, String invTime, int customerId, String customerName,
			String customerAddress, String customerPhone, int doctorId, String doctorName, int invMode,
			double grossAmount, double edAmount, double discAmount, double taxAmount, double vatAmount,
			double adjAmount, double netAmount, double roundoff, String remarks, int pstId, String pstNo, int finyrId,
			int storeId, int companyId, int isDeleted, int createdBy, Date createdDate, int updatedBy, Date updatedDate,
			String lang, List<SalesDetails> salesDetails, String finyrCode, double cashAmount, double cardAmount,
			double creditAmount, String cardFourDigit, String cardExpDate, double tenderAmount, int printCount,
			int holdFlag, int isposted, double customerDiscPer, String dateText, int saleReturnId,
			String saleReturnInvNo, List<SaleReturn> saleReturns, double specialDiscPer, double specialDiscAmount,
			double totalMrp, String prescriptionRegNo, Date prescriptionIssueDate, String slipNo, String esiCode,
			String esiType, String debitor_code, String saleacc_code, String dutiesandtax_code, String roundof_code,
			String discount_code, int duties_ledger_id, int round_ledger_id, int sale_ledger_id, int discount_ledger_id,
			int debitor_ledger_id, int debitor_cash_ledger_id, String qs, List<SaleReturnLedger> salels,
			int card_ledger_id, int is_account, int isExclusive) {
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
		this.adjAmount = adjAmount;
		this.netAmount = netAmount;
		this.roundoff = roundoff;
		this.remarks = remarks;
		this.pstId = pstId;
		this.pstNo = pstNo;
		this.finyrId = finyrId;
		this.storeId = storeId;
		this.companyId = companyId;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.lang = lang;
		this.salesDetails = salesDetails;
		this.finyrCode = finyrCode;
		this.cashAmount = cashAmount;
		this.cardAmount = cardAmount;
		this.creditAmount = creditAmount;
		this.cardFourDigit = cardFourDigit;
		this.cardExpDate = cardExpDate;
		this.tenderAmount = tenderAmount;
		this.printCount = printCount;
		this.holdFlag = holdFlag;
		this.isposted = isposted;
		this.customerDiscPer = customerDiscPer;
		this.dateText = dateText;
		this.saleReturnId = saleReturnId;
		this.saleReturnInvNo = saleReturnInvNo;
		this.saleReturns = saleReturns;
		this.specialDiscPer = specialDiscPer;
		this.specialDiscAmount = specialDiscAmount;
		this.totalMrp = totalMrp;
		this.prescriptionRegNo = prescriptionRegNo;
		this.prescriptionIssueDate = prescriptionIssueDate;
		this.slipNo = slipNo;
		this.esiCode = esiCode;
		this.esiType = esiType;
		this.debitor_code = debitor_code;
		this.saleacc_code = saleacc_code;
		this.dutiesandtax_code = dutiesandtax_code;
		this.roundof_code = roundof_code;
		this.discount_code = discount_code;
		this.duties_ledger_id = duties_ledger_id;
		this.round_ledger_id = round_ledger_id;
		this.sale_ledger_id = sale_ledger_id;
		this.discount_ledger_id = discount_ledger_id;
		this.debitor_ledger_id = debitor_ledger_id;
		this.debitor_cash_ledger_id = debitor_cash_ledger_id;
		this.qs = qs;
		this.salels = salels;
		this.card_ledger_id = card_ledger_id;
		this.is_account = is_account;
		this.isExclusive = isExclusive;
	}

}