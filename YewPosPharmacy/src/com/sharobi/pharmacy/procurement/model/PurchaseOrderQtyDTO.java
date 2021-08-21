package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;


@XmlRootElement
public class PurchaseOrderQtyDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "need_total_loose_qty" })
	private int needTotalLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "need_pack_qty" })
	private int needPackQty;
	
	@Expose
	@MapToData(columnAliases = { "need_loose_qty" })
	private int needLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "need_rounded_pack_qty" })
	private int needRoundedPackQty;

	public int getNeedTotalLooseQty() {
		return needTotalLooseQty;
	}

	public void setNeedTotalLooseQty(int needTotalLooseQty) {
		this.needTotalLooseQty = needTotalLooseQty;
	}

	public int getNeedPackQty() {
		return needPackQty;
	}

	public void setNeedPackQty(int needPackQty) {
		this.needPackQty = needPackQty;
	}

	public int getNeedLooseQty() {
		return needLooseQty;
	}

	public void setNeedLooseQty(int needLooseQty) {
		this.needLooseQty = needLooseQty;
	}

	public int getNeedRoundedPackQty() {
		return needRoundedPackQty;
	}

	public void setNeedRoundedPackQty(int needRoundedPackQty) {
		this.needRoundedPackQty = needRoundedPackQty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + needLooseQty;
		result = prime * result + needPackQty;
		result = prime * result + needRoundedPackQty;
		result = prime * result + needTotalLooseQty;
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
		PurchaseOrderQtyDTO other = (PurchaseOrderQtyDTO) obj;
		if (needLooseQty != other.needLooseQty)
			return false;
		if (needPackQty != other.needPackQty)
			return false;
		if (needRoundedPackQty != other.needRoundedPackQty)
			return false;
		if (needTotalLooseQty != other.needTotalLooseQty)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderQtyDTO [needTotalLooseQty=" + needTotalLooseQty
				+ ", needPackQty=" + needPackQty + ", needLooseQty="
				+ needLooseQty + ", needRoundedPackQty=" + needRoundedPackQty
				+ "]";
	}
	
	
	

}