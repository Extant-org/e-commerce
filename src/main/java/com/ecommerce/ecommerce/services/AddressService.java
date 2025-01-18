package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.entities.Address;
import com.ecommerce.ecommerce.repositories.AddressRepository;
import com.ecommerce.ecommerce.resources.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address nout found with id: " + id));
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress (Long id, Address addressDetails) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));

        if (addressDetails.getZipCode() != null) {
            existingAddress.setZipCode(addressDetails.getZipCode());
        }
        if (addressDetails.getStreet() != null) {
            existingAddress.setStreet(addressDetails.getStreet());
        }
        if (addressDetails.getComplement() != null) {
            existingAddress.setComplement(addressDetails.getComplement());
        }
        if (addressDetails.getCity() != null) {
            existingAddress.setCity(addressDetails.getCity());
        }
        if (addressDetails.getState() != null) {
            existingAddress.setState(addressDetails.getState());
        }

        return addressRepository.save(existingAddress);
    }

    public void deleteAddress(Long id) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));

        addressRepository.deleteById(id);
    }
}
