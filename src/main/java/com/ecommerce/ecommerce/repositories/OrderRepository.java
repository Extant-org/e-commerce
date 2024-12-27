package com.ecommerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
