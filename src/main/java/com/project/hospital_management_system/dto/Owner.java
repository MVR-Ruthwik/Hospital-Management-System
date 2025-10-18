package com.project.hospital_management_system.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	private String ownerName;
	private double ownerNetworth;
	private long ownerPhone;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Hospital hospital;

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getOwnerNetworth() {
		return ownerNetworth;
	}

	public void setOwnerNetworth(double ownerNetworth) {
		this.ownerNetworth = ownerNetworth;
	}

	public long getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

}
