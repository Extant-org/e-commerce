package com.ecommerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
