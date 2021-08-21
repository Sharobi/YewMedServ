package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;
/**
 * Entity implementation class for Entity: gen_t_menu_product_type_mapping
 * 
 */

@XmlRootElement
@Entity
@Table(name = "gen_t_menu_product_type_mapping")
public class MenuProductTypeMapper implements Serializable {

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "menu_id")
	private int menuId;

	@Expose
	@Column(name = "product_type_id")
	private int productTypeId;
	
	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	private static final long serialVersionUID = 1L;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getProductTypeId() {
		return productTypeId;
	}


	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}


	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	
}