package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;


@XmlRootElement
public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;

	@Expose
	@MapToData(columnAliases = { "name" })
	private String name;

	@Expose
	@MapToData(columnAliases = { "code" })
	private String code;

	@Expose
	@MapToData(columnAliases = { "address" })
	private String address;

	@Expose
	@MapToData(columnAliases = { "pin" })
	private String pin;

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
	@MapToData(columnAliases = { "phone_no" })
	private String phoneNo;

	@Expose
	@MapToData(columnAliases = { "fax" })
	private String fax;

	@Expose
	@MapToData(columnAliases = { "ob_bal" })
	private double obBal;

	@Expose
	@MapToData(columnAliases = { "credit_limit" })
	private double creditLimit;
	
	@Expose
	@MapToData(columnAliases = { "payble_amount" })
	private double paybleAmount;
	
	@Expose
	@MapToData(columnAliases = { "payble_text" })
	private String paybleText;
	
	@Expose
	@MapToData(columnAliases = { "addhar_card_no" })
	private String addharCardNo;
	
	@Expose
	@MapToData(columnAliases = { "outstanding_amount" })
	private double outstandingAmount;
	
	@Expose
	@MapToData(columnAliases = { "dob" })
	private Date dob;
	
	@Expose
	@MapToData(columnAliases = { "gender" })
	private String gender;
	
	//22.03.2018
	@Expose
	@MapToData(columnAliases = { "age" })
	private int age;
	
	@Expose
	@MapToData(columnAliases = { "guardian_name" })
	private String guardian_name;
	
	@Expose
	@MapToData(columnAliases = { "pan_no" })
	private String panNo;
	
	@Expose
	@MapToData(columnAliases = { "gst_no" })
	private String gstNo;
	
	//02.03.2020
	@Expose
	@MapToData(columnAliases = { "consi_name" })
	private String consiName;
	
	@Expose
	@MapToData(columnAliases = { "consi_address" })
	private String consiAddress;
	
	@Expose
	@MapToData(columnAliases = { "consi_phone" })
	private String consiPhone;
	
	@Expose
	@MapToData(columnAliases = { "consi_gst_no" })
	private String consiGstNo;
	
	@Expose
	@MapToData(columnAliases = { "consi_state_id" })
	private int consiStateId;

	public CustomerDTO() {
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

	public double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public String getAddharCardNo() {
		return addharCardNo;
	}

	public void setAddharCardNo(String addharCardNo) {
		this.addharCardNo = addharCardNo;
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
		return "CustomerDTO [id=" + id + ", name=" + name + ", code=" + code + ", address=" + address + ", pin=" + pin
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", phoneNo=" + phoneNo + ", fax="
				+ fax + ", obBal=" + obBal + ", creditLimit=" + creditLimit + ", paybleAmount=" + paybleAmount
				+ ", paybleText=" + paybleText + ", addharCardNo=" + addharCardNo + ", outstandingAmount="
				+ outstandingAmount + ", dob=" + dob + ", gender=" + gender + ", age=" + age + ", guardian_name="
				+ guardian_name + ", panNo=" + panNo + ", gstNo=" + gstNo + ", consiName=" + consiName
				+ ", consiAddress=" + consiAddress + ", consiPhone=" + consiPhone + ", consiGstNo=" + consiGstNo
				+ ", consiStateId=" + consiStateId + "]";
	}

	public CustomerDTO(int id, String name, String code, String address, String pin, String city, String state,
			String country, String phoneNo, String fax, double obBal, double creditLimit, double paybleAmount,
			String paybleText, String addharCardNo, double outstandingAmount, Date dob, String gender, int age,
			String guardian_name, String panNo, String gstNo, String consiName, String consiAddress, String consiPhone,
			String consiGstNo, int consiStateId) {
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
		this.paybleAmount = paybleAmount;
		this.paybleText = paybleText;
		this.addharCardNo = addharCardNo;
		this.outstandingAmount = outstandingAmount;
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