package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class TaxDetailsSaleBillDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;
	
	@Expose
	@MapToData(columnAliases = { "tax_name" })
	private String taxName;
	
	@Expose
	@MapToData(columnAliases = { "tax_percentage" })
	private double taxPercentage;
	
	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;
	
	
	@Expose
	@MapToData(columnAliases = { "taxable_amount" })
	private double taxableAmount;
	
	@Expose
	@MapToData(columnAliases = { "CGST" })
	private double cgst;
	
	@Expose
	@MapToData(columnAliases = { "CGST_percentage" })
	private double cgstPercentage;
	
	@Expose
	@MapToData(columnAliases = { "SGST" })
	private double sgst;
	
	@Expose
	@MapToData(columnAliases = { "SGST_percentage" })
	private double sgstPercentage;
	
	@Expose
	@MapToData(columnAliases = { "IGST" })
	private double igst;
	
	@Expose
	@MapToData(columnAliases = { "IGST_percentage" })
	private double igstPercentage;

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	@Override
	public String toString() {
		return "TaxDetailsSaleBillDTO [taxId=" + taxId + ", taxName=" + taxName
				+ ", taxPercentage=" + taxPercentage + ", taxAmount="
				+ taxAmount + ", taxableAmount=" + taxableAmount + ", cgst="
				+ cgst + ", cgstPercentage=" + cgstPercentage + ", sgst="
				+ sgst + ", sgstPercentage=" + sgstPercentage + ", igst="
				+ igst + ", igstPercentage=" + igstPercentage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cgst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cgstPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(igst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(igstPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sgst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sgstPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + taxId;
		result = prime * result + ((taxName == null) ? 0 : taxName.hashCode());
		temp = Double.doubleToLongBits(taxPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxableAmount);
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
		TaxDetailsSaleBillDTO other = (TaxDetailsSaleBillDTO) obj;
		if (Double.doubleToLongBits(cgst) != Double
				.doubleToLongBits(other.cgst))
			return false;
		if (Double.doubleToLongBits(cgstPercentage) != Double
				.doubleToLongBits(other.cgstPercentage))
			return false;
		if (Double.doubleToLongBits(igst) != Double
				.doubleToLongBits(other.igst))
			return false;
		if (Double.doubleToLongBits(igstPercentage) != Double
				.doubleToLongBits(other.igstPercentage))
			return false;
		if (Double.doubleToLongBits(sgst) != Double
				.doubleToLongBits(other.sgst))
			return false;
		if (Double.doubleToLongBits(sgstPercentage) != Double
				.doubleToLongBits(other.sgstPercentage))
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double
				.doubleToLongBits(other.taxAmount))
			return false;
		if (taxId != other.taxId)
			return false;
		if (taxName == null) {
			if (other.taxName != null)
				return false;
		} else if (!taxName.equals(other.taxName))
			return false;
		if (Double.doubleToLongBits(taxPercentage) != Double
				.doubleToLongBits(other.taxPercentage))
			return false;
		if (Double.doubleToLongBits(taxableAmount) != Double
				.doubleToLongBits(other.taxableAmount))
			return false;
		return true;
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

	public double getCgstPercentage() {
		return cgstPercentage;
	}

	public void setCgstPercentage(double cgstPercentage) {
		this.cgstPercentage = cgstPercentage;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getSgstPercentage() {
		return sgstPercentage;
	}

	public void setSgstPercentage(double sgstPercentage) {
		this.sgstPercentage = sgstPercentage;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getIgstPercentage() {
		return igstPercentage;
	}

	public void setIgstPercentage(double igstPercentage) {
		this.igstPercentage = igstPercentage;
	}
	
	

}