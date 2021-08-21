package com.sharobi.pharmacy.commonutil;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LabelInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String barcode;

	private boolean printBarcode = true;

	private int itemId;

	private boolean printItemId = true;

	private String mrp;

	private boolean printMrp = true;

	private String itemName;

	private boolean printItemName = true;

	private String dimensionStr;

	private boolean printDimensionStr = true;

	private String storeName;

	private boolean printStoreName = true;
	
	private String itemCategory;
	
	private boolean printItemCategory = true;
	
    private String itemSubCategory;
    private String grpName;
    private String size;
    private String colour;
	
	private String saleRate;
	private String batch;
	private String expiryDate;
	private String sku;
	
	private String storeCurrency;
	
	private boolean printBatch = true;
	
	private boolean printExpiry = true;
	
	private boolean printSaleRate = true;

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public boolean isPrintBarcode() {
		return printBarcode;
	}

	public void setPrintBarcode(boolean printBarcode) {
		this.printBarcode = printBarcode;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public boolean isPrintItemId() {
		return printItemId;
	}

	public void setPrintItemId(boolean printItemId) {
		this.printItemId = printItemId;
	}

	public String getMrp() {
		return mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public boolean isPrintMrp() {
		return printMrp;
	}

	public void setPrintMrp(boolean printMrp) {
		this.printMrp = printMrp;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isPrintItemName() {
		return printItemName;
	}

	public void setPrintItemName(boolean printItemName) {
		this.printItemName = printItemName;
	}

	public String getDimensionStr() {
		return dimensionStr;
	}

	public void setDimensionStr(String dimensionStr) {
		this.dimensionStr = dimensionStr;
	}

	public boolean isPrintDimensionStr() {
		return printDimensionStr;
	}

	public void setPrintDimensionStr(boolean printDimensionStr) {
		this.printDimensionStr = printDimensionStr;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public boolean isPrintStoreName() {
		return printStoreName;
	}

	public void setPrintStoreName(boolean printStoreName) {
		this.printStoreName = printStoreName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public boolean isPrintItemCategory() {
		return printItemCategory;
	}

	public void setPrintItemCategory(boolean printItemCategory) {
		this.printItemCategory = printItemCategory;
	}

	public String getItemSubCategory() {
		return itemSubCategory;
	}

	public void setItemSubCategory(String itemSubCategory) {
		this.itemSubCategory = itemSubCategory;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(String saleRate) {
		this.saleRate = saleRate;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getStoreCurrency() {
		return storeCurrency;
	}

	public void setStoreCurrency(String storeCurrency) {
		this.storeCurrency = storeCurrency;
	}

	public boolean isPrintBatch() {
		return printBatch;
	}

	public void setPrintBatch(boolean printBatch) {
		this.printBatch = printBatch;
	}

	public boolean isPrintExpiry() {
		return printExpiry;
	}

	public void setPrintExpiry(boolean printExpiry) {
		this.printExpiry = printExpiry;
	}

	public boolean isPrintSaleRate() {
		return printSaleRate;
	}

	public void setPrintSaleRate(boolean printSaleRate) {
		this.printSaleRate = printSaleRate;
	}
	
	

}