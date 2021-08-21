package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SaleReturnDTO implements Serializable {

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
	private double roundoff;

	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;

	@Expose
	@MapToData(columnAliases = { "remarks" })
	private String remarks;

	@Expose
	@MapToData(columnAliases = { "customer_id" })
	private int customerId;

	@Expose
	@MapToData(columnAliases = { "customer_name" })
	private String customerName;

	@Expose
	@MapToData(columnAliases = { "customer_phone" })
	private String customerPhone;

	@Expose
	@MapToData(columnAliases = { "customer_address" })
	private String customerAddress;

	@Expose
	@MapToData(columnAliases = { "doctor_id" })
	private int doctorId;

	@Expose
	@MapToData(columnAliases = { "doctor_name" })
	private String doctorName;
	
	@Expose
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;

	@Expose
	@MapToData(columnAliases = { "sale_return_id" })
	private int saleReturnId;
	
	@Expose
	@MapToData(columnAliases = { "pre_adj_amount" })
	private double preAdjAmount;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_per" })
	private double specialDiscPer;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_amount" })
	private double specialDiscAmount;

	private static final long serialVersionUID = 1L;
	

	public double getSpecialDiscPer() {
		return specialDiscPer;
	}

	public void setSpecialDiscPer(double specialDiscPer) {
		this.specialDiscPer = specialDiscPer;
	}

	public double getSpecialDiscAmount() {
		return specialDiscAmount;
	}

	public void setSpecialDiscAmount(double specialDiscAmount) {
		this.specialDiscAmount = specialDiscAmount;
	}

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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getIsPosted() {
		return isPosted;
	}

	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	public int getSaleReturnId() {
		return saleReturnId;
	}

	public void setSaleReturnId(int saleReturnId) {
		this.saleReturnId = saleReturnId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + customerId;
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result
				+ ((customerPhone == null) ? 0 : customerPhone.hashCode());
		temp = Double.doubleToLongBits(discAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + doctorId;
		result = prime * result
				+ ((doctorName == null) ? 0 : doctorName.hashCode());
		temp = Double.doubleToLongBits(edAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(grossAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + invMode;
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isPosted;
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(preAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		temp = Double.doubleToLongBits(roundoff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saleReturnId;
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
		SaleReturnDTO other = (SaleReturnDTO) obj;
		if (Double.doubleToLongBits(adjAmount) != Double
				.doubleToLongBits(other.adjAmount))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
			return false;
		if (Double.doubleToLongBits(discAmount) != Double
				.doubleToLongBits(other.discAmount))
			return false;
		if (doctorId != other.doctorId)
			return false;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
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
		if (invNo == null) {
			if (other.invNo != null)
				return false;
		} else if (!invNo.equals(other.invNo))
			return false;
		if (isPosted != other.isPosted)
			return false;
		if (Double.doubleToLongBits(netAmount) != Double
				.doubleToLongBits(other.netAmount))
			return false;
		if (Double.doubleToLongBits(preAdjAmount) != Double
				.doubleToLongBits(other.preAdjAmount))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (Double.doubleToLongBits(roundoff) != Double
				.doubleToLongBits(other.roundoff))
			return false;
		if (saleReturnId != other.saleReturnId)
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
		return "SaleReturnDTO [invNo=" + invNo + ", invDate=" + invDate
				+ ", invMode=" + invMode + ", grossAmount=" + grossAmount
				+ ", edAmount=" + edAmount + ", discAmount=" + discAmount
				+ ", vatAmount=" + vatAmount + ", taxAmount=" + taxAmount
				+ ", adjAmount=" + adjAmount + ", roundoff=" + roundoff
				+ ", netAmount=" + netAmount + ", remarks=" + remarks
				+ ", customerId=" + customerId + ", customerName="
				+ customerName + ", customerPhone=" + customerPhone
				+ ", customerAddress=" + customerAddress + ", doctorId="
				+ doctorId + ", doctorName=" + doctorName + ", isPosted="
				+ isPosted + ", saleReturnId=" + saleReturnId
				+ ", preAdjAmount=" + preAdjAmount + "]";
	}

	


}