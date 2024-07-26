package com.akargl.acltakehome3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.akargl.acltakehome3.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}