package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.EmployeeDao;
import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.exception.EmployeeIdNotFound;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	ResponseStructure<Employee> responseStructure;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Employee created in DB");
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Employee fetched from DB");
			responseStructure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Employee deleted from DB");
			responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		Employee employee = employeeDao.fetchEmployeeById(oldEmployeeId);
		if (employee != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Employee updated in DB");
			responseStructure.setData(employeeDao.updateEmployeeById(oldEmployeeId, newEmployee));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public List<Employee> fetchAllEmployee() {
		return employeeDao.fetchAllEmployee();
	}
}
