package com.sharobi.pharmacy.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="acc_t_journal")
@XmlRootElement
public class AccountJournalMaster {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Expose
	private int journal_type_id;
	@Expose
	private String inv_no;
	@Expose
	private Date inv_date;
	@Expose
	private int pst_id;
	@Expose
	private String pst_inv_no;
	@Expose
	private String doc_no;
	@Expose
	private Date doc_date;
	@Expose
	private String scheme_docno;
	@Expose
	private String narration;
	@Expose
	private int company_id;
	@Expose
	private int store_id;
	@Expose
	private int finyr_id;
	@Expose
	private int created_by;
	@Expose
	private int updated_by;
	@Expose
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Expose
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	public AccountJournalMaster() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJournal_type_id() {
		return journal_type_id;
	}

	public void setJournal_type_id(int journal_type_id) {
		this.journal_type_id = journal_type_id;
	}

	public String getInv_no() {
		return inv_no;
	}

	public void setInv_no(String inv_no) {
		this.inv_no = inv_no;
	}

	public Date getInv_date() {
		return inv_date;
	}

	public void setInv_date(Date inv_date) {
		this.inv_date = inv_date;
	}

	public int getPst_id() {
		return pst_id;
	}

	public void setPst_id(int pst_id) {
		this.pst_id = pst_id;
	}

	public String getPst_inv_no() {
		return pst_inv_no;
	}

	public void setPst_inv_no(String pst_inv_no) {
		this.pst_inv_no = pst_inv_no;
	}

	public String getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public Date getDoc_date() {
		return doc_date;
	}

	public void setDoc_date(Date doc_date) {
		this.doc_date = doc_date;
	}

	public String getScheme_docno() {
		return scheme_docno;
	}

	public void setScheme_docno(String scheme_docno) {
		this.scheme_docno = scheme_docno;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
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

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "AccountJournalMaster [id=" + id + ", journal_type_id=" + journal_type_id + ", inv_no=" + inv_no
				+ ", inv_date=" + inv_date + ", pst_id=" + pst_id + ", pst_inv_no=" + pst_inv_no + ", doc_no=" + doc_no
				+ ", doc_date=" + doc_date + ", scheme_docno=" + scheme_docno + ", narration=" + narration
				+ ", company_id=" + company_id + ", store_id=" + store_id + ", finyr_id=" + finyr_id + ", created_by="
				+ created_by + ", updated_by=" + updated_by + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

	public AccountJournalMaster(int id, int journal_type_id, String inv_no, Date inv_date, int pst_id,
			String pst_inv_no, String doc_no, Date doc_date, String scheme_docno, String narration, int company_id,
			int store_id, int finyr_id, int created_by, int updated_by, Date createdDate, Date updatedDate) {
		super();
		this.id = id;
		this.journal_type_id = journal_type_id;
		this.inv_no = inv_no;
		this.inv_date = inv_date;
		this.pst_id = pst_id;
		this.pst_inv_no = pst_inv_no;
		this.doc_no = doc_no;
		this.doc_date = doc_date;
		this.scheme_docno = scheme_docno;
		this.narration = narration;
		this.company_id = company_id;
		this.store_id = store_id;
		this.finyr_id = finyr_id;
		this.created_by = created_by;
		this.updated_by = updated_by;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
}
