package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class CustomerLastSaleDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "sale_id" })
	private int saleId;
	
	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;
	
	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;
	
	@Expose
	@MapToData(columnAliases = { "inv_time" })
	private String invTime;

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
	@MapToData(columnAliases = { "roundoff" })
	private double roundOff;
	
	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "cash_amount" })
	private double cashAmount;
	
	@Expose
	@MapToData(columnAliases = { "card_amount" })
	private double cardAmount;
	
	@Expose
	@MapToData(columnAliases = { "credit_amount" })
	private double creditAmount;
	

	private static final long serialVersionUID = 1L;


	public int getSaleId() {
		return saleId;
	}


	public void setSaleId(int saleId) {
		this.saleId = saleId;
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


	public String getInvTime() {
		return invTime;
	}


	public void setInvTime(String invTime) {
		this.invTime = invTime;
	}


	public String getInvModeName() {
		return invModeName;
	}


	public void setInvModeName(String invModeName) {
		this.invModeName = invModeName;
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


	public double getRoundOff() {
		return roundOff;
	}


	public void setRoundOff(double roundOff) {
		this.roundOff = roundOff;
	}


	public double getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}


	public double getCashAmount() {
		return cashAmount;
	}


	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}


	public double getCardAmount() {
		return cardAmount;
	}


	public void setCardAmount(double cardAmount) {
		this.cardAmount = cardAmount;
	}


	public double getCreditAmount() {
		return creditAmount;
	}


	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cardAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cashAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(edAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(grossAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result
				+ ((invModeName == null) ? 0 : invModeName.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + ((invTime == null) ? 0 : invTime.hashCode());
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(roundOff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saleId;
		temp = Double.doubleToLongBits(taxAmount);
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
		CustomerLastSaleDTO other = (CustomerLastSaleDTO) obj;
		if (Double.doubleToLongBits(adjAmount) != Double
				.doubleToLongBits(other.adjAmount))
			return false;
		if (Double.doubleToLongBits(cardAmount) != Double
				.doubleToLongBits(other.cardAmount))
			return false;
		if (Double.doubleToLongBits(cashAmount) != Double
				.doubleToLongBits(other.cashAmount))
			return false;
		if (Double.doubleToLongBits(creditAmount) != Double
				.doubleToLongBits(other.creditAmount))
			return false;
		if (Double.doubleToLongBits(discAmount) != Double
				.doubleToLongBits(other.discAmount))
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
		if (invTime == null) {
			if (other.invTime != null)
				return false;
		} else if (!invTime.equals(other.invTime))
			return false;
		if (Double.doubleToLongBits(netAmount) != Double
				.doubleToLongBits(other.netAmount))
			return false;
		if (Double.doubleToLongBits(roundOff) != Double
				.doubleToLongBits(other.roundOff))
			return false;
		if (saleId != other.saleId)
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double
				.doubleToLongBits(other.taxAmount))
			return false;
		if (Double.doubleToLongBits(vatAmount) != Double
				.doubleToLongBits(other.vatAmount))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CustomerLastSaleDTO [saleId=" + saleId + ", invNo=" + invNo
				+ ", invDate=" + invDate + ", invTime=" + invTime
				+ ", invModeName=" + invModeName + ", grossAmount="
				+ grossAmount + ", edAmount=" + edAmount + ", discAmount="
				+ discAmount + ", vatAmount=" + vatAmount + ", taxAmount="
				+ taxAmount + ", adjAmount=" + adjAmount + ", roundOff="
				+ roundOff + ", netAmount=" + netAmount + ", cashAmount="
				+ cashAmount + ", cardAmount=" + cardAmount + ", creditAmount="
				+ creditAmount + "]";
	}
	

}