//package online.gladikov.home.climate_service_online.controller;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.ErrorResponse;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import online.gladikov.home.common.exception.*;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import jakarta.validation.ConstraintViolationException;
//
//@ControllerAdvice
//public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
//		
////		@Override
////		protected ResponseEntity<Object> handleMethodArgumentNotValid(
////				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
////					Map<String, String> body = new HashMap<>();
////					ex.getBindingResult().getAllErrors().forEach((error) -> {
////						String fieldName = ((FieldError) error).getField();
////						String errorMessage = error.getDefaultMessage();
////						body.put(fieldName, errorMessage);
////					});
////					
////			return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
////		}
//		
//		
//		@ExceptionHandler(ConstraintViolationException.class)
//		public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,HttpHeaders headers,HttpStatusCode status) {
//			Map<String, Object> body = new LinkedHashMap<>();
//		    body.put("timestamp", LocalDateTime.now());
//		    body.put("message", ex.getConstraintViolations().stream().limit(1).peek(x->x.getPropertyPath()).toList());
//		    
//		    return new ResponseEntity<>(body.toString(), HttpStatus.BAD_REQUEST);
//		}
////		(?<=messageTemplate=')(.*)(?=')
//		// ********* NOT FOUND ************ \\
//		@ExceptionHandler(ResourceNotFoundException.class)
//		public ResponseEntity<Object> handleResourceNotFoundException( ResourceNotFoundException ex, WebRequest request) {
//			Map<String, Object> body = new LinkedHashMap<>();
//			body.put("timestamp", LocalDateTime.now());
//			body.put("message", ex.getCause());
//			return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//		}
//		// ********* NOT AVAILABLE ************ \\
//		@ExceptionHandler(ResourceNotAvailableException.class)
//		public ResponseEntity<Object> handleResourceNotAvailableException( ResourceNotAvailableException ex, WebRequest request) {
//		    Map<String, Object> body = new LinkedHashMap<>();
//		    body.put("timestamp", LocalDateTime.now());
//		    body.put("message", ex.getCause());
//		    return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
//		}
//		
//		@Override
//		protected ResponseEntity<Object> handleMethodArgumentNotValid(
//				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//			ErrorResponse body=ErrorResponse.builder(ex, status, PAGE_NOT_FOUND_LOG_CATEGORY).build();
//			return new ResponseEntity<>(body, headers, status);
//		}
//
//}
