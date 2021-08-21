package com.sharobi.pharmacy.admin.webservice;

import com.sharobi.pharmacy.admin.model.RoleDTO;
import com.sharobi.pharmacy.admin.model.UserRoleMapping;
import com.sharobi.pharmacy.roles.model.User;

public interface AdminWS {

	String addUser(User user);

	String getUser(int id);

	String getUserByCompany(int id);

	String addorupdateRole(RoleDTO role);

	String getRolesByCompany(int id);

	String getRoleMenusByRole(int id);

	String deleteRole(RoleDTO role);

	String mapuserrole(UserRoleMapping urm);

	String getUserRoleMappingByCompany(int id);

}
