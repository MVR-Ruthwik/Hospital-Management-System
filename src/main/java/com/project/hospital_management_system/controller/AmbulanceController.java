package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.service.AmbulanceService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AmbulanceController {

	@Autowired
	AmbulanceService ambulanceService;

	@Operation(summary = "Save Ambulance", description = "API to create a new Ambulance")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Ambulance successfully created") })
	@PostMapping("/saveAmbulance")
	public ResponseEntity<ResponseStructure<Ambulance>> saveAmbulance(@RequestBody Ambulance ambulance) {
		return ambulanceService.saveAmbulance(ambulance);
	}

	@Operation(summary = "Fetch Ambulance", description = "API to fetch Ambulance by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "Ambulance successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Ambulance not found") })
	@GetMapping("/fetchAmbulanceById")
	public ResponseEntity<ResponseStructure<Ambulance>> fetchAmbulanceById(@RequestParam int ambulanceId) {
		return ambulanceService.fetchAmbulanceById(ambulanceId);
	}
	@Operation(summary = "Delete Ambulance by ID", description = "API to delete Ambulance by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Ambulance successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Ambulance not found with given ID")
	})

	@DeleteMapping("/deleteAmbulanceById")
	public ResponseEntity<ResponseStructure<Ambulance>> deleteAmbulanceById(@RequestParam int ambulanceId) {
		return ambulanceService.deleteAmbulanceById(ambulanceId);
	}
	@Operation(summary = "Update Ambulance by ID", description = "API to update existing Ambulance details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Ambulance successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Ambulance not found with given ID")
	})

	@PutMapping("/updateAmbulanceById")
	public ResponseEntity<ResponseStructure<Ambulance>> updateAmbulanceById(@RequestParam int oldAmbulanceId,
			@RequestBody Ambulance newAmbulance) {
		return ambulanceService.updateAmbulanceById(oldAmbulanceId, newAmbulance);
	}
	@Operation(summary = "Fetch All Ambulances", description = "API to retrieve all ambulances from the database")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "List of ambulances fetched successfully"),
	    @ApiResponse(responseCode = "204", description = "No ambulances found")
	})

	@GetMapping("/fetchAllAmbulance")
	public List<Ambulance> fetchAllAmbulance() {
		return ambulanceService.fetchAllAmbulance();
	}
}
