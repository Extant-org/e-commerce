package com.ecommerce.ecommerce.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.ProductCategoryDTO;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.services.ProductCategoryService;

@RestController
@RequestMapping(value = "/products/{id}/categories")
public class ProductCategoryResource {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<Product> addCategories(
            @PathVariable Long id,
            @RequestBody ProductCategoryDTO productCategoriesDTO) {
        Product updatedProduct = productCategoryService.addCategories(id, productCategoriesDTO.getCategoryIds());
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping
    public ResponseEntity<Product> updateCategories(
            @PathVariable Long id,
            @RequestBody ProductCategoryDTO productCategoriesDTO) {
        Product updatedProduct = productCategoryService.updateCategories(id, productCategoriesDTO.getCategoryIds());
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping
    public ResponseEntity<Product> removeCategories(
            @PathVariable Long id,
            @RequestBody ProductCategoryDTO productCategoriesDTO) {
        Product updatedProduct = productCategoryService.removeCategories(id, productCategoriesDTO.getCategoryIds());
        return ResponseEntity.ok(updatedProduct);
    }
}
