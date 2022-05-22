package com.Comp.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	 public ResourceNotFoundException(Long id) {
	        super("Could not found employee with id "+id);
	    }
}

