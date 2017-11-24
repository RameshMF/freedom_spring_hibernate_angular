package com.mjwcorp.geddswebviewer.application.getarm;

public class DBException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructs a DBException using the given exception message.
	 *
	 * @param message The message explaining the reason for the exception
	 */
	public DBException(String message) {
		super( message );
	}

	/**
	 * Constructs a DBException using the given message and underlying cause.
	 *
	 * @param cause The underlying cause.
	 */
	public DBException(Throwable cause) {
		super( cause );
	}

	/**
	 * Constructs a DBException using the given message and underlying cause.
	 *
	 * @param message The message explaining the reason for the exception.
	 * @param cause The underlying cause.
	 */
	public DBException(String message, Throwable cause) {
		super( message, cause );
	}
}
