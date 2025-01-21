package com.ecommerce.ecommerce.dto;

import java.util.Set;

public class ProductCategoryDTO {

    private Set<Long> categoryIds;

	public Set<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
