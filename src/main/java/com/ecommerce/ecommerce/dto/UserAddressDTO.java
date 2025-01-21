package com.ecommerce.ecommerce.dto;

import java.util.Set;

public class UserAddressDTO {

    private Set<Long> addressIds;

    public Set<Long> getAddressIds() {
        return addressIds;
    }

    public void setAddressIds(Set<Long> addressIds) {
        this.addressIds = addressIds;
    }
}
