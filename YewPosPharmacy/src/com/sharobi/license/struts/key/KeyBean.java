package com.sharobi.license.struts.key;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: com_t_store_license
 * 
 */
@XmlRootElement
@Entity
@Table(name = "com_t_store_license")
public class KeyBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "license_key")
	private String license_key = "";

	@Expose
	@Column(name = "product_id")
	private String product_id;

	@Expose
	@Column(name = "company_id")
	private String company_id;

	@Expose
	@Column(name = "store_id")
	private String store_id;

	@Expose
	@Column(name = "user_id")
	private String user_id;

	@Expose
	@Column(name = "no_of_users")
	private String no_of_users;

	@Expose
	@Column(name = "versions")
	private String versions;

	@Expose
	@Column(name = "from_date")
	private String from_date;

	@Expose
	@Column(name = "to_date")
	private String to_date;

	@Expose
	@Column(name = "is_current")
	private int is_current;

	@Expose
	@Column(name = "no_of_month")
	private String no_of_month;

	@Expose
	@Column(name = "mac_id")
	private String mac_id = "";

	@Expose
	@Column(name = "email_sent")
	private String email_id;

	@Expose
	@Column(name = "is_deleted")
	private int is_deleted;

	@Expose
	@Column(name = "created_by")
	private int createdBy;

	@Expose
	@Column(name = "created_date")
	private Date createdDate;

	@Expose
	@Column(name = "updated_by")
	private int updatedBy;

	@Expose
	@Column(name = "updated_date")
	private Date updatedDate;

	@Expose
	@Transient
	private String status;

	@Expose
	@Transient
	private String storeName;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicense_key() {
		return license_key;
	}

	public void setLicense_key(String license_key) {
		this.license_key = license_key;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getNo_of_users() {
		return no_of_users;
	}

	public void setNo_of_users(String no_of_users) {
		this.no_of_users = no_of_users;
	}

	public String getVersions() {
		return versions;
	}

	public void setVersions(String versions) {
		this.versions = versions;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public int getIs_current() {
		return is_current;
	}

	public void setIs_current(int is_current) {
		this.is_current = is_current;
	}

	public String getNo_of_month() {
		return no_of_month;
	}

	public void setNo_of_month(String no_of_month) {
		this.no_of_month = no_of_month;
	}

	public String getMac_id() {
		return mac_id;
	}

	public void setMac_id(String mac_id) {
		this.mac_id = mac_id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "KeyBean [id=" + id + ", license_key=" + license_key
				+ ", product_id=" + product_id + ", company_id=" + company_id
				+ ", store_id=" + store_id + ", user_id=" + user_id
				+ ", no_of_users=" + no_of_users + ", versions=" + versions
				+ ", from_date=" + from_date + ", to_date=" + to_date
				+ ", is_current=" + is_current + ", no_of_month=" + no_of_month
				+ ", mac_id=" + mac_id + ", email_id=" + email_id
				+ ", is_deleted=" + is_deleted + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", status=" + status
				+ ", storeName=" + storeName + "]";
	}

	
}
