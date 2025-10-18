package com.project.hospital_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	private String roomName;
	private String roomType;
	private int roomNumber;
	private String roomFloor;
	private double roomCost;
	private int noOfBeds;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomFloor() {
		return roomFloor;
	}
	public void setRoomFloor(String roomFloor) {
		this.roomFloor = roomFloor;
	}
	public double getRoomCost() {
		return roomCost;
	}
	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	

}
