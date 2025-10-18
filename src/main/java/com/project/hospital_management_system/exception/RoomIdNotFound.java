package com.project.hospital_management_system.exception;

public class RoomIdNotFound extends RuntimeException {

	private String message = "RoomId not found in the DB";

	public String getMessage() {
		return message;
	}

}


