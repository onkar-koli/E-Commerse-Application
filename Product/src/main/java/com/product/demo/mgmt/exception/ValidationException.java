package com.product.demo.mgmt.exception;

public class ValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1l;
	private Long errorCode;
	private String message;
	
	public ValidationException(Long errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Long getErrorCode() {
		return errorCode;
	}

}
