package com.sharobi.pharmacy.common.model;

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
 * Entity implementation class for Entity: para_reason_type
 * 
 */

@XmlRootElement
@Entity
@Table(name = "para_reason_type")
public class ReturnReasonTypeMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "type_name")
	private String typeName;
	
	@Expose
	@Column(name = "type_tag")
	private String typeTag;
	
	@Expose
	@Column(name = "remarks")
	private String remarks;


	public int getId() {
		return id;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getTypeTag() {
		return typeTag;
	}


	public void setTypeTag(String typeTag) {
		this.typeTag = typeTag;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public void setId(int id) {
		this.id = id;
	}

	
}