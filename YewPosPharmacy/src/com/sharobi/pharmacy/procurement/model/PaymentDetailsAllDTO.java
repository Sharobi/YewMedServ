package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class PaymentDetailsAllDTO implements Serializable {

	@Expose
	@MapToData(columnAliases = { "payment_id" })
	private int paymentId;
	
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
	@MapToData(columnAliases = { "payable_amount" })
	private double paybleAmount;

	@Expose
	@MapToData(columnAliases = { "outstanding_amount" })
	private double outstandingAmount;

	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;

	@Expose
	@MapToData(columnAliases = { "roundoff" })
	private double roundoff;

	@Expose
	@MapToData(columnAliases = { "pay_amount" })
	private double payAmount;

	@Expose
	@MapToData(columnAliases = { "remaining_amount" })
	private double remainingAmount;
	
	@Expose
	@MapToData(columnAliases = { "card_no" })
	private String cardNo;

	@Expose
	@MapToData(columnAliases = { "cheque_no" })
	private String chequeNo;

	@Expose
	@MapToData(columnAliases = { "cheque_date" })
	private Date chequeDate;
	
	@Expose
	@MapToData(columnAliases = { "bank_name" })
	private String bankName;

	@Expose
	@MapToData(columnAliases = { "distributor_id" })
	private int supplierId;

	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String supplierName;
	
	@Expose
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;
	
	@Expose
	@MapToData(columnAliases = { "created_by" })
	private int createdBy;
	
	@Expose
	@MapToData(columnAliases = { "remarks" })
	private String remarks;
	
	@Expose
	@MapToData(columnAliases = { "created_by_user" })
	private String createdByUser;
	

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	private static final long serialVersionUID = 1L;
	
	
	public int getIsPosted() {
		return isPosted;
	}

	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
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

	
	

	public String getInvModeName() {
		return invModeName;
	}

	public void setInvModeName(String invModeName) {
		this.invModeName = invModeName;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getPaybleAmount() {
		return paybleAmount;
	}

	public void setPaybleAmount(double paybleAmount) {
		this.paybleAmount = paybleAmount;
	}

	public double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		if(chequeNo.equals(""))
		{
			this.chequeNo = "0";
		}
		else
		{
			this.chequeNo = chequeNo;
		}
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result
				+ ((chequeDate == null) ? 0 : chequeDate.hashCode());
		result = prime * result
				+ ((chequeNo == null) ? 0 : chequeNo.hashCode());
		result = prime * result + createdBy;
		result = prime * result
				+ ((createdByUser == null) ? 0 : createdByUser.hashCode());
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + invMode;
		result = prime * result
				+ ((invModeName == null) ? 0 : invModeName.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isPosted;
		long temp;
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(outstandingAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(payAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(paybleAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + paymentId;
		temp = Double.doubleToLongBits(remainingAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		temp = Double.doubleToLongBits(roundoff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + supplierId;
		result = prime * result
				+ ((supplierName == null) ? 0 : supplierName.hashCode());
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
		PaymentDetailsAllDTO other = (PaymentDetailsAllDTO) obj;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (chequeDate == null) {
			if (other.chequeDate != null)
				return false;
		} else if (!chequeDate.equals(other.chequeDate))
			return false;
		if (chequeNo == null) {
			if (other.chequeNo != null)
				return false;
		} else if (!chequeNo.equals(other.chequeNo))
			return false;
		if (createdBy != other.createdBy)
			return false;
		if (createdByUser == null) {
			if (other.createdByUser != null)
				return false;
		} else if (!createdByUser.equals(other.createdByUser))
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
		if (Double.doubleToLongBits(outstandingAmount) != Double
				.doubleToLongBits(other.outstandingAmount))
			return false;
		if (Double.doubleToLongBits(payAmount) != Double
				.doubleToLongBits(other.payAmount))
			return false;
		if (Double.doubleToLongBits(paybleAmount) != Double
				.doubleToLongBits(other.paybleAmount))
			return false;
		if (paymentId != other.paymentId)
			return false;
		if (Double.doubleToLongBits(remainingAmount) != Double
				.doubleToLongBits(other.remainingAmount))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (Double.doubleToLongBits(roundoff) != Double
				.doubleToLongBits(other.roundoff))
			return false;
		if (supplierId != other.supplierId)
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaymentDetailsAllDTO [paymentId=" + paymentId + ", invNo="
				+ invNo + ", invDate=" + invDate + ", invMode=" + invMode
				+ ", invModeName=" + invModeName + ", paybleAmount="
				+ paybleAmount + ", outstandingAmount=" + outstandingAmount
				+ ", netAmount=" + netAmount + ", roundoff=" + roundoff
				+ ", payAmount=" + payAmount + ", remainingAmount="
				+ remainingAmount + ", cardNo=" + cardNo + ", chequeNo="
				+ chequeNo + ", chequeDate=" + chequeDate + ", bankName="
				+ bankName + ", supplierId=" + supplierId + ", supplierName="
				+ supplierName + ", isPosted=" + isPosted + ", createdBy="
				+ createdBy + ", remarks=" + remarks + ", createdByUser="
				+ createdByUser + "]";
	}

	
	

	
}