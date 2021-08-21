package com.sharobi.pharmacy.dashboard.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class GraphData {
	
	@Expose
	@MapToData(columnAliases={"sales"})
	private String sales;
	
	@Expose
	@MapToData(columnAliases={"sales_return"})
	private String salesReturn;
	
	public GraphData() { }

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getSalesReturn() {
		return salesReturn;
	}

	public void setSalesReturn(String salesReturn) {
		this.salesReturn = salesReturn;
	}

	@Override
	public String toString() {
		return "GraphData [sales=" + sales + ", salesReturn=" + salesReturn + "]";
	}
	
}
