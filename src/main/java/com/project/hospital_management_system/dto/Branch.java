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
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private String branchGst;
	private long branchPhone;
	private String branchEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BranchHead branchHead;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Doctor> doctors;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Patient> patients;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Room> rooms;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employees;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ambulance>ambulances;
	
	
	public BranchHead getBranchHead() {
		return branchHead;
	}
	public void setBranchHead(BranchHead branchHead) {
		this.branchHead = branchHead;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Ambulance> getAmbulances() {
		return ambulances;
	}
	public void setAmbulances(List<Ambulance> ambulances) {
		this.ambulances = ambulances;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchGst() {
		return branchGst;
	}
	public void setBranchGst(String branchGst) {
		this.branchGst = branchGst;
	}
	public long getBranchPhone() {
		return branchPhone;
	}
	public void setBranchPhone(long branchPhone) {
		this.branchPhone = branchPhone;
	}
	public String getBranchEmail() {
		return branchEmail;
	}
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

}
