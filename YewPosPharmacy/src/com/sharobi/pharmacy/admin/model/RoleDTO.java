package com.sharobi.pharmacy.admin.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement
public class RoleDTO {
	@Expose
	private int id;
	@Expose
	private String name;
	@Expose
	private int companyId;
	@Expose
	private int storeId;
	@Expose
	private int createdBy;
	@Expose
	private Date createdDate;
	@Expose
	private int updatedBy;
	@Expose
	private Date updatedDate;
	@Expose
	private List<MenuDTO> menuList;
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
	public List<MenuDTO> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<MenuDTO> menuList) {
		this.menuList = menuList;
	}
	public int getStoreId() {
		return storeId;
	}
	@XmlElement
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", name=" + name + ", companyId=" + companyId + ", storeId=" + storeId
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", menuList=" + menuList + "]";
	}

}
