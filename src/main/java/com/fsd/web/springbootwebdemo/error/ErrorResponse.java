package com.fsd.web.springbootwebdemo.error;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private int statusCode;
	private HttpStatus errorMessage;
	private String ecxeption;
	private String description;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public HttpStatus getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(HttpStatus errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getEcxeption() {
		return ecxeption;
	}
	public void setEcxeption(String ecxeption) {
		this.ecxeption = ecxeption;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
