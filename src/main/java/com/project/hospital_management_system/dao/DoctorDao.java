package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.repo.DoctorRepo;
@Repository
public class DoctorDao {
	@Autowired
	DoctorRepo doctorRepo;
	@Autowired
	PatientDao patientDao;

	
	public Doctor saveDoctor(Doctor doctor) {
//		Doctor dbDoctor = DoctorRepo.save(doctor);
//		return dbDoctor;
		return doctorRepo.save(doctor);
	}

	public Doctor fetchDoctorById(int doctorId) {
		Optional<Doctor> doctor = doctorRepo.findById(doctorId);
		if (doctor.isEmpty()) {
			return null;
		} else {
			return doctor.get();
		}
//		if (doctor.isPresent()) {
//			return doctor.get();
//		} else {
//			return null;
//		}
	}

	public Doctor deleteDoctorById(int doctorId) {
		// Doctor doctor = DoctorRepo.findById(doctorId).get();
		Doctor doctor = fetchDoctorById(doctorId);
		doctorRepo.delete(doctor);
		return doctor;
	}

	public Doctor updateDoctorById(int oldDoctorId, Doctor newDoctor) {
		newDoctor.setDoctorId(oldDoctorId);
		return doctorRepo.save(newDoctor);
	}

	public List<Doctor> fetchAllDoctor() {
		return doctorRepo.findAll();
	}

	public Doctor addNewPatientToExistingDoctor(int doctorId,Patient newPatient) 
	{
		Doctor doctor = fetchDoctorById(doctorId);
		List<Patient> list = doctor.getPatients();
		list.add(newPatient);
		doctor.setPatients(list);
		return saveDoctor(doctor);
	}
	
	public Doctor addExistingPatientToExistingDoctor(int patientId, int doctorId ) 
	{
	Patient patient=patientDao.fetchPatientById(patientId);
		Doctor doctor= fetchDoctorById(patientId);
		List<Patient> list = doctor.getPatients();
		list.add(patient);
		doctor.setPatients(list);
		return saveDoctor(doctor);

}

}
