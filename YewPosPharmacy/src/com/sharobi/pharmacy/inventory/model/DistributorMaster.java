package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: in_m_distributor
 * 
 */

@XmlRootElement
@Entity
@Table(name = "in_m_distributor")
public class DistributorMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "name")
	private String name;

	@Expose
	@Column(name = "pin")
	private String pin;

	@Expose
	@Column(name = "address")
	private String address;

	@Expose
	@Column(name = "city")
	private String city;

	@Expose
	@Column(name = "state")
	private String state;

	@Expose
	@Column(name = "country")
	private String country;

	@Expose
	@Column(name = "phone_no1")
	private String phoneNo1;

	@Expose
	@Column(name = "phone_no2")
	private String phoneNo2;

	@Expose
	@Column(name = "fax")
	private String fax;

	@Expose
	@Column(name = "email")
	private String email;

	@Expose
	@Column(name = "contact_person")
	private String contactPerson;

	@Expose
	@Column(name = "registration_no")
	private String registrationNo;

	@Expose
	@Column(name = "ob_bal")
	private double obBal;

	@Expose
	@Column(name = "credit_limit")
	private double creditLimit;

	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;

	@Expose
	@Column(name = "store_id")
	private int storeId;

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
	private String lang;

	

	@Expose
	@Column(name = "discount")
	private double discount;

	@Expose
	@Column(name = "discount_amount")
	private double discountAmount;

	@Expose
	@Column(name = "licence_no")
	private String licenceNo;
	
	@Expose
	@Transient
	private int finyrId;
	
	@Expose
	@Transient
	private double paybleAmount;
	
	@Expose
	@Transient
	private String paybleText;
	
	/*@Expose
	@Column(name = "due_days")
	private int dueDays;
	
	@Expose
	@Column(name = "due_per")
	private double duePer;*/
	
	
	

	/*public int getDueDays() {
		return dueDays;
	}

	public void setDueDays(int dueDays) {
		this.dueDays = dueDays;
	}

	public double getDuePer() {
		return duePer;
	}

	public void setDuePer(double duePer) {
		this.duePer = duePer;
	}*/

	public double getPaybleAmount() {
		return paybleAmount;
	}

	public void setPaybleAmount(double paybleAmount) {
		this.paybleAmount = paybleAmount;
	}

	public String getPaybleText() {
		return paybleText;
	}

	public void setPaybleText(String paybleText) {
		this.paybleText = paybleText;
	}

	public int getFinyrId() {
		return finyrId;
	}

	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public String getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public double getObBal() {
		return obBal;
	}

	public void setObBal(double obBal) {
		this.obBal = obBal;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "DistributorMaster [id=" + id + ", name=" + name + ", pin=" + pin + ", address=" + address + ", city="
				+ city + ", state=" + state + ", country=" + country + ", phoneNo1=" + phoneNo1 + ", phoneNo2="
				+ phoneNo2 + ", fax=" + fax + ", email=" + email + ", contactPerson=" + contactPerson
				+ ", registrationNo=" + registrationNo + ", obBal=" + obBal + ", creditLimit=" + creditLimit
				+ ", companyId=" + companyId + ", isDeleted=" + isDeleted + ", storeId=" + storeId + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + ", lang=" + lang + ", discount=" + discount + ", discountAmount=" + discountAmount
				+ ", licenceNo=" + licenceNo + ", finyrId=" + finyrId + ", paybleAmount=" + paybleAmount
				+ ", paybleText=" + paybleText + "]";
	}

}