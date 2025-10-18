package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.service.PrescriptionService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PrescriptionController {

	@Autowired
	PrescriptionService prescriptionService;

	@Operation(summary = "Save Prescription", description = "API to create a new Prescription")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Prescription successfully created") })
	@PostMapping("/savePrescription")
	
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(@RequestBody Prescription prescription) {
		return prescriptionService.savePrescription(prescription);
	}

	@Operation(summary = "Fetch Prescription", description = "API to fetch Prescription by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "Prescription successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Prescription not found") })
	
	@GetMapping("/fetchPrescriptionById")
	public ResponseEntity<ResponseStructure<Prescription>> fetchPrescriptionById(@RequestParam int prescriptionId) {
		return prescriptionService.fetchPrescriptionById(prescriptionId);
	}
	@Operation(summary = "Delete Prescription by ID", description = "API to delete Prescription by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Prescription successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Prescription not found with given ID")
	})

	@DeleteMapping("/deletePrescriptionById")
	public ResponseEntity<ResponseStructure<Prescription>> deletePrescriptionById(@RequestParam int prescriptionId) {
		return prescriptionService.deletePrescriptionById(prescriptionId);
	}
	@Operation(summary = "Update Prescription by ID", description = "API to update existing Prescription details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Prescription successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Prescription not found with given ID")
	})

	@PutMapping("/updatePrescriptionById")
	public ResponseEntity<ResponseStructure<Prescription>> updatePrescriptionById(@RequestParam int oldPrescriptionId,
			@RequestBody Prescription newPrescription) {
		return prescriptionService.updatePrescriptionById(oldPrescriptionId, newPrescription);
	}
	@Operation(summary = "Fetch All Prescriptions", description = "API to retrieve all prescriptions from the database")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "List of prescriptions fetched successfully"),
	    @ApiResponse(responseCode = "204", description = "No prescriptions found")
	})

	@GetMapping("/fetchAllPrescription")
	public List<Prescription> fetchAllPrescription() {
		return prescriptionService.fetchAllPrescription();
	}
}