package org.efood.restraunt.repository;

import org.efood.restraunt.dto.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetails extends JpaRepository<Payment, Integer> {

	
}
