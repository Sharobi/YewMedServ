package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;
/**
 * Entity implementation class for Entity: in_m_tax
 * 
 */

@XmlRootElement
@Entity
@Table(name = "in_m_tax")
public class TaxMaster implements Serializable {

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "name")
	private String name;

	@Expose
	@Column(name = "percentage")
	private double percentage;
	
	@Expose
	@Column(name = "description")
	private String description;
	
	
	@Expose
	@Column(name = "is_group")
	private int isGroup;

	@Expose
	@Column(name = "tax_mode")
	private String taxMode;
	
	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;
	
	
	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	
	@Expose
	@Column(name = "created_by")
	private int createdBy;

	@Expose
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Expose
	@Column(name = "updated_by")
	private int updatedBy;

	@Expose
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@Expose
	@Transient
	private List<TaxGrpDetailsMaster> taxGrpDetailsMasters;
	

	private static final long serialVersionUID = 1L;

	

	public List<TaxGrpDetailsMaster> getTaxGrpDetailsMasters() {
		return taxGrpDetailsMasters;
	}


	public void setTaxGrpDetailsMasters(
			List<TaxGrpDetailsMaster> taxGrpDetailsMasters) {
		this.taxGrpDetailsMasters = taxGrpDetailsMasters;
	}


	public int getId() {
		return id;
	}


	@XmlElement
	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	@XmlElement
	public void setName(String name) {
		this.name = name;
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


	public int getIsGroup() {
		return isGroup;
	}


	@XmlElement
	public void setIsGroup(int isGroup) {
		this.isGroup = isGroup;
	}


	public String getTaxMode() {
		return taxMode;
	}


	@XmlElement
	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}


	public int getIsDeleted() {
		return isDeleted;
	}


	@XmlElement
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


	public int getCompanyId() {
		return companyId;
	}


	@XmlElement
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public int getCreatedBy() {
		return createdBy;
	}


	@XmlElement
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	@XmlElement
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public int getUpdatedBy() {
		return updatedBy;
	}


	@XmlElement
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	@XmlElement
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	

	
}