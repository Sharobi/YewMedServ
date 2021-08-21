package com.sharobi.pharmacy.sales.model;

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
 * Entity implementation class for Entity: sal_t_sale_details
 * 
 */

@XmlRootElement
@Entity
@Table(name = "sal_t_sale_details")
public class SalesDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "sale_id")
	private int saleId;

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
	@Column(name = "loose_unit_id")
	private int looseUnitId;

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
	@Column(name = "multiplier")
	private int multiplier;

	@Expose
	@Transient
	private String lang;
	
	@Expose
	@Transient
	private String expiryDateFormat;
	
	@Expose
	@Column(name = "mrp_per_unit")
	private double mrpPerUnit;
	
	@Expose
	@Column(name = "rate_per_unit")
	private double ratePerUnit;
	
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
	@Column(name = "is_group_tax")
	private int isGroupTax;
	
	@Expose
	@Column(name = "tax_mode")
	private String taxMode;
	
	@Expose
	@Column(name =  "purchase_cost_per_unit")
	private double purchaseCostPerUnit;
	
	@Expose
	@Column(name =  "item_total_mrp")
	private double itemTotalMrp;
	
	@Expose
	@Column(name =  "sale_rate")
	private double saleRate;
	
	@Expose
	@Column(name =  "is_exclusive")
	private int isExclusive;
	
	

	public int getIsExclusive() {
		return isExclusive;
	}

	public void setIsExclusive(int isExclusive) {
		this.isExclusive = isExclusive;
	}

	public double getSaleRate() {
		return saleRate;
	}

	@XmlElement
	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public double getItemTotalMrp() {
		return itemTotalMrp;
	}

	@XmlElement
	public void setItemTotalMrp(double itemTotalMrp) {
		this.itemTotalMrp = itemTotalMrp;
	}

	public double getPurchaseCostPerUnit() {
		return purchaseCostPerUnit;
	}

	@XmlElement
	public void setPurchaseCostPerUnit(double purchaseCostPerUnit) {
		this.purchaseCostPerUnit = purchaseCostPerUnit;
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

	public double getMrpPerUnit() {
		return mrpPerUnit;
	}

	@XmlElement
	public void setMrpPerUnit(double mrpPerUnit) {
		this.mrpPerUnit = mrpPerUnit;
	}

	public double getRatePerUnit() {
		return ratePerUnit;
	}

	@XmlElement
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
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

	public int getSaleId() {
		return saleId;
	}

	@XmlElement
	public void setSaleId(int saleId) {
		this.saleId = saleId;
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

	public int getLooseUnitId() {
		return looseUnitId;
	}

	@XmlElement
	public void setLooseUnitId(int looseUnitId) {
		this.looseUnitId = looseUnitId;
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

	public int getMultiplier() {
		return multiplier;
	}

	@XmlElement
	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	public String getLang() {
		return lang;
	}

	@XmlElement
	public void setLang(String lang) {
		this.lang = lang;
	}

}