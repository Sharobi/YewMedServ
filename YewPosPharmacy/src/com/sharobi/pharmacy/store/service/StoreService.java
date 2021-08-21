package com.sharobi.pharmacy.store.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.EmailBean;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.store.dao.StoreDAO;
import com.sharobi.pharmacy.store.dao.impl.StoreDAOImpl;
import com.sharobi.pharmacy.store.model.FinYrMaster;
import com.sharobi.pharmacy.store.model.StoreMaster;

public class StoreService {

	private StoreDAO storeDAO = new StoreDAOImpl();

	public StoreService() {

	}

	public StoreMaster getStoreDetails(String storeId) throws ServiceException {

		StoreMaster store = null;
		try {

			store = storeDAO.getStoreDetails(storeId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get store", e);

		}
		return store;
	}
	
	public ResponseObj sendEmail(EmailBean emailBean,HttpServletRequest request)
			throws ServiceException {
		ResponseObj status=null;
		try {
			status = storeDAO.sendEmail(emailBean,request);

		} catch (DAOException e) {
			throw new ServiceException("error email", e);

		}
		return status;
	}
	
	public List<FinYrMaster> getFinYrList(CommonResultSetMapper mapper) throws ServiceException {
		List<FinYrMaster> finYrMasters = null;
		try {
			finYrMasters = storeDAO.getFinYrList(mapper);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get finyr list", e);
		}
		return finYrMasters;
	}

}
