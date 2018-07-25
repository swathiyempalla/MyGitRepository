package com.restexample.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.restexample.crud.util.ValidationUtil;

@ControllerAdvice
public class ExceptionHandlingController {

	 @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<ExceptionResponse> resourceNotFound(UserNotFoundException ex) {
	        ExceptionResponse response = new ExceptionResponse();
	        response.setResMsg(ex.getMessage());
	        response.setUserid("");
	        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(InvalidDateException.class)
	    public ResponseEntity<ExceptionResponse> invalidInput(InvalidDateException ex) {
	        ExceptionResponse response = new ExceptionResponse();
	        response.setResMsg(ex.getMessage());
	        response.setUserid("");
	        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	    }
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
	        BindingResult result = ex.getBindingResult();
	        ExceptionResponse response = new ExceptionResponse();
	        response.setResMsg("Validation Error");
	        response.setUserid("");
	        response.setErrors(ValidationUtil.fromBindingErrors(result));
	        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	    }
}
