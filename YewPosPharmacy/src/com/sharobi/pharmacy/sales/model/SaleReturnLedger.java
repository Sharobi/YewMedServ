package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SaleReturnLedger implements Serializable {
	
	@Expose
	@MapToData(columnAliases = { "type"})
	private String type;
	@Expose
	@MapToData(columnAliases = { "account_id"})
	private int account_id;
	@Expose
	@MapToData(columnAliases = { "amount"})
	private double amount;
	
	public SaleReturnLedger() {
	}

	public String getType() {
		return type;
	}

	@XmlElement
	public void setType(String type) {
		this.type = type;
	}

	public int getAccount_id() {
		return account_id;
	}

	@XmlElement
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public double getAmount() {
		return amount;
	}

	@XmlElement
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SaleReturnLedger [type=" + type + ", account_id=" + account_id + ", amount=" + amount + "]";
	}

	public SaleReturnLedger(String type, int account_id, double amount) {
		super();
		this.type = type;
		this.account_id = account_id;
		this.amount = amount;
	}

}
