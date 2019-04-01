package com.fsd.web.springbootwebdemo.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fsd.web.springbootwebdemo.error.ErrorResponse;
import com.fsd.web.springbootwebdemo.model.Book;

@ControllerAdvice
public class BookStoreExceptionhandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<ErrorResponse> handleConflict(Exception ex , WebRequest request){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponse.setDescription("Data not available for the given book id");
		errorResponse.setEcxeption(ex.getMessage());
		errorResponse.setStatusCode(500);
		
		return ResponseEntity.ok(errorResponse);
		
	}

}
