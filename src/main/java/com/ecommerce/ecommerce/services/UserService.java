package com.ecommerce.ecommerce.services;

import java.util.List;

import com.ecommerce.ecommerce.resources.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}
	
	public User saveUser(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
	
	public User updateUser(Long id, User userDetails) {

	    User existingUser = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	    
	    if (userDetails.getName() != null) {
	        existingUser.setName(userDetails.getName());
	    }
	    if (userDetails.getEmail() != null) {
	        existingUser.setEmail(userDetails.getEmail());
	    }
	    if (userDetails.getPhone() != null) {
	        existingUser.setPhone(userDetails.getPhone());
	    }
	    if (userDetails.getPassword() != null) {
	        existingUser.setPassword(userDetails.getPassword());
	    }
	    

	    return userRepository.save(existingUser);
	}


	public void deleteUser(Long id) {
	    User existingUser = userRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

		userRepository.deleteById(id);
	}

}
