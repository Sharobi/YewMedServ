package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: pur_t_purchase_details_tax_mapping
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pur_t_purchase_details_tax_mapping")
public class PurchaseDetailsTaxMapper implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "purchase_id")
	private int purchaseId;
	
	@Expose
	@Column(name = "purchase_details_id")
	private int purchaseDetailsId;
	
	@Expose
	@Column(name = "item_id")
	private int itemId;

		
	@Expose
	@Column(name = "tax_id")
	private int taxId;
	
	@Expose
	@Column(name = "percentage")
	private double percentage;
	
	@Expose
	@Column(name = "amount")
	private double amount;
	
	@Expose
	@Column(name = "tax_mode")
	private String taxMode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getPurchaseDetailsId() {
		return purchaseDetailsId;
	}

	public void setPurchaseDetailsId(int purchaseDetailsId) {
		this.purchaseDetailsId = purchaseDetailsId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTaxMode() {
		return taxMode;
	}

	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}
	
	
}