package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.PatientDao;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.exception.PatientIdNotFound;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class PatientService {

	@Autowired
	PatientDao patientDao;

	@Autowired
	ResponseStructure<Patient> responseStructure;

	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Patient created in DB");
		responseStructure.setData(patientDao.savePatient(patient));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(int patientId) {
		Patient patient = patientDao.fetchPatientById(patientId);
		if (patient != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Patient fetched from DB");
			responseStructure.setData(patient);
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new PatientIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(int patientId) {
		Patient patient = patientDao.fetchPatientById(patientId);
		if (patient != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Patient deleted from DB");
			responseStructure.setData(patientDao.deletePatientById(patientId));
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PatientIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Patient>> updatePatientById(int oldPatientId, Patient newPatient) {
		Patient patient = patientDao.fetchPatientById(oldPatientId);
		if (patient != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Patient updated in DB");
			responseStructure.setData(patientDao.updatePatientById(oldPatientId, newPatient));
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PatientIdNotFound();
		}
	}

	public List<Patient> fetchAllPatient() {
		return patientDao.fetchAllPatient();
	}
	public Patient addExistingPaymentToExistingPatient(int patientId, int paymentId) {
	    return patientDao.addExistingPaymentToExistingPatient(patientId, paymentId);
	}
	public Patient addExistingPrescriptionToExistingPatient(int patientId, int prescriptionId) {
	    return patientDao.addExistingPrescriptionToExistingPatient(patientId, prescriptionId);
	}
	public Patient addNewPrescriptionToExistingPatient(int patientId, Prescription newPrescription) {
	    return patientDao.addNewPrescriptionToExistingPatient(patientId, newPrescription);
	}


}