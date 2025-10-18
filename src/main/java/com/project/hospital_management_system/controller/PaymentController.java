package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.Payment;
import com.project.hospital_management_system.service.PaymentService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Operation(summary = "Save Payment", description = "API to create a new Payment")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Payment successfully created") })
	@PostMapping("/savePayment")
	public ResponseEntity<ResponseStructure<Payment>> savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}

	@Operation(summary = "Fetch Payment", description = "API to fetch Payment by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "Payment successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Payment not found") })
	@GetMapping("/fetchPaymentById")
	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(@RequestParam int paymentId) {
		return paymentService.fetchPaymentById(paymentId);
	}
	@Operation(summary = "Delete Payment by ID", description = "API to delete Payment by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Payment successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Payment not found with given ID")
	})

	@DeleteMapping("/deletePaymentById")
	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(@RequestParam int paymentId) {
		return paymentService.deletePaymentById(paymentId);
	}
	@Operation(summary = "Update Payment by ID", description = "API to update existing Payment details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Payment successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Payment not found with given ID")
	})

	@PutMapping("/updatePaymentById")
	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(@RequestParam int oldPaymentId,
			@RequestBody Payment newPayment) {
		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}
	@Operation(summary = "Fetch All Payments", description = "API to retrieve all payments from the database")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "List of payments fetched successfully"),
	    @ApiResponse(responseCode = "204", description = "No payments found")
	})

	@GetMapping("/fetchAllPayment")
	public List<Payment> fetchAllPayment() {
		return paymentService.fetchAllPayment();
	}
}
