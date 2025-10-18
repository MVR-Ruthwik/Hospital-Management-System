package com.project.hospital_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private long doctorPhone;
	private String doctorEmail;
	private String doctorGender;
	private String doctorSpeclization;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Patient>patients;
	
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public long getDoctorPhone() {
		return doctorPhone;
	}
	public void setDoctorPhone(long doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public String getDoctorGender() {
		return doctorGender;
	}
	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}
	public String getDoctorSpeclization() {
		return doctorSpeclization;
	}
	public void setDoctorSpeclization(String doctorSpeclization) {
		this.doctorSpeclization = doctorSpeclization;
	}

}
