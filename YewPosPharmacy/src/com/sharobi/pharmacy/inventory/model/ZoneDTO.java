package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ZoneDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;

	@Expose
	@MapToData(columnAliases = { "name" })
	private String name;
	
	@Expose
	@MapToData(columnAliases = { "city_id" })
	private int cityId;
	
	@Expose
	@MapToData(columnAliases = { "city_name" })
	private String cityName;
	
	@Expose
	@MapToData(columnAliases = { "state_id" })
	private int stateId;
	
	@Expose
	@MapToData(columnAliases = { "state_name" })
	private String stateName;
	
	@Expose
	@MapToData(columnAliases = { "country_id" })
	private int countryId;
	
	@Expose
	@MapToData(columnAliases = { "country_name" })
	private String countryName;
	
	@Expose
	@MapToData(columnAliases = { "district_name" })
	private String districtName;
	

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
