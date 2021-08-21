package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SaleHeaderDTO implements Serializable {
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
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;

	@Expose
	@MapToData(columnAliases = { "customer_disc_per" })
	private double customerDiscPer;

	@Expose
	@MapToData(columnAliases = { "inv_time" })
	private String invTime;

	@Expose
	@MapToData(columnAliases = { "sale_return_id" })
	private int saleReturnId;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_per" })
	private double specialDiscPer;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_amount" })
	private double specialDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "credit_limit" })
	private double creditLimit;
	
	@Expose
	@MapToData(columnAliases = { "total_amount" })
	private double totalAmount;
	
	@Expose
	@MapToData(columnAliases = { "taxable_amount" })
	private double taxableAmount;
	
	@Expose
	@MapToData(columnAliases = { "CGST" })
	private double cgst;
	
	@Expose
	@MapToData(columnAliases = { "SGST" })
	private double sgst;
	
	@Expose
	@MapToData(columnAliases = { "IGST" })
	private double igst;
	
	@Expose
	@MapToData(columnAliases = { "total_mrp" })
	private double totalMrp;
	
	@Expose
	@MapToData(columnAliases = { "esi_type" })
	private String esiType;
	
	@Expose
	@MapToData(columnAliases = { "prescription_reg_no" })
	private String prescriptionRegNo;
	
	@Expose
	@MapToData(columnAliases = { "prescription_issue_date" })
	private Date prescriptionIssueDate;
	
	@Expose
	@MapToData(columnAliases = { "slip_no" })
	private String slipNo;
	
	@Expose
	@MapToData(columnAliases = { "esi_code" })
	private String esiCode;
	
	@Expose
	@MapToData(columnAliases = { "customer_code" })
	private String customerCode;
	
	@Expose
	@MapToData(columnAliases = { "gender" })
	private String gender;
	
	@Expose
	@MapToData(columnAliases = { "place_of_treatment" })
	private String placeOfTreatment;
	
	@Expose
	@MapToData(columnAliases = { "total_return_amount" })
	private double totalReturnAmount;
	
	@Expose
	@MapToData(columnAliases = { "all_return_ids" })
	private String allReturnIds;
	
	@Expose
	@MapToData(columnAliases = { "customer_gst_no" })
	private String customerGstNo;
	
	@Expose
	@MapToData(columnAliases = { "customer_pan_no"})
	private String customerPanNo;
	
	//02.03.2020
		@Expose
		@MapToData(columnAliases = { "consi_name" })
		private String consiName;
		
		@Expose
		@MapToData(columnAliases = { "consi_address" })
		private String consiAddress;
		
		@Expose
		@MapToData(columnAliases = { "consi_phone" })
		private String consiPhone;
		
		@Expose
		@MapToData(columnAliases = { "consi_gst_no" })
		private String consiGstNo;
		
		@Expose
		@MapToData(columnAliases = { "consi_state_id" })
		private int consiStateId;
		
		@Expose
		@MapToData(columnAliases = { "guardian_name" })
		private String guardianName;

	private static final long serialVersionUID = 1L;
	
	
	public String getPlaceOfTreatment() {
		return placeOfTreatment;
	}

	public void setPlaceOfTreatment(String placeOfTreatment) {
		this.placeOfTreatment = placeOfTreatment;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEsiType() {
		return esiType;
	}

	public void setEsiType(String esiType) {
		this.esiType = esiType;
	}

	public String getPrescriptionRegNo() {
		return prescriptionRegNo;
	}

	public void setPrescriptionRegNo(String prescriptionRegNo) {
		this.prescriptionRegNo = prescriptionRegNo;
	}

	public Date getPrescriptionIssueDate() {
		return prescriptionIssueDate;
	}

	public void setPrescriptionIssueDate(Date prescriptionIssueDate) {
		this.prescriptionIssueDate = prescriptionIssueDate;
	}

	public String getSlipNo() {
		return slipNo;
	}

	public void setSlipNo(String slipNo) {
		this.slipNo = slipNo;
	}

	public String getEsiCode() {
		return esiCode;
	}

	public void setEsiCode(String esiCode) {
		this.esiCode = esiCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	
	public double getTotalMrp() {
		return totalMrp;
	}

	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
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

	public int getSaleReturnId() {
		return saleReturnId;
	}

	public void setSaleReturnId(int saleReturnId) {
		this.saleReturnId = saleReturnId;
	}

	public String getInvTime() {
		return invTime;
	}

	public void setInvTime(String invTime) {
		this.invTime = invTime;
	}

	public double getCustomerDiscPer() {
		return customerDiscPer;
	}

	public void setCustomerDiscPer(double customerDiscPer) {
		this.customerDiscPer = customerDiscPer;
	}

	public int getIsPosted() {
		return isPosted;
	}

	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
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

	public Double getTotalReturnAmount() {
		return totalReturnAmount;
	}

	public void setTotalReturnAmount(Double totalReturnAmount) {
		this.totalReturnAmount = totalReturnAmount;
	}
	
	public String getAllReturnIds() {
		return allReturnIds;
	}

	public void setAllReturnIds(String allReturnIds) {
		this.allReturnIds = allReturnIds;
	}

	
	public String getCustomerGstNo() {
		return customerGstNo;
	}

	public void setCustomerGstNo(String customerGstNo) {
		this.customerGstNo = customerGstNo;
	}

	public String getCustomerPanNo() {
		return customerPanNo;
	}

	public void setCustomerPanNo(String customerPanNo) {
		this.customerPanNo = customerPanNo;
	}

	
	
	public String getConsiName() {
		return consiName;
	}

	public void setConsiName(String consiName) {
		this.consiName = consiName;
	}

	public String getConsiAddress() {
		return consiAddress;
	}

	public void setConsiAddress(String consiAddress) {
		this.consiAddress = consiAddress;
	}

	public String getConsiPhone() {
		return consiPhone;
	}

	public void setConsiPhone(String consiPhone) {
		this.consiPhone = consiPhone;
	}

	public String getConsiGstNo() {
		return consiGstNo;
	}

	public void setConsiGstNo(String consiGstNo) {
		this.consiGstNo = consiGstNo;
	}

	public int getConsiStateId() {
		return consiStateId;
	}

	public void setConsiStateId(int consiStateId) {
		this.consiStateId = consiStateId;
	}
	
	

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
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
		temp = Double.doubleToLongBits(cgst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditLimit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result
				+ ((customerCode == null) ? 0 : customerCode.hashCode());
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
		result = prime * result + ((esiCode == null) ? 0 : esiCode.hashCode());
		result = prime * result + ((esiType == null) ? 0 : esiType.hashCode());
		temp = Double.doubleToLongBits(grossAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + holdFlag;
		temp = Double.doubleToLongBits(igst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + invMode;
		result = prime * result
				+ ((invModeName == null) ? 0 : invModeName.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + ((invTime == null) ? 0 : invTime.hashCode());
		result = prime * result + isPosted;
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime
				* result
				+ ((prescriptionIssueDate == null) ? 0 : prescriptionIssueDate
						.hashCode());
		result = prime
				* result
				+ ((prescriptionRegNo == null) ? 0 : prescriptionRegNo
						.hashCode());
		result = prime * result + printCount;
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		temp = Double.doubleToLongBits(roundoff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saleId;
		result = prime * result + saleReturnId;
		temp = Double.doubleToLongBits(sgst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((slipNo == null) ? 0 : slipNo.hashCode());
		temp = Double.doubleToLongBits(specialDiscAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(specialDiscPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxableAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tenderAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalAmount);
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
		SaleHeaderDTO other = (SaleHeaderDTO) obj;
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
		if (Double.doubleToLongBits(cgst) != Double
				.doubleToLongBits(other.cgst))
			return false;
		if (Double.doubleToLongBits(creditAmount) != Double
				.doubleToLongBits(other.creditAmount))
			return false;
		if (Double.doubleToLongBits(creditLimit) != Double
				.doubleToLongBits(other.creditLimit))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerCode == null) {
			if (other.customerCode != null)
				return false;
		} else if (!customerCode.equals(other.customerCode))
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
		if (esiCode == null) {
			if (other.esiCode != null)
				return false;
		} else if (!esiCode.equals(other.esiCode))
			return false;
		if (esiType == null) {
			if (other.esiType != null)
				return false;
		} else if (!esiType.equals(other.esiType))
			return false;
		if (Double.doubleToLongBits(grossAmount) != Double
				.doubleToLongBits(other.grossAmount))
			return false;
		if (holdFlag != other.holdFlag)
			return false;
		if (Double.doubleToLongBits(igst) != Double
				.doubleToLongBits(other.igst))
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
		if (invTime == null) {
			if (other.invTime != null)
				return false;
		} else if (!invTime.equals(other.invTime))
			return false;
		if (isPosted != other.isPosted)
			return false;
		if (Double.doubleToLongBits(netAmount) != Double
				.doubleToLongBits(other.netAmount))
			return false;
		if (prescriptionIssueDate == null) {
			if (other.prescriptionIssueDate != null)
				return false;
		} else if (!prescriptionIssueDate.equals(other.prescriptionIssueDate))
			return false;
		if (prescriptionRegNo == null) {
			if (other.prescriptionRegNo != null)
				return false;
		} else if (!prescriptionRegNo.equals(other.prescriptionRegNo))
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
		if (saleReturnId != other.saleReturnId)
			return false;
		if (Double.doubleToLongBits(sgst) != Double
				.doubleToLongBits(other.sgst))
			return false;
		if (slipNo == null) {
			if (other.slipNo != null)
				return false;
		} else if (!slipNo.equals(other.slipNo))
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
		if (Double.doubleToLongBits(taxableAmount) != Double
				.doubleToLongBits(other.taxableAmount))
			return false;
		if (Double.doubleToLongBits(tenderAmount) != Double
				.doubleToLongBits(other.tenderAmount))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double
				.doubleToLongBits(other.totalAmount))
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
		return "SaleHeaderDTO [saleId=" + saleId + ", invNo=" + invNo + ", invDate=" + invDate + ", invMode=" + invMode
				+ ", invModeName=" + invModeName + ", grossAmount=" + grossAmount + ", edAmount=" + edAmount
				+ ", discAmount=" + discAmount + ", vatAmount=" + vatAmount + ", taxAmount=" + taxAmount
				+ ", adjAmount=" + adjAmount + ", roundoff=" + roundoff + ", netAmount=" + netAmount + ", remarks="
				+ remarks + ", customerId=" + customerId + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerAddress=" + customerAddress + ", doctorId=" + doctorId + ", doctorName="
				+ doctorName + ", cashAmount=" + cashAmount + ", cardAmount=" + cardAmount + ", creditAmount="
				+ creditAmount + ", cardFourDigit=" + cardFourDigit + ", cardExpDate=" + cardExpDate + ", tenderAmount="
				+ tenderAmount + ", printCount=" + printCount + ", holdFlag=" + holdFlag + ", isPosted=" + isPosted
				+ ", customerDiscPer=" + customerDiscPer + ", invTime=" + invTime + ", saleReturnId=" + saleReturnId
				+ ", specialDiscPer=" + specialDiscPer + ", specialDiscAmount=" + specialDiscAmount + ", creditLimit="
				+ creditLimit + ", totalAmount=" + totalAmount + ", taxableAmount=" + taxableAmount + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", igst=" + igst + ", totalMrp=" + totalMrp + ", esiType=" + esiType
				+ ", prescriptionRegNo=" + prescriptionRegNo + ", prescriptionIssueDate=" + prescriptionIssueDate
				+ ", slipNo=" + slipNo + ", esiCode=" + esiCode + ", customerCode=" + customerCode + ", gender="
				+ gender + ", placeOfTreatment=" + placeOfTreatment + ", totalReturnAmount=" + totalReturnAmount
				+ ", allReturnIds=" + allReturnIds + ", customerGstNo=" + customerGstNo + ", customerPanNo="
				+ customerPanNo + ", consiName=" + consiName + ", consiAddress=" + consiAddress + ", consiPhone="
				+ consiPhone + ", consiGstNo=" + consiGstNo + ", consiStateId=" + consiStateId + ", guardianName="
				+ guardianName + "]";
	}

	

	


}