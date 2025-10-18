package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.BranchHead;
import com.project.hospital_management_system.service.BranchHeadService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchHeadController {

	@Autowired
	BranchHeadService branchHeadService;

	@Operation(summary = "Save BranchHead", description = "API to create a new BranchHead")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "BranchHead successfully created") })
	@PostMapping("/saveBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(@RequestBody BranchHead branchHead) {
		return branchHeadService.saveBranchHead(branchHead);
	}

	@Operation(summary = "Fetch BranchHead", description = "API to fetch BranchHead by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "BranchHead successfully fetched"),
			@ApiResponse(responseCode = "404", description = "BranchHead not found") })
	@GetMapping("/fetchBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(@RequestParam int branchHeadId) {
		return branchHeadService.fetchBranchHeadById(branchHeadId);
	}
	@Operation(summary = "Delete BranchHead by ID", description = "API to delete BranchHead by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "BranchHead successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "BranchHead not found with given ID")
	})

	@DeleteMapping("/deleteBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(@RequestParam int branchHeadId) {
		return branchHeadService.deleteBranchHeadById(branchHeadId);
	}
	@Operation(summary = "Update BranchHead by ID", description = "API to update existing BranchHead details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "BranchHead successfully updated"),
	    @ApiResponse(responseCode = "404", description = "BranchHead not found with given ID")
	})

	@PutMapping("/updateBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHeadById(@RequestParam int oldBranchHeadId,
			@RequestBody BranchHead newBranchHead) {
		return branchHeadService.updateBranchHeadById(oldBranchHeadId, newBranchHead);
	}
	@Operation(summary = "Fetch All BranchHeads", description = "API to retrieve all branch heads from the database")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "List of branch heads fetched successfully"),
	    @ApiResponse(responseCode = "204", description = "No branch heads found")
	})

	@GetMapping("/fetchAllBranchHead")
	public List<BranchHead> fetchAllBranchHead() {
		return branchHeadService.fetchAllBranchHead();
	}
}