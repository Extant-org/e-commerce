package com.ecommerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
