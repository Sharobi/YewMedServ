package com.sharobi.pharmacy.admin.webservice.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sharobi.pharmacy.admin.model.RoleDTO;
import com.sharobi.pharmacy.admin.model.UserRoleMapping;
import com.sharobi.pharmacy.admin.service.AdminService;
import com.sharobi.pharmacy.admin.webservice.AdminWS;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.roles.model.Role;
import com.sharobi.pharmacy.roles.model.RoleMenu;
import com.sharobi.pharmacy.roles.model.User;


@Path("/admin")
public class AdminWSImpl implements AdminWS {

	private AdminService adminService = new AdminService();
	
	@Override
	@Path(value = "/adduser")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addUser(User user) {
		ResponseObj ro = null;
		System.out.println("User : "+user.toString());
		try {
			ro = adminService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ro == null) {
			ro = new ResponseObj();
			ro.setStatus("User not added successfully.");
		}
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
		java.lang.reflect.Type type = new TypeToken<ResponseObj>() {
		}.getType(); 
		String json = gson.toJson(ro, type);
//		System.out.println("adduser = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getuser/{id}")
	@GET
	@Produces("application/json")
	public String getUser(@PathParam("id") int id) {
		User u = null;
		System.out.println("User : "+id);
		try {
			u = adminService.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		u.setPassword("");
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<User>() {
		}.getType();
		String json = gson.toJson(u, type);
//		System.out.println("getuser = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getusersbycompany/{id}")
	@GET
	@Produces("application/json")
	public String getUserByCompany(@PathParam("id") int id) {
		List<User> ul = null;
		System.out.println("User : "+id);
		try {
			ul = adminService.getUserByCompany(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ul!=null) {
			for (User user : ul) {
				user.setPassword("");
			}
		}
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<User>>() {
		}.getType();
		String json = gson.toJson(ul, type);
//		System.out.println("getUserByCompany = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getrolesbycompany/{id}")
	@GET
	@Produces("application/json")
	public String getRolesByCompany(@PathParam("id") int id) {
		List<Role> roles = null;
		System.out.println("User : "+id);
		try {
			roles = adminService.getRolesByCompany(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<Role>>() {
		}.getType();
		String json = gson.toJson(roles, type);
//		System.out.println("getUserByCompany = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getrolemenusbyrole/{id}")
	@GET
	@Produces("application/json")
	public String getRoleMenusByRole(@PathParam("id") int id) {
		List<RoleMenu> roleMenus = null;
		System.out.println("roleid : "+id);
		try {
			roleMenus = adminService.getRoleMenusByRole(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<RoleMenu>>() {
		}.getType();
		String json = gson.toJson(roleMenus, type);
//		System.out.println("getUserByCompany = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/addorupdaterole")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addorupdateRole(RoleDTO role) {
		ResponseObj ro = null;
		System.out.println("Role : "+role.toString());
		try {
			ro = adminService.addorupdateRole(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ro == null) {
			ro = new ResponseObj();
			ro.setStatus("Role not added successfully.");
		}
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
		java.lang.reflect.Type type = new TypeToken<ResponseObj>() {
		}.getType(); 
		String json = gson.toJson(ro, type);
//		System.out.println("adduser = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/deleterole")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteRole(RoleDTO role) {
		ResponseObj ro = null;
		System.out.println("Role : "+role.toString());
		try {
			ro = adminService.deleteRole(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ro == null) {
			ro = new ResponseObj();
			ro.setStatus("Role not deleted successfully.");
		}
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
		java.lang.reflect.Type type = new TypeToken<ResponseObj>() {
		}.getType(); 
		String json = gson.toJson(ro, type);
//		System.out.println("adduser = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/mapuserrole")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String mapuserrole(UserRoleMapping urm) {
		ResponseObj ro = null;
		System.out.println("mapuserrole : "+urm.toString());
		try {
			ro = adminService.mapuserrole(urm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ro == null) {
			ro = new ResponseObj();
			ro.setStatus("User Role not mapped successfully.");
		}
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
		java.lang.reflect.Type type = new TypeToken<ResponseObj>() {
		}.getType(); 
		String json = gson.toJson(ro, type);
//		System.out.println("adduser = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getuserrolemappingbycompany/{id}")
	@GET
	@Produces("application/json")
	public String getUserRoleMappingByCompany(@PathParam("id") int id) {
		List<UserRoleMapping> uroles = null;
		System.out.println("company id : "+id);
		try {
			uroles = adminService.getUserRoleMappingByCompany(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<UserRoleMapping>>() {
		}.getType();
		String json = gson.toJson(uroles, type);
//		System.out.println("getUserByCompany = "+json);
		return json;
	}
}
