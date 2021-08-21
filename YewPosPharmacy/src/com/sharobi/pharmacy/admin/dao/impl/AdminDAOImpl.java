package com.sharobi.pharmacy.admin.dao.impl;
import java.io.StringWriter;
/**
 * rajarshi
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

import com.sharobi.license.struts.key.KeyBean;
import com.sharobi.license.struts.key.KeyDetails;
import com.sharobi.pharmacy.admin.dao.AdminDAO;
import com.sharobi.pharmacy.admin.model.RoleDTO;
import com.sharobi.pharmacy.admin.model.UserRoleMapping;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.commonutil.StoredProcedures;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.roles.model.Role;
import com.sharobi.pharmacy.roles.model.RoleMenu;
import com.sharobi.pharmacy.roles.model.User;

import net.sf.resultsetmapper.ReflectionResultSetMapper;

public class AdminDAOImpl implements AdminDAO {
	private final static Logger logger = LogManager
			.getLogger(AdminDAOImpl.class);

	private EntityManagerFactory entityManagerFactory = PersistenceListener.getEntityManager();
	

	public AdminDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User login(User user) throws DAOException {
		
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			//entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			//String encryptdPwd=encrypt(user.getPassword());
			
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_VALID_USER);
			callableStatement.setString(1, user.getUserName());
			callableStatement.setString(2, user.getPassword());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			boolean more = rs.next();
			
			if (!more) {
				user.setValid(false);
			} else if(more){
				user.setValid(true);
				logger.info("User fetched");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return user;
	}
	
	@Override
	public ResponseObj addUser(User user) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj ro = new ResponseObj();

		List<User> existingUsers = getUserByCompanyNStore(user.getCompanyId(),user.getStoreId());
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			
			Query qry = em
					.createQuery("SELECT k FROM KeyBean k WHERE k.store_id=:store_id order by k.id desc");
			qry.setMaxResults(1);

			qry.setParameter("store_id",
					Integer.toString(user.getStoreId()));
			KeyBean bean = (KeyBean) qry.getSingleResult();
			String license = bean.getLicense_key();

			boolean isValidKey = true;

			// TGFhZ05GemRtMDFEZ2Fk
			KeyDetails keyDetails = new KeyDetails();
			KeyBean key = keyDetails.getKeyDetails(license);
			System.out.println("License user no = "+key.getNo_of_users());
			if(existingUsers.size() <= Integer.parseInt(key.getNo_of_users())) {
				
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				try {
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_GEN_CREATE_USER);
					callableStatement.setInt(1, user.getId());
					callableStatement.setString(2, user.getUserName());
					callableStatement.setString(3, user.getPassword());
					callableStatement.setString(4, user.getUserCode());
					callableStatement.setString(5, user.getFname());
					callableStatement.setString(6, user.getLname());
					callableStatement.setString(7, user.getPhone());
					callableStatement.setString(8, user.getEmail());
					callableStatement.setInt(9, user.getIsActive());
					callableStatement.setInt(10, user.getIsLocked());
					callableStatement.setInt(11, user.getCompanyId());
					callableStatement.setInt(12, user.getStoreId());
					callableStatement.setInt(13, user.getCreatedBy());
					callableStatement.registerOutParameter(14,java.sql.Types.INTEGER);
					
					callableStatement.execute();
					status = callableStatement.getInt(14);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				em.getTransaction().commit();
			}
			else {
				status = -2;
				throw new Exception("Number of users saturated.");
		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		
		if(status > 0 ) {
			ro.setId(status);
			ro.setStatus("User created successfully");
		} else if(status == -2) {
			ro.setId(status);
			ro.setStatus("Number of users in license are already created. You can create upto "+existingUsers+" number of users.");
		} else {
			ro.setId(status);
			ro.setStatus("User not created successfully");
		}
		return ro;

	}
	
	@Override
	public User getUser(int uid) throws DAOException {

		User u = null;
		EntityManager em = null;
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
//			em.getTransaction().begin();
			
			Query qry = em
					.createQuery("SELECT u FROM User u where u.id=:uid");
			qry.setParameter("uid", uid);
			u = (User) qry.getSingleResult();
			

//			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of getUser", e);

		} finally {
			if(em != null) em.close();
		}
		return u;
	}

	@Override
	public List<User> getUserByCompany(int id) throws DAOException {

		List<User> u = null;
		EntityManager em = null;
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
//			em.getTransaction().begin();
			
			Query qry = em.createQuery("SELECT u FROM User u where u.companyId=:id and u.isAdmin=0");
//					.createQuery("SELECT u.id,u.userName,u.fname,u.lname,u.userCode,u.companyId,u.isLocked,u.storeId,u.createdBy,u.updatedBy,u.isAdmin,u.email,u.phone FROM User u where u.companyId=:id and u.isAdmin=0");
			qry.setParameter("id", id);
			u = (List<User>) qry.getResultList();
			

//			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of getUser", e);

		} finally {
			if(em != null) em.close();
		}
		return u;
	}
	
	@Override
	public List<User> getUserByCompanyNStore(int id,int storeId) throws DAOException {

		List<User> u = null;
		EntityManager em = null;
		int isActive=1;
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
//			em.getTransaction().begin();
			
			Query qry = em.createQuery("SELECT u FROM User u where u.companyId=:id and u.storeId=:storeId and u.isActive=:isActive");
//					.createQuery("SELECT u.id,u.userName,u.fname,u.lname,u.userCode,u.companyId,u.isLocked,u.storeId,u.createdBy,u.updatedBy,u.isAdmin,u.email,u.phone FROM User u where u.companyId=:id and u.isAdmin=0");
			qry.setParameter("id", id);
			qry.setParameter("storeId", storeId);
			qry.setParameter("isActive", isActive);
			u = (List<User>) qry.getResultList();
			

//			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of getUser in companyandstore", e);

		} finally {
			if(em != null) em.close();
		}
		return u;
	}

	@Override
	public ResponseObj addorupdateRole(RoleDTO role) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj ro = new ResponseObj();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			try {
				StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-10-04\\file_purchase_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(RoleDTO.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchase, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(role, sw);
				String result = sw.toString();
				System.out.println("addOrUpdateRole xml:: "+result);
				
				
				  callableStatement = connection
				  .prepareCall(StoredProcedures.PROC_GEN_CREATE_ROLE);
				  callableStatement.setString(1, result);
				  callableStatement.registerOutParameter(2,java.sql.Types.INTEGER);
				  
				  callableStatement.execute(); 
				  status = callableStatement.getInt(2);
				 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		
		if(status > 0 ) {
			ro.setId(status);
			ro.setStatus("Role created successfully");
		} else {
			ro.setId(status);
			ro.setStatus("Role not created successfully");
		}
		return ro;

	}

	@Override
	public List<Role> getRolesByCompany(int id) throws DAOException {

		List<Role> roles = null;
		EntityManager em = null;
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
//			em.getTransaction().begin();
			
			Query qry = em.createQuery("SELECT r FROM Role r where r.companyId=:id and r.isDeleted=0");
			qry.setParameter("id", id);
			roles = (List<Role>) qry.getResultList();
			

//			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of getRoles", e);

		} finally {
			if(em != null) em.close();
		}
		return roles;
	}

	@Override
	public List<RoleMenu> getRoleMenusByRole(int id) throws DAOException {

		List<RoleMenu> roleMenus = null;
		EntityManager em = null;
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
//			em.getTransaction().begin();
			
			Query qry = em.createQuery("SELECT rm FROM RoleMenu rm where rm.roleId=:id");
			qry.setParameter("id", id);
			roleMenus = (List<RoleMenu>) qry.getResultList();
//			em.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of getRoleMenus", e);
		} finally {
			if(em != null) em.close();
		}
		return roleMenus;
	}

	@Override
	public ResponseObj deleteRole(RoleDTO role) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj ro = new ResponseObj();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			try {
				StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-10-04\\file_purchase_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(RoleDTO.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchase, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(role, sw);
				String result = sw.toString();
				System.out.println("addOrUpdateRole xml:: "+result);
				
				
				  callableStatement = connection
				  .prepareCall(StoredProcedures.PROC_GEN_DELETE_ROLE);
				  callableStatement.setInt(1, role.getCompanyId());
				  callableStatement.setInt(2, role.getId());
				  callableStatement.registerOutParameter(3,java.sql.Types.INTEGER);
				  
				  callableStatement.execute(); 
				  status = callableStatement.getInt(3);
				 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		
		if(status > 0 ) {
			ro.setId(status);
			ro.setStatus("Role deleted successfully");
		} else {
			ro.setId(status);
			ro.setStatus("Role not deleted successfully");
		}
		return ro;

	}

	@Override
	public ResponseObj mapuserrole(UserRoleMapping urm) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj ro = new ResponseObj();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			try {
				
				  callableStatement = connection
				  .prepareCall(StoredProcedures.PROC_GEN_USER_ROLE_MAPPING);
				  callableStatement.setInt(1, urm.getUserId());
				  callableStatement.setInt(2, urm.getRoleId());
				  callableStatement.setInt(3, urm.getCreatedBy());
				  callableStatement.registerOutParameter(4,java.sql.Types.INTEGER);
				  
				  callableStatement.execute(); 
				  status = callableStatement.getInt(4);
				 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		
		if(status > 0 ) {
			ro.setId(status);
			ro.setStatus("Role User mapped successfully");
		} else {
			ro.setId(status);
			ro.setStatus("Role User not mapped successfully");
		}
		return ro;

	}

	@Override
	public List<UserRoleMapping> getUserRoleMappingByCompany(int id) throws DAOException {
		List<UserRoleMapping> list=new ArrayList<UserRoleMapping>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_USER_ROLE);
			
			callableStatement.setInt(1, id);
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<UserRoleMapping> resultSetMapper = new ReflectionResultSetMapper<UserRoleMapping>(
					UserRoleMapping.class);
			while(rs.next()){
				UserRoleMapping card = new UserRoleMapping();
				card = resultSetMapper.mapRow(rs);
				list.add(card);
			}
			logger.info("fetched all user role mappings");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}

	/*public String encrypt(String str) {
		

		try {
			SecretKey key;
			key = KeyGenerator.getInstance("DES").generateKey();
			ecipher = Cipher.getInstance("DES");
			
			ecipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] utf8 = str.getBytes("UTF8");

			byte[] enc = ecipher.doFinal(utf8);

			// encode to base64

			enc = BASE64EncoderStream.encode(enc);

			return new String(enc);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}*/

}


