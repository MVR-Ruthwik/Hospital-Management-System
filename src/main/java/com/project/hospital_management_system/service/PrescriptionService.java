package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.PrescriptionDao;
import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.exception.PrescriptionIdNotFound;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class PrescriptionService {

	@Autowired
	PrescriptionDao prescriptionDao;

	@Autowired
	ResponseStructure<Prescription> responseStructure;

	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(Prescription prescription) {
		System.out.println("Received in service: " + prescription.getPrescriptionName() + ", " + prescription.getPrescriptionDate());


		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Prescription created in DB");
		responseStructure.setData(prescriptionDao.savePrescription(prescription));
		return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Prescription>> fetchPrescriptionById(int prescriptionId) {
		Prescription prescription = prescriptionDao.fetchPrescriptionById(prescriptionId);
		if (prescription != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Prescription fetched from DB");
			responseStructure.setData(prescription);
			return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new PrescriptionIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Prescription>> deletePrescriptionById(int prescriptionId) {
		Prescription prescription = prescriptionDao.fetchPrescriptionById(prescriptionId);
		if (prescription != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Prescription deleted from DB");
			responseStructure.setData(prescriptionDao.deletePrescriptionById(prescriptionId));
			return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PrescriptionIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Prescription>> updatePrescriptionById(int oldPrescriptionId, Prescription newPrescription) {
		Prescription prescription = prescriptionDao.fetchPrescriptionById(oldPrescriptionId);
		if (prescription != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Prescription updated in DB");
			responseStructure.setData(prescriptionDao.updatePrescriptionById(oldPrescriptionId, newPrescription));
			return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PrescriptionIdNotFound();
		}
	}

	public List<Prescription> fetchAllPrescription() {
		return prescriptionDao.fetchAllPrescription();
	}
}
