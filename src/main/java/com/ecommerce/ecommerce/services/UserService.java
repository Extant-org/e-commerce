package com.ecommerce.ecommerce.services;

import java.util.List;

import com.ecommerce.ecommerce.dto.UserDTO;
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
	
	public User saveUser(UserDTO userDTO) {
		User user = new User();
		String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setCPF(userDTO.getCPF());
		user.setPassword(encodedPassword);

		return userRepository.save(user);
	}
	
	public User updateUser(Long id, UserDTO userDTO) {

	    User existingUser = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

		if (userDTO.getName() != null) {
	        existingUser.setName(userDTO.getName());
	    }
	    if (userDTO.getEmail() != null) {
	        existingUser.setEmail(userDTO.getEmail());
	    }
	    if (userDTO.getPhone() != null) {
	        existingUser.setPhone(userDTO.getPhone());
	    }
		if (userDTO.getPassword() != null) {
			String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
			existingUser.setPassword(encryptedPassword);
		}
		if (userDTO.getCPF() != null) {
			existingUser.setCPF(userDTO.getCPF());
		}
	    

	    return userRepository.save(existingUser);
	}


	public void deleteUser(Long id) {
	    User existingUser = userRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

		userRepository.deleteById(id);
	}

}
