package com.durga.cms.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.durga.cms.errors.ApplicationError;
import com.durga.cms.exceptions.CustomerNotFoundException;

@RestController
@ControllerAdvice
public class ExceptionResource  extends ResponseEntityExceptionHandler
{
	     @Value("${url}")
	     private String details;
	     
	     @ExceptionHandler(CustomerNotFoundException.class)
         public ResponseEntity<ApplicationError> handleCustomerNotFoundException(CustomerNotFoundException ex,WebRequest webRequest)
         {
        	    ApplicationError error=new ApplicationError();
        	    error.setCode(404);
        	    error.setMessage(ex.getMessage());
        	    error.setDetails(details);
        	    return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
         }
}
