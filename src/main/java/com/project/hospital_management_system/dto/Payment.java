package com.project.hospital_management_system.dto;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String paymentType;
	private Date paymentTime;
	private double paymentAmount;
	private String paymentTrancationId;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentTrancationId() {
		return paymentTrancationId;
	}
	public void setPaymentTrancationId(String paymentTrancationId) {
		this.paymentTrancationId = paymentTrancationId;
	}

}
