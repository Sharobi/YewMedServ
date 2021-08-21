package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: in_m_tax_group_details
 * 
 */

@XmlRootElement
@Entity
@Table(name = "in_m_tax_group_details")
public class TaxGrpDetailsMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "parent_id")
	private int parentId;

	@Expose
	@Column(name = "percentage")
	private double percentage;
	
	@Expose
	@Column(name = "description")
	private String description;
	
	@Expose
	@Column(name = "tax_id")
	private int taxId;
	
	@Expose
	@Column(name = "tax_mode")
	private String taxMode;
	
	@Expose
	@Transient
	private String taxName;
	
	
	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public String getTaxMode() {
		return taxMode;
	}

	@XmlElement
	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	@XmlElement
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public double getPercentage() {
		return percentage;
	}

	@XmlElement
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public int getTaxId() {
		return taxId;
	}

	@XmlElement
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	
	

}