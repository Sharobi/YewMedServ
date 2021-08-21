package com.sharobi.pharmacy.store.webservice.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.EmailBean;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.store.model.FinYrMaster;
import com.sharobi.pharmacy.store.model.StoreMaster;
import com.sharobi.pharmacy.store.service.StoreService;
import com.sharobi.pharmacy.store.webservice.StoreWS;

/**
 * rajarshi
 */
@Path(value = "/store")
public class StoreWSImpl implements StoreWS {
	private StoreService storeService = new StoreService();

	@Override
	@Path(value = "/getStoreDetails")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getStoreDetails(@QueryParam(value = "storeId") String storeId) {
		StoreMaster store = null;
		long startTime = System.currentTimeMillis();
		try {

			store = storeService.getStoreDetails(storeId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		long endTime = System.currentTimeMillis();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(store, StoreMaster.class);
		
		System.out.println("time diff in WS:: " + (endTime - startTime));

		return json;
	}
	
	
	@Path(value = "/sendEmail")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String sendEmail(EmailBean emailBean,@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = storeService.sendEmail(emailBean,request);

		} catch (Exception x) {
			
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Email not sent successfully.");
			x.printStackTrace();
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Override
	@Path(value = "/getFinYrList")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getFinYrList(CommonResultSetMapper mapper) {
		List<FinYrMaster> finYrMasters = null;
		try {
			finYrMasters = storeService.getFinYrList(mapper);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<FinYrMaster>>() {
		}.getType();
		String json = gson.toJson(finYrMasters, type);
		return json;
	}

	public StoreService getRoleService() {
		return storeService;
	}

	public void setRoleService(StoreService roleService) {
		this.storeService = roleService;
	}

}
