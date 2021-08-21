package com.sharobi.pharmacy.roles.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class LoginInfoByUserDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;

	@Expose
	@MapToData(columnAliases = { "user_name" })
	private String userName;

	@MapToData(columnAliases = { "password" })
	private String password;

	@Expose
	@MapToData(columnAliases = { "user_code" })
	private String userCode;

	@Expose
	@MapToData(columnAliases = { "fname" })
	private String fname;

	@Expose
	@MapToData(columnAliases = { "lname" })
	private String lname;

	@Expose
	@MapToData(columnAliases = { "phone" })
	private String phone;

	@Expose
	@MapToData(columnAliases = { "email" })
	private String email;

	@Expose
	@MapToData(columnAliases = { "company_id" })
	private int companyId;

	@Expose
	@MapToData(columnAliases = { "store_id" })
	private int storeId;

	@Expose
	@MapToData(columnAliases = { "is_current" })
	private int isCurrent;

	@Expose
	@MapToData(columnAliases = { "is_active" })
	private int isActive;

	@Expose
	@MapToData(columnAliases = { "is_locked" })
	private int isLocked;

	@Expose
	@MapToData(columnAliases = { "finyr_id" })
	private int finyrId;

	@Expose
	@MapToData(columnAliases = { "start_date" })
	private Date startDate;

	@Expose
	@MapToData(columnAliases = { "end_date" })
	private Date endDate;

	@Expose
	@MapToData(columnAliases = { "finyr_code" })
	private String finyrCode;

	@Expose
	@MapToData(columnAliases = { "description" })
	private String description;
	
	@Expose
	@MapToData(columnAliases = { "tax_reg_no" })
	private String taxRegNo;
	
	@Expose
	@MapToData(columnAliases = { "is_tax_reg_no" })
	private int isTaxRegNo;
	
	@Expose
	@MapToData(columnAliases = { "vat_per" })
	private double vatPer;
	
	@Expose
	@MapToData(columnAliases = { "tax_per" })
	private double taxPer;

	@Expose
	@Transient
	private String loginDate;

	@Expose
	@Transient
	private String message;

	@Expose
	@Transient
	private String lang;
	
	@Expose
	@MapToData(columnAliases = { "product_type_id" })
	private int productTypeId;
	
	@Expose
	@MapToData(columnAliases = { "dl_licence_no" })
	private String dlLicenceNo;
	
	@Expose
	@MapToData(columnAliases = { "dl_registration_date" })
	private Date dlRegistrationDate;
	
	@Expose
	@MapToData(columnAliases = { "dl_expiry_date" })
	private Date dlExpiryDate;
	
	@Expose
	@MapToData(columnAliases = { "state_licence_no" })
	private String stateLicenceNo;
	
	@Expose
	@MapToData(columnAliases = { "state_registration_date" })
	private Date stateRegistrationDate;
	
	@Expose
	@MapToData(columnAliases = { "state_expiry_date" })
	private Date stateExpiryDate;
	
	@Expose
	@MapToData(columnAliases = { "store_code" })
	private String storeCode;
	
	@Expose
	@MapToData(columnAliases = { "location_id" })
	private int locationId;
	
	@Expose
	@MapToData(columnAliases = { "location_name" })
	private String locationName;
	
	@Expose
	@MapToData(columnAliases = { "version_name" })
	private String versionName;
	
	@Expose
	@MapToData(columnAliases = { "tax_reg_no_text" })
	private String taxRegNoText;
	
	@Expose
	@MapToData(columnAliases = { "is_exclusive" })
	private int isExclusive;
	
	@Expose
	@MapToData(columnAliases = { "is_mail_enable" })
	private int isMailEnable;
	
	@Expose
	@MapToData(columnAliases = { "mail_password" })
	private String mailPassword;
	
	@Expose
	@MapToData(columnAliases = { "mail_port" })
	private String mailPort;
	
	@Expose
	@MapToData(columnAliases = { "mail_smtp" })
	private String mailSmtp;
	
	@Expose
	@MapToData(columnAliases = { "is_esi" })
	private int isEsi;
	
	@Expose
	@MapToData(columnAliases = { "currency_code" })
	private String currency_code;
	
	@Expose
	@MapToData(columnAliases = { "currency_desc" })
	private String currency_desc;
	
	//05.04.2018
	@Expose
	@MapToData(columnAliases = { "is_account" })
	private int is_account;
	
	//15.07.2018
	@Expose
	@MapToData(columnAliases = { "is_admin" })
	private int isAdmin;

	private static final long serialVersionUID = 1L;
	
	
	

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

	public int getIsEsi() {
		return isEsi;
	}

	public void setIsEsi(int isEsi) {
		this.isEsi = isEsi;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getTaxRegNo() {
		return taxRegNo;
	}

	public void setTaxRegNo(String taxRegNo) {
		this.taxRegNo = taxRegNo;
	}

	public int getIsTaxRegNo() {
		return isTaxRegNo;
	}

	public void setIsTaxRegNo(int isTaxRegNo) {
		this.isTaxRegNo = isTaxRegNo;
	}

	public double getVatPer() {
		return vatPer;
	}

	public void setVatPer(double vatPer) {
		this.vatPer = vatPer;
	}

	public double getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(double taxPer) {
		this.taxPer = taxPer;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
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

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getFinyrCode() {
		return finyrCode;
	}

	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(int isCurrent) {
		this.isCurrent = isCurrent;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
	}

	public int getFinyrId() {
		return finyrId;
	}

	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	public String getCurrency_desc() {
		return currency_desc;
	}

	public void setCurrency_desc(String currency_desc) {
		this.currency_desc = currency_desc;
	}
	
	public int getIs_account() {
		return is_account;
	}

	public void setIs_account(int is_account) {
		this.is_account = is_account;
	}
	
	

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((dlExpiryDate == null) ? 0 : dlExpiryDate.hashCode());
		result = prime * result
				+ ((dlLicenceNo == null) ? 0 : dlLicenceNo.hashCode());
		result = prime
				* result
				+ ((dlRegistrationDate == null) ? 0 : dlRegistrationDate
						.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((finyrCode == null) ? 0 : finyrCode.hashCode());
		result = prime * result + finyrId;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + id;
		result = prime * result + isActive;
		result = prime * result + isCurrent;
		result = prime * result + isEsi;
		result = prime * result + isExclusive;
		result = prime * result + isLocked;
		result = prime * result + isMailEnable;
		result = prime * result + isTaxRegNo;
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + locationId;
		result = prime * result
				+ ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result
				+ ((loginDate == null) ? 0 : loginDate.hashCode());
		result = prime * result
				+ ((mailPassword == null) ? 0 : mailPassword.hashCode());
		result = prime * result
				+ ((mailPort == null) ? 0 : mailPort.hashCode());
		result = prime * result
				+ ((mailSmtp == null) ? 0 : mailSmtp.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + productTypeId;
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((stateExpiryDate == null) ? 0 : stateExpiryDate.hashCode());
		result = prime * result
				+ ((stateLicenceNo == null) ? 0 : stateLicenceNo.hashCode());
		result = prime
				* result
				+ ((stateRegistrationDate == null) ? 0 : stateRegistrationDate
						.hashCode());
		result = prime * result
				+ ((storeCode == null) ? 0 : storeCode.hashCode());
		result = prime * result + storeId;
		long temp;
		temp = Double.doubleToLongBits(taxPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((taxRegNo == null) ? 0 : taxRegNo.hashCode());
		result = prime * result
				+ ((taxRegNoText == null) ? 0 : taxRegNoText.hashCode());
		result = prime * result
				+ ((userCode == null) ? 0 : userCode.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		temp = Double.doubleToLongBits(vatPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((versionName == null) ? 0 : versionName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginInfoByUserDTO other = (LoginInfoByUserDTO) obj;
		if (companyId != other.companyId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dlExpiryDate == null) {
			if (other.dlExpiryDate != null)
				return false;
		} else if (!dlExpiryDate.equals(other.dlExpiryDate))
			return false;
		if (dlLicenceNo == null) {
			if (other.dlLicenceNo != null)
				return false;
		} else if (!dlLicenceNo.equals(other.dlLicenceNo))
			return false;
		if (dlRegistrationDate == null) {
			if (other.dlRegistrationDate != null)
				return false;
		} else if (!dlRegistrationDate.equals(other.dlRegistrationDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (finyrCode == null) {
			if (other.finyrCode != null)
				return false;
		} else if (!finyrCode.equals(other.finyrCode))
			return false;
		if (finyrId != other.finyrId)
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (isCurrent != other.isCurrent)
			return false;
		if (isEsi != other.isEsi)
			return false;
		if (isExclusive != other.isExclusive)
			return false;
		if (isLocked != other.isLocked)
			return false;
		if (isMailEnable != other.isMailEnable)
			return false;
		if (isTaxRegNo != other.isTaxRegNo)
			return false;
		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (locationId != other.locationId)
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (loginDate == null) {
			if (other.loginDate != null)
				return false;
		} else if (!loginDate.equals(other.loginDate))
			return false;
		if (mailPassword == null) {
			if (other.mailPassword != null)
				return false;
		} else if (!mailPassword.equals(other.mailPassword))
			return false;
		if (mailPort == null) {
			if (other.mailPort != null)
				return false;
		} else if (!mailPort.equals(other.mailPort))
			return false;
		if (mailSmtp == null) {
			if (other.mailSmtp != null)
				return false;
		} else if (!mailSmtp.equals(other.mailSmtp))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (productTypeId != other.productTypeId)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (stateExpiryDate == null) {
			if (other.stateExpiryDate != null)
				return false;
		} else if (!stateExpiryDate.equals(other.stateExpiryDate))
			return false;
		if (stateLicenceNo == null) {
			if (other.stateLicenceNo != null)
				return false;
		} else if (!stateLicenceNo.equals(other.stateLicenceNo))
			return false;
		if (stateRegistrationDate == null) {
			if (other.stateRegistrationDate != null)
				return false;
		} else if (!stateRegistrationDate.equals(other.stateRegistrationDate))
			return false;
		if (storeCode == null) {
			if (other.storeCode != null)
				return false;
		} else if (!storeCode.equals(other.storeCode))
			return false;
		if (storeId != other.storeId)
			return false;
		if (Double.doubleToLongBits(taxPer) != Double
				.doubleToLongBits(other.taxPer))
			return false;
		if (taxRegNo == null) {
			if (other.taxRegNo != null)
				return false;
		} else if (!taxRegNo.equals(other.taxRegNo))
			return false;
		if (taxRegNoText == null) {
			if (other.taxRegNoText != null)
				return false;
		} else if (!taxRegNoText.equals(other.taxRegNoText))
			return false;
		if (userCode == null) {
			if (other.userCode != null)
				return false;
		} else if (!userCode.equals(other.userCode))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (Double.doubleToLongBits(vatPer) != Double
				.doubleToLongBits(other.vatPer))
			return false;
		if (versionName == null) {
			if (other.versionName != null)
				return false;
		} else if (!versionName.equals(other.versionName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginInfoByUserDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", userCode="
				+ userCode + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", email=" + email
				+ ", companyId=" + companyId + ", storeId=" + storeId + ", isCurrent=" + isCurrent + ", isActive="
				+ isActive + ", isLocked=" + isLocked + ", finyrId=" + finyrId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", finyrCode=" + finyrCode + ", description=" + description + ", taxRegNo="
				+ taxRegNo + ", isTaxRegNo=" + isTaxRegNo + ", vatPer=" + vatPer + ", taxPer=" + taxPer + ", loginDate="
				+ loginDate + ", message=" + message + ", lang=" + lang + ", productTypeId=" + productTypeId
				+ ", dlLicenceNo=" + dlLicenceNo + ", dlRegistrationDate=" + dlRegistrationDate + ", dlExpiryDate="
				+ dlExpiryDate + ", stateLicenceNo=" + stateLicenceNo + ", stateRegistrationDate="
				+ stateRegistrationDate + ", stateExpiryDate=" + stateExpiryDate + ", storeCode=" + storeCode
				+ ", locationId=" + locationId + ", locationName=" + locationName + ", versionName=" + versionName
				+ ", taxRegNoText=" + taxRegNoText + ", isExclusive=" + isExclusive + ", isMailEnable=" + isMailEnable
				+ ", mailPassword=" + mailPassword + ", mailPort=" + mailPort + ", mailSmtp=" + mailSmtp + ", isEsi="
				+ isEsi + ", currency_code=" + currency_code + ", currency_desc=" + currency_desc + ", is_account="
				+ is_account + ", isAdmin=" + isAdmin + "]";
	}

	


}