/**
 * 
 */
package com.sharobi.pharmacy.commonutil;

import java.security.MessageDigest;


/**
 * @author habib
 *
 */
public class PasswordManager {
	
	private static PasswordManager manager = null;
	private MessageDigest md = null;
	
	private PasswordManager() {
			try {
				md = MessageDigest.getInstance("SHA");
				} catch (java.security.NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
		}
	
	public static PasswordManager getInstance() {

		if (manager == null) {

			manager = new PasswordManager();
			return manager;
		}
		return manager;
	}

	
	public String encrypt(String str) {
		byte[] encPassword = md.digest(str.getBytes());
		return new String(encPassword);
		}

}
