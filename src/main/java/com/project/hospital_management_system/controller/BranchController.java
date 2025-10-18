package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.service.BranchService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@Operation(summary = "Save Branch", description = "API to create a new Branch")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Branch successfully created") })
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@Operation(summary = "Fetch Branch", description = "API to fetch Branch by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "Branch successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Branch not found") })
	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}
	@Operation(summary = "Delete Branch by ID", description = "API to delete Branch by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branch successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Branch not found with given ID")
	})

	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}
	@Operation(summary = "Update Branch by ID", description = "API to update existing Branch details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branch successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Branch not found with given ID")
	})

	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int oldBranchId,
			@RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}
	@Operation(summary = "Fetch All Branches", description = "API to retrieve all branches from the database")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "List of branches fetched successfully"),
	    @ApiResponse(responseCode = "204", description = "No branches found")
	})

	@GetMapping("/fetchAllBranch")
	public List<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}
	@PutMapping("/addExistingBranchHeadToExistingBranch")
	public Branch addExistingBranchHeadToExistingBranch(@RequestParam int branchId, @RequestParam int branchHeadId) {
	    return branchService.addExistingBranchHeadToExistingBranch(branchId, branchHeadId);
	}
	@PutMapping("/addExistingAddressToExistingBranch")
	public Branch addExistingAddressToExistingBranch(@RequestParam int branchId, @RequestParam int addressId) {
	    return branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}
	

	@PutMapping("/addExistingAmbulanceToExistingBranch")
	public Branch addExistingAmbulanceToExistingBranch(@RequestParam int branchId, @RequestParam int ambulanceId) {
	    return branchService.addExistingAmbulanceToExistingBranch(branchId, ambulanceId);
	}
	@PostMapping("/addNewAmbulanceToExistingBranch")
	public Branch addNewAmbulanceToExistingBranch(
	        @RequestParam int branchId,
	        @RequestBody Ambulance newAmbulance) {
	    return branchService.addNewAmbulanceToExistingBranch(branchId, newAmbulance);
	}

	@PutMapping("/addExistingEmployeeToExistingBranch")
	public Branch addExistingEmployeeToExistingBranch(@RequestParam int branchId, @RequestParam int employeeId) {
	    return branchService.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}
	@PostMapping("/addNewEmployeeToExistingBranch")
	public Branch addNewEmployeeToExistingBranch(
	        @RequestParam int branchId,
	        @RequestBody Employee newEmployee) {
	    return branchService.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}

	@PutMapping("/addExistingRoomToExistingBranch")
	public Branch addExistingRoomToExistingBranch(@RequestParam int branchId, @RequestParam int roomId) {
	    return branchService.addExistingRoomToExistingBranch(branchId, roomId);
	}
	@PutMapping("/addExistingPatientToExistingBranch")
	public Branch addExistingPatientToExistingBranch(@RequestParam int branchId, @RequestParam int patientId) {
	    return branchService.addExistingPatientToExistingBranch(branchId, patientId);
	}
	@PostMapping("/addNewPatientToExistingBranch")
	public Branch addNewPatientToExistingBranch(
	        @RequestParam int branchId,
	        @RequestBody Patient newPatient) {
	    return branchService.addNewPatientToExistingBranch(branchId, newPatient);
	}

	@PostMapping("/addNewRoomToExistingBranch")
	public Branch addNewRoomToExistingBranch(
	        @RequestParam int branchId,
	        @RequestBody Room newRoom) {
	    return branchService.addNewRoomToExistingBranch(branchId, newRoom);
	}

	@PutMapping("/addExistingDoctorToExistingBranch")
	public Branch addExistingDoctorToExistingBranch(@RequestParam int branchId, @RequestParam int doctorId) {
	    return branchService.addExistingDoctorToExistingBranch(branchId, doctorId);
	}
	@PostMapping("/addNewDoctorToExistingBranch")
	public Branch addNewDoctorToExistingBranch(
	        @RequestParam int branchId,
	        @RequestBody Doctor newDoctor) {
	    return branchService.addNewDoctorToExistingBranch(branchId, newDoctor);
	}


}
