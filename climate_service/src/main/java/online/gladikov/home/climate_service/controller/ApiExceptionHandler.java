package online.gladikov.home.climate_service.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;
import online.gladikov.home.common.exception.ResourceNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
		
//		@Override
//		protected ResponseEntity<Object> handleMethodArgumentNotValid(
//				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//					Map<String, String> body = new HashMap<>();
//					ex.getBindingResult().getAllErrors().forEach((error) -> {
//						String fieldName = ((FieldError) error).getField();
//						String errorMessage = error.getDefaultMessage();
//						body.put(fieldName, errorMessage);
//					});
//					
//			return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//		}
		
		
		@ExceptionHandler(ConstraintViolationException.class)
		public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,HttpHeaders headers,HttpStatusCode status) {
			Map<String, Object> body = new LinkedHashMap<>();
		    body.put("timestamp", LocalDateTime.now());
		    body.put("message", ex.getConstraintViolations().stream().limit(1).peek(x->x.getPropertyPath()).toList());
		    
		    return new ResponseEntity<>(body.toString(), HttpStatus.BAD_REQUEST);
		}
//		(?<=messageTemplate=')(.*)(?=')
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<Object> handleResourceNotFoundException( ResourceNotFoundException ex, WebRequest request) {

		    Map<String, Object> body = new LinkedHashMap<>();
		    body.put("timestamp", LocalDateTime.now());
		    body.put("message", "Resource not found");

		    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
		}
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
			ErrorResponse body=ErrorResponse.builder(ex, status, PAGE_NOT_FOUND_LOG_CATEGORY).build();
			return new ResponseEntity<>(body, headers, status);
		}

}
