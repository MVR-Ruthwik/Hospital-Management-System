package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Payment;
import com.project.hospital_management_system.repo.PaymentRepo;
@Repository
public class PaymentDao {
	@Autowired
	PaymentRepo paymentRepo;

	
	public Payment savePayment(Payment payment) {
//		Payment dbPayment = paymentRepo.save(payment);
//		return dbPayment;
		return paymentRepo.save(payment);
	}

	public Payment fetchPaymentById(int paymentId) {
		Optional<Payment> payment = paymentRepo.findById(paymentId);
		if (payment.isEmpty()) {
			return null;
		} else {
			return payment.get();
		}
//		if (payment.isPresent()) {
//			return payment.get();
//		} else {
//			return null;
//		}
	}

	public Payment deletePaymentById(int paymentId) {
		// Payment payment = paymentRepo.findById(paymentId).get();
		Payment payment = fetchPaymentById(paymentId);
		paymentRepo.delete(payment);
		return payment;
	}

	public Payment updatePaymentById(int oldPaymentId, Payment newPayment) {
		newPayment.setPaymentId(oldPaymentId);
		return paymentRepo.save(newPayment);
	}

	public List<Payment> fetchAllPayment() {
		return paymentRepo.findAll();
	}

	


}
