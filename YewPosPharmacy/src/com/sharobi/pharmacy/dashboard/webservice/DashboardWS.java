package com.sharobi.pharmacy.dashboard.webservice;

import com.sharobi.pharmacy.common.CommonResultSetMapper;

public interface DashboardWS {
	public String getAllCount(CommonResultSetMapper cm);

	public String getAllTransMonthWise(CommonResultSetMapper cm);

	public String getTotalStore();

	public String getAllCountMonthWise(CommonResultSetMapper cm);

	String getAllStoreByCompanyId(CommonResultSetMapper cm);
}
