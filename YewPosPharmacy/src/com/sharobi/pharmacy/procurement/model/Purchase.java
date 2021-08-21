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
import com.sharobi.pharmacy.inventory.model.ExpiryPurchaseMapping;

/**
 * Entity implementation class for Entity: pur_t_purchase
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pur_t_purchase")
public class Purchase implements Serializable {

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
	@Column(name = "po_order_id")
	private int poOrderId;

	@Expose
	@Column(name = "purchase_return_id")
	private int purchaseReturnId;

	@Expose
	@Column(name = "inv_mode")
	private int invMode;

	@Expose
	@Column(name = "distributor_id")
	private int distributorId;

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
	@Column(name = "lot_adj_amount")
	private double lotAdjAmount;

	@Expose
	@Column(name = "roundoff")
	private double roundoff;

	@Expose
	@Column(name = "cst")
	private double cst;

	@Expose
	@Column(name = "vat_diff")
	private double vatDiff;

	@Expose
	@Column(name = "remarks")
	private String remarks;

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
	private String qryCondition;

	@Expose
	@Transient
	private String invModeName;

	@Expose
	@Transient
	private String distName;

	@Expose
	@Column(name = "total_mrp")
	private double totalMrp;

	@Expose
	@Transient
	private List<PurchaseDetails> purchaseDetails;

	@Expose
	@Column(name = "finyr_code")
	private String finyrCode;

	@Expose
	@Column(name = "bill_no")
	private String billNo;

	@Expose
	@Transient
	private double specDiscPer;

	@Expose
	@Transient
	private double specDiscAmount;
	
	@Expose
	@Transient
	private double distDiscPer;
	
	@Expose
	@Column(name = "payment_id")
	private int paymentId;
	
	@Expose
	@Column(name = "adv_amount")
	private double advAmount;
	
	@Expose
	@Column(name = "distributor_bill_amount")
	private double distributorBillAmount;
	
	@Expose
	@Column(name = "other_adj_amount")
	private double otherAdjAmount;
	
	@Expose
	@Transient
	private List<PurchaseReturn> purchaseReturns;
	
	@Expose
	@Column(name = "expiry_adj_amount")
	private double expiryAdjAmount;
	
	@Expose
	@Transient
	private List<ExpiryPurchaseMapping> expiryReturns;
	
	@Expose
	@Column(name = "due_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;
	
	@Expose
	@Transient
	private String purchaseOrderInvNo;
	
	@Expose
	@Transient
	private List<String> itemNotFndList;
	
	//12.03.2018
	@Expose
	@Transient
	private List<PurchaseReturnLedger> prls;
	
	@Expose
	@Transient
	private int duties_ledger_id;
	@Expose
	@Transient
	private int round_ledger_id;
	@Expose
	@Transient
	private int purchase_ledger_id;
	@Expose
	@Transient
	private int discount_ledger_id;
	@Expose
	@Transient
	private int credior_ledger_id;
	@Expose
	@Transient
	private int lotadjas_ledger_id;
	@Expose
	@Transient
	private String qs;
	
	@Expose
	@Column(name = "creditor_amt")
	private double creditor_amt;
	
	//06.04.2018
	@Expose
	@Transient
	private int is_account;
	   
	   
	public Purchase() { }
	
	public List<String> getItemNotFndList() {
		return itemNotFndList;
	}

	public void setItemNotFndList(List<String> itemNotFndList) {
		this.itemNotFndList = itemNotFndList;
	}

	public String getPurchaseOrderInvNo() {
		return purchaseOrderInvNo;
	}

	@XmlElement
	public void setPurchaseOrderInvNo(String purchaseOrderInvNo) {
		this.purchaseOrderInvNo = purchaseOrderInvNo;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<ExpiryPurchaseMapping> getExpiryReturns() {
		return expiryReturns;
	}

	public void setExpiryReturns(List<ExpiryPurchaseMapping> expiryReturns) {
		this.expiryReturns = expiryReturns;
	}

	public double getExpiryAdjAmount() {
		return expiryAdjAmount;
	}

	@XmlElement
	public void setExpiryAdjAmount(double expiryAdjAmount) {
		this.expiryAdjAmount = expiryAdjAmount;
	}

	public List<PurchaseReturn> getPurchaseReturns() {
		return purchaseReturns;
	}

	public void setPurchaseReturns(List<PurchaseReturn> purchaseReturns) {
		this.purchaseReturns = purchaseReturns;
	}

	public int getPaymentId() {
		return paymentId;
	}

	@XmlElement
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAdvAmount() {
		return advAmount;
	}

	@XmlElement
	public void setAdvAmount(double advAmount) {
		this.advAmount = advAmount;
	}

	public double getDistributorBillAmount() {
		return distributorBillAmount;
	}

	@XmlElement
	public void setDistributorBillAmount(double distributorBillAmount) {
		this.distributorBillAmount = distributorBillAmount;
	}

	public double getOtherAdjAmount() {
		return otherAdjAmount;
	}

	@XmlElement
	public void setOtherAdjAmount(double otherAdjAmount) {
		this.otherAdjAmount = otherAdjAmount;
	}

	public double getDistDiscPer() {
		return distDiscPer;
	}

	@XmlElement
	public void setDistDiscPer(double distDiscPer) {
		this.distDiscPer = distDiscPer;
	}

	public double getSpecDiscPer() {
		return specDiscPer;
	}

	@XmlElement
	public void setSpecDiscPer(double specDiscPer) {
		this.specDiscPer = specDiscPer;
	}

	public double getSpecDiscAmount() {
		return specDiscAmount;
	}

	@XmlElement
	public void setSpecDiscAmount(double specDiscAmount) {
		this.specDiscAmount = specDiscAmount;
	}

	public String getBillNo() {
		return billNo;
	}

	@XmlElement
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getFinyrCode() {
		return finyrCode;
	}

	@XmlElement
	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}

	public double getTotalMrp() {
		return totalMrp;
	}

	@XmlElement
	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public List<PurchaseDetails> getPurchaseDetails() {
		return purchaseDetails;
	}

	// @XmlElementWrapper
	// @XmlElement
	public void setPurchaseDetails(List<PurchaseDetails> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	public String getDistName() {
		return distName;
	}

	@XmlElement
	public void setDistName(String distName) {
		this.distName = distName;
	}

	public String getInvModeName() {
		return invModeName;
	}

	@XmlElement
	public void setInvModeName(String invModeName) {
		this.invModeName = invModeName;
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

	public int getPoOrderId() {
		return poOrderId;
	}

	@XmlElement
	public void setPoOrderId(int poOrderId) {
		this.poOrderId = poOrderId;
	}

	public int getPurchaseReturnId() {
		return purchaseReturnId;
	}

	@XmlElement
	public void setPurchaseReturnId(int purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
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

	public double getLotAdjAmount() {
		return lotAdjAmount;
	}

	@XmlElement
	public void setLotAdjAmount(double lotAdjAmount) {
		this.lotAdjAmount = lotAdjAmount;
	}

	public double getRoundoff() {
		return roundoff;
	}

	@XmlElement
	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}

	public double getCst() {
		return cst;
	}

	@XmlElement
	public void setCst(double cst) {
		this.cst = cst;
	}

	public double getVatDiff() {
		return vatDiff;
	}

	@XmlElement
	public void setVatDiff(double vatDiff) {
		this.vatDiff = vatDiff;
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

	public String getQryCondition() {
		return qryCondition;
	}

	@XmlElement
	public void setQryCondition(String qryCondition) {
		this.qryCondition = qryCondition;
	}

	public List<PurchaseReturnLedger> getPrls() {
		return prls;
	}

	public void setPrls(List<PurchaseReturnLedger> prls) {
		this.prls = prls;
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

	public int getPurchase_ledger_id() {
		return purchase_ledger_id;
	}

	@XmlElement
	public void setPurchase_ledger_id(int purchase_ledger_id) {
		this.purchase_ledger_id = purchase_ledger_id;
	}

	public int getDiscount_ledger_id() {
		return discount_ledger_id;
	}

	@XmlElement
	public void setDiscount_ledger_id(int discount_ledger_id) {
		this.discount_ledger_id = discount_ledger_id;
	}

	public int getCredior_ledger_id() {
		return credior_ledger_id;
	}

	@XmlElement
	public void setCredior_ledger_id(int credior_ledger_id) {
		this.credior_ledger_id = credior_ledger_id;
	}

	public int getLotadjas_ledger_id() {
		return lotadjas_ledger_id;
	}

	@XmlElement
	public void setLotadjas_ledger_id(int lotadjas_ledger_id) {
		this.lotadjas_ledger_id = lotadjas_ledger_id;
	}

	public String getQs() {
		return qs;
	}

	@XmlElement
	public void setQs(String qs) {
		this.qs = qs;
	}

	public double getCreditor_amt() {
		return creditor_amt;
	}

	@XmlElement
	public void setCreditor_amt(double creditor_amt) {
		this.creditor_amt = creditor_amt;
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
		return "Purchase [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", poOrderId=" + poOrderId
				+ ", purchaseReturnId=" + purchaseReturnId + ", invMode=" + invMode + ", distributorId=" + distributorId
				+ ", grossAmount=" + grossAmount + ", edAmount=" + edAmount + ", discAmount=" + discAmount
				+ ", taxAmount=" + taxAmount + ", vatAmount=" + vatAmount + ", adjAmount=" + adjAmount + ", netAmount="
				+ netAmount + ", lotAdjAmount=" + lotAdjAmount + ", roundoff=" + roundoff + ", cst=" + cst
				+ ", vatDiff=" + vatDiff + ", remarks=" + remarks + ", isPosted=" + isPosted + ", pstId=" + pstId
				+ ", pstNo=" + pstNo + ", finyrId=" + finyrId + ", storeId=" + storeId + ", companyId=" + companyId
				+ ", isDeleted=" + isDeleted + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", lang=" + lang + ", qryCondition="
				+ qryCondition + ", invModeName=" + invModeName + ", distName=" + distName + ", totalMrp=" + totalMrp
				+ ", purchaseDetails=" + purchaseDetails + ", finyrCode=" + finyrCode + ", billNo=" + billNo
				+ ", specDiscPer=" + specDiscPer + ", specDiscAmount=" + specDiscAmount + ", distDiscPer=" + distDiscPer
				+ ", paymentId=" + paymentId + ", advAmount=" + advAmount + ", distributorBillAmount="
				+ distributorBillAmount + ", otherAdjAmount=" + otherAdjAmount + ", purchaseReturns=" + purchaseReturns
				+ ", expiryAdjAmount=" + expiryAdjAmount + ", expiryReturns=" + expiryReturns + ", dueDate=" + dueDate
				+ ", purchaseOrderInvNo=" + purchaseOrderInvNo + ", itemNotFndList=" + itemNotFndList + ", prls=" + prls
				+ ", duties_ledger_id=" + duties_ledger_id + ", round_ledger_id=" + round_ledger_id
				+ ", purchase_ledger_id=" + purchase_ledger_id + ", discount_ledger_id=" + discount_ledger_id
				+ ", credior_ledger_id=" + credior_ledger_id + ", lotadjas_ledger_id=" + lotadjas_ledger_id + ", qs="
				+ qs + ", creditor_amt=" + creditor_amt + ", is_account=" + is_account + "]";
	}

	public Purchase(int id, String invNo, Date invDate, int poOrderId, int purchaseReturnId, int invMode,
			int distributorId, double grossAmount, double edAmount, double discAmount, double taxAmount,
			double vatAmount, double adjAmount, double netAmount, double lotAdjAmount, double roundoff, double cst,
			double vatDiff, String remarks, int isPosted, int pstId, String pstNo, int finyrId, int storeId,
			int companyId, int isDeleted, int createdBy, Date createdDate, int updatedBy, Date updatedDate, String lang,
			String qryCondition, String invModeName, String distName, double totalMrp,
			List<PurchaseDetails> purchaseDetails, String finyrCode, String billNo, double specDiscPer,
			double specDiscAmount, double distDiscPer, int paymentId, double advAmount, double distributorBillAmount,
			double otherAdjAmount, List<PurchaseReturn> purchaseReturns, double expiryAdjAmount,
			List<ExpiryPurchaseMapping> expiryReturns, Date dueDate, String purchaseOrderInvNo,
			List<String> itemNotFndList, List<PurchaseReturnLedger> prls, int duties_ledger_id, int round_ledger_id,
			int purchase_ledger_id, int discount_ledger_id, int credior_ledger_id, int lotadjas_ledger_id, String qs,
			double creditor_amt, int is_account) {
		super();
		this.id = id;
		this.invNo = invNo;
		this.invDate = invDate;
		this.poOrderId = poOrderId;
		this.purchaseReturnId = purchaseReturnId;
		this.invMode = invMode;
		this.distributorId = distributorId;
		this.grossAmount = grossAmount;
		this.edAmount = edAmount;
		this.discAmount = discAmount;
		this.taxAmount = taxAmount;
		this.vatAmount = vatAmount;
		this.adjAmount = adjAmount;
		this.netAmount = netAmount;
		this.lotAdjAmount = lotAdjAmount;
		this.roundoff = roundoff;
		this.cst = cst;
		this.vatDiff = vatDiff;
		this.remarks = remarks;
		this.isPosted = isPosted;
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
		this.qryCondition = qryCondition;
		this.invModeName = invModeName;
		this.distName = distName;
		this.totalMrp = totalMrp;
		this.purchaseDetails = purchaseDetails;
		this.finyrCode = finyrCode;
		this.billNo = billNo;
		this.specDiscPer = specDiscPer;
		this.specDiscAmount = specDiscAmount;
		this.distDiscPer = distDiscPer;
		this.paymentId = paymentId;
		this.advAmount = advAmount;
		this.distributorBillAmount = distributorBillAmount;
		this.otherAdjAmount = otherAdjAmount;
		this.purchaseReturns = purchaseReturns;
		this.expiryAdjAmount = expiryAdjAmount;
		this.expiryReturns = expiryReturns;
		this.dueDate = dueDate;
		this.purchaseOrderInvNo = purchaseOrderInvNo;
		this.itemNotFndList = itemNotFndList;
		this.prls = prls;
		this.duties_ledger_id = duties_ledger_id;
		this.round_ledger_id = round_ledger_id;
		this.purchase_ledger_id = purchase_ledger_id;
		this.discount_ledger_id = discount_ledger_id;
		this.credior_ledger_id = credior_ledger_id;
		this.lotadjas_ledger_id = lotadjas_ledger_id;
		this.qs = qs;
		this.creditor_amt = creditor_amt;
		this.is_account = is_account;
	}

}