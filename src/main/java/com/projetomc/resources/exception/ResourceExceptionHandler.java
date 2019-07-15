package com.projetomc.resources.exception;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetomc.services.exceptions.ObejctNotFoundException2;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObejctNotFoundException2.class)
	public ResponseEntity<StandardError> objectNotFoud(ObejctNotFoundException2 e, HttpServlet request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}


}
