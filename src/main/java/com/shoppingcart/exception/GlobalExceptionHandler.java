package com.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleException(Exception ex) {

		ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleCartIsEmptyException(CartIsEmptyException ex){
		ErrorMessage  message=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleProductNotInStockException(ProductNotInStockException ex){
		ErrorMessage  message=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleProductNotExistsException(ProductNotExistsException ex){
		ErrorMessage  message=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleUserNotExistsException(UserNotExistsException ex){
		ErrorMessage  message=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
}
