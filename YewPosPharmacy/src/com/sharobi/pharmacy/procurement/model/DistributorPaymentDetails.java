package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class DistributorPaymentDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "inv_from" })
	private String invFrom;
	
	@Expose
	@MapToData(columnAliases = { "inv_id" })
	private int invId;
	
	public int getInvId() {
		return invId;
	}

	@XmlElement
	public void setInvId(int invId) {
		this.invId = invId;
	}

	public String getInvFrom() {
		return invFrom;
	}

	@XmlElement
	public void setInvFrom(String invFrom) {
		this.invFrom = invFrom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invFrom == null) ? 0 : invFrom.hashCode());
		result = prime * result + invId;
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
		DistributorPaymentDetails other = (DistributorPaymentDetails) obj;
		if (invFrom == null) {
			if (other.invFrom != null)
				return false;
		} else if (!invFrom.equals(other.invFrom))
			return false;
		if (invId != other.invId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DistributorPaymentFooter [invFrom=" + invFrom + ", invId="
				+ invId + "]";
	}

	
}