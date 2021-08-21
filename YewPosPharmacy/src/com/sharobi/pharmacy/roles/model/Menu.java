package com.sharobi.pharmacy.roles.model;

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
 * Entity implementation class for Entity: gen_m_menu
 * 
 */
@XmlRootElement
@Entity
@Table(name = "gen_m_menu")
public class Menu implements Serializable {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "name")
	private String name;

	@Expose
	@Column(name = "parent_menu_id")
	private int parentMenuId;

	@Expose
	@Column(name = "display_order")
	private int displayOrder;

	@Expose
	@Column(name = "menu_url")
	private String menuUrl;

	@Expose
	@Column(name = "company_id")
	private int companyId;

	@Expose
	@Column(name = "menu_code")
	private String menuCode;

	@Expose
	@Column(name = "is_menu")
	private int isMenu;

	@Expose
	@Column(name = "store_id")
	private int storeId;

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
	private int roleId;

	@Expose
	@Transient
	private int menuId;

	@Expose
	@Transient
	private int isAll;

	@Expose
	@Transient
	private int isView;

	@Expose
	@Transient
	private int isNone;
	
	@Expose
	@Transient
	private String lang;
	
	@Expose
	@Column(name = "QS")
	private String qs;

	private static final long serialVersionUID = 1L;
	
	
	
	public String getQs() {
		return qs;
	}

	public void setQs(String qs) {
		this.qs = qs;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public int getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(int isMenu) {
		this.isMenu = isMenu;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getIsAll() {
		return isAll;
	}

	public void setIsAll(int isAll) {
		this.isAll = isAll;
	}

	public int getIsView() {
		return isView;
	}

	public void setIsView(int isView) {
		this.isView = isView;
	}

	public int getIsNone() {
		return isNone;
	}

	public void setIsNone(int isNone) {
		this.isNone = isNone;
	}

}