package com.sharobi.pharmacy.store.webservice;

import javax.ws.rs.QueryParam;

import com.sharobi.pharmacy.common.CommonResultSetMapper;

/**
rajarshi
*/

public interface StoreWS {
		
		public String getStoreDetails(@QueryParam(value = "storeId") String storeId);
		
		public String getFinYrList(CommonResultSetMapper mapper);
					
}


