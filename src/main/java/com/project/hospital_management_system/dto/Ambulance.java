package com.project.hospital_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ambulance {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ambulanceId;
	private String ambulanceNumber;
	private String ambulanceBrand;
	private String ambulanceTopSpeed;
	private double ambulanceMileage;
	public int getAmbulanceId() {
		return ambulanceId;
	}
	public void setAmbulanceId(int ambulanceId) {
		this.ambulanceId = ambulanceId;
	}
	public String getAmbulanceNumber() {
		return ambulanceNumber;
	}
	public void setAmbulanceNumber(String ambulanceNumber) {
		this.ambulanceNumber = ambulanceNumber;
	}
	public String getAmbulanceBrand() {
		return ambulanceBrand;
	}
	public void setAmbulanceBrand(String ambulanceBrand) {
		this.ambulanceBrand = ambulanceBrand;
	}
	public String getAmbulanceTopSpeed() {
		return ambulanceTopSpeed;
	}
	public void setAmbulanceTopSpeed(String ambulanceTopSpeed) {
		this.ambulanceTopSpeed = ambulanceTopSpeed;
	}
	public double getAmbulanceMileage() {
		return ambulanceMileage;
	}
	public void setAmbulanceMileage(double ambulanceMileage) {
		this.ambulanceMileage = ambulanceMileage;
	}
	
	
}
