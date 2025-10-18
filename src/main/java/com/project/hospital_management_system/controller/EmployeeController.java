package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.service.EmployeeService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Operation(summary = "Save Employee", description = "API to create a new Employee")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Employee successfully created") })
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@Operation(summary = "Fetch Employee", description = "API to fetch Employee by ID")
	@ApiResponses({ @ApiResponse(responseCode = "302", description = "Employee successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Employee not found") })
	@GetMapping("/fetchEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}
	@Operation(summary = "Delete Employee by ID", description = "API to delete Employee by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Employee successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Employee not found with given ID")
	})

	@DeleteMapping("/deleteEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@RequestParam int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}
	@Operation(summary = "Update Employee by ID", description = "API to update existing Employee details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Employee successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Employee not found with given ID")
	})

	@PutMapping("/updateEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(@RequestParam int oldEmployeeId,
			@RequestBody Employee newEmployee) {
		return employeeService.updateEmployeeById(oldEmployeeId, newEmployee);
	}
	@Operation(summary = "Fetch All Employees", description = "API to retrieve all employees from the database")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "List of employees fetched successfully"),
	    @ApiResponse(responseCode = "204", description = "No employees found")
	})

	@GetMapping("/fetchAllEmployee")
	public List<Employee> fetchAllEmployee() {
		return employeeService.fetchAllEmployee();
	}
}
