package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ItemDTO implements Serializable {
	
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;
	
	@Expose
	@MapToData(columnAliases = { "name" })
	private String name;
	
	@Expose
	@MapToData(columnAliases = { "code" })
	private String code;


	@Expose
	@MapToData(columnAliases = { "HSN_code" })
	private String hsnCode;

	@Expose
	@MapToData(columnAliases = { "SKU" })
	private String sku;

	@Expose
	@MapToData(columnAliases = { "group_id" })
	private int groupId;	

	@Expose
	@MapToData(columnAliases = { "category_id" })
	private int categoryId;

	@Expose
	@MapToData(columnAliases = { "sub_category_id" })
	private int subCategoryId;
	
	@Expose
	@MapToData(columnAliases = { "schedule_id" })
	private int scheduleId;
	
	@Expose
	@MapToData(columnAliases = { "content_id" })
	private int contentId;

	@Expose
	@MapToData(columnAliases = { "brand_id" })
	private int brandId;

	@Expose
	@MapToData(columnAliases = { "manufacturer_id" })
	private int manufacturerId;

	@Expose
	@MapToData(columnAliases = { "entry_date" })
	private Date entryDate;

	@Expose
	@MapToData(columnAliases = { "VAT" })
	private double vat;

	@Expose
	@MapToData(columnAliases = { "is_on_mrp" })
	private int isOnMrp;
	
	@Expose
	@MapToData(columnAliases = { "purchase_tax_id" })
	private int purchaseTaxId;
	
	@Expose
	@MapToData(columnAliases = { "purchase_tax_percentage" })
	private double purchaseTaxPercentage;
	
	@Expose
	@MapToData(columnAliases = { "sale_tax_id" })
	private int saleTaxId;
	
	@Expose
	@MapToData(columnAliases = { "sale_tax_percentage" })
	private double saleTaxPercentage;
	
	@Expose
	@MapToData(columnAliases = { "pack_unit_id" })
	private int packUnitId;
	
	@Expose
	@MapToData(columnAliases = { "conversion" })
	private int conversion;
	
	@Expose
	@MapToData(columnAliases = { "is_loose_sale" })
	private int isLooseSale;
	
	@Expose
	@MapToData(columnAliases = { "loose_unit_id" })
	private int looseUnitId;
	
	@Expose
	@MapToData(columnAliases = { "storage" })
	private String storage;
	
	@Expose
	@MapToData(columnAliases = { "care" })
	private String care;
	
	@Expose
	@MapToData(columnAliases = { "reorder_level" })
	private int reorderLevel;
	
	@Expose
	@MapToData(columnAliases = { "reorder_level_unit_id" })
	private int reorderLevelUnitId;
	
	@Expose
	@MapToData(columnAliases = { "price" })
	private double price;
	
	@Expose
	@MapToData(columnAliases = { "is_taxable" })
	private int isTaxable;
	
	@Expose
	@MapToData(columnAliases = { "markup" })
	private double markup;
	
	@Expose
	@MapToData(columnAliases = { "is_discount" })
	private int isDiscount;
	
	@Expose
	@MapToData(columnAliases = { "discount" })
	private double discount;
	
	@Expose
	@MapToData(columnAliases = { "max_discount_limit" })
	private double maxDiscountLimit;
	
	@Expose
	@MapToData(columnAliases = { "strength" })
	private String strength;
	
	@Expose
	@MapToData(columnAliases = { "net_content" })
	private String netContent;
	
	@Expose
	@MapToData(columnAliases = { "note" })
	private String note;
	
	
	@Expose
	@MapToData(columnAliases = { "tax_mode" })
	private String taxMode;
	
	@Expose
	@MapToData(columnAliases = { "is_group" })
	private int isGroup;
	
	private static final long serialVersionUID = 1L;
	
	

	public String getTaxMode() {
		return taxMode;
	}

	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public int getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(int isGroup) {
		this.isGroup = isGroup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	
	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public int getIsOnMrp() {
		return isOnMrp;
	}

	public void setIsOnMrp(int isOnMrp) {
		this.isOnMrp = isOnMrp;
	}

	public int getPurchaseTaxId() {
		return purchaseTaxId;
	}

	public void setPurchaseTaxId(int purchaseTaxId) {
		this.purchaseTaxId = purchaseTaxId;
	}

	public double getPurchaseTaxPercentage() {
		return purchaseTaxPercentage;
	}

	public void setPurchaseTaxPercentage(double purchaseTaxPercentage) {
		this.purchaseTaxPercentage = purchaseTaxPercentage;
	}

	public int getSaleTaxId() {
		return saleTaxId;
	}

	public void setSaleTaxId(int saleTaxId) {
		this.saleTaxId = saleTaxId;
	}

	public double getSaleTaxPercentage() {
		return saleTaxPercentage;
	}

	public void setSaleTaxPercentage(double saleTaxPercentage) {
		this.saleTaxPercentage = saleTaxPercentage;
	}

	public int getPackUnitId() {
		return packUnitId;
	}

	public void setPackUnitId(int packUnitId) {
		this.packUnitId = packUnitId;
	}

	public int getConversion() {
		return conversion;
	}

	public void setConversion(int conversion) {
		this.conversion = conversion;
	}

	public int getIsLooseSale() {
		return isLooseSale;
	}

	public void setIsLooseSale(int isLooseSale) {
		this.isLooseSale = isLooseSale;
	}

	public int getLooseUnitId() {
		return looseUnitId;
	}

	public void setLooseUnitId(int looseUnitId) {
		this.looseUnitId = looseUnitId;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getCare() {
		return care;
	}

	public void setCare(String care) {
		this.care = care;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getReorderLevelUnitId() {
		return reorderLevelUnitId;
	}

	public void setReorderLevelUnitId(int reorderLevelUnitId) {
		this.reorderLevelUnitId = reorderLevelUnitId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIsTaxable() {
		return isTaxable;
	}

	public void setIsTaxable(int isTaxable) {
		this.isTaxable = isTaxable;
	}

	public double getMarkup() {
		return markup;
	}

	public void setMarkup(double markup) {
		this.markup = markup;
	}

	public int getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(int isDiscount) {
		this.isDiscount = isDiscount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getMaxDiscountLimit() {
		return maxDiscountLimit;
	}

	public void setMaxDiscountLimit(double maxDiscountLimit) {
		this.maxDiscountLimit = maxDiscountLimit;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getNetContent() {
		return netContent;
	}

	public void setNetContent(String netContent) {
		this.netContent = netContent;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}