package com.sharobi.pharmacy.admin.service;

import java.util.List;

import com.sharobi.pharmacy.admin.dao.AdminDAO;
import com.sharobi.pharmacy.admin.dao.impl.AdminDAOImpl;
import com.sharobi.pharmacy.admin.model.RoleDTO;
import com.sharobi.pharmacy.admin.model.UserRoleMapping;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.roles.model.Role;
import com.sharobi.pharmacy.roles.model.RoleMenu;
import com.sharobi.pharmacy.roles.model.User;

public class AdminService {

	AdminDAO adminDao = new AdminDAOImpl();
	
	public ResponseObj addUser(User user) throws ServiceException {
		ResponseObj ro = null;
		try {

			ro = adminDao.addUser(user);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to create user", e);

		}
		return ro;
	}
	
	public User getUser(int uid) throws ServiceException {
		User u = null;
		try {

			u = adminDao.getUser(uid);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to fetch user", e);

		}
		return u;
	}

	public List<User> getUserByCompany(int id) throws ServiceException {
		List<User> u = null;
		try {
			u = adminDao.getUserByCompany(id);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to fetch user by company", e);
		}
		return u;
	}

	public ResponseObj addorupdateRole(RoleDTO role) throws ServiceException {
		ResponseObj ro = null;
		try {

			ro = adminDao.addorupdateRole(role);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to create/update role", e);

		}
		return ro;
	}

	public List<Role> getRolesByCompany(int id) throws ServiceException {
		List<Role> roles = null;
		try {
			roles = adminDao.getRolesByCompany(id);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to fetch roles by company", e);
		}
		return roles;
	}

	public List<RoleMenu> getRoleMenusByRole(int id) throws ServiceException {
		List<RoleMenu> roleMenus = null;
		try {
			roleMenus = adminDao.getRoleMenusByRole(id);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to fetch role menus by role", e);
		}
		return roleMenus;
	}

	public ResponseObj deleteRole(RoleDTO role) throws ServiceException {
		ResponseObj ro = null;
		try {

			ro = adminDao.deleteRole(role);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to delete role", e);

		}
		return ro;
	}

	public ResponseObj mapuserrole(UserRoleMapping urm) throws ServiceException {
		ResponseObj ro = null;
		try {

			ro = adminDao.mapuserrole(urm);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to map user with role", e);

		}
		return ro;
	}

	public List<UserRoleMapping> getUserRoleMappingByCompany(int id) throws ServiceException {
		List<UserRoleMapping> roleMenus = null;
		try {
			roleMenus = adminDao.getUserRoleMappingByCompany(id);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to fetch role menus by role", e);
		}
		return roleMenus;
	}

}
