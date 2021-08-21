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
 * Entity implementation class for Entity: pur_t_purchase_order_details
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pur_t_purchase_order_details")
public class PurchaseOrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "purchase_order_id")
	private int purchaseOrderId;

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
	@Column(name = "rec_pack_qty")
	private int recPackQty;
	
	@Expose
	@Column(name = "rec_loose_qty")
	private int recLooseQty;
	
	@Expose
	@Column(name = "mrp")
	private double mrp;
	
	@Expose
	@Column(name = "rate")
	private double rate;
	
	@Expose
	@Column(name = "sale_rate")
	private double saleRate;

	@Expose
	@Column(name = "gross_amount")
	private double grossAmount;
	
	@Expose
	@Column(name = "disc_per")
	private double discPer;

	@Expose
	@Column(name = "disc")
	private double disc;
	
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
	@Column(name = "tax_mode")
	private String taxMode;
	
	@Expose
	@Column(name = "is_group_tax")
	private int isGroupTax;
	
	@Expose
	@Column(name = "net_amount")
	private double netAmount;
	
	@Expose
	@Column(name = "tmp_id")
	private int	tmpId;
	
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
	@Transient
	private String lang;
	
	@Expose
	@Column(name = "inv_type")
	private String invType;
	
	@Expose
	@Column(name = "item_total_mrp")
	private double itemTotalMrp;
	
	

	public double getItemTotalMrp() {
		return itemTotalMrp;
	}

	@XmlElement
	public void setItemTotalMrp(double itemTotalMrp) {
		this.itemTotalMrp = itemTotalMrp;
	}

	public String getInvType() {
		return invType;
	}

	@XmlElement
	public void setInvType(String invType) {
		this.invType = invType;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	@XmlElement
	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
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

	public double getFreeQty() {
		return freeQty;
	}

	@XmlElement
	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}

	public int getRecPackQty() {
		return recPackQty;
	}

	@XmlElement
	public void setRecPackQty(int recPackQty) {
		this.recPackQty = recPackQty;
	}

	public int getRecLooseQty() {
		return recLooseQty;
	}

	@XmlElement
	public void setRecLooseQty(int recLooseQty) {
		this.recLooseQty = recLooseQty;
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

	public double getSaleRate() {
		return saleRate;
	}

	@XmlElement
	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	@XmlElement
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
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

	public String getTaxMode() {
		return taxMode;
	}

	@XmlElement
	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public int getIsGroupTax() {
		return isGroupTax;
	}

	@XmlElement
	public void setIsGroupTax(int isGroupTax) {
		this.isGroupTax = isGroupTax;
	}

	public double getNetAmount() {
		return netAmount;
	}

	@XmlElement
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public int getTmpId() {
		return tmpId;
	}

	@XmlElement
	public void setTmpId(int tmpId) {
		this.tmpId = tmpId;
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
	

}