package com.Comp.Exception;

public class EmployeeExistedException extends RuntimeException {

		public EmployeeExistedException() {
	        super("Employee already existed in database");
	}

	}
