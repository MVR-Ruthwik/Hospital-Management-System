package com.project.hospital_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String patientName;
	private int patientAge;
	private String patientHealthIssue;
	private long patientPhone;
	private String patientEmail;
	private String patientGender;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Prescription> prescriptions;
	
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientHealthIssue() {
		return patientHealthIssue;
	}
	public void setPatientHealthIssue(String patientHealthIssue) {
		this.patientHealthIssue = patientHealthIssue;
	}
	public long getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(long patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

}
