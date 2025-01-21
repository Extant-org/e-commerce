package com.ecommerce.ecommerce.resources;

import com.ecommerce.ecommerce.dto.UserAddressDTO;
import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users/{id}/addresses")
public class UserAddressResource {

    @Autowired
    private UserAddressService userAddressService;

    @PostMapping
    public ResponseEntity<User> addAddress(
            @PathVariable Long id,
            @RequestBody UserAddressDTO userAddressDTO) {
        User updatedUser = userAddressService.addAddress(id, userAddressDTO.getAddressIds());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .build()
                .toUri();
        return ResponseEntity.created(location).body(updatedUser);
    }

    @PutMapping
    public ResponseEntity<User> updateAddress(
            @PathVariable Long id,
            @RequestBody UserAddressDTO userAddressDTO) {
        User updatedUser = userAddressService.updateAddress(id, userAddressDTO.getAddressIds());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping
    public ResponseEntity<User> removeAddress(
            @PathVariable Long id,
            @RequestBody UserAddressDTO userAddressDTO) {
        User updatedUser = userAddressService.removeAddress(id, userAddressDTO.getAddressIds());
        return ResponseEntity.ok(updatedUser);
    }
}
