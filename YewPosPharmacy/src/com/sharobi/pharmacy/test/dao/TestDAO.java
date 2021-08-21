package com.sharobi.pharmacy.test.dao;

import java.util.List;

import com.sharobi.pharmacy.inventory.model.CountryMaster;

public interface TestDAO {

	public List<CountryMaster> getAllaccgroups();
	public List<CountryMaster> getspeccntris(CountryMaster cm);
}
