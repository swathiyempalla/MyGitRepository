package com.restexample.crud.exceptions;

public class UserInputValidationException extends RuntimeException {
		
		private static final long serialVersionUID = 1L;
		 
	    public UserInputValidationException(String message) {
	        super(message);
	    }
}
