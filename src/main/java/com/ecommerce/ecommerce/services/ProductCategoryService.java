package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.resources.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.repositories.CategoryRepository;
import com.ecommerce.ecommerce.repositories.ProductRepository;

import java.util.Set;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product addCategories(Long productId, Set<Long> categoryIds) {
        Product product = getProductById(productId);

        for (Long categoryId : categoryIds) {
            Category category = getCategoryById(categoryId);
            product.getCategories().add(category);
        }

        return productRepository.save(product);
    }

    public Product updateCategories(Long productId, Set<Long> categoryIds) {
        Product product = getProductById(productId);

        product.getCategories().clear();
        for (Long categoryId : categoryIds) {
            Category category = getCategoryById(categoryId);
            product.getCategories().add(category);
        }

        return productRepository.save(product);
    }

    public Product removeCategories(Long productId, Set<Long> categoryIds) {
        Product product = getProductById(productId);

        for (Long categoryId : categoryIds) {
            Category category = getCategoryById(categoryId);
            product.getCategories().remove(category);
        }

        return productRepository.save(product);
    }

    private Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
    }

    private Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));
    }
}
