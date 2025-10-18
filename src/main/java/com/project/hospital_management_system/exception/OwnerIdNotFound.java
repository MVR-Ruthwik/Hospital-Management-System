package com.project.hospital_management_system.exception;

public class OwnerIdNotFound extends RuntimeException {

	private String message = "OwnerId not found in the DB";

	public String getMessage() {
		return message;
	}

}
