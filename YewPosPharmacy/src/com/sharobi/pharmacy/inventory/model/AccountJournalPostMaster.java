package com.sharobi.pharmacy.inventory.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="acc_t_journal_post")
@XmlRootElement
public class AccountJournalPostMaster {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Expose
	private int journal_id;
	@Expose
	private Date journal_date;
	@Expose
	private int account_group_id;
	@Expose
	private int account_id;
	@Expose
	private double dr_amount;
	@Expose
	private double cr_amount;
	@Expose
	private int factor;
	@Expose
	private int pst_type_id;
	@Expose
	private String pst_type_code;
	@Expose
	private int company_id;
	@Expose
	private int store_id;
	@Expose
	private int finyr_id;
	
	public AccountJournalPostMaster() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJournal_id() {
		return journal_id;
	}

	public void setJournal_id(int journal_id) {
		this.journal_id = journal_id;
	}

	public Date getJournal_date() {
		return journal_date;
	}

	public void setJournal_date(Date journal_date) {
		this.journal_date = journal_date;
	}

	public int getAccount_group_id() {
		return account_group_id;
	}

	public void setAccount_group_id(int account_group_id) {
		this.account_group_id = account_group_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public double getDr_amount() {
		return dr_amount;
	}

	public void setDr_amount(double dr_amount) {
		this.dr_amount = dr_amount;
	}

	public double getCr_amount() {
		return cr_amount;
	}

	public void setCr_amount(double cr_amount) {
		this.cr_amount = cr_amount;
	}

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}

	public int getPst_type_id() {
		return pst_type_id;
	}

	public void setPst_type_id(int pst_type_id) {
		this.pst_type_id = pst_type_id;
	}

	public String getPst_type_code() {
		return pst_type_code;
	}

	public void setPst_type_code(String pst_type_code) {
		this.pst_type_code = pst_type_code;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public int getFinyr_id() {
		return finyr_id;
	}

	public void setFinyr_id(int finyr_id) {
		this.finyr_id = finyr_id;
	}

	@Override
	public String toString() {
		return "AccountJournalPostMaster [id=" + id + ", journal_id=" + journal_id + ", journal_date=" + journal_date
				+ ", account_group_id=" + account_group_id + ", account_id=" + account_id + ", dr_amount=" + dr_amount
				+ ", cr_amount=" + cr_amount + ", factor=" + factor + ", pst_type_id=" + pst_type_id
				+ ", pst_type_code=" + pst_type_code + ", company_id=" + company_id + ", store_id=" + store_id
				+ ", finyr_id=" + finyr_id + "]";
	}

	public AccountJournalPostMaster(int id, int journal_id, Date journal_date, int account_group_id, int account_id,
			double dr_amount, double cr_amount, int factor, int pst_type_id, String pst_type_code, int company_id,
			int store_id, int finyr_id) {
		super();
		this.id = id;
		this.journal_id = journal_id;
		this.journal_date = journal_date;
		this.account_group_id = account_group_id;
		this.account_id = account_id;
		this.dr_amount = dr_amount;
		this.cr_amount = cr_amount;
		this.factor = factor;
		this.pst_type_id = pst_type_id;
		this.pst_type_code = pst_type_code;
		this.company_id = company_id;
		this.store_id = store_id;
		this.finyr_id = finyr_id;
	}
	
}
