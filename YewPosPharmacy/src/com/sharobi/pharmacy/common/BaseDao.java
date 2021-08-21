/**
 * 
 */
package com.sharobi.pharmacy.common;

import java.util.List;

/**
 * @author habib
 *
 */
public interface BaseDao<T> {
	
	public T save(T obj) throws Exception;
	public T add(T obj) throws Exception;
	public T update(T obj) throws Exception;
	public void deleteObject(T obj) throws Exception;
	public T getObject(int id,int storeId) throws Exception;
	public List<T> getObjects(String searchClause) throws Exception;
	public List<T> getObjects(T obj) throws Exception;
	public List<T> getObjects(Object... obj) throws Exception;
	public boolean isExsistingObject(T obj) throws Exception;
	public int getSearchCount(String searchString) throws Exception;
	public int getSearchCount(T obj) throws Exception;

}
