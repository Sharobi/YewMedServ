package com.sharobi.pharmacy.roles.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class MenuByUserDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "role_id" })
	private int roleId;

	@Expose
	@MapToData(columnAliases = { "role_name" })
	private String roleName;

	@Expose
	@MapToData(columnAliases = { "menu_id" })
	private int menuId;

	@Expose
	@MapToData(columnAliases = { "menu_name" })
	private String menuName;

	@Expose
	@MapToData(columnAliases = { "path" })
	private String path;

	@Expose
	@MapToData(columnAliases = { "parent_menu_id" })
	private int parentMenuId;

	@Expose
	@MapToData(columnAliases = { "display_order" })
	private int displayOrder;

	@Expose
	@MapToData(columnAliases = { "menu_url" })
	private String menuUrl;

	@Expose
	@MapToData(columnAliases = { "company_id" })
	private int companyId;

	@Expose
	@MapToData(columnAliases = { "store_id" })
	private int storeId;

	@Expose
	@MapToData(columnAliases = { "is_menu" })
	private int isMenu;

	@Expose
	@MapToData(columnAliases = { "menu_code" })
	private String menuCode;

	@Expose
	@MapToData(columnAliases = { "is_all" })
	private int isAll;

	@Expose
	@MapToData(columnAliases = { "is_view" })
	private int isView;

	@Expose
	@MapToData(columnAliases = { "is_none" })
	private int isNone;

	@Expose
	@MapToData(columnAliases = { "level" })
	private int level;

	@Expose
	@MapToData(columnAliases = { "ordering" })
	private String ordering;

	@Expose
	@Transient
	List<MenuByUserDTO> subMenuList;
	
	@Expose
	@MapToData(columnAliases = { "QS" })
	private String qs;

	private static final long serialVersionUID = 1L;
	
	

	public String getQs() {
		return qs;
	}

	public void setQs(String qs) {
		this.qs = qs;
	}

	public List<MenuByUserDTO> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<MenuByUserDTO> subMenuList) {
		this.subMenuList = subMenuList;
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

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	public int getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(int isMenu) {
		this.isMenu = isMenu;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getOrdering() {
		return ordering;
	}

	public void setOrdering(String ordering) {
		this.ordering = ordering;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
		result = prime * result + displayOrder;
		result = prime * result + isAll;
		result = prime * result + isMenu;
		result = prime * result + isNone;
		result = prime * result + isView;
		result = prime * result + level;
		result = prime * result
				+ ((menuCode == null) ? 0 : menuCode.hashCode());
		result = prime * result + menuId;
		result = prime * result
				+ ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + ((menuUrl == null) ? 0 : menuUrl.hashCode());
		result = prime * result
				+ ((ordering == null) ? 0 : ordering.hashCode());
		result = prime * result + parentMenuId;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((qs == null) ? 0 : qs.hashCode());
		result = prime * result + roleId;
		result = prime * result
				+ ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + storeId;
		result = prime * result
				+ ((subMenuList == null) ? 0 : subMenuList.hashCode());
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
		MenuByUserDTO other = (MenuByUserDTO) obj;
		if (companyId != other.companyId)
			return false;
		if (displayOrder != other.displayOrder)
			return false;
		if (isAll != other.isAll)
			return false;
		if (isMenu != other.isMenu)
			return false;
		if (isNone != other.isNone)
			return false;
		if (isView != other.isView)
			return false;
		if (level != other.level)
			return false;
		if (menuCode == null) {
			if (other.menuCode != null)
				return false;
		} else if (!menuCode.equals(other.menuCode))
			return false;
		if (menuId != other.menuId)
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (menuUrl == null) {
			if (other.menuUrl != null)
				return false;
		} else if (!menuUrl.equals(other.menuUrl))
			return false;
		if (ordering == null) {
			if (other.ordering != null)
				return false;
		} else if (!ordering.equals(other.ordering))
			return false;
		if (parentMenuId != other.parentMenuId)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (qs == null) {
			if (other.qs != null)
				return false;
		} else if (!qs.equals(other.qs))
			return false;
		if (roleId != other.roleId)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (storeId != other.storeId)
			return false;
		if (subMenuList == null) {
			if (other.subMenuList != null)
				return false;
		} else if (!subMenuList.equals(other.subMenuList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuByUserDTO [roleId=" + roleId + ", roleName=" + roleName
				+ ", menuId=" + menuId + ", menuName=" + menuName + ", path="
				+ path + ", parentMenuId=" + parentMenuId + ", displayOrder="
				+ displayOrder + ", menuUrl=" + menuUrl + ", companyId="
				+ companyId + ", storeId=" + storeId + ", isMenu=" + isMenu
				+ ", menuCode=" + menuCode + ", isAll=" + isAll + ", isView="
				+ isView + ", isNone=" + isNone + ", level=" + level
				+ ", ordering=" + ordering + ", subMenuList=" + subMenuList
				+ ", qs=" + qs + "]";
	}

}