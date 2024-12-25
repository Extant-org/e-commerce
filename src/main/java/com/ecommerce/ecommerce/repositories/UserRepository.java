package com.ecommerce.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
