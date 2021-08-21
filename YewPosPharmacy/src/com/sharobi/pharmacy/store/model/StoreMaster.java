package com.sharobi.pharmacy.store.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

/**
 * Entity implementation class for Entity: gen_m_store
 * 
 */

@XmlRootElement
@Entity
@Table(name = "gen_m_store")
public class StoreMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@MapToData(columnAliases={"id"})
	@Column(name = "id")
	private int id;

	@Expose
	@ManyToOne
	@JoinColumn(name = "company_id")
	private CompanyMaster companyMaster;

	@Expose
	@MapToData(columnAliases={"name"})
	@Column(name = "name")
	private String name;

	@Expose
	@Column(name = "registration_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;

	@Expose
	@Column(name = "termination_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date terminationDate;

	@Expose
	@Column(name = "currency_id")
	private int currencyId;

	@Expose
	@Column(name = "latitude")
	private String latitude;

	@Expose
	@Column(name = "longitude")
	private String longitude;

	@Expose
	@Column(name = "address")
	private String address;

	@Expose
	@Column(name = "state")
	private String state;

	@Expose
	@Column(name = "country")
	private String country;

	@Expose
	@Column(name = "postcode")
	private String postcode;

	@Expose
	@Column(name = "email")
	private String email;

	@Expose
	@Column(name = "phone")
	private String phone;

	@Expose
	@Column(name = "fax")
	private String fax;

	@Expose
	@Column(name = "is_active")
	private int isActive;

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
	@Column(name = "is_default")
	private int isDefault;
	
	@Expose
	@Column(name = "dl_licence_no")
	private String dlLicenceNo;
	
	@Expose
	@Column(name = "dl_registration_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dlRegistrationDate;
	
	@Expose
	@Column(name = "dl_expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dlExpiryDate;
	
	@Expose
	@Column(name = "state_licence_no")
	private String stateLicenceNo;
	
	@Expose
	@Column(name = "state_registration_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date stateRegistrationDate;
	
	@Expose
	@Column(name = "state_expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date stateExpiryDate;
	
	@Expose
	@Column(name = "tax_reg_no")
	private String taxRegNo;
	
	@Expose
	@Column(name = "tax_per")
	private double taxPer;
	
	@Expose
	@Column(name = "vat_per")
	private double vatPer;
	
	@Expose
	@Column(name = "is_mail_enable")
	private int isMailEnable;
	
	@Expose
	@Column(name = "mail_password")
	private String mailPassword;
	
	@Expose
	@Column(name = "mail_port")
	private String mailPort;
	
	@Expose
	@Column(name = "mail_smtp")
	private String mailSmtp;
	
	@Expose
	@Column(name = "tax_reg_no_text")
	private String taxRegNoText;
	
	@Expose
	@Column(name = "is_exclusive")
	private int isExclusive;
	
	@Expose
	@Column(name = "is_esi")
	private int isEsi;
	
	//05.04.2018
	@Expose
	@Column(name = "is_account")
	private int is_account ;
	
	@Expose
	@Transient
	@MapToData(columnAliases = { "fin_yr_id" })
	private int finYrId;
	
	public StoreMaster() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIsEsi() {
		return isEsi;
	}

	public void setIsEsi(int isEsi) {
		this.isEsi = isEsi;
	}

	public int getIsMailEnable() {
		return isMailEnable;
	}

	public void setIsMailEnable(int isMailEnable) {
		this.isMailEnable = isMailEnable;
	}

	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	public String getMailPort() {
		return mailPort;
	}

	public void setMailPort(String mailPort) {
		this.mailPort = mailPort;
	}

	public String getMailSmtp() {
		return mailSmtp;
	}

	public void setMailSmtp(String mailSmtp) {
		this.mailSmtp = mailSmtp;
	}

	public String getTaxRegNoText() {
		return taxRegNoText;
	}

	public void setTaxRegNoText(String taxRegNoText) {
		this.taxRegNoText = taxRegNoText;
	}

	public int getIsExclusive() {
		return isExclusive;
	}

	public void setIsExclusive(int isExclusive) {
		this.isExclusive = isExclusive;
	}

	public String getTaxRegNo() {
		return taxRegNo;
	}

	public void setTaxRegNo(String taxRegNo) {
		this.taxRegNo = taxRegNo;
	}

	public double getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(double taxPer) {
		this.taxPer = taxPer;
	}

	public double getVatPer() {
		return vatPer;
	}

	public void setVatPer(double vatPer) {
		this.vatPer = vatPer;
	}

	public String getDlLicenceNo() {
		return dlLicenceNo;
	}

	public void setDlLicenceNo(String dlLicenceNo) {
		this.dlLicenceNo = dlLicenceNo;
	}

	public Date getDlRegistrationDate() {
		return dlRegistrationDate;
	}

	public void setDlRegistrationDate(Date dlRegistrationDate) {
		this.dlRegistrationDate = dlRegistrationDate;
	}

	public Date getDlExpiryDate() {
		return dlExpiryDate;
	}

	public void setDlExpiryDate(Date dlExpiryDate) {
		this.dlExpiryDate = dlExpiryDate;
	}

	public String getStateLicenceNo() {
		return stateLicenceNo;
	}

	public void setStateLicenceNo(String stateLicenceNo) {
		this.stateLicenceNo = stateLicenceNo;
	}

	public Date getStateRegistrationDate() {
		return stateRegistrationDate;
	}

	public void setStateRegistrationDate(Date stateRegistrationDate) {
		this.stateRegistrationDate = stateRegistrationDate;
	}

	public Date getStateExpiryDate() {
		return stateExpiryDate;
	}

	public void setStateExpiryDate(Date stateExpiryDate) {
		this.stateExpiryDate = stateExpiryDate;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompanyMaster getCompanyMaster() {
		return companyMaster;
	}

	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
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
	
	public int getIs_account() {
		return is_account;
	}

	public void setIs_account(int is_account) {
		this.is_account = is_account;
	}

	public int getFinYrId() {
		return finYrId;
	}

	public void setFinYrId(int finYrId) {
		this.finYrId = finYrId;
	}

	@Override
	public String toString() {
		return "StoreMaster [id=" + id + ", companyMaster=" + companyMaster + ", name=" + name + ", registrationDate="
				+ registrationDate + ", terminationDate=" + terminationDate + ", currencyId=" + currencyId
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", address=" + address + ", state=" + state
				+ ", country=" + country + ", postcode=" + postcode + ", email=" + email + ", phone=" + phone + ", fax="
				+ fax + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", isDefault=" + isDefault + ", dlLicenceNo=" + dlLicenceNo + ", dlRegistrationDate="
				+ dlRegistrationDate + ", dlExpiryDate=" + dlExpiryDate + ", stateLicenceNo=" + stateLicenceNo
				+ ", stateRegistrationDate=" + stateRegistrationDate + ", stateExpiryDate=" + stateExpiryDate
				+ ", taxRegNo=" + taxRegNo + ", taxPer=" + taxPer + ", vatPer=" + vatPer + ", isMailEnable="
				+ isMailEnable + ", mailPassword=" + mailPassword + ", mailPort=" + mailPort + ", mailSmtp=" + mailSmtp
				+ ", taxRegNoText=" + taxRegNoText + ", isExclusive=" + isExclusive + ", isEsi=" + isEsi
				+ ", is_account=" + is_account + ", finYrId=" + finYrId + "]";
	}

	
}