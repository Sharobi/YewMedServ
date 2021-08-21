package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SaleDetailsAllDTO implements Serializable {
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
	@MapToData(columnAliases = { "roundoff" })
	private double roundoff;

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

	@Expose
	@MapToData(columnAliases = { "card_four_digit" })
	private String cardFourDigit;

	@Expose
	@MapToData(columnAliases = { "card_exp_date" })
	private String cardExpDate;

	@Expose
	@MapToData(columnAliases = { "tender_amount" })
	private double tenderAmount;

	@Expose
	@MapToData(columnAliases = { "print_count" })
	private int printCount;
	
	@Expose
	@MapToData(columnAliases = { "hold_flag" })
	private int holdFlag;
	
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
	@MapToData(columnAliases = { "customer_disc_per" })
	private double customerDiscPer;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_per" })
	private double specialDiscPer;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_amount" })
	private double specialDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "total_mrp" })
	private double totalMrp;
	
	private static final long serialVersionUID = 1L;
	
	public double getTotalMrp() {
		return totalMrp;
	}


	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}


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


	public double getCustomerDiscPer() {
		return customerDiscPer;
	}


	public void setCustomerDiscPer(double customerDiscPer) {
		this.customerDiscPer = customerDiscPer;
	}


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


	public int getInvMode() {
		return invMode;
	}


	public void setInvMode(int invMode) {
		this.invMode = invMode;
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


	public String getCardFourDigit() {
		return cardFourDigit;
	}


	public void setCardFourDigit(String cardFourDigit) {
		this.cardFourDigit = cardFourDigit;
	}


	public String getCardExpDate() {
		return cardExpDate;
	}


	public void setCardExpDate(String cardExpDate) {
		this.cardExpDate = cardExpDate;
	}


	public double getTenderAmount() {
		return tenderAmount;
	}


	public void setTenderAmount(double tenderAmount) {
		this.tenderAmount = tenderAmount;
	}


	public int getPrintCount() {
		return printCount;
	}


	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}


	public int getHoldFlag() {
		return holdFlag;
	}


	public void setHoldFlag(int holdFlag) {
		this.holdFlag = holdFlag;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cardAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((cardExpDate == null) ? 0 : cardExpDate.hashCode());
		result = prime * result
				+ ((cardFourDigit == null) ? 0 : cardFourDigit.hashCode());
		temp = Double.doubleToLongBits(cashAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((customerAddress == null) ? 0 : customerAddress.hashCode());
		temp = Double.doubleToLongBits(customerDiscPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		result = prime * result + holdFlag;
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + invMode;
		result = prime * result
				+ ((invModeName == null) ? 0 : invModeName.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isPosted;
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + printCount;
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		temp = Double.doubleToLongBits(roundoff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saleId;
		temp = Double.doubleToLongBits(specialDiscAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(specialDiscPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tenderAmount);
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
		SaleDetailsAllDTO other = (SaleDetailsAllDTO) obj;
		if (Double.doubleToLongBits(adjAmount) != Double
				.doubleToLongBits(other.adjAmount))
			return false;
		if (Double.doubleToLongBits(cardAmount) != Double
				.doubleToLongBits(other.cardAmount))
			return false;
		if (cardExpDate == null) {
			if (other.cardExpDate != null)
				return false;
		} else if (!cardExpDate.equals(other.cardExpDate))
			return false;
		if (cardFourDigit == null) {
			if (other.cardFourDigit != null)
				return false;
		} else if (!cardFourDigit.equals(other.cardFourDigit))
			return false;
		if (Double.doubleToLongBits(cashAmount) != Double
				.doubleToLongBits(other.cashAmount))
			return false;
		if (Double.doubleToLongBits(creditAmount) != Double
				.doubleToLongBits(other.creditAmount))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (Double.doubleToLongBits(customerDiscPer) != Double
				.doubleToLongBits(other.customerDiscPer))
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
		if (holdFlag != other.holdFlag)
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
		if (Double.doubleToLongBits(netAmount) != Double
				.doubleToLongBits(other.netAmount))
			return false;
		if (printCount != other.printCount)
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (Double.doubleToLongBits(roundoff) != Double
				.doubleToLongBits(other.roundoff))
			return false;
		if (saleId != other.saleId)
			return false;
		if (Double.doubleToLongBits(specialDiscAmount) != Double
				.doubleToLongBits(other.specialDiscAmount))
			return false;
		if (Double.doubleToLongBits(specialDiscPer) != Double
				.doubleToLongBits(other.specialDiscPer))
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double
				.doubleToLongBits(other.taxAmount))
			return false;
		if (Double.doubleToLongBits(tenderAmount) != Double
				.doubleToLongBits(other.tenderAmount))
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
		return "SaleDetailsAllDTO [saleId=" + saleId + ", invNo=" + invNo
				+ ", invDate=" + invDate + ", invMode=" + invMode
				+ ", invModeName=" + invModeName + ", grossAmount="
				+ grossAmount + ", edAmount=" + edAmount + ", discAmount="
				+ discAmount + ", vatAmount=" + vatAmount + ", taxAmount="
				+ taxAmount + ", adjAmount=" + adjAmount + ", roundoff="
				+ roundoff + ", netAmount=" + netAmount + ", cashAmount="
				+ cashAmount + ", cardAmount=" + cardAmount + ", creditAmount="
				+ creditAmount + ", cardFourDigit=" + cardFourDigit
				+ ", cardExpDate=" + cardExpDate + ", tenderAmount="
				+ tenderAmount + ", printCount=" + printCount + ", holdFlag="
				+ holdFlag + ", remarks=" + remarks + ", customerId="
				+ customerId + ", customerName=" + customerName
				+ ", customerPhone=" + customerPhone + ", customerAddress="
				+ customerAddress + ", doctorId=" + doctorId + ", doctorName="
				+ doctorName + ", isPosted=" + isPosted + ", customerDiscPer="
				+ customerDiscPer + ", specialDiscPer=" + specialDiscPer
				+ ", specialDiscAmount=" + specialDiscAmount + ", totalMrp="
				+ totalMrp + "]";
	}


	
	
	
}