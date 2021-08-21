package com.sharobi.pharmacy.dashboard.webservice.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.dashboard.model.Dashboard;
import com.sharobi.pharmacy.dashboard.model.GraphData;
import com.sharobi.pharmacy.dashboard.service.DashboardService;
import com.sharobi.pharmacy.dashboard.webservice.DashboardWS;
import com.sharobi.pharmacy.store.model.StoreMaster;

@Path(value = "/dashboard")
public class DashboardWSImpl implements DashboardWS {
	
	private DashboardService dashService = new DashboardService();
	
	@Override
	@Path(value = "/getAllCount")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllCount(CommonResultSetMapper cm) {
		Dashboard count = null;
		System.out.println("mapper = "+cm);
		try {
			count = dashService.getAllCount(cm);
		} catch (Exception x) {
			count = null;
			x.printStackTrace();
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<Dashboard>() {
		}.getType();
		String json = gson.toJson(count, type);
		
		//System.out.println("getAllCount = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getAllTransMonthWise")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllTransMonthWise(CommonResultSetMapper cm) {
		GraphData count = null;
		try {
			count = dashService.getAllTransMonthWise(cm);
		} catch (Exception x) {
			count = null;
			x.printStackTrace();
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<GraphData>() {
		}.getType();
		String json = gson.toJson(count, type);
		
		//System.out.println("getAllTransMonthWise = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getAllCountMonthWise")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllCountMonthWise(CommonResultSetMapper cm) {
		GraphData count = null;
		try {
			count = dashService.getAllCountMonthWise(cm);
		} catch (Exception x) {
			count = null;
			x.printStackTrace();
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<GraphData>() {
		}.getType();
		String json = gson.toJson(count, type);
		
		//System.out.println("getAllCountMonthWise = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getAllStore")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getTotalStore() {
		List<StoreMaster> storeMaster = null;
		//int count = 0;
		try {
			storeMaster = dashService.getAllStore();
		} catch (Exception x) {
			storeMaster = null;
			x.printStackTrace();
		}Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<StoreMaster>>() {
		}.getType();
		String json = gson.toJson(storeMaster, type);
		return json;
	}
	
	@Override
	@Path(value = "/getAllStoreByCompanyId")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllStoreByCompanyId(CommonResultSetMapper cm) {
		List<StoreMaster> storeMaster = null;
		//int count = 0;
		try {
			storeMaster = dashService.getAllStoreByCompanyId(cm.getCompanyId());
		} catch (Exception x) {
			storeMaster = null;
			x.printStackTrace();
		}Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<StoreMaster>>() {
		}.getType();
		String json = gson.toJson(storeMaster, type);
		//System.out.println("getAllStoreByCompanyId : "+json);
		return json;
	}
}
