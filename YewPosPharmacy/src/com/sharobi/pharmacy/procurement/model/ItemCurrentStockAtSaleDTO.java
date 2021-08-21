package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ItemCurrentStockAtSaleDTO implements Serializable {
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

	private static final long serialVersionUID = 1L;

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

	

}