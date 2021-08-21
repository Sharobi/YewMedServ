/**
 * 
 */
package com.sharobi.pharmacy.commonutil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.exceptions.DAOException;

/**
 * @author habib
 * 
 */
public class Util {

  private static EntityManagerFactory entityManagerFactory = PersistenceListener.getEntityManager();;

	public static boolean validateExpiryDate(String expDate) {
		boolean valid=true;
		try {
			
			String[] arr=expDate.split("/");
			String expMnth=arr[0];
			String expYr=arr[1];
			
			int expMonth=Integer.parseInt(expMnth);
			int expYear=Integer.parseInt(expYr);
			
			//get current month and year
			java.util.Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int curntMonth = cal.get(Calendar.MONTH);
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime());
			System.out.println(formattedDate);
			int crntYear=Integer.parseInt(formattedDate);
			
			if(expMonth>12){
				valid=false;
			}
			
			else if(expYear<crntYear){
				valid=false;
			}
			
			else if (expYear==crntYear) {
				if(expMonth<=curntMonth+1){
					valid=false;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
	}
	
	public static boolean checkChildTableDataExist(String id, String qryStr) throws DAOException{
		boolean isDataExist=false;
		EntityManager em = null;
		try{
		
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		String queryStr="SELECT TABLE_NAME, COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE COLUMN_NAME LIKE '"+qryStr+"'";
		Query query1 = em.createNativeQuery(queryStr);
		
		List<Object> resultList=query1.getResultList();
		Iterator<Object> it=resultList.iterator();
		while (it.hasNext()) {
			Object[] row = (Object[]) it.next();
			
			String tablName=(String)row[0];
			String colName=(String)row[1];
			
			//check if data exists
			String queryStr1="SELECT * FROM "+ tablName+" where "+colName+"="+id;
			Query query2 = em.createNativeQuery(queryStr1);
			List<Object> resultList1=query2.getResultList();
			if(resultList1.size()>0){
				isDataExist=true;
				break;
			}
			
			}
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("Check data to be deleted", e);
		} finally {
			em.close();
		}
		return isDataExist;
	}
	
	public static boolean chkSpecialCharacter(String s) {
	     if (s == null || s.trim().isEmpty()) {
	         System.out.println("Incorrect format of string");
	         return false;
	     }
	     Pattern p = Pattern.compile("[^A-Za-z0-9]");
	     Matcher m = p.matcher(s);
	    // boolean b = m.matches();
	     boolean b = m.find();
	     return b;
	 }
	
	public static double roundOffUptoTwoPlacesDouble(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		double tmp = value;
		if (value % 1 != 0.5) {
			tmp = Math.round(value);
		}

		return (double) tmp / factor;
	}

	public static void main(String args[]) {
		try {
			String date1="02/17";
			java.util.Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.YEAR);
			
			System.out.println("month:: "+month);
			
			
			
			String[] arr=date1.split("/");
			System.out.println("vvvvvvvv");

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
