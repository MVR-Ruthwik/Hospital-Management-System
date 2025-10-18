package com.project.hospital_management_system.exception;

public class BranchIdNotFound extends RuntimeException {

	private String message = "BranchId not found in the DB";

	public String getMessage() {
		return message;
	}

}


