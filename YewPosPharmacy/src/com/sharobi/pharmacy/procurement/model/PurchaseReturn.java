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

import net.sf.resultsetmapper.MapToData;

/**
 * Entity implementation class for Entity: pur_t_purchase_return
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pur_t_purchase_return")
public class PurchaseReturn implements Serializable {

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
	@Column(name = "purchase_id")
	private int purchaseId;
	
	@Expose
	@Column(name = "inv_mode")
	private int invMode;
	
	@Expose
	@Column(name = "inv_type")
	private int invType;
	
	@Expose
	@Column(name = "based_on")
	private int basedOn;
	
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
	@Column(name = "lot_adj_amount")
	private double lotAdjAmount;
		
	@Expose
	@Column(name = "spc_dis")
	private double spcDis;
	
	@Expose
	@Column(name = "spc_dis_amount")
	private double spcDisAmount;
	
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
	@Column(name = "credit_note")
	private String creditNote;
	
	@Expose
	@Column(name = "remarks")
	private String remarks;
	
	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;
	
	@Expose
	@Column(name = "is_posted")
	private int isposted;

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
	private List<PurchaseReturnDetails> purchaseReturnDetails;
	
	@Expose
	@Transient
	private String finyrCode;
	
	//08.03.2018
	
	@Expose
	@Transient
	private List<PurchaseReturnLedger> prls;
	
	@Expose
	@Transient
	@MapToData(columnAliases = { "creditor_debit_amt"})
	private double creditor_debit_amt;
	
	@Expose
	@Transient
	@MapToData(columnAliases = { "duties_ledger_id"})
	private int duties_ledger_id;
	@Expose
	@Transient
	@MapToData(columnAliases = { "round_ledger_id"})
	private int round_ledger_id;
	@Expose
	@Transient
	@MapToData(columnAliases = { "purchase_ledger_id"})
	private int purchase_ledger_id;
	@Expose
	@Transient
	@MapToData(columnAliases = { "discount_ledger_id"})
	private int discount_ledger_id;
	@Expose
	@Transient
	@MapToData(columnAliases = { "creditor_ledger_id"})
	private int creditor_ledger_id;
	@Expose
	@Transient
	@MapToData(columnAliases = { "lot_ledger_id"})
	private int lot_ledger_id;
	@Expose
	@Transient
	private String qs;
	
	//06.04.2018
	@Expose
	@Transient
	private int is_account;
	
	public PurchaseReturn() { }
	
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

	
	public List<PurchaseReturnDetails> getPurchaseReturnDetails() {
		return purchaseReturnDetails;
	}

	public void setPurchaseReturnDetails(
			List<PurchaseReturnDetails> purchaseReturnDetails) {
		this.purchaseReturnDetails = purchaseReturnDetails;
	}

	public int getIsposted() {
		return isposted;
	}

	@XmlElement
	public void setIsposted(int isposted) {
		this.isposted = isposted;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	@XmlElement
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getInvType() {
		return invType;
	}

	@XmlElement
	public void setInvType(int invType) {
		this.invType = invType;
	}

	public int getBasedOn() {
		return basedOn;
	}

	@XmlElement
	public void setBasedOn(int basedOn) {
		this.basedOn = basedOn;
	}

	public int getDistributorId() {
		return distributorId;
	}

	@XmlElement
	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public double getLotAdjAmount() {
		return lotAdjAmount;
	}

	@XmlElement
	public void setLotAdjAmount(double lotAdjAmount) {
		this.lotAdjAmount = lotAdjAmount;
	}

	public double getSpcDis() {
		return spcDis;
	}

	@XmlElement
	public void setSpcDis(double spcDis) {
		this.spcDis = spcDis;
	}

	public double getSpcDisAmount() {
		return spcDisAmount;
	}

	@XmlElement
	public void setSpcDisAmount(double spcDisAmount) {
		this.spcDisAmount = spcDisAmount;
	}

	public double getTotalMrp() {
		return totalMrp;
	}

	@XmlElement
	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public String getCreditNote() {
		return creditNote;
	}

	@XmlElement
	public void setCreditNote(String creditNote) {
		this.creditNote = creditNote;
	}

	public List<PurchaseReturnLedger> getPrls() {
		return prls;
	}

	public void setPrls(List<PurchaseReturnLedger> prls) {
		this.prls = prls;
	}

	public double getCreditor_debit_amt() {
		return creditor_debit_amt;
	}

	@XmlElement
	public void setCreditor_debit_amt(double creditor_debit_amt) {
		this.creditor_debit_amt = creditor_debit_amt;
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

	public int getCreditor_ledger_id() {
		return creditor_ledger_id;
	}

	@XmlElement
	public void setCreditor_ledger_id(int creditor_ledger_id) {
		this.creditor_ledger_id = creditor_ledger_id;
	}

	public String getQs() {
		return qs;
	}

	@XmlElement
	public void setQs(String qs) {
		this.qs = qs;
	}

	public int getLot_ledger_id() {
		return lot_ledger_id;
	}

	@XmlElement
	public void setLot_ledger_id(int lot_ledger_id) {
		this.lot_ledger_id = lot_ledger_id;
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
		return "PurchaseReturn [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", purchaseId=" + purchaseId
				+ ", invMode=" + invMode + ", invType=" + invType + ", basedOn=" + basedOn + ", distributorId="
				+ distributorId + ", grossAmount=" + grossAmount + ", edAmount=" + edAmount + ", discAmount="
				+ discAmount + ", taxAmount=" + taxAmount + ", vatAmount=" + vatAmount + ", adjAmount=" + adjAmount
				+ ", lotAdjAmount=" + lotAdjAmount + ", spcDis=" + spcDis + ", spcDisAmount=" + spcDisAmount
				+ ", roundoff=" + roundoff + ", netAmount=" + netAmount + ", totalMrp=" + totalMrp + ", creditNote="
				+ creditNote + ", remarks=" + remarks + ", isDeleted=" + isDeleted + ", isposted=" + isposted
				+ ", pstId=" + pstId + ", pstNo=" + pstNo + ", finyrId=" + finyrId + ", storeId=" + storeId
				+ ", companyId=" + companyId + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", lang=" + lang
				+ ", purchaseReturnDetails=" + purchaseReturnDetails + ", finyrCode=" + finyrCode + ", prls=" + prls
				+ ", creditor_debit_amt=" + creditor_debit_amt + ", duties_ledger_id=" + duties_ledger_id
				+ ", round_ledger_id=" + round_ledger_id + ", purchase_ledger_id=" + purchase_ledger_id
				+ ", discount_ledger_id=" + discount_ledger_id + ", creditor_ledger_id=" + creditor_ledger_id
				+ ", lot_ledger_id=" + lot_ledger_id + ", qs=" + qs + ", is_account=" + is_account + "]";
	}

	public PurchaseReturn(int id, String invNo, Date invDate, int purchaseId, int invMode, int invType, int basedOn,
			int distributorId, double grossAmount, double edAmount, double discAmount, double taxAmount,
			double vatAmount, double adjAmount, double lotAdjAmount, double spcDis, double spcDisAmount,
			double roundoff, double netAmount, double totalMrp, String creditNote, String remarks, int isDeleted,
			int isposted, int pstId, String pstNo, int finyrId, int storeId, int companyId, int createdBy,
			Date createdDate, int updatedBy, Date updatedDate, String lang,
			List<PurchaseReturnDetails> purchaseReturnDetails, String finyrCode, List<PurchaseReturnLedger> prls,
			double creditor_debit_amt, int duties_ledger_id, int round_ledger_id, int purchase_ledger_id,
			int discount_ledger_id, int creditor_ledger_id, int lot_ledger_id, String qs, int is_account) {
		super();
		this.id = id;
		this.invNo = invNo;
		this.invDate = invDate;
		this.purchaseId = purchaseId;
		this.invMode = invMode;
		this.invType = invType;
		this.basedOn = basedOn;
		this.distributorId = distributorId;
		this.grossAmount = grossAmount;
		this.edAmount = edAmount;
		this.discAmount = discAmount;
		this.taxAmount = taxAmount;
		this.vatAmount = vatAmount;
		this.adjAmount = adjAmount;
		this.lotAdjAmount = lotAdjAmount;
		this.spcDis = spcDis;
		this.spcDisAmount = spcDisAmount;
		this.roundoff = roundoff;
		this.netAmount = netAmount;
		this.totalMrp = totalMrp;
		this.creditNote = creditNote;
		this.remarks = remarks;
		this.isDeleted = isDeleted;
		this.isposted = isposted;
		this.pstId = pstId;
		this.pstNo = pstNo;
		this.finyrId = finyrId;
		this.storeId = storeId;
		this.companyId = companyId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.lang = lang;
		this.purchaseReturnDetails = purchaseReturnDetails;
		this.finyrCode = finyrCode;
		this.prls = prls;
		this.creditor_debit_amt = creditor_debit_amt;
		this.duties_ledger_id = duties_ledger_id;
		this.round_ledger_id = round_ledger_id;
		this.purchase_ledger_id = purchase_ledger_id;
		this.discount_ledger_id = discount_ledger_id;
		this.creditor_ledger_id = creditor_ledger_id;
		this.lot_ledger_id = lot_ledger_id;
		this.qs = qs;
		this.is_account = is_account;
	}

}