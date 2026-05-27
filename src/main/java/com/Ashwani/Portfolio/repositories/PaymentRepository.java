package com.Ashwani.Portfolio.repositories;

import com.Ashwani.Portfolio.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
