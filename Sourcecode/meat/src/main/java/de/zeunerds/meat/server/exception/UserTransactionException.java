package de.zeunerds.meat.server.exception;

public class UserTransactionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9177666301200102232L;

	public UserTransactionException(String message) {
		super(message);
	}
	
	public UserTransactionException(Throwable cause) {
		super(cause);
	}
}
