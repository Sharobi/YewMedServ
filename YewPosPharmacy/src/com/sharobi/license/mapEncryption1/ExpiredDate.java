package com.sharobi.license.mapEncryption1;

import java.util.Calendar;

import com.sharobi.pharmacy.common.ReturnConstant;


public class ExpiredDate {
	String periodEncrypted = "";
	String activationKey = "";
	
	public ExpiredDate(String period, String key) {
		periodEncrypted = period;
		activationKey = key;
	}
	
	public ExpiredDate(String key) {
		periodEncrypted = "" + key.charAt(0);
		activationKey = key;
	}

	public String expiredDate(){
		String day = "";
	
		Calendar calendar = Calendar.getInstance();
		EncryptingLevel1 encryptingLevel1 = new EncryptingLevel1();
		encryptingLevel1.decodingActivationKey1(activationKey);
		calendar.set(Integer.parseInt("20" + encryptingLevel1.decodedYear), Integer.parseInt(encryptingLevel1.decodedMonth)-1, Integer.parseInt(encryptingLevel1.decodedDay));
		long timeMilliSec = calendar.getTimeInMillis();
		
		if(ReturnConstant.devMode) System.out.println("From date======" + calendar.getTime());
		int months = 0;
		for(int i = 0; i < 24; i++){
			 if(this.periodEncrypted.equals(EncryptingLevel1.mappingPeriods[i])){
				 months = i+1;
				 break;
			 }
		 }
		if(ReturnConstant.devMode) System.out.println("no of months ======" + months);
		
		calendar.add(Calendar.MONTH, months);
		calendar.add(Calendar.DATE, 1);
		
		String yy = Integer.toString(calendar.get(calendar.YEAR));
		String mm = Integer.toString(calendar.get(calendar.MONTH)+ 1);
		String dd = Integer.toString(calendar.get(calendar.DAY_OF_MONTH));
		
		if(mm.length() == 1)mm = "0" + mm;
		if(dd.length() == 1)dd = "0" + dd;
		
		day = yy + "-" + mm + "-" + dd;
		if(ReturnConstant.devMode) System.out.println("Expired Time is " + day);
		return day;
	}

	public static void main(String[] args) {
		//ExpiredDate date = new ExpiredDate("L", "PaagN*ydm01Jr03");
		ExpiredDate date = new ExpiredDate("PaagN*ydm01Jr03");
		date.expiredDate();
	}

}
