package com.example.OrderManagement.repository;

import com.example.OrderManagement.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {

}
