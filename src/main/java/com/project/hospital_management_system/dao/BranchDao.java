package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.BranchHead;
import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;

	@Autowired
	AddressDao addressDao;
	@Autowired
	@Lazy
	AmbulanceDao ambulanceDao;
	@Autowired
	BranchHeadDao branchHeadDao;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	PatientDao patientDao;
	@Autowired
	RoomDao roomDao;

	public Branch saveBranch(Branch branch) {
//		Branch dbBranch = BranchRepo.save(Branch);
//		return dbBranch;
		return branchRepo.save(branch);
	}

	public Branch fetchBranchById(int branchId) {
		Optional<Branch> branch = branchRepo.findById(branchId);
		if (branch.isEmpty()) {
			return null;
		} else {
			return branch.get();
		}
//		if (Branch.isPresent()) {
//			return Branch.get();
//		} else {
//			return null;
//		}
	}

	public Branch deleteBranchById(int branchId) {
		// Branch branch = BranchRepo.findById(BranchId).get();
		Branch branch = fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}

	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		return branchRepo.save(newBranch);
	}

	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}


	public Branch addNewAmbulanceToExistingBranch(int branchId,Ambulance newAmbulance) 
	{
		Branch branch = fetchBranchById(branchId);
		List<Ambulance> list = branch.getAmbulances();
		list.add(newAmbulance);
		branch.setAmbulances(list);
		return saveBranch(branch);
	}
	public Branch addExistingAmbulanceToExistingBranch(int ambulanceId, int branchId) 
	{
		Ambulance ambulance = ambulanceDao.fetchAmbulanceById(ambulanceId);
		Branch branch = fetchBranchById(branchId);
		List<Ambulance> list = branch.getAmbulances();
		list.add(ambulance);
		branch.setAmbulances(list);
		return saveBranch(branch);

    }
	public Branch addExistingAddressToExistingBranch(int addressId, int branchId) {
		Address address = addressDao.fetchAddressById(addressId);
		Branch branch = fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	public Branch addExistingBranchHeadToExistingBranch(int branchHeadId, int branchId) {
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
		Branch branch = fetchBranchById(branchId);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}
	

	public Branch addNewDoctorToExistingBranch(int branchId,Doctor newDoctor) 
	{
		Branch branch = fetchBranchById(branchId);
		List<Doctor> list = branch.getDoctors();
		list.add(newDoctor);
		branch.setDoctors(list);
		return saveBranch(branch);
	}
	public Branch addExistingDoctorToExistingBranch(int doctorId, int branchId) 
	{
	Doctor doctor= doctorDao.fetchDoctorById(doctorId);
		Branch branch = fetchBranchById(branchId);
		List<Doctor> list = branch.getDoctors();
		list.add(doctor);
		branch.setDoctors(list);
		return saveBranch(branch);
	}
		public Branch addNewEmployeeToExistingBranch(int branchId,Employee newEmployee) 
		{
			Branch branch = fetchBranchById(branchId);
			List<Employee> list = branch.getEmployees();
			list.add(newEmployee);
			branch.setEmployees(list);
			return saveBranch(branch);
		}
		public Branch addExistingEmployeeToExistingBranch(int employeeId, int branchId) 
		{
		Employee employee= employeeDao.fetchEmployeeById(employeeId);
			Branch branch = fetchBranchById(branchId);
			List<Employee> list = branch.getEmployees();
			list.add(employee);
			branch.setEmployees(list);
			return saveBranch(branch);

    }
		
		public Branch addNewPatientToExistingBranch(int branchId,Patient newPatient) 
		{
			Branch branch = fetchBranchById(branchId);
			List<Patient> list = branch.getPatients();
			list.add(newPatient);
			branch.setPatients(list);
			return saveBranch(branch);
		}
		
		public Branch addExistingPatientToExistingBranch(int patientId, int branchId) 
		{
		Patient patient= patientDao.fetchPatientById(patientId);
			Branch branch = fetchBranchById(branchId);
			List<Patient> list = branch.getPatients();
			list.add(patient);
			branch.setPatients(list);
			return saveBranch(branch);

    }
		public Branch addNewRoomToExistingBranch(int branchId,Room newRoom) 
		{
			Branch branch = fetchBranchById(branchId);
			List<Room> list = branch.getRooms();
			list.add(newRoom);
			branch.setRooms(list);
			return saveBranch(branch);
		}
		
		public Branch addExistingRoomToExistingBranch(int roomId, int branchId) 
		{
		Room room=roomDao.fetchRoomById(roomId);
			Branch branch = fetchBranchById(branchId);
			List<Room> list = branch.getRooms();
			list.add(room);
			branch.setRooms(list);
			return saveBranch(branch);

    }
		
	}


