package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.service.DoctorService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	@Operation(summary = "Save Doctor", description = "API to create a new Doctor")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Doctor successfully created") })
	@PostMapping("/saveDoctor")
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}

	@Operation(summary = "Fetch Doctor", description = "API to fetch Doctor by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "Doctor successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Doctor not found") })
	@GetMapping("/fetchDoctorById")
	public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorById(@RequestParam int doctorId) {
		return doctorService.fetchDoctorById(doctorId);
	}
	@Operation(summary = "Delete Doctor by ID", description = "API to delete Doctor by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Doctor successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Doctor not found with given ID")
	})

	@DeleteMapping("/deleteDoctorById")
	public ResponseEntity<ResponseStructure<Doctor>> deleteDoctorById(@RequestParam int doctorId) {
		return doctorService.deleteDoctorById(doctorId);
	}
	@Operation(summary = "Update Doctor by ID", description = "API to update existing Doctor details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Doctor successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Doctor not found with given ID")
	})

	@PutMapping("/updateDoctorById")
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctorById(@RequestParam int oldDoctorId,
			@RequestBody Doctor newDoctor) {
		return doctorService.updateDoctorById(oldDoctorId, newDoctor);
	}
	@Operation(summary = "Fetch All Doctors", description = "API to retrieve all doctors from the database")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "List of doctors fetched successfully"),
	    @ApiResponse(responseCode = "204", description = "No doctors found")
	})

	@GetMapping("/fetchAllDoctor")
	public List<Doctor> fetchAllDoctor() {
		return doctorService.fetchAllDoctor();
	}
	@PutMapping("/addExistingPatientToExistingDoctor")
	public Doctor addExistingPatientToExistingDoctor(@RequestParam int doctorId, @RequestParam int patientId) {
	    return doctorService.addExistingPatientToExistingDoctor(doctorId, patientId);
	}
	@PostMapping("/addNewPatientToExistingDoctor")
	public Doctor addNewPatientToExistingDoctor(
	        @RequestParam int doctorId,
	        @RequestBody Patient newPatient) {
	    return doctorService.addNewPatientToExistingDoctor(doctorId, newPatient);
	}

}
