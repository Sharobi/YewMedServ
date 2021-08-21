/**
 * 
 */
package com.sharobi.pharmacy.exceptions;

/**
 * @author habib
 *
 */
public class UserAccountExpiredException extends Exception {

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public UserAccountExpiredException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param cause
	 */
	public UserAccountExpiredException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 */
	public UserAccountExpiredException(String message) {
		super(message);
	}

	public UserAccountExpiredException() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "User account expired";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserAccountExpiredException";
	}

}
