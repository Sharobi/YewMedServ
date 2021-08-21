package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ItemCurrentStockDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;

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
	@MapToData(columnAliases = { "pack_unit_id" })
	private int packUnitId;

	@Expose
	@MapToData(columnAliases = { "conversion" })
	private int conversion;

	@Expose
	@MapToData(columnAliases = { "mrp" })
	private double mrp;

	@Expose
	@MapToData(columnAliases = { "pack_qty" })
	private int packQty;

	@Expose
	@MapToData(columnAliases = { "loose_qty" })
	private double looseQty;

	@Expose
	@MapToData(columnAliases = { "pack_unit_name" })
	private String packUnitName;

	@Expose
	@MapToData(columnAliases = { "content_name" })
	private String contentName;

	@Expose
	@MapToData(columnAliases = { "manufacturer_name" })
	private String manufacturerName;

	@Expose
	@MapToData(columnAliases = { "net_content" })
	private String netContent;

	@Expose
	@MapToData(columnAliases = { "stock_qty" })
	private String stockQty;

	@Expose
	@MapToData(columnAliases = { "rack_name" })
	private String rackName;

	@Expose
	@MapToData(columnAliases = { "hold_qty" })
	private String holdQty;

	@Expose
	@MapToData(columnAliases = { "calculate_loose_hold_qty" })
	private int calculateLooseHoldQty;

	@Expose
	@MapToData(columnAliases = { "group_name" })
	private String groupName;

	@Expose
	@MapToData(columnAliases = { "loose_unit_id" })
	private int looseUnitId;

	@Expose
	@MapToData(columnAliases = { "loose_unit_name" })
	private String looseUnitName;

	@Expose
	@MapToData(columnAliases = { "schedule_id" })
	private int scheduleId;

	@Expose
	@MapToData(columnAliases = { "schedule_name" })
	private String scheduleName;
	
	@Expose
	@MapToData(columnAliases = { "calculate_loose_qty" })
	private int calculateLooseQty ;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_code" })
	private String manufacturerCode;
	
	@Expose
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;
	
	@Expose
	@MapToData(columnAliases = { "expiry_status_mode" })
	private int expiryStatusMode;

	@Expose
	@MapToData(columnAliases = { "expiry_status" })
	private String expiryStatus;
	
	@Expose
	@MapToData(columnAliases = { "vat_per" })
	private double vatPer;
	
	@Expose
	@MapToData(columnAliases = { "tax_per" })
	private double taxPer;
	
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
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;
	
	@Expose
	@MapToData(columnAliases = { "tax_name" })
	private String taxName;
	
	@Expose
	@MapToData(columnAliases = { "tax_percentage" })
	private double taxPercentage;
	
	@Expose
	@MapToData(columnAliases = { "tax_mode" })
	private String taxMode;
	
	@Expose
	@MapToData(columnAliases = { "is_group_tax" })
	private int isGroupTax;
	
	@Expose
	@MapToData(columnAliases = { "discount" })
	private double discount;
	
	@Expose
	@MapToData(columnAliases = { "is_discount" })
	private int isDiscount;
	
	@Expose
	@MapToData(columnAliases = { "max_discount_limit" })
	private double maxDiscountLimit;
	
	@Expose
	@MapToData(columnAliases = { "purchase_cost_per_unit" })
	private double purchaseCostPerUnit;
	
	@Expose
	@MapToData(columnAliases = { "note" })
	private String note;
	
	@Expose
	@MapToData(columnAliases = { "sale_rate" })
	private double saleRate;
	
	@Expose
	@MapToData(columnAliases = { "purchase_rate" })
	private double purchaseRate;
	
	@Expose
	@MapToData(columnAliases = { "claculate_loose_reorder_level_qty" })
	private int claculateLooseReorderLevelQty;
	
	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String purInvNo;
	
	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date purInvDate;
	
	private static final long serialVersionUID = 1L;
	
	
	public int getClaculateLooseReorderLevelQty() {
		return claculateLooseReorderLevelQty;
	}

	public void setClaculateLooseReorderLevelQty(int claculateLooseReorderLevelQty) {
		this.claculateLooseReorderLevelQty = claculateLooseReorderLevelQty;
	}

	public double getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(int isDiscount) {
		this.isDiscount = isDiscount;
	}

	public double getMaxDiscountLimit() {
		return maxDiscountLimit;
	}

	public void setMaxDiscountLimit(double maxDiscountLimit) {
		this.maxDiscountLimit = maxDiscountLimit;
	}

	public double getPurchaseCostPerUnit() {
		return purchaseCostPerUnit;
	}

	public void setPurchaseCostPerUnit(double purchaseCostPerUnit) {
		this.purchaseCostPerUnit = purchaseCostPerUnit;
	}

	public double getVatPer() {
		return vatPer;
	}

	public void setVatPer(double vatPer) {
		this.vatPer = vatPer;
	}

	public double getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(double taxPer) {
		this.taxPer = taxPer;
	}

	public String getExpiryStatus() {
		return expiryStatus;
	}

	public void setExpiryStatus(String expiryStatus) {
		this.expiryStatus = expiryStatus;
	}

	public int getExpiryStatusMode() {
		return expiryStatusMode;
	}

	public void setExpiryStatusMode(int expiryStatusMode) {
		this.expiryStatusMode = expiryStatusMode;
	}

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}
	
	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public int getCalculateLooseQty() {
		return calculateLooseQty;
	}

	public void setCalculateLooseQty(int calculateLooseQty) {
		this.calculateLooseQty = calculateLooseQty;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleName() {
		return scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	public int getLooseUnitId() {
		return looseUnitId;
	}

	public void setLooseUnitId(int looseUnitId) {
		this.looseUnitId = looseUnitId;
	}

	public String getLooseUnitName() {
		return looseUnitName;
	}

	public void setLooseUnitName(String looseUnitName) {
		this.looseUnitName = looseUnitName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getNetContent() {
		return netContent;
	}

	public void setNetContent(String netContent) {
		this.netContent = netContent;
	}

	public String getStockQty() {
		return stockQty;
	}

	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}

	public String getRackName() {
		return rackName;
	}

	public void setRackName(String rackName) {
		this.rackName = rackName;
	}

	public String getHoldQty() {
		return holdQty;
	}

	public void setHoldQty(String holdQty) {
		this.holdQty = holdQty;
	}

	public int getCalculateLooseHoldQty() {
		return calculateLooseHoldQty;
	}

	public void setCalculateLooseHoldQty(int calculateLooseHoldQty) {
		this.calculateLooseHoldQty = calculateLooseHoldQty;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public int getPackQty() {
		return packQty;
	}

	public void setPackQty(int packQty) {
		this.packQty = packQty;
	}

	public double getLooseQty() {
		return looseQty;
	}

	public void setLooseQty(double looseQty) {
		this.looseQty = looseQty;
	}

	public String getPackUnitName() {
		return packUnitName;
	}

	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}

	public String getPurInvNo() {
		return purInvNo;
	}

	public void setPurInvNo(String purInvNo) {
		this.purInvNo = purInvNo;
	}

	public Date getPurInvDate() {
		return purInvDate;
	}

	public void setPurInvDate(Date purInvDate) {
		this.purInvDate = purInvDate;
	}

	@Override
	public String toString() {
		return "ItemCurrentStockDTO [itemId=" + itemId + ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", expiryDateFormat=" + expiryDateFormat + ", packUnitId=" + packUnitId + ", conversion=" + conversion
				+ ", mrp=" + mrp + ", packQty=" + packQty + ", looseQty=" + looseQty + ", packUnitName=" + packUnitName
				+ ", contentName=" + contentName + ", manufacturerName=" + manufacturerName + ", netContent="
				+ netContent + ", stockQty=" + stockQty + ", rackName=" + rackName + ", holdQty=" + holdQty
				+ ", calculateLooseHoldQty=" + calculateLooseHoldQty + ", groupName=" + groupName + ", looseUnitId="
				+ looseUnitId + ", looseUnitName=" + looseUnitName + ", scheduleId=" + scheduleId + ", scheduleName="
				+ scheduleName + ", calculateLooseQty=" + calculateLooseQty + ", manufacturerCode=" + manufacturerCode
				+ ", itemUniqueKey=" + itemUniqueKey + ", expiryStatusMode=" + expiryStatusMode + ", expiryStatus="
				+ expiryStatus + ", vatPer=" + vatPer + ", taxPer=" + taxPer + ", itemName=" + itemName + ", sku=" + sku
				+ ", hsnCode=" + hsnCode + ", taxId=" + taxId + ", taxName=" + taxName + ", taxPercentage="
				+ taxPercentage + ", taxMode=" + taxMode + ", isGroupTax=" + isGroupTax + ", discount=" + discount
				+ ", isDiscount=" + isDiscount + ", maxDiscountLimit=" + maxDiscountLimit + ", purchaseCostPerUnit="
				+ purchaseCostPerUnit + ", note=" + note + ", saleRate=" + saleRate + ", purchaseRate=" + purchaseRate
				+ ", claculateLooseReorderLevelQty=" + claculateLooseReorderLevelQty + ", purInvNo=" + purInvNo
				+ ", purInvDate=" + purInvDate + "]";
	}

	
	
}