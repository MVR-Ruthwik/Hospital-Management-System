package com.project.hospital_management_system.exception;

public class BranchHeadIdNotFound extends RuntimeException {

	private String message = "BranchHeadId not found in the DB";

	public String getMessage() {
		return message;
	}

}


