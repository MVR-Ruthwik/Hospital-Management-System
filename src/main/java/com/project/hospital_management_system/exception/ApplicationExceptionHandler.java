
package com.project.hospital_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.hospital_management_system.util.ResponseStructure;

//@RestControllerAdvice is a class level annotation 
//which acts like a global exception handler in our project

//All the exceptions will come to this class

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	ResponseStructure<String> responseStructure;

	@ExceptionHandler(OwnerIdNotFound.class)
	// @ExceptionHandler acts like a local exception handler or it will handle specific exception
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found in  the db");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	

}
