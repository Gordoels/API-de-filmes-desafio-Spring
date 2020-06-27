package com.api.filmes.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApifilmesResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		String messageForUser = messageSource.getMessage("invalid.message", null, LocaleContextHolder.getLocale());
		String messageForDeveloper = ex.getCause().toString();
		
		List<Error> errors = Arrays.asList(new Error(messageForUser, messageForDeveloper));
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error> errors = createErrorList(ex.getBindingResult());
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Error> createErrorList(BindingResult bindingResult){
		List<Error> errors = new ArrayList<>();
		
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			String messageForUser = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String messageForDeveloper = fieldError.toString();
			errors.add(new Error(messageForUser, messageForDeveloper));
		}
		return errors;
	}
	
	public static class Error{
		
		private String messageForUser;
		private String messageForDeveloper;
		
		
		public Error(String messageForUser, String messageForDeveloper) {
			super();
			this.messageForUser = messageForUser;
			this.messageForDeveloper = messageForDeveloper;
		}
		
		
		public String getMessageForUser() {
			return messageForUser;
		}
		public String getMessageForDeveloper() {
			return messageForDeveloper;
		}
		
		
	}
}
