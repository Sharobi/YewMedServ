package com.sharobi.pharmacy.admin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
@Entity
@Table(name="gen_t_user_role")
public class UserRoleMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@MapToData(columnAliases = {"id"})
	private int id;
	@Expose
	@MapToData(columnAliases = {"user_id"})
	private int userId;
	@Transient
	@Expose
	@MapToData(columnAliases = {"user_name"})
	private String userName;
	@Expose
	@MapToData(columnAliases = {"role_id"})
	private int roleId;
	@Transient
	@Expose
	@MapToData(columnAliases = {"role_name"})
	private String roleName;
	private int companyId;
	private int storeId;
	private int isPermit;
	private int createdBy;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getIsPermit() {
		return isPermit;
	}
	public void setIsPermit(int isPermit) {
		this.isPermit = isPermit;
	}
	@Override
	public String toString() {
		return "UserRoleMapping [id=" + id + ", userId=" + userId + ", userName=" + userName + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", companyId=" + companyId + ", storeId=" + storeId + ", isPermit="
				+ isPermit + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + "]";
	}

}
