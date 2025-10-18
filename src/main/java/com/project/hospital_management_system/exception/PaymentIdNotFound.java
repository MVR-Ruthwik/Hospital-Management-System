package com.project.hospital_management_system.exception;

public class PaymentIdNotFound extends RuntimeException {

	private String message = "PaymentId not found in the DB";

	public String getMessage() {
		return message;
	}

}


