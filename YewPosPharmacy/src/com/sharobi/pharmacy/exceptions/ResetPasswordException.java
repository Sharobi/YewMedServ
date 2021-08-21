/**
 * 
 */
package com.sharobi.pharmacy.exceptions;

/**
 * @author habib
 *
 */
public class ResetPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ResetPasswordException() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param message
	 */
	public ResetPasswordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ResetPasswordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ResetPasswordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Reset The password";
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ResetPasswordException";
	}

}
