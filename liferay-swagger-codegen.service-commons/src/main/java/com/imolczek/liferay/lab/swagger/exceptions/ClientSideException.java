package com.imolczek.liferay.lab.swagger.exceptions;

public class ClientSideException extends Exception {

	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ClientSideException(int code) {
		super();
		this.code = code;
	}	
	
}
