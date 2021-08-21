package com.sharobi.pharmacy.commonutil;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ParaJournalTypeDTO {
	@Expose
	@MapToData(columnAliases = { "journal_type_id"})
	private int journal_type_id;
	@Expose
	@MapToData(columnAliases = { "journal_type"})
	private String journal_type;
	@Expose
	@MapToData(columnAliases = { "description"})
	private String description;
	@Expose
	@MapToData(columnAliases = { "journal_prefix"})
	private String journal_prefix;
	
	public ParaJournalTypeDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getJournal_type_id() {
		return journal_type_id;
	}

	public void setJournal_type_id(int journal_type_id) {
		this.journal_type_id = journal_type_id;
	}

	public String getJournal_type() {
		return journal_type;
	}

	public void setJournal_type(String journal_type) {
		this.journal_type = journal_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJournal_prefix() {
		return journal_prefix;
	}

	public void setJournal_prefix(String journal_prefix) {
		this.journal_prefix = journal_prefix;
	}

	@Override
	public String toString() {
		return "ParaJournalTypeDTO [journal_type_id=" + journal_type_id + ", journal_type=" + journal_type
				+ ", description=" + description + ", journal_prefix=" + journal_prefix + "]";
	}

	public ParaJournalTypeDTO(int journal_type_id, String journal_type, String description, String journal_prefix) {
		super();
		this.journal_type_id = journal_type_id;
		this.journal_type = journal_type;
		this.description = description;
		this.journal_prefix = journal_prefix;
	}
	
}
