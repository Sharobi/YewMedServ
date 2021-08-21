package com.sharobi.pharmacy.roles.webservice.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.roles.model.LoginInfoByUserDTO;
import com.sharobi.pharmacy.roles.model.Menu;
import com.sharobi.pharmacy.roles.model.MenuByUserDTO;
import com.sharobi.pharmacy.roles.model.Role;
import com.sharobi.pharmacy.roles.service.RoleService;
import com.sharobi.pharmacy.roles.webservice.RoleWS;

@Path(value = "/role")
public class RoleWSImpl implements RoleWS {

	private RoleService roleService = new RoleService();

	@Override
	@Path(value = "/addRole")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addRole(Role role) {
		String status = "";
		try {
			status = roleService.addRole(role);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/addMenu")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addMenu(Menu menu) {
		String status = "";
		try {
			status = roleService.addMenu(menu);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateRole")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateRole(Role role) {
		String status = "";
		try {
			status = roleService.updateRole(role);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/getMenuByUser")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getMenuByUser(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "userId") String userId,
			@QueryParam(value = "productTypeId") String productTypeId) {
		List<MenuByUserDTO> menuList = null;
		//long startTime = System.currentTimeMillis();
		try {
			// roleService.getObjects(cmpnyId);
			menuList = roleService.getMenuByUser(cmpnyId, storeId, userId,productTypeId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		//long endTime = System.currentTimeMillis();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<MenuByUserDTO>>() {
		}.getType();
		String json = gson.toJson(menuList, type);

		//System.out.println("time diff in WS getMenuByUser:: " + (endTime - startTime));

		return json;
	}

	@Override
	@Path(value = "/getMenuDetailsByUser")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getMenuDetailsByUser(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "userId") String userId,
			@QueryParam(value = "menuId") String menuId,
			@QueryParam(value = "productTypeId") String productTypeId,
			@QueryParam(value = "lang") String lang) {
		//System.out.println("testing ptid");
		//System.out.println("Menu ID = "+menuId);
		//System.out.println("cmpnyId ID = "+cmpnyId);
		//System.out.println("storeId ID = "+storeId);
		//System.out.println("userId ID = "+userId);
		//System.out.println("productTypeId ID = "+productTypeId);
		//System.out.println("lang ID = "+lang);
		
		
		MenuByUserDTO menu = null;
		//long startTime = System.currentTimeMillis();
		try {
			menu = roleService.getMenuDetailsByUser(cmpnyId, storeId, userId,
					menuId, productTypeId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		//long endTime = System.currentTimeMillis();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(menu, MenuByUserDTO.class);

		//System.out.println("time diff in WS getMenuDetailsByUser:: " + (endTime - startTime));
		return json;
	}

	@Override
	@Path(value = "/authenticate")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String authenticateUser(LoginInfoByUserDTO user) {
		LoginInfoByUserDTO loggedInUsr = null;
		try {

			loggedInUsr = roleService.getUserByCredential(user);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd").create();
		return gsonBuilder.excludeFieldsWithoutExposeAnnotation().create()
				.toJson(loggedInUsr);
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
