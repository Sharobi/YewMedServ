package com.sharobi.pharmacy.procurement.model;

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
 * Entity implementation class for Entity: pur_t_purchase_return_details
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pur_t_purchase_return_details")
public class PurchaseReturnDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "purchase_return_id")
	private int purchaseReturnId;

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
	@Column(name = "ed_per")
	private double edPer;

	@Expose
	@Column(name = "ed")
	private double ed;

	@Expose
	@Column(name = "tax_per")
	private double taxPer;

	@Expose
	@Column(name = "tax")
	private double tax;

	@Expose
	@Column(name = "vat_per")
	private double vatPer;

	@Expose
	@Column(name = "vat")
	private double vat;

	@Expose
	@Column(name = "disc_per")
	private double discPer;

	@Expose
	@Column(name = "disc")
	private double disc;

	@Expose
	@Column(name = "tot_amount")
	private double totAmount;

	@Expose
	@Column(name = "finyr_id")
	private int finyrId;

	@Expose
	@Column(name = "purchase_id")
	private int purchaseId;

	@Expose
	@Column(name = "store_id")
	private int storeId;

	@Expose
	@Column(name = "company_id")
	private int companyId;

	@Expose
	@Transient
	private String lang;
	
	@Expose
	@Transient
	private String expiryDateFormat;
	
	@Expose
	@Column(name = "purchase_inv_no")
	private String purchaseInvNo;
	
	@Expose
	@Column(name = "item_lot_adj_amount")
	private double itemLotAdjAmount;
	
	@Expose
	@Column(name =  "tax_id" )
	private int taxId;
	
		
	@Expose
	@Column(name =  "tax_percentage" )
	private double taxPercentage;
	
	@Expose
	@Column(name =  "tax_amount" )
	private double taxAmount;
	
	@Expose
	@Column(name =  "is_group_tax" )
	private int isGroupTax;
	
	@Expose
	@Column(name =  "tax_mode" )
	private String taxMode;
	
	@Expose
	@Column(name = "reason_id")
	private int reasonId;
	
	public PurchaseReturnDetails() { }
	
	public int getReasonId() {
		return reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}

	public int getTaxId() {
		return taxId;
	}
	
	@XmlElement
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	@XmlElement
	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	@XmlElement
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public int getIsGroupTax() {
		return isGroupTax;
	}

	@XmlElement
	public void setIsGroupTax(int isGroupTax) {
		this.isGroupTax = isGroupTax;
	}

	public String getTaxMode() {
		return taxMode;
	}

	@XmlElement
	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public double getItemLotAdjAmount() {
		return itemLotAdjAmount;
	}

	@XmlElement
	public void setItemLotAdjAmount(double itemLotAdjAmount) {
		this.itemLotAdjAmount = itemLotAdjAmount;
	}

	public String getPurchaseInvNo() {
		return purchaseInvNo;
	}

	@XmlElement
	public void setPurchaseInvNo(String purchaseInvNo) {
		this.purchaseInvNo = purchaseInvNo;
	}

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

	public double getEdPer() {
		return edPer;
	}

	@XmlElement
	public void setEdPer(double edPer) {
		this.edPer = edPer;
	}

	public double getEd() {
		return ed;
	}

	@XmlElement
	public void setEd(double ed) {
		this.ed = ed;
	}

	public double getTaxPer() {
		return taxPer;
	}

	@XmlElement
	public void setTaxPer(double taxPer) {
		this.taxPer = taxPer;
	}

	public double getTax() {
		return tax;
	}

	@XmlElement
	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getVatPer() {
		return vatPer;
	}

	@XmlElement
	public void setVatPer(double vatPer) {
		this.vatPer = vatPer;
	}

	public double getVat() {
		return vat;
	}

	@XmlElement
	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getDiscPer() {
		return discPer;
	}

	@XmlElement
	public void setDiscPer(double discPer) {
		this.discPer = discPer;
	}

	public double getDisc() {
		return disc;
	}

	@XmlElement
	public void setDisc(double disc) {
		this.disc = disc;
	}

	public double getTotAmount() {
		return totAmount;
	}

	@XmlElement
	public void setTotAmount(double totAmount) {
		this.totAmount = totAmount;
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

	public String getLang() {
		return lang;
	}

	@XmlElement
	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getPurchaseReturnId() {
		return purchaseReturnId;
	}

	@XmlElement
	public void setPurchaseReturnId(int purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}

	public double getFreeQty() {
		return freeQty;
	}

	@XmlElement
	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	@XmlElement
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	@Override
	public String toString() {
		return "PurchaseReturnDetails [id=" + id + ", purchaseReturnId=" + purchaseReturnId + ", invNo=" + invNo
				+ ", invDate=" + invDate + ", itemId=" + itemId + ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", packUnitId=" + packUnitId + ", packQty=" + packQty + ", conversion=" + conversion + ", looseQty="
				+ looseQty + ", freeQty=" + freeQty + ", mrp=" + mrp + ", rate=" + rate + ", amount=" + amount
				+ ", edPer=" + edPer + ", ed=" + ed + ", taxPer=" + taxPer + ", tax=" + tax + ", vatPer=" + vatPer
				+ ", vat=" + vat + ", discPer=" + discPer + ", disc=" + disc + ", totAmount=" + totAmount + ", finyrId="
				+ finyrId + ", purchaseId=" + purchaseId + ", storeId=" + storeId + ", companyId=" + companyId
				+ ", lang=" + lang + ", expiryDateFormat=" + expiryDateFormat + ", purchaseInvNo=" + purchaseInvNo
				+ ", itemLotAdjAmount=" + itemLotAdjAmount + ", taxId=" + taxId + ", taxPercentage=" + taxPercentage
				+ ", taxAmount=" + taxAmount + ", isGroupTax=" + isGroupTax + ", taxMode=" + taxMode + ", reasonId="
				+ reasonId + "]";
	}

	public PurchaseReturnDetails(int id, int purchaseReturnId, String invNo, Date invDate, int itemId, String batchNo,
			Date expiryDate, int packUnitId, int packQty, int conversion, int looseQty, double freeQty, double mrp,
			double rate, double amount, double edPer, double ed, double taxPer, double tax, double vatPer, double vat,
			double discPer, double disc, double totAmount, int finyrId, int purchaseId, int storeId, int companyId,
			String lang, String expiryDateFormat, String purchaseInvNo, double itemLotAdjAmount, int taxId,
			double taxPercentage, double taxAmount, int isGroupTax, String taxMode, int reasonId) {
		super();
		this.id = id;
		this.purchaseReturnId = purchaseReturnId;
		this.invNo = invNo;
		this.invDate = invDate;
		this.itemId = itemId;
		this.batchNo = batchNo;
		this.expiryDate = expiryDate;
		this.packUnitId = packUnitId;
		this.packQty = packQty;
		this.conversion = conversion;
		this.looseQty = looseQty;
		this.freeQty = freeQty;
		this.mrp = mrp;
		this.rate = rate;
		this.amount = amount;
		this.edPer = edPer;
		this.ed = ed;
		this.taxPer = taxPer;
		this.tax = tax;
		this.vatPer = vatPer;
		this.vat = vat;
		this.discPer = discPer;
		this.disc = disc;
		this.totAmount = totAmount;
		this.finyrId = finyrId;
		this.purchaseId = purchaseId;
		this.storeId = storeId;
		this.companyId = companyId;
		this.lang = lang;
		this.expiryDateFormat = expiryDateFormat;
		this.purchaseInvNo = purchaseInvNo;
		this.itemLotAdjAmount = itemLotAdjAmount;
		this.taxId = taxId;
		this.taxPercentage = taxPercentage;
		this.taxAmount = taxAmount;
		this.isGroupTax = isGroupTax;
		this.taxMode = taxMode;
		this.reasonId = reasonId;
	}
		
}