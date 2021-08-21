package com.sharobi.pharmacy.common.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement
public class ExcelUploadResultObj implements Serializable {
	@Expose
	private int id;

	@Expose
	private String result;

	@Expose
	private List<String> failedItemList;
	
	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<String> getFailedItemList() {
		return failedItemList;
	}

	public void setFailedItemList(List<String> failedItemList) {
		this.failedItemList = failedItemList;
	}
	
}