/**
 * 
 */
package com.sharobi.pharmacy.exceptions;

/**
 * @author habib
 *
 */
public class NoSuchResultException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchResultException() {
		// TODO Auto-generated constructor stub
	}

	public NoSuchResultException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NoSuchResultException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NoSuchResultException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "NoSuchResultException";
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NoSuchResultException";
	}
}
