package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class StockDetailsAdjustmentDTO implements Serializable {
	
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;
	
	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;

	@Expose
	@MapToData(columnAliases = { "item_name" })
	private String itemName;
	
	@Expose
	@MapToData(columnAliases = { "SKU" })
	private String sku;
	
	@Expose
	@MapToData(columnAliases = { "HSN_code" })
	private String hsnCode;

	@Expose
	@MapToData(columnAliases = { "batch_no" })
	private String batchNo;

	@Expose
	@MapToData(columnAliases = { "expiry_date" })
	private Date expiryDate;

	@Expose
	@MapToData(columnAliases = { "expiry_date_format" })
	private String expiryDateFormat;
	
	@Expose
	@MapToData(columnAliases = { "pack_qty" })
	private int packQty;
	
	@Expose
	@MapToData(columnAliases = { "conversion" })
	private int conversion;
	
	@Expose
	@MapToData(columnAliases = { "loose_qty" })
	private int looseQty;

	@Expose
	@MapToData(columnAliases = { "pack_unit_id" })
	private int packUnitId;

	@Expose
	@MapToData(columnAliases = { "pack_unit_name" })
	private String packUnitName;	

	@Expose
	@MapToData(columnAliases ={ "as_on_date"})
	private Date asOnDate;

	@Expose
	@MapToData(columnAliases = { "mrp" })
	private double mrp;

	@Expose
	@MapToData(columnAliases = { "rate" })
	private double rate;
	
	@Expose
	@MapToData(columnAliases = { "sale_rate" })
	private double saleRate;
	
	@Expose
	@MapToData(columnAliases = { "distributor_id" })
	private int distributorId;
	
	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String distributorName;
	
	@Expose
	@MapToData(columnAliases = { "remaining_loose_qty" })
	private int remainingLooseQty;
	
	
	@Expose
	@MapToData(columnAliases = { "is_sale" })
	private int isSale;
	
	@Expose
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;
	
	@Expose
	@MapToData(columnAliases = { "tax_percentage" })
	private double taxPercentage;
	
	@Expose
	private int companyId;
	
	@Expose
	private int storeId;
	
	@Expose
	private int finyrId;
	
	@Expose
	private int createdBy;
	
	private static final long serialVersionUID = 1L;
	
	
	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getFinyrId() {
		return finyrId;
	}

	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}

	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}

	public int getPackQty() {
		return packQty;
	}

	public void setPackQty(int packQty) {
		this.packQty = packQty;
	}

	public int getConversion() {
		return conversion;
	}

	public void setConversion(int conversion) {
		this.conversion = conversion;
	}

	public int getLooseQty() {
		return looseQty;
	}

	public void setLooseQty(int looseQty) {
		this.looseQty = looseQty;
	}

	public int getPackUnitId() {
		return packUnitId;
	}

	public void setPackUnitId(int packUnitId) {
		this.packUnitId = packUnitId;
	}

	public String getPackUnitName() {
		return packUnitName;
	}

	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}

	public Date getAsOnDate() {
		return asOnDate;
	}

	public void setAsOnDate(Date asOnDate) {
		this.asOnDate = asOnDate;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public int getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public int getRemainingLooseQty() {
		return remainingLooseQty;
	}

	public void setRemainingLooseQty(int remainingLooseQty) {
		this.remainingLooseQty = remainingLooseQty;
	}

	public int getIsSale() {
		return isSale;
	}

	public void setIsSale(int isSale) {
		this.isSale = isSale;
	}
	
		
}