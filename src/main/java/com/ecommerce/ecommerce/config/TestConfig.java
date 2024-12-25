package com.ecommerce.ecommerce.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "teste", "teste@gmail.com", "123456879", "123456");
		User u2 = new User(null, "teste2", "teste2@gmail.com", "987654321", "654321");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
