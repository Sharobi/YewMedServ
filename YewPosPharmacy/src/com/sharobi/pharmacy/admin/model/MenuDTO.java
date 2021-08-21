package com.sharobi.pharmacy.admin.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement
public class MenuDTO {
	@Expose
	private int menuId;
	@Expose
	private int isAll;
	public int getMenuId() {
		return menuId;
	}
	@XmlElement
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getIsAll() {
		return isAll;
	}
	@XmlElement
	public void setIsAll(int isAll) {
		this.isAll = isAll;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", isAll=" + isAll + "]";
	}
	
	
}
