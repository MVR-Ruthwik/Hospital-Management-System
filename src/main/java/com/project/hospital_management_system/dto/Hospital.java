
package com.project.hospital_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;
	private String hospitalName;
	private String hospitalGst;
	private long hospitalPhone;
	private String hospitalEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branch;

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalGst() {
		return hospitalGst;
	}

	public void setHospitalGst(String hospitalGst) {
		this.hospitalGst = hospitalGst;
	}

	public long getHospitalPhone() {
		return hospitalPhone;
	}

	public void setHospitalPhone(long hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}

	public String getHospitalEmail() {
		return hospitalEmail;
	}

	public void setHospitalEmail(String hospitalEmail) {
		this.hospitalEmail = hospitalEmail;
	}

}
