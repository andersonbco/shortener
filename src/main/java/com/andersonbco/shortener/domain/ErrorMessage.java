package com.andersonbco.shortener.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage {

	@JsonProperty(value = "err_code")
	private String errCode;
	
	private String description;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
