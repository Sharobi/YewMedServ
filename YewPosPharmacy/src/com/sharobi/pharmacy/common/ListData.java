package com.sharobi.pharmacy.common;

import java.util.List;

/**
 * rajarshi
 */
public class ListData<T> {

	private List<T> objList = null;

	public ListData() {
		// TODO Auto-generated constructor stub
	}

	public ListData(List<T> list) {
		this.objList = list;
	}

	public List<T> getObjList() {
		return objList;
	}

	public void setObjList(List<T> objList) {
		this.objList = objList;
	}

}


