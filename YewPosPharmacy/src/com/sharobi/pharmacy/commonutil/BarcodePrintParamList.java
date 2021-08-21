package com.sharobi.pharmacy.commonutil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BarcodePrintParamList implements Serializable {
	
	/**
	 * SerialVersion UID for BarcodePrintParamList
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The list of BarcodePrintParam
	 */
	private List<BarcodePrintParam> paramList;
	
	/**
	 * Default constructor.
	 */
	public BarcodePrintParamList() {
		this.paramList = new ArrayList<>();
	}

	/**
	 * Constructor with the list of BarcodePrintParam <br/>
	 * 
	 * @param barcodePrintParamList	The list of BarcodePrintParam
	 */
	public BarcodePrintParamList(List<BarcodePrintParam> barcodePrintParamList) {
		this.paramList = barcodePrintParamList;
	}

	/**
	 * @return the barcodePrintParamList
	 */
	public List<BarcodePrintParam> getParamList() {
		return paramList;
	}

	/**
	 * @param barcodePrintParamList the barcodePrintParamList to set
	 */
	public void setParamList(List<BarcodePrintParam> barcodePrintParamList) {
		this.paramList = barcodePrintParamList;
	}

	@Override
	public String toString() {
		return "BarcodePrintParamList: " + paramList;
	}
	
	
	
}