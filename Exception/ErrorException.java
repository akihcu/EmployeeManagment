package com.Comp.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



public class ErrorException {

	@ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(EmployeeExistedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String employeeExistedHandler(EmployeeExistedException ex) {
        return ex.getMessage();
    }
	 }