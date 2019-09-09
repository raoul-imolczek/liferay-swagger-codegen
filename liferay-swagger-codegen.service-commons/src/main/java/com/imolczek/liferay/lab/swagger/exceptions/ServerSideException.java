package com.imolczek.liferay.lab.swagger.exceptions;

public class ServerSideException extends Exception {
	
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ServerSideException(int code) {
		super();
		this.code = code;
	}	

}
