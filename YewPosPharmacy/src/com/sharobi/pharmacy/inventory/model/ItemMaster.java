package com.sharobi.pharmacy.inventory.model;

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
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;
import com.sharobi.pharmacy.procurement.model.TaxMaster;

/**
 * Entity implementation class for Entity: in_m_item
 * 
 */

@XmlRootElement
@Entity
@Table(name = "in_m_item")
public class ItemMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "name")
	private String name;

	@Expose
	@Column(name = "code")
	private String code;

	@Expose
	@Column(name = "group_id")
	private int groupId;

	@Expose
	@Column(name = "category_id")
	private int categoryId;

	@Expose
	@Column(name = "sub_category_id")
	private int subCategoryId;

	@Expose
	@Column(name = "schedule_id")
	private int scheduleId;

	@Expose
	@Column(name = "content_id")
	private int contentId;

	@Expose
	@Column(name = "brand_id")
	private int brandId;

	@Expose
	@Column(name = "manufacturer_id")
	private int manufacturerId;

	@Expose
	@Column(name = "entry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entryDate;

	@Expose
	@Column(name = "VAT")
	private double vat;

	@Expose
	@Column(name = "is_on_mrp")
	private int isOnMrp;

	@Expose
	@Column(name = "pack_unit_id")
	private int packUnitId;

	@Expose
	@Column(name = "conversion")
	private int conversion;

	@Expose
	@Column(name = "loose_unit_id")
	private int looseUnitId;

	@Expose
	@Column(name = "storage")
	private String storage;

	@Expose
	@Column(name = "care")
	private String care;

	@Expose
	@Column(name = "reorder_level")
	private int reorderLevel;

	@Expose
	@Column(name = "reorder_level_unit_id")
	private int reorderLevelUnitId;

	@Expose
	@Column(name = "price")
	private double price;

	@Expose
	@Column(name = "is_taxable")
	private int isTaxable;

	@Expose
	@Column(name = "note")
	private String note;

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
	private int rackId;

	@Expose
	@Transient
	private GroupMaster groupMaster;

	@Expose
	@Transient
	private CategoryMaster categoryMaster;

	@Expose
	@Transient
	private SubCategoryMaster subCategoryMaster;

	@Expose
	@Transient
	private ScheduleMaster scheduleMaster;

	@Expose
	@Transient
	private ContentMaster contentMaster;

	@Expose
	@Transient
	private BrandMaster brandMaster;

	@Expose
	@Transient
	private ManufacturerMaster manufacturerMaster;

	@Expose
	@Transient
	private UnitMaster packUnit;

	@Expose
	@Transient
	private UnitMaster looseUnit;

	@Expose
	@Transient
	private UnitMaster reorderLevelUnit;

	@Expose
	@Transient
	private RackMaster rack;

	@Expose
	@Column(name = "markup")
	private double markup;

	@Expose
	@Column(name = "strength")
	private String strength;
	
	@Expose
	@Column(name = "net_content")
	private String netContent;
	
	@Expose
	@Column(name = "purchase_tax_id")
	private int purchaseTaxId;
	
	@Expose
	@Column(name = "purchase_tax_percentage")
	private double purchaseTaxPercentage;
	
	
	@Expose
	@Column(name = "sale_tax_id")
	private int saleTaxId;
	
	@Expose
	@Column(name = "sale_tax_percentage")
	private double saleTaxPercentage;
	
	@Expose
	@Column(name = "SKU")
	private String sku;
	
	@Expose
	@Column(name = "discount")
	private double discount;
	
	@Expose
	@Column(name = "max_discount_limit")
	private double maxDiscountLimit;
	
	@Expose
	@Column(name = "is_discount")
	private int isDiscount;
	
	@Expose
	@Transient
	private TaxMaster saleTax;
	
	@Expose
	@Transient
	private TaxMaster purchaseTax;
	
	@Expose
	@Column(name = "HSN_code")
	private String hsnCode;
	
	@Expose
	@Column(name = "is_loose_sale")
	private int isLooseSale;
	
	

	public int getIsLooseSale() {
		return isLooseSale;
	}

	public void setIsLooseSale(int isLooseSale) {
		this.isLooseSale = isLooseSale;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public TaxMaster getSaleTax() {
		return saleTax;
	}

	public void setSaleTax(TaxMaster saleTax) {
		this.saleTax = saleTax;
	}

	public TaxMaster getPurchaseTax() {
		return purchaseTax;
	}

	public void setPurchaseTax(TaxMaster purchaseTax) {
		this.purchaseTax = purchaseTax;
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getPurchaseTaxId() {
		return purchaseTaxId;
	}

	public void setPurchaseTaxId(int purchaseTaxId) {
		this.purchaseTaxId = purchaseTaxId;
	}

	public String getNetContent() {
		return netContent;
	}

	public void setNetContent(String netContent) {
		this.netContent = netContent;
	}

	public double getMarkup() {
		return markup;
	}

	public void setMarkup(double markup) {
		this.markup = markup;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public RackMaster getRack() {
		return rack;
	}

	public void setRack(RackMaster rack) {
		this.rack = rack;
	}

	public GroupMaster getGroupMaster() {
		return groupMaster;
	}

	public void setGroupMaster(GroupMaster groupMaster) {
		this.groupMaster = groupMaster;
	}

	public CategoryMaster getCategoryMaster() {
		return categoryMaster;
	}

	public void setCategoryMaster(CategoryMaster categoryMaster) {
		this.categoryMaster = categoryMaster;
	}

	public SubCategoryMaster getSubCategoryMaster() {
		return subCategoryMaster;
	}

	public void setSubCategoryMaster(SubCategoryMaster subCategoryMaster) {
		this.subCategoryMaster = subCategoryMaster;
	}

	public ScheduleMaster getScheduleMaster() {
		return scheduleMaster;
	}

	public void setScheduleMaster(ScheduleMaster scheduleMaster) {
		this.scheduleMaster = scheduleMaster;
	}

	public ContentMaster getContentMaster() {
		return contentMaster;
	}

	public void setContentMaster(ContentMaster contentMaster) {
		this.contentMaster = contentMaster;
	}

	public BrandMaster getBrandMaster() {
		return brandMaster;
	}

	public void setBrandMaster(BrandMaster brandMaster) {
		this.brandMaster = brandMaster;
	}

	public ManufacturerMaster getManufacturerMaster() {
		return manufacturerMaster;
	}

	public void setManufacturerMaster(ManufacturerMaster manufacturerMaster) {
		this.manufacturerMaster = manufacturerMaster;
	}

	public UnitMaster getPackUnit() {
		return packUnit;
	}

	public void setPackUnit(UnitMaster packUnit) {
		this.packUnit = packUnit;
	}

	public UnitMaster getLooseUnit() {
		return looseUnit;
	}

	public void setLooseUnit(UnitMaster looseUnit) {
		this.looseUnit = looseUnit;
	}

	public UnitMaster getReorderLevelUnit() {
		return reorderLevelUnit;
	}

	public void setReorderLevelUnit(UnitMaster reorderLevelUnit) {
		this.reorderLevelUnit = reorderLevelUnit;
	}

	public int getRackId() {
		return rackId;
	}

	public void setRackId(int rackId) {
		this.rackId = rackId;
	}

	public int getLooseUnitId() {
		return looseUnitId;
	}

	public void setLooseUnitId(int looseUnitId) {
		this.looseUnitId = looseUnitId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public int getIsTaxable() {
		return isTaxable;
	}

	public void setIsTaxable(int isTaxable) {
		this.isTaxable = isTaxable;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brandId;
		result = prime * result + ((care == null) ? 0 : care.hashCode());
		result = prime * result + categoryId;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + companyId;
		result = prime * result + contentId;
		result = prime * result + conversion;
		result = prime * result + createdBy;
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result
				+ ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime * result + groupId;
		result = prime * result + id;
		result = prime * result + isDeleted;
		result = prime * result + isOnMrp;
		result = prime * result + isTaxable;
		result = prime * result + manufacturerId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + packUnitId;
		result = prime * result + reorderLevel;
		result = prime * result + reorderLevelUnitId;
		result = prime * result + scheduleId;
		result = prime * result + ((storage == null) ? 0 : storage.hashCode());
		result = prime * result + subCategoryId;
		result = prime * result + updatedBy;
		result = prime * result
				+ ((updatedDate == null) ? 0 : updatedDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(vat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMaster other = (ItemMaster) obj;
		if (brandId != other.brandId)
			return false;
		if (care == null) {
			if (other.care != null)
				return false;
		} else if (!care.equals(other.care))
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (companyId != other.companyId)
			return false;
		if (contentId != other.contentId)
			return false;
		if (conversion != other.conversion)
			return false;
		if (createdBy != other.createdBy)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (entryDate == null) {
			if (other.entryDate != null)
				return false;
		} else if (!entryDate.equals(other.entryDate))
			return false;
		if (groupId != other.groupId)
			return false;
		if (id != other.id)
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (isOnMrp != other.isOnMrp)
			return false;
		if (isTaxable != other.isTaxable)
			return false;
		if (manufacturerId != other.manufacturerId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (packUnitId != other.packUnitId)
			return false;
		if (reorderLevel != other.reorderLevel)
			return false;
		if (reorderLevelUnitId != other.reorderLevelUnitId)
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		if (subCategoryId != other.subCategoryId)
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (Double.doubleToLongBits(vat) != Double.doubleToLongBits(other.vat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemMaster [id=" + id + ", name=" + name + ", code=" + code + ", groupId=" + groupId + ", categoryId="
				+ categoryId + ", subCategoryId=" + subCategoryId + ", scheduleId=" + scheduleId + ", contentId="
				+ contentId + ", brandId=" + brandId + ", manufacturerId=" + manufacturerId + ", entryDate=" + entryDate
				+ ", vat=" + vat + ", isOnMrp=" + isOnMrp + ", packUnitId=" + packUnitId + ", conversion=" + conversion
				+ ", looseUnitId=" + looseUnitId + ", storage=" + storage + ", care=" + care + ", reorderLevel="
				+ reorderLevel + ", reorderLevelUnitId=" + reorderLevelUnitId + ", price=" + price + ", isTaxable="
				+ isTaxable + ", note=" + note + ", companyId=" + companyId + ", isDeleted=" + isDeleted
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", rackId=" + rackId + ", groupMaster=" + groupMaster
				+ ", categoryMaster=" + categoryMaster + ", subCategoryMaster=" + subCategoryMaster
				+ ", scheduleMaster=" + scheduleMaster + ", contentMaster=" + contentMaster + ", brandMaster="
				+ brandMaster + ", manufacturerMaster=" + manufacturerMaster + ", packUnit=" + packUnit + ", looseUnit="
				+ looseUnit + ", reorderLevelUnit=" + reorderLevelUnit + ", rack=" + rack + ", markup=" + markup
				+ ", strength=" + strength + ", netContent=" + netContent + ", purchaseTaxId=" + purchaseTaxId
				+ ", purchaseTaxPercentage=" + purchaseTaxPercentage + ", saleTaxId=" + saleTaxId
				+ ", saleTaxPercentage=" + saleTaxPercentage + ", sku=" + sku + ", discount=" + discount
				+ ", maxDiscountLimit=" + maxDiscountLimit + ", isDiscount=" + isDiscount + ", saleTax=" + saleTax
				+ ", purchaseTax=" + purchaseTax + ", hsnCode=" + hsnCode + ", isLooseSale=" + isLooseSale + "]";
	}

	
}