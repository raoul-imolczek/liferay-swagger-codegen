package com.imolczek.liferay.lab.swagger.exceptions;

public class CommunicationException extends Exception {

	private String exception;

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public CommunicationException(String exception) {
		super();
		this.exception = exception;
	}
	
}
