/**
 * 
 */
package com.sharobi.pharmacy.commonutil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;



/**
 * @author habib
 *
 */
public class TrimBeanValue {
	
	private static final TrimBeanValue trimBeanValue = new TrimBeanValue();
	
	private TrimBeanValue() {}
	
	public Object trimObjectValue(Object object) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		
		if(object == null){
			
			throw new IllegalArgumentException("parameters cant be null");
		}
		Field[] allFields = object.getClass().getDeclaredFields();
		
		for (Field field : allFields) {
			
			if(field.getGenericType().equals(String.class)){
				
				field.setAccessible(true);
				field.set(object, (field.get(object) == null?null:field.get(object).toString().trim()));
			}
			
		}
		return object;
	}
	/**
	 * 
	 * This method returns the <code>TrimBeanValue</code> object
	 * @return TrimBeanValue object
	 */
	public static TrimBeanValue getInstance(){
		return trimBeanValue;
	}
	

}
