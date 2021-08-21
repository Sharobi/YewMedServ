package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ItemHistoryDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "name" })
	private String name;
	
	
	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;

	
	@Expose
	@MapToData(columnAliases = { "batch_no" })
	private String batchNo;


	@Expose
	@MapToData(columnAliases = { "expiry_date_format" })
	private String expiryDateFormat;

	@Expose
	@MapToData(columnAliases = { "in_pack_qty" })
	private int inPackQty;

	@Expose
	@MapToData(columnAliases = { "in_loose_qty" })
	private int inLooseQty;	

	@Expose
	@MapToData(columnAliases = { "in_calculate_loose_qty" })
	private int inCalculateLooseQty;

	@Expose
	@MapToData(columnAliases = { "in_stock_qty" })
	private int inStockQty;
	
	@Expose
	@MapToData(columnAliases = { "out_pack_qty" })
	private int outPackQty;
	
	@Expose
	@MapToData(columnAliases = { "out_loose_qty" })
	private int outLooseQty;

	@Expose
	@MapToData(columnAliases = { "out_calculate_loose_qty" })
	private int outCalculateLooseQty;

	@Expose
	@MapToData(columnAliases = { "out_stock_qty" })
	private String outStockQty;

	@Expose
	@MapToData(columnAliases = { "tran_type" })
	private String tranType;

	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;

	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;
	
	@Expose
	@MapToData(columnAliases = { "party_name" })
	private String partyName;

	private static final long serialVersionUID = 1L;
	

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}

	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}

	public int getInPackQty() {
		return inPackQty;
	}

	public void setInPackQty(int inPackQty) {
		this.inPackQty = inPackQty;
	}

	public int getInLooseQty() {
		return inLooseQty;
	}

	public void setInLooseQty(int inLooseQty) {
		this.inLooseQty = inLooseQty;
	}

	public int getInCalculateLooseQty() {
		return inCalculateLooseQty;
	}

	public void setInCalculateLooseQty(int inCalculateLooseQty) {
		this.inCalculateLooseQty = inCalculateLooseQty;
	}

	public int getInStockQty() {
		return inStockQty;
	}

	public void setInStockQty(int inStockQty) {
		this.inStockQty = inStockQty;
	}

	public int getOutPackQty() {
		return outPackQty;
	}

	public void setOutPackQty(int outPackQty) {
		this.outPackQty = outPackQty;
	}

	public int getOutLooseQty() {
		return outLooseQty;
	}

	public void setOutLooseQty(int outLooseQty) {
		this.outLooseQty = outLooseQty;
	}

	public int getOutCalculateLooseQty() {
		return outCalculateLooseQty;
	}

	public void setOutCalculateLooseQty(int outCalculateLooseQty) {
		this.outCalculateLooseQty = outCalculateLooseQty;
	}

	public String getOutStockQty() {
		return outStockQty;
	}

	public void setOutStockQty(String outStockQty) {
		this.outStockQty = outStockQty;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		result = prime * result + inCalculateLooseQty;
		result = prime * result + inLooseQty;
		result = prime * result + inPackQty;
		result = prime * result + inStockQty;
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + outCalculateLooseQty;
		result = prime * result + outLooseQty;
		result = prime * result + outPackQty;
		result = prime * result
				+ ((outStockQty == null) ? 0 : outStockQty.hashCode());
		result = prime * result
				+ ((tranType == null) ? 0 : tranType.hashCode());
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
		ItemHistoryDTO other = (ItemHistoryDTO) obj;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (expiryDateFormat == null) {
			if (other.expiryDateFormat != null)
				return false;
		} else if (!expiryDateFormat.equals(other.expiryDateFormat))
			return false;
		if (inCalculateLooseQty != other.inCalculateLooseQty)
			return false;
		if (inLooseQty != other.inLooseQty)
			return false;
		if (inPackQty != other.inPackQty)
			return false;
		if (inStockQty != other.inStockQty)
			return false;
		if (invDate == null) {
			if (other.invDate != null)
				return false;
		} else if (!invDate.equals(other.invDate))
			return false;
		if (invNo == null) {
			if (other.invNo != null)
				return false;
		} else if (!invNo.equals(other.invNo))
			return false;
		if (itemId != other.itemId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (outCalculateLooseQty != other.outCalculateLooseQty)
			return false;
		if (outLooseQty != other.outLooseQty)
			return false;
		if (outPackQty != other.outPackQty)
			return false;
		if (outStockQty == null) {
			if (other.outStockQty != null)
				return false;
		} else if (!outStockQty.equals(other.outStockQty))
			return false;
		if (tranType == null) {
			if (other.tranType != null)
				return false;
		} else if (!tranType.equals(other.tranType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemHistoryDTO [name=" + name + ", itemId=" + itemId
				+ ", batchNo=" + batchNo + ", expiryDateFormat="
				+ expiryDateFormat + ", inPackQty=" + inPackQty
				+ ", inLooseQty=" + inLooseQty + ", inCalculateLooseQty="
				+ inCalculateLooseQty + ", inStockQty=" + inStockQty
				+ ", outPackQty=" + outPackQty + ", outLooseQty=" + outLooseQty
				+ ", outCalculateLooseQty=" + outCalculateLooseQty
				+ ", outStockQty=" + outStockQty + ", tranType=" + tranType
				+ ", invNo=" + invNo + ", invDate=" + invDate + "]";
	}
	
	
	
}