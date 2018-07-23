package com.restexample.crud.exceptions;

public class ExceptionResponse {

	 private String resMsg;
	    private String errorMessage;
	 
	    public ExceptionResponse() {
	    }
	 
	    public String getResMsg() {
			return resMsg;
		}



		public void setResMsg(String resMsg) {
			this.resMsg = resMsg;
		}



		public String getErrorMessage() {
	        return errorMessage;
	    }
	 
	    public void setErrorMessage(String errorMessage) {
	        this.errorMessage = errorMessage;
	    }

}
