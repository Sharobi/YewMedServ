package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class AccountTransTypeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;

	@Expose
	@MapToData(columnAliases = { "type" })
	private String type;
	
	@Expose
	@MapToData(columnAliases = { "factor" })
	private int factor;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}

	
}
