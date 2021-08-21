package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class PurchaseReturnDTO implements Serializable {

	@Expose
	@MapToData(columnAliases = { "purchase_return_id" })
	private int purchaseReturnId;
	
	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;

	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;

	@Expose
	@MapToData(columnAliases = { "inv_mode" })
	private int invMode;
	
	@Expose
	@MapToData(columnAliases = { "inv_mode_name" })
	private String invModeName;

	
	@Expose
	@MapToData(columnAliases = { "gross_amount" })
	private double grossAmount;

	@Expose
	@MapToData(columnAliases = { "ed_amount" })
	private double edAmount;

	@Expose
	@MapToData(columnAliases = { "disc_amount" })
	private double discAmount;

	@Expose
	@MapToData(columnAliases = { "vat_amount" })
	private double vatAmount;

	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;

	@Expose
	@MapToData(columnAliases = { "adj_amount" })
	private double adjAmount;
	
	@Expose
	@MapToData(columnAliases = { "lot_adj_amount" })
	private double lotAdjAmount;

	@Expose
	@MapToData(columnAliases = { "roundoff" })
	private double roundoff;

	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "total_mrp" })
	private double totalMrp;

	@Expose
	@MapToData(columnAliases = { "remarks" })
	private String remarks;

	@Expose
	@MapToData(columnAliases = { "distributor_id" })
	private int distributorId;

	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String distributorName;
	
	
	@Expose
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;
	
	@Expose
	@MapToData(columnAliases = { "pre_adj_amount" })
	private double preAdjAmount;

	private static final long serialVersionUID = 1L;
	
	
	public double getPreAdjAmount() {
		return preAdjAmount;
	}

	public void setPreAdjAmount(double preAdjAmount) {
		this.preAdjAmount = preAdjAmount;
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

	public int getInvMode() {
		return invMode;
	}

	public void setInvMode(int invMode) {
		this.invMode = invMode;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getEdAmount() {
		return edAmount;
	}

	public void setEdAmount(double edAmount) {
		this.edAmount = edAmount;
	}

	public double getDiscAmount() {
		return discAmount;
	}

	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}

	public double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getAdjAmount() {
		return adjAmount;
	}

	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}

	public double getRoundoff() {
		return roundoff;
	}

	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public String getRemarks() {
		
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public int getIsPosted() {
		return isPosted;
	}

	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	public int getPurchaseReturnId() {
		return purchaseReturnId;
	}

	public void setPurchaseReturnId(int purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}

	

	public String getInvModeName() {
		return invModeName;
	}

	public void setInvModeName(String invModeName) {
		this.invModeName = invModeName;
	}

	public double getLotAdjAmount() {
		return lotAdjAmount;
	}

	public void setLotAdjAmount(double lotAdjAmount) {
		this.lotAdjAmount = lotAdjAmount;
	}

	public double getTotalMrp() {
		return totalMrp;
	}

	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + distributorId;
		result = prime * result
				+ ((distributorName == null) ? 0 : distributorName.hashCode());
		temp = Double.doubleToLongBits(edAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(grossAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + invMode;
		result = prime * result
				+ ((invModeName == null) ? 0 : invModeName.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isPosted;
		temp = Double.doubleToLongBits(lotAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(preAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + purchaseReturnId;
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		temp = Double.doubleToLongBits(roundoff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalMrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vatAmount);
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
		PurchaseReturnDTO other = (PurchaseReturnDTO) obj;
		if (Double.doubleToLongBits(adjAmount) != Double
				.doubleToLongBits(other.adjAmount))
			return false;
		if (Double.doubleToLongBits(discAmount) != Double
				.doubleToLongBits(other.discAmount))
			return false;
		if (distributorId != other.distributorId)
			return false;
		if (distributorName == null) {
			if (other.distributorName != null)
				return false;
		} else if (!distributorName.equals(other.distributorName))
			return false;
		if (Double.doubleToLongBits(edAmount) != Double
				.doubleToLongBits(other.edAmount))
			return false;
		if (Double.doubleToLongBits(grossAmount) != Double
				.doubleToLongBits(other.grossAmount))
			return false;
		if (invDate == null) {
			if (other.invDate != null)
				return false;
		} else if (!invDate.equals(other.invDate))
			return false;
		if (invMode != other.invMode)
			return false;
		if (invModeName == null) {
			if (other.invModeName != null)
				return false;
		} else if (!invModeName.equals(other.invModeName))
			return false;
		if (invNo == null) {
			if (other.invNo != null)
				return false;
		} else if (!invNo.equals(other.invNo))
			return false;
		if (isPosted != other.isPosted)
			return false;
		if (Double.doubleToLongBits(lotAdjAmount) != Double
				.doubleToLongBits(other.lotAdjAmount))
			return false;
		if (Double.doubleToLongBits(netAmount) != Double
				.doubleToLongBits(other.netAmount))
			return false;
		if (Double.doubleToLongBits(preAdjAmount) != Double
				.doubleToLongBits(other.preAdjAmount))
			return false;
		if (purchaseReturnId != other.purchaseReturnId)
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (Double.doubleToLongBits(roundoff) != Double
				.doubleToLongBits(other.roundoff))
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double
				.doubleToLongBits(other.taxAmount))
			return false;
		if (Double.doubleToLongBits(totalMrp) != Double
				.doubleToLongBits(other.totalMrp))
			return false;
		if (Double.doubleToLongBits(vatAmount) != Double
				.doubleToLongBits(other.vatAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseReturnDTO [purchaseReturnId=" + purchaseReturnId
				+ ", invNo=" + invNo + ", invDate=" + invDate + ", invMode="
				+ invMode + ", invModeName=" + invModeName + ", grossAmount="
				+ grossAmount + ", edAmount=" + edAmount + ", discAmount="
				+ discAmount + ", vatAmount=" + vatAmount + ", taxAmount="
				+ taxAmount + ", adjAmount=" + adjAmount + ", lotAdjAmount="
				+ lotAdjAmount + ", roundoff=" + roundoff + ", netAmount="
				+ netAmount + ", totalMrp=" + totalMrp + ", remarks=" + remarks
				+ ", distributorId=" + distributorId + ", distributorName="
				+ distributorName + ", isPosted=" + isPosted
				+ ", preAdjAmount=" + preAdjAmount + "]";
	}

	

	
}