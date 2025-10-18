package com.project.hospital_management_system.exception;

public class AmbulanceIdNotFound extends RuntimeException {

	private String message = "AmbulanceId not found in the DB";

	public String getMessage() {
		return message;
	}

}


