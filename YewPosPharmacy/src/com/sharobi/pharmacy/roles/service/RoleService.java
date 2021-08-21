package com.sharobi.pharmacy.roles.service;

import java.util.List;

import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.roles.dao.RoleDAO;
import com.sharobi.pharmacy.roles.dao.impl.RoleDAOImpl;
import com.sharobi.pharmacy.roles.model.LoginInfoByUserDTO;
import com.sharobi.pharmacy.roles.model.Menu;
import com.sharobi.pharmacy.roles.model.MenuByUserDTO;
import com.sharobi.pharmacy.roles.model.Role;


public class RoleService {

	private RoleDAO roleDAO = new RoleDAOImpl();

	public RoleService() {

	}

	public String addRole(Role role) throws ServiceException {
		String status ="";
		try {
			status = roleDAO.addRole(role);

		} catch (DAOException e) {
			throw new ServiceException("error creating Role", e);

		}
		return status;
	}
	
	public String createRole(Role role) throws ServiceException {
		String status ="";
		try {
			status = roleDAO.addRole(role);

		} catch (DAOException e) {
			throw new ServiceException("error creating Role", e);

		}
		return status;
	}
	
	public String addMenu(Menu menu) throws ServiceException {
		String status ="";
		try {
			status = roleDAO.addMenu(menu);

		} catch (DAOException e) {
			throw new ServiceException("error creating Role", e);

		}
		return status;
	}
	
	public String updateRole(Role role) throws ServiceException {
		String status ="";
		try {
			status = roleDAO.updateRole(role);

		} catch (DAOException e) {
			throw new ServiceException("error creating Role", e);

		}
		return status;
	}
	
	public List<MenuByUserDTO> getMenuByUser(String cmpnyId,
			String storeId, String userId,String productTypeId) throws ServiceException {

		List<MenuByUserDTO> menuList = null;
		try {
			
			menuList = roleDAO.getMenuByUser(cmpnyId,
					storeId,userId,productTypeId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get menu by user", e);

		}
		return menuList;
	}
	
	public MenuByUserDTO getMenuDetailsByUser(String cmpnyId,
			String storeId, String userId, String menuId, String productTypeId) throws ServiceException {

		MenuByUserDTO menu = null;
		try {
			
			menu = roleDAO.getMenuDetailsByUser(cmpnyId,
					storeId,userId,menuId,productTypeId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get menu details by user", e);

		}
		return menu;
	}
	

	public LoginInfoByUserDTO getUserByCredential(LoginInfoByUserDTO customer)
			throws ServiceException {
		LoginInfoByUserDTO loggedinUser = null;
		try {
			
			loggedinUser = roleDAO.getUserByCredential(customer);

			System.out.println("Enter LoginService.getUserByCredential ");
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("problem occured while trying to login",
					e);
		}
		return loggedinUser;
	}


	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	







}
