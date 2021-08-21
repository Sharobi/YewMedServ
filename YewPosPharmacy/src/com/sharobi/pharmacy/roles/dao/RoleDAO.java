package com.sharobi.pharmacy.roles.dao;

import java.util.List;

import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.roles.model.LoginInfoByUserDTO;
import com.sharobi.pharmacy.roles.model.Menu;
import com.sharobi.pharmacy.roles.model.MenuByUserDTO;
import com.sharobi.pharmacy.roles.model.Role;

public interface RoleDAO {

	public String addRole(Role role) throws DAOException;

	public String addMenu(Menu menu) throws DAOException;

	public String updateRole(Role role) throws DAOException;

	public List<MenuByUserDTO> getMenuByUser(String cmpnyId, String storeId,
			String userId,String productTypeId) throws DAOException;
	
	public MenuByUserDTO getMenuDetailsByUser(String cmpnyId, String storeId,
			String userId,String menuId, String productTypeId) throws DAOException;
	
	public LoginInfoByUserDTO getUserByCredential(LoginInfoByUserDTO user)
			throws DAOException;


}
