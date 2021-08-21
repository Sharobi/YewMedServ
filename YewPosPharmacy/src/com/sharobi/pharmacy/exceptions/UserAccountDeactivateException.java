/**
 * 
 */
package com.sharobi.pharmacy.exceptions;

/**
 * @author habib
 *
 */
public class UserAccountDeactivateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UserAccountDeactivateException() {
		super();
	}
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public UserAccountDeactivateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAccountDeactivateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param message
	 */
	public UserAccountDeactivateException(String message) {
		super();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "User account deactivated";
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserAccountDeactivateException";
	}

}

