package com.rajesh.banking.exception;

import java.net.ResponseCache;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	//Handle specific Exception- AccountException
	
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<ErrorDetails> handleAccountException(AccountException exception,
			WebRequest request){
		
		ErrorDetails details=new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				request.getDescription(false),
				"Account_NOT_FOUND");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	
	//Handle Generic Exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> genericExceptionHandler(Exception exception, WebRequest webRequest){
		ErrorDetails details=new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"INTERNAL_SERVERE_ERROR");
		
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
}











