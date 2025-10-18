package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Payment;
import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.repo.PatientRepo;

@Repository
public class PatientDao {
	@Autowired
	PatientRepo patientRepo;
@Autowired
	PrescriptionDao prescriptionDao;
@Autowired
PaymentDao paymentDao;
	public Patient savePatient(Patient patient) {
//		Patient dbPatient = patientRepo.save(patient);
//		return dbPatient;
		return patientRepo.save(patient);
	}

	public Patient fetchPatientById(int patientId) {
		Optional<Patient> patient = patientRepo.findById(patientId);
		if (patient.isEmpty()) {
			return null;
		} else {
			return patient.get();
		}
//		if (patient.isPresent()) {
//			return patient.get();
//		} else {
//			return null;
//		}
	}
	

	public Patient deletePatientById(int patientId) {
		// Patient patient = PatientRepo.findById(patientId).get();
		Patient patient = fetchPatientById(patientId);
		patientRepo.delete(patient);
		return patient;
	}

	public Patient updatePatientById(int oldPatientId, Patient newPatient) {
		newPatient.setPatientId(oldPatientId);
		return patientRepo.save(newPatient);
	}

	public List<Patient> fetchAllPatient() {
		return patientRepo.findAll();
	}

	public Patient addNewPrescriptionToExistingPatient(int patientId,Prescription newPrescription) 
	{
		Patient patient = fetchPatientById(patientId);
		List<Prescription> list = patient.getPrescriptions();
		list.add(newPrescription);
		patient.setPrescriptions(list);
		return savePatient(patient);
	}
	
	public Patient addExistingPrescriptionToExistingPatient(int prescriptionId, int patientId) 
	{
	Prescription prescription=prescriptionDao.fetchPrescriptionById( prescriptionId);
		Patient patient = fetchPatientById(patientId);
		List<Prescription> list = patient.getPrescriptions();
		list.add(prescription);
		patient.setPrescriptions(list);
		return savePatient(patient);

}
	public Patient addExistingPaymentToExistingPatient(int paymentId, int patientId) 
	{
	Payment payment=paymentDao.fetchPaymentById(paymentId);
		Patient patient = fetchPatientById(patientId);
		patient.setPayment(payment);
		return savePatient(patient);

}


}
