package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class CustomerInfoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;
	
	@Expose
	@MapToData(columnAliases = { "name" })
	private String name;
	
	@Expose
	@MapToData(columnAliases = { "phone_no" })
	private String phoneNo;
	
	@Expose
	@MapToData(columnAliases = { "address" })
	private String address;
		
	@Expose
	@MapToData(columnAliases = { "credit_limit" })
	private double creditLimit;
	
	@Expose
	@MapToData(columnAliases = { "code" })
	private String code;
	
	@Expose
	@MapToData(columnAliases = { "fax" })
	private String fax;
	
	@Expose
	@MapToData(columnAliases = { "gst_no" })
	private String gstNo;
	
	

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	@Override
	public String toString() {
		return "CustomerInfoDTO [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", address=" + address
				+ ", creditLimit=" + creditLimit + ", code=" + code + ", fax=" + fax + ", gstNo=" + gstNo + "]";
	}


	
}