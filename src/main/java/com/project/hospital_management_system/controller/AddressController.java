package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.service.AddressService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	@Operation(summary = "Save Address", description = "API to create a new Address")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Address successfully created") })
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@Operation(summary = "Fetch Address", description = "API to fetch Address by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "Address successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Address not found") })
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}

	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}

	@PutMapping("/updateAddressById")
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(@RequestParam int oldAddressId,
			@RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}

	@GetMapping("/fetchAllAddress")
	public List<Address> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}
}