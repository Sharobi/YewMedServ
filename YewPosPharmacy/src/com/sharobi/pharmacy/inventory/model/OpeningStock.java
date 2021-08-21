package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;



@XmlRootElement
public class OpeningStock implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Transient
	private List<OpeningStockDetails> openingStockDetails;

	public List<OpeningStockDetails> getOpeningStockDetails() {
		return openingStockDetails;
	}

	public void setOpeningStockDetails(List<OpeningStockDetails> openingStockDetails) {
		this.openingStockDetails = openingStockDetails;
	}
	
	

	
	

}