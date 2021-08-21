package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class TaxDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;

	@Expose
	@MapToData(columnAliases = { "tax_name" })
	private String taxName;
	
	@Expose
	@MapToData(columnAliases = { "percentage" })
	private double percentage;
	
	@Expose
	@MapToData(columnAliases = { "description" })
	private String description;
	
	@Expose
	@MapToData(columnAliases = { "is_group" })
	private int isGroup;
	
	@Expose
	@MapToData(columnAliases = { "tax_mode" })
	private String taxMode;


	private static final long serialVersionUID = 1L;

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

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(int isGroup) {
		this.isGroup = isGroup;
	}

	

	public String getTaxMode() {
		return taxMode;
	}

	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + isGroup;
		long temp;
		temp = Double.doubleToLongBits(percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + taxId;
		result = prime * result + ((taxMode == null) ? 0 : taxMode.hashCode());
		result = prime * result + ((taxName == null) ? 0 : taxName.hashCode());
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
		TaxDTO other = (TaxDTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isGroup != other.isGroup)
			return false;
		if (Double.doubleToLongBits(percentage) != Double
				.doubleToLongBits(other.percentage))
			return false;
		if (taxId != other.taxId)
			return false;
		if (taxMode == null) {
			if (other.taxMode != null)
				return false;
		} else if (!taxMode.equals(other.taxMode))
			return false;
		if (taxName == null) {
			if (other.taxName != null)
				return false;
		} else if (!taxName.equals(other.taxName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaxDTO [taxId=" + taxId + ", taxName=" + taxName
				+ ", percentage=" + percentage + ", description=" + description
				+ ", isGroup=" + isGroup + ", taxMode=" + taxMode + "]";
	}

	
	

}