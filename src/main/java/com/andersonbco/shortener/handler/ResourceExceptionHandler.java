package com.andersonbco.shortener.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.andersonbco.shortener.domain.ErrorMessage;
import com.andersonbco.shortener.services.exceptions.CustomAliasExistsException;
import com.andersonbco.shortener.services.exceptions.ShortenedUrlNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(CustomAliasExistsException.class)
	public ResponseEntity<ErrorMessage> handleCustomAliasExistsException(CustomAliasExistsException e, HttpServletRequest request) {
		
		ErrorMessage message = new ErrorMessage();
		message.setErr_code("001");
		message.setDescription("CUSTOM ALIAS ALREADY EXISTS");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@ExceptionHandler(ShortenedUrlNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleShortenedUrlNotFoundException(ShortenedUrlNotFoundException e, HttpServletRequest request) {
		
		ErrorMessage message = new ErrorMessage();
		message.setErr_code("002");
		message.setDescription("SHORTENED URL NOT FOUND");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}	
}
