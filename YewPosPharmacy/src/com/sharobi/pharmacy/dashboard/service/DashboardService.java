package com.sharobi.pharmacy.dashboard.service;

import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.dashboard.dao.DashboardDAO;
import com.sharobi.pharmacy.dashboard.dao.impl.DashboardDAOImpl;
import com.sharobi.pharmacy.dashboard.model.Dashboard;
import com.sharobi.pharmacy.dashboard.model.GraphData;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.store.model.StoreMaster;

public class DashboardService {
	
	DashboardDAO ddao = new DashboardDAOImpl();
	
	public Dashboard getAllCount(CommonResultSetMapper cm)
			throws ServiceException {
		Dashboard count = null;
		try {
			
			count = ddao.getAllCount(cm);
			

		} catch (DAOException e) {
			throw new ServiceException("error getTotalCount count", e);

		}
		return count;
	}

	public GraphData getAllTransMonthWise(CommonResultSetMapper cm) throws ServiceException  {
		GraphData graphdata = null;
		try {
			
			graphdata = ddao.getAllTransMonthWise(cm);
			

		} catch (DAOException e) {
			throw new ServiceException("error getAllTransMonthWise", e);

		}
		return graphdata;
	}
	
	public List<StoreMaster> getAllStore()throws ServiceException {
	     List<StoreMaster> storeMaster = null;
		    try {
	
			storeMaster = ddao.getAllStore();
	
	
		} catch (DAOException e) {
			e.printStackTrace();
	       throw new ServiceException("error getAllStore count", e);
	
		}
		return storeMaster;
	}

	public GraphData getAllCountMonthWise(CommonResultSetMapper cm) throws ServiceException {
		GraphData graphdata = null;
		try {
			
			graphdata = ddao.getAllCountMonthWise(cm);
			

		} catch (DAOException e) {
			throw new ServiceException("error getAllCountMonthWise", e);

		}
		return graphdata;
	}

	public List<StoreMaster> getAllStoreByCompanyId(int companyId) throws ServiceException {
		List<StoreMaster> smlist = null;
		try {
			
			smlist = ddao.getAllStoreByCompanyId(companyId);
			

		} catch (DAOException e) {
			throw new ServiceException("error getAllCountMonthWise", e);

		}
		return smlist;
	}
}
