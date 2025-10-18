package com.project.hospital_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management_system.dto.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{



}
