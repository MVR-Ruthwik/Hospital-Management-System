package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.service.PatientService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@Operation(summary = "Save Patient", description = "API to create a new Patient")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Patient successfully created") })
	@PostMapping("/savePatient")
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	@Operation(summary = "Fetch Patient", description = "API to fetch Patient by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "Patient successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Patient not found") })
	@GetMapping("/fetchPatientById")
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(@RequestParam int patientId) {
		return patientService.fetchPatientById(patientId);
	}
	@Operation(summary = "Delete Patient by ID", description = "API to delete Patient by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Patient successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Patient not found with given ID")
	})

	@DeleteMapping("/deletePatientById")
	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(@RequestParam int patientId) {
		return patientService.deletePatientById(patientId);
	}
	@Operation(summary = "Update Patient by ID", description = "API to update existing Patient details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Patient successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Patient not found with given ID")
	})

	@PutMapping("/updatePatientById")
	public ResponseEntity<ResponseStructure<Patient>> updatePatientById(@RequestParam int oldPatientId,
			@RequestBody Patient newPatient) {
		return patientService.updatePatientById(oldPatientId, newPatient);
	}
	@Operation(summary = "Fetch All Patients", description = "API to retrieve all patients from the database")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "List of patients fetched successfully"),
	    @ApiResponse(responseCode = "204", description = "No patients found")
	})

	@GetMapping("/fetchAllPatient")
	public List<Patient> fetchAllPatient() {
		return patientService.fetchAllPatient();
	}
	@PutMapping("/addExistingPaymentToExistingPatient")
	public Patient addExistingPaymentToExistingPatient(@RequestParam int patientId, @RequestParam int paymentId) {
	    return patientService.addExistingPaymentToExistingPatient(patientId, paymentId);
	}
	@PutMapping("/addExistingPrescriptionToExistingPatient")
	public Patient addExistingPrescriptionToExistingPatient(@RequestParam int patientId, @RequestParam int prescriptionId) {
	    return patientService.addExistingPrescriptionToExistingPatient(patientId, prescriptionId);
	}
	@PostMapping("/addNewPrescriptionToExistingPatient")
	public Patient addNewPrescriptionToExistingPatient(
	        @RequestParam int patientId,
	        @RequestBody Prescription newPrescription) {
	    return patientService.addNewPrescriptionToExistingPatient(patientId, newPrescription);
	}


}