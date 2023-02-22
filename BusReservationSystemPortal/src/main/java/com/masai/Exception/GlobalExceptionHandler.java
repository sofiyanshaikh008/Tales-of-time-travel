package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.masai.Entity.MyErrorDetail;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(NoHandlerFoundException.class)
	   public ResponseEntity<MyErrorDetail>  NoHandlerFound(NoHandlerFoundException ex,WebRequest wr) {

		   MyErrorDetail myErr = new MyErrorDetail();
		   myErr.setTimeStamp(LocalDateTime.now());
		   myErr.setMessage(ex.getMessage());
		   myErr.setDetails(wr.getDescription(false));

		   return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
	   }


	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<MyErrorDetail>  NotValidArgs(MethodArgumentNotValidException ex) {

		   MyErrorDetail myErr = new MyErrorDetail();
		   myErr.setTimeStamp(LocalDateTime.now());
		   myErr.setMessage(ex.getMessage());
		   myErr.setDetails(ex.getBindingResult().getFieldError().getDefaultMessage());

		   return new ResponseEntity<>(myErr ,HttpStatus.BAD_REQUEST);
	   }
}
