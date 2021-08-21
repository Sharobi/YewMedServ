package com.sharobi.pharmacy.store.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.EmailBean;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.store.model.StoreMaster;
import com.sharobi.pharmacy.store.model.FinYrMaster;

/**
rajarshi
*/
public interface StoreDAO {

	public StoreMaster getStoreDetails(String storeId) throws DAOException;
	
	public ResponseObj sendEmail(EmailBean emailBean,HttpServletRequest request) throws DAOException;
	
	public List<FinYrMaster> getFinYrList(CommonResultSetMapper comm) throws DAOException;
	

}

