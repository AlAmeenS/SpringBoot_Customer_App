package com.shopping.shoppingCart.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shopping.shoppingCart.exception.ApplicationError;
import com.shopping.shoppingCart.exception.CustomerNotFound;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler{
	@Value("${api_ulr}")
	private String details;
	@Autowired
	private ApplicationError applicationError;
	
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<ApplicationError> handleCustomerNotfoundExeption(CustomerNotFound customerNotFound, WebRequest request){
		
		applicationError.setCode(101);
		applicationError.setMessage(customerNotFound.getMessage());
		applicationError.setDetails(details);
		return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
	}
	

}
