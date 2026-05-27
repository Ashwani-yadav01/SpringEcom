package com.Ashwani.Portfolio.repositories;

import com.Ashwani.Portfolio.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}