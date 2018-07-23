package com.restexample.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

	 @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<ExceptionResponse> resourceNotFound(UserNotFoundException ex) {
	        ExceptionResponse response = new ExceptionResponse();
	        response.setResMsg("Not found");
	        response.setErrorMessage(ex.getMessage());
	        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(UserInputValidationException.class)
	    public ResponseEntity<ExceptionResponse> invalidInput(UserInputValidationException ex) {
	        ExceptionResponse response = new ExceptionResponse();
	        response.setResMsg("Validation Error");
	        response.setErrorMessage(ex.getMessage());
	        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	    }
}
