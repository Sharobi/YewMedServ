package com.sharobi.pharmacy.test.service;

import java.util.ArrayList;
import java.util.List;

import com.sharobi.pharmacy.inventory.model.CountryMaster;
import com.sharobi.pharmacy.test.dao.TestDAO;
import com.sharobi.pharmacy.test.dao.impl.TestDAOImpl;

public class TestService {

	TestDAO tDao = new TestDAOImpl();
	
	public List<CountryMaster> getAllaccgroups() {
		List<CountryMaster> countryMasters = new ArrayList<>();
		countryMasters = tDao.getAllaccgroups();;
		System.out.println("Service cms = "+countryMasters);
		return countryMasters;
	}


	public List<CountryMaster> getspeccntris(CountryMaster cm) {
		return tDao.getspeccntris(cm);
	}
}
