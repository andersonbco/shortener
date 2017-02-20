package com.andersonbco.shortener.domain;

public class ErrorMessage {

	private String err_code;
	
	private String description;

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
