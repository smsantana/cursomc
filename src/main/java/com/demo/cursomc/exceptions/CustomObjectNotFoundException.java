package com.demo.cursomc.exceptions;

public class CustomObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CustomObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public CustomObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
