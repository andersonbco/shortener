package com.andersonbco.shortener.services.exceptions;

public class ShortenedUrlNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4394790283007818284L;

	public ShortenedUrlNotFoundException(String message) {
		super(message);
	}

	public ShortenedUrlNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
