	package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.BranchDao;
import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.exception.BranchIdNotFound;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Branch> responseStructure;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Branch created in DB");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Branch fetched from DB");
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Branch deleted from DB");
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Branch updated in DB");
			responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public List<Branch> fetchAllBranch() {
		return branchDao.fetchAllBranch();
	}
	public Branch addExistingBranchHeadToExistingBranch(int branchId, int branchHeadId) {
	    return branchDao.addExistingBranchHeadToExistingBranch(branchId, branchHeadId);
	}
	public Branch addExistingAddressToExistingBranch(int branchId, int addressId) {
	    return branchDao.addExistingAddressToExistingBranch(branchId, addressId);
	}
	public Branch addExistingAmbulanceToExistingBranch(int branchId, int ambulanceId) {
	    return branchDao.addExistingAmbulanceToExistingBranch(branchId, ambulanceId);
	}
	public Branch addNewAmbulanceToExistingBranch(int branchId, Ambulance newAmbulance) {
	    return branchDao.addNewAmbulanceToExistingBranch(branchId, newAmbulance);
	}

	public Branch addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
	    return branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}
	public Branch addNewEmployeeToExistingBranch(int branchId, Employee newEmployee) {
	    return branchDao.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}

	public Branch addExistingRoomToExistingBranch(int branchId, int roomId) {
	    return branchDao.addExistingRoomToExistingBranch(branchId, roomId);
	}
	public Branch addNewRoomToExistingBranch(int branchId, Room newRoom) {
	    return branchDao.addNewRoomToExistingBranch(branchId, newRoom);
	}

	public Branch addExistingPatientToExistingBranch(int branchId, int patientId) {
	    return branchDao.addExistingPatientToExistingBranch(branchId, patientId);
	}
	public Branch addNewPatientToExistingBranch(int branchId, Patient newPatient) {
	    return branchDao.addNewPatientToExistingBranch(branchId, newPatient);
	}

	public Branch addExistingDoctorToExistingBranch(int branchId, int doctorId) {
	    return branchDao.addExistingDoctorToExistingBranch(branchId, doctorId);
	}
	public Branch addNewDoctorToExistingBranch(int branchId, Doctor newDoctor) {
	    return branchDao.addNewDoctorToExistingBranch(branchId, newDoctor);
	}


	
}