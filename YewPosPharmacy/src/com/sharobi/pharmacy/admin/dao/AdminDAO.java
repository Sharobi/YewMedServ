package com.sharobi.pharmacy.admin.dao;

import java.util.List;

import com.sharobi.pharmacy.admin.model.RoleDTO;
import com.sharobi.pharmacy.admin.model.UserRoleMapping;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.roles.model.Role;
import com.sharobi.pharmacy.roles.model.RoleMenu;
import com.sharobi.pharmacy.roles.model.User;


/**
rajarshi
*/
public interface AdminDAO {

	public User login(User user) throws DAOException;
	
	//added on 15.07.2019
	public ResponseObj addUser(User user) throws DAOException;

	public User getUser(int uid) throws DAOException;

	public List<User> getUserByCompany(int id) throws DAOException;

	public ResponseObj addorupdateRole(RoleDTO role) throws DAOException;

	public List<Role> getRolesByCompany(int id) throws DAOException;

	public List<RoleMenu> getRoleMenusByRole(int id) throws DAOException;

	public ResponseObj deleteRole(RoleDTO role) throws DAOException;

	public ResponseObj mapuserrole(UserRoleMapping urm) throws DAOException;

	public List<UserRoleMapping> getUserRoleMappingByCompany(int id) throws DAOException;
	
	public List<User> getUserByCompanyNStore(int compId,int storeId) throws DAOException;
	

}

