package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;



@XmlRootElement
public class DistributorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;

	@Expose
	@MapToData(columnAliases = { "name" })
	private String name;

	@Expose
	@MapToData(columnAliases = { "pin" })
	private String pin;

	@Expose
	@MapToData(columnAliases = { "address" })
	private String address;

	@Expose
	@MapToData(columnAliases = { "city" })
	private String city;

	@Expose
	@MapToData(columnAliases = { "state" })
	private String state;

	@Expose
	@MapToData(columnAliases = { "country" })
	private String country;

	@Expose
	@MapToData(columnAliases = { "phone_no1" })
	private String phoneNo1;

	@Expose
	@MapToData(columnAliases = { "phone_no2" })
	private String phoneNo2;

	@Expose
	@MapToData(columnAliases = { "fax" })
	private String fax;

	@Expose
	@MapToData(columnAliases = { "email" })
	private String email;

	@Expose
	@MapToData(columnAliases = { "contact_person" })
	private String contactPerson;

	@Expose
	@MapToData(columnAliases = { "registration_no" })
	private String registrationNo;

	@Expose
	@MapToData(columnAliases = { "ob_bal" })
	private double obBal;

	@Expose
	@MapToData(columnAliases = { "credit_limit" })
	private double creditLimit;

	@Expose
	@MapToData(columnAliases = { "discount" })
	private double discount;

	@Expose
	@MapToData(columnAliases = { "discount_amount" })
	private double discountAmount;

	@Expose
	@MapToData(columnAliases = { "licence_no" })
	private String licenceNo;
	
	@Expose
	@Transient
	private int finyrId;
	
	@Expose
	@MapToData(columnAliases = { "payble_amount" })
	private double paybleAmount;
	
	@Expose
	@MapToData(columnAliases = { "payble_text" })
	private String paybleText;
	
	@Expose
	@MapToData(columnAliases = { "outstanding_amount" })
	private double outstandingAmount;
	

	public double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

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

	public int getFinyrId() {
		return finyrId;
	}

	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}
	
	
}