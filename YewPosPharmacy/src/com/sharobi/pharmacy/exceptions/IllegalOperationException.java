/**
 * 
 */
package com.sharobi.pharmacy.exceptions;

/**
 * @author habib
 *
 */
public class IllegalOperationException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalOperationException() {
		// TODO Auto-generated constructor stub
	}

	public IllegalOperationException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public IllegalOperationException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public IllegalOperationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "IllegalOperationException";
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "IllegalOperationException";
	}
}
