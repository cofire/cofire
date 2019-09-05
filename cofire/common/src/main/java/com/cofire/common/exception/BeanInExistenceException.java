/**
 * 
 */
package com.cofire.common.exception;

/**
 * @author chl_seu
 *
 */
public class BeanInExistenceException extends RuntimeException {

	private static final long serialVersionUID = 1494457943889981148L;

	/**
	 * 
	 */
	public BeanInExistenceException() {
		super("The Bean is InExistence");
	}

	/**
	 * @param message
	 */
	public BeanInExistenceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BeanInExistenceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BeanInExistenceException(String message, Throwable cause) {
		super(message, cause);
	}

}
