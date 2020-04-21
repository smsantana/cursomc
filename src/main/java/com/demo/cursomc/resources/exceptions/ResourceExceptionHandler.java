package com.demo.cursomc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.cursomc.services.exceptions.CustomObjectNotFoundException;
import com.demo.cursomc.services.exceptions.DataIntegrityExcpetion;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(CustomObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectnotFound(CustomObjectNotFoundException e, HttpServletRequest request){
		StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
				
	}
	
	@ExceptionHandler(DataIntegrityExcpetion.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityExcpetion e, HttpServletRequest request){
		StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
				
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validacao", System.currentTimeMillis());
		
		for(FieldError it : e.getBindingResult().getFieldErrors()) {
			err.setError(it.getField(), it.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
				
	}
	
	
	
}
