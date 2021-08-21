/**
 * 
 */
package com.sharobi.pharmacy.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author habib
 *
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	private final static Logger serviceLogger = LogManager
			.getLogger(BaseServiceImpl.class);

	private BaseDao<T> baseDao;
	
	

	/**
	 * @return the baseDao
	 */
	public BaseDao<T> getBaseDao() {
		return baseDao;
	}



	/**
	 * @param baseDao the baseDao to set
	 */
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}



	/**
	 * 
	 */
	public BaseServiceImpl() {
		// TODO Auto-generated constructor stub
		super();
	}

}
