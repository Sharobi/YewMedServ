/**
 * 
 */
package com.sharobi.pharmacy.exceptions;

/**
 * @author habib
 *
 */
public class DuplicateRecordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateRecordException() {
		// TODO Auto-generated constructor stub
		super();
	}

	public DuplicateRecordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateRecordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateRecordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "DuplicateEntry";
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "RecorAlreadyExist";
	}

}
