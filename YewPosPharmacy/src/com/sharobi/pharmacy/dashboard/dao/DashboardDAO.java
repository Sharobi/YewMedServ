package com.sharobi.pharmacy.dashboard.dao;

import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.dashboard.model.Dashboard;
import com.sharobi.pharmacy.dashboard.model.GraphData;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.store.model.StoreMaster;

public interface DashboardDAO {
	public Dashboard getAllCount(CommonResultSetMapper cm) throws DAOException;

	public GraphData getAllTransMonthWise(CommonResultSetMapper cm) throws DAOException;

	public List<StoreMaster> getAllStore() throws DAOException;

	public GraphData getAllCountMonthWise(CommonResultSetMapper cm) throws DAOException;

	public List<StoreMaster> getAllStoreByCompanyId(int companyId) throws DAOException;
}
