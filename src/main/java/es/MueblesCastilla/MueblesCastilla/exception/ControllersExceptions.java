package es.MueblesCastilla.MueblesCastilla.exception;





import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllersExceptions {


    @ExceptionHandler( EmailValidationException.class)   
    public ResponseEntity<Map<String, String>> emailException (EmailValidationException emailValidationException){
    	return ResponseEntity.status(HttpStatus.CONFLICT)
    			.body(Collections.singletonMap("Error",emailValidationException.getMessage()));
    }
}
