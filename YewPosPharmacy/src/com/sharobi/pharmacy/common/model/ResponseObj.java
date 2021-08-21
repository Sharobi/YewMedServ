package com.sharobi.pharmacy.common.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;
import com.sharobi.pharmacy.inventory.model.ItemMaster;

@XmlRootElement
public class ResponseObj implements Serializable {
	@Expose
	private int id;

	@Expose
	private String status;

	@Expose
	private String reason;
	
	@Expose
	private ItemMaster item;
	
	@Expose
	private String code;


	private static final long serialVersionUID = 1L;
	
	public ItemMaster getItem() {
		return item;
	}

	public void setItem(ItemMaster item) {
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}