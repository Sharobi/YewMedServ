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
 * Entity implementation class for Entity: pur_t_purchase_details
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pur_t_purchase_details")
public class PurchaseDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "purchase_id")
	private int purchaseId;

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
	@Column(name = "store_id")
	private int storeId;

	@Expose
	@Column(name = "company_id")
	private int companyId;

	@Expose
	@Column(name = "free_qty")
	private double freeQty;

	@Expose
	@Transient
	private String lang;

	@Expose
	@Transient
	private String qryCondition;

	@Expose
	@Transient
	private String packUnitName;

	@Expose
	@Transient
	private String itemName;

	@Expose
	@Transient
	private int grpId;

	@Expose
	@Transient
	private String grpName;

	@Expose
	@Transient
	private int schdId;

	@Expose
	@Transient
	private String schdName;

	@Expose
	@Transient
	private int manuId;

	@Expose
	@Transient
	private String manuName;

	@Expose
	@Column(name = "expiry_date_format")
	private String expiryDateFormat;
	
	@Expose
	@Transient
	private String manuCode;
	
	@Expose
	@Transient
	private String itemUniqueKey;
	
	@Expose
	@Column(name = "item_lot_adj_amount")
	private double itemLotAdjAmount;
	
	@Expose
	@Column(name = "tax_id")
	private int taxId;
	
	@Expose
	@Column(name = "tax_percentage")
	private double taxPercentage;
	
	@Expose
	@Column(name = "tax_amount")
	private double taxAmount;
	
	@Expose
	@Transient
	private String taxName;
	
	@Expose
	@Transient
	private double taxableRate;
	
	@Expose
	@Column(name = "tax_mode")
	private String taxMode;
	
	@Expose
	@Column(name = "is_group_tax")
	private int isGroupTax;
	
	@Expose
	@Transient
	private int isTaxOnMrp;
	
	@Expose
	@Transient
	private String sku;
	
	@Expose
	@Column(name = "purchase_net_amount")
	private double purchaseNetAmount;
	
	@Expose
	@Transient
	private String hsnCode;
	
	@Expose
	@Column(name = "sale_rate")
	private double saleRate;
	
	@Expose
	@Column(name = "purchase_order_id")
	private int purchaseOrderId;
	
	@Expose
	@Transient
	private String purchaseOrderInvNo;
	
	
	public String getPurchaseOrderInvNo() {
		return purchaseOrderInvNo;
	}

	@XmlElement
	public void setPurchaseOrderInvNo(String purchaseOrderInvNo) {
		this.purchaseOrderInvNo = purchaseOrderInvNo;
	}

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public double getPurchaseNetAmount() {
		return purchaseNetAmount;
	}

	public void setPurchaseNetAmount(double purchaseNetAmount) {
		this.purchaseNetAmount = purchaseNetAmount;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getIsTaxOnMrp() {
		return isTaxOnMrp;
	}

	public void setIsTaxOnMrp(int isTaxOnMrp) {
		this.isTaxOnMrp = isTaxOnMrp;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public double getTaxableRate() {
		return taxableRate;
	}

	public void setTaxableRate(double taxableRate) {
		this.taxableRate = taxableRate;
	}

	

	public String getTaxMode() {
		return taxMode;
	}

	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public int getIsGroupTax() {
		return isGroupTax;
	}

	public void setIsGroupTax(int isGroupTax) {
		this.isGroupTax = isGroupTax;
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

	public double getItemLotAdjAmount() {
		return itemLotAdjAmount;
	}

	@XmlElement
	public void setItemLotAdjAmount(double itemLotAdjAmount) {
		this.itemLotAdjAmount = itemLotAdjAmount;
	}

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	@XmlElement
	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}

	public String getManuCode() {
		return manuCode;
	}

	public void setManuCode(String manuCode) {
		this.manuCode = manuCode;
	}

	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}

	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public int getSchdId() {
		return schdId;
	}

	public void setSchdId(int schdId) {
		this.schdId = schdId;
	}

	public String getSchdName() {
		return schdName;
	}

	public void setSchdName(String schdName) {
		this.schdName = schdName;
	}

	public int getManuId() {
		return manuId;
	}

	public void setManuId(int manuId) {
		this.manuId = manuId;
	}

	public String getManuName() {
		return manuName;
	}

	public void setManuName(String manuName) {
		this.manuName = manuName;
	}

	public String getItemName() {
		return itemName;
	}

	@XmlElement
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPackUnitName() {
		return packUnitName;
	}

	@XmlElement
	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}

	public double getFreeQty() {
		return freeQty;
	}

	@XmlElement
	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	@XmlElement
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
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

	public String getQryCondition() {
		return qryCondition;
	}

	@XmlElement
	public void setQryCondition(String qryCondition) {
		this.qryCondition = qryCondition;
	}

}