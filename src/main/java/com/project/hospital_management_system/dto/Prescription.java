package com.project.hospital_management_system.dto;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prescriptionId;
	private String prescriptionName;
	private String prescriptionType;
	
	private LocalDate prescriptionDate;
	private String prescriptionUsage;
	
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public String getPrescriptionName() {
		return prescriptionName;
	}
	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}
	public String getPrescriptionType() {
		return prescriptionType;
	}
	public void setPrescriptionType(String prescriptionType) {
		this.prescriptionType = prescriptionType;
	}
	public LocalDate getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(LocalDate prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	public String getPrescriptionUsage() {
		return prescriptionUsage;
	}
	public void setPrescriptionUsage(String prescriptionUsage) {
		this.prescriptionUsage = prescriptionUsage;
	}
	

}
