package com.sharobi.pharmacy.roles.webservice;

import javax.ws.rs.QueryParam;

import com.sharobi.pharmacy.roles.model.LoginInfoByUserDTO;
import com.sharobi.pharmacy.roles.model.Menu;
import com.sharobi.pharmacy.roles.model.Role;

public interface RoleWS {

	public String addRole(Role role);

	public String updateRole(Role role);

	public String addMenu(Menu menu);

	public String getMenuByUser(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "userId") String userId,
			@QueryParam(value = "productTypeId") String productTypeId);

	public String authenticateUser(LoginInfoByUserDTO user);

	public String getMenuDetailsByUser(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "userId") String userId,
			@QueryParam(value = "menuId") String menuId,
			@QueryParam(value = "productTypeId") String productTypeId,
			@QueryParam(value = "lang") String lang);
}
