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
 * Entity implementation class for Entity: in_m_customer
 * 
 */

@XmlRootElement
@Entity
@Table(name = "in_m_customer")
public class CustomerMaster implements Serializable {

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
	@Column(name = "code")
	private String code;

	@Expose
	@Column(name = "address")
	private String address;

	@Expose
	@Column(name = "pin")
	private String pin;

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
	@Column(name = "phone_no")
	private String phoneNo;

	@Expose
	@Column(name = "fax")
	private String fax;

	@Expose
	@Column(name = "ob_bal")
	private double obBal;

	@Expose
	@Column(name = "credit_limit")
	private double creditLimit;

	@Expose
	@Column(name = "store_id")
	private int storeId;

	@Expose
	@Column(name = "company_id")
	private int companyId;

	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;

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
	@Transient
	private int finyrId;
	
	@Expose
	@Column(name = "addhar_card_no")
	private String addharCardNo;
	
	@Expose
	@Column(name = "dob")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	
	@Expose
	@Column(name = "gender")
	private String gender;
	
	//22.03.2018
	@Expose
	@Column(name = "age")
	private int age;
	
	@Expose
	@Column(name = "guardian_name")
	private String guardian_name;
	
	@Expose
	@Column(name = "pan_no")
	private String panNo;
	
	@Expose
	@Column(name = "gst_no")
	private String gstNo;
	
	//02.03.2020
	@Expose
	@Column(name = "consi_name")
	private String consiName;
	@Expose
	@Column(name = "consi_address")
	private String consiAddress;
	@Expose
	@Column(name = "consi_phone")
	private String consiPhone;
	
	@Expose
	@Column(name = "consi_gst_no")
	private String consiGstNo;
	
	@Expose
	@Column(name = "consi_state_id")
	private int consiStateId;
	
	public CustomerMaster() {
		// TODO Auto-generated constructor stub
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddharCardNo() {
		return addharCardNo;
	}

	public void setAddharCardNo(String addharCardNo) {
		this.addharCardNo = addharCardNo;
	}

	public int getFinyrId() {
		return finyrId;
	}

	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGuardian_name() {
		return guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
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

	

	@Override
	public String toString() {
		return "CustomerMaster [id=" + id + ", name=" + name + ", code=" + code + ", address=" + address + ", pin="
				+ pin + ", city=" + city + ", state=" + state + ", country=" + country + ", phoneNo=" + phoneNo
				+ ", fax=" + fax + ", obBal=" + obBal + ", creditLimit=" + creditLimit + ", storeId=" + storeId
				+ ", companyId=" + companyId + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", lang=" + lang + ", finyrId=" + finyrId + ", addharCardNo=" + addharCardNo + ", dob=" + dob
				+ ", gender=" + gender + ", age=" + age + ", guardian_name=" + guardian_name + ", panNo=" + panNo
				+ ", gstNo=" + gstNo + ", consiName=" + consiName + ", consiAddress=" + consiAddress + ", consiPhone="
				+ consiPhone + ", consiGstNo=" + consiGstNo + ", consiStateId=" + consiStateId + "]";
	}

	public CustomerMaster(int id, String name, String code, String address, String pin, String city, String state,
			String country, String phoneNo, String fax, double obBal, double creditLimit, int storeId, int companyId,
			int isDeleted, int createdBy, Date createdDate, int updatedBy, Date updatedDate, String lang, int finyrId,
			String addharCardNo, Date dob, String gender, int age, String guardian_name, String panNo, String gstNo,
			String consiName, String consiAddress, String consiPhone, String consiGstNo, int consiStateId) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.address = address;
		this.pin = pin;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
		this.fax = fax;
		this.obBal = obBal;
		this.creditLimit = creditLimit;
		this.storeId = storeId;
		this.companyId = companyId;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.lang = lang;
		this.finyrId = finyrId;
		this.addharCardNo = addharCardNo;
		this.dob = dob;
		this.gender = gender;
		this.age = age;
		this.guardian_name = guardian_name;
		this.panNo = panNo;
		this.gstNo = gstNo;
		this.consiName = consiName;
		this.consiAddress = consiAddress;
		this.consiPhone = consiPhone;
		this.consiGstNo = consiGstNo;
		this.consiStateId = consiStateId;
	}

	
	

}