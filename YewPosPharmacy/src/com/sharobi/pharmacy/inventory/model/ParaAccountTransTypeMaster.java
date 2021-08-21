package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="para_account_trans_type")
@XmlRootElement
public class ParaAccountTransTypeMaster implements Serializable {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Expose
	private String type;
	
	@Expose
	private int factor;
	
	public ParaAccountTransTypeMaster() {
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "ParaAccountTransType [id=" + id + ", type=" + type + ", factor=" + factor + "]";
	}

	public ParaAccountTransTypeMaster(int id, String type, int factor) {
		super();
		this.id = id;
		this.type = type;
		this.factor = factor;
	}
	
}
