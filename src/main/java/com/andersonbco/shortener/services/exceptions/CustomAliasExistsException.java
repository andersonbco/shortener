package com.andersonbco.shortener.services.exceptions;

public class CustomAliasExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1696068276907560715L;

	public CustomAliasExistsException(String message) {
		super(message);
	}

	public CustomAliasExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
