package com.proyectodam.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.proyectodam.ProyectodamApplication;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(ProyectodamApplication.class);
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception e){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"Ocurrio un error",e.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		//Para mostrar mensajes de error en funcion del nivel----------------------------
		logger.trace("Este es un mensaje de rastreo");
		logger.debug("Este es un mensaje de depuracion");
		logger.info("Este es un mensaje de informacion");
		logger.warn("Este es un mensaje de advertencia");
		logger.error("Este es un mensaje de error");
		//----------------------------------------------------------------------------------------
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {			
			String fieldName= ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);			
		});
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"Ocurrio un error",ex.getMessage(),errors);
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);	
	}
	
}
