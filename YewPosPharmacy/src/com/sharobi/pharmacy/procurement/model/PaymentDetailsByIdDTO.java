package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class PaymentDetailsByIdDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "bill_no" })
	private String billNo;
	
	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;

	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;

	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;

	@Expose
	@MapToData(columnAliases = { "adv_amount" })
	private double advAmount;

	@Expose
	@MapToData(columnAliases = { "due_amount" })
	private double dueAmount;
	
	@Expose
	@MapToData(columnAliases = { "inv_from" })
	private String invFrom;
	
	@Expose
	@MapToData(columnAliases = { "inv_id" })
	private int invId;
	
	@Expose
	@MapToData(columnAliases = { "outstanding_amount" })
	private double outstandingAmount;
	
	@Expose
	@MapToData(columnAliases = { "inv_from_type" })
	private String invFromType;
	
	@Expose
	@MapToData(columnAliases = { "other_adj_amount" })
	private double otherAdjAmount;
	
	
	
	public double getOtherAdjAmount() {
		return otherAdjAmount;
	}

	public void setOtherAdjAmount(double otherAdjAmount) {
		this.otherAdjAmount = otherAdjAmount;
	}

	public String getInvFromType() {
		return invFromType;
	}

	public void setInvFromType(String invFromType) {
		this.invFromType = invFromType;
	}

	public double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public String getInvFrom() {
		return invFrom;
	}

	public void setInvFrom(String invFrom) {
		this.invFrom = invFrom;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
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

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	

	public double getAdvAmount() {
		return advAmount;
	}

	public void setAdvAmount(double advAmount) {
		this.advAmount = advAmount;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(advAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((billNo == null) ? 0 : billNo.hashCode());
		temp = Double.doubleToLongBits(dueAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + ((invFrom == null) ? 0 : invFrom.hashCode());
		result = prime * result
				+ ((invFromType == null) ? 0 : invFromType.hashCode());
		result = prime * result + invId;
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(otherAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(outstandingAmount);
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
		PaymentDetailsByIdDTO other = (PaymentDetailsByIdDTO) obj;
		if (Double.doubleToLongBits(advAmount) != Double
				.doubleToLongBits(other.advAmount))
			return false;
		if (billNo == null) {
			if (other.billNo != null)
				return false;
		} else if (!billNo.equals(other.billNo))
			return false;
		if (Double.doubleToLongBits(dueAmount) != Double
				.doubleToLongBits(other.dueAmount))
			return false;
		if (invDate == null) {
			if (other.invDate != null)
				return false;
		} else if (!invDate.equals(other.invDate))
			return false;
		if (invFrom == null) {
			if (other.invFrom != null)
				return false;
		} else if (!invFrom.equals(other.invFrom))
			return false;
		if (invFromType == null) {
			if (other.invFromType != null)
				return false;
		} else if (!invFromType.equals(other.invFromType))
			return false;
		if (invId != other.invId)
			return false;
		if (invNo == null) {
			if (other.invNo != null)
				return false;
		} else if (!invNo.equals(other.invNo))
			return false;
		if (Double.doubleToLongBits(netAmount) != Double
				.doubleToLongBits(other.netAmount))
			return false;
		if (Double.doubleToLongBits(otherAdjAmount) != Double
				.doubleToLongBits(other.otherAdjAmount))
			return false;
		if (Double.doubleToLongBits(outstandingAmount) != Double
				.doubleToLongBits(other.outstandingAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaymentDetailsByIdDTO [billNo=" + billNo + ", invNo=" + invNo
				+ ", invDate=" + invDate + ", netAmount=" + netAmount
				+ ", advAmount=" + advAmount + ", dueAmount=" + dueAmount
				+ ", invFrom=" + invFrom + ", invId=" + invId
				+ ", outstandingAmount=" + outstandingAmount + ", invFromType="
				+ invFromType + ", otherAdjAmount=" + otherAdjAmount + "]";
	}

	
	

	
}