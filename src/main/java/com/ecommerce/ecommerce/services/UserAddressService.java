package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.entities.Address;
import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.repositories.AddressRepository;
import com.ecommerce.ecommerce.repositories.UserRepository;
import com.ecommerce.ecommerce.resources.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserAddressService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    public User addAddress(Long userId, Set<Long> addressIds) {
        User user = getUserById(userId);

        for (Long addressId : addressIds) {
            Address address = getAddressById(addressId);
            user.getAddresses().add(address);
        }

        return userRepository.save(user);

    }

    public User updateAddress(Long userId, Set<Long> addressIds) {
        User user = getUserById(userId);

        user.getAddresses().clear();
        for (Long addressId : addressIds) {
            Address address = getAddressById(addressId);
            user.getAddresses().add(address);
        }

        return userRepository.save(user);
    }

    public User removeAddress(Long userId, Set<Long> addressIds) {
        User user = getUserById(userId);

        for (Long addressId : addressIds) {
            Address address = getAddressById(addressId);
            user.getAddresses().remove(address);
        }

        return userRepository.save(user);
    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    private Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + addressId));
    }

}
