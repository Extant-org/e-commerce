package com.ecommerce.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.ecommerce.ecommerce.resources.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Long id, Product ProductDetails) {

		Product existingProduct = productRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	    
	    if (ProductDetails.getName() != null) {
	    	existingProduct.setName(ProductDetails.getName());
	    }
	    if (ProductDetails.getDescription() != null) {
	    	existingProduct.setDescription(ProductDetails.getDescription());
	    }
	    if (ProductDetails.getPrice() != null) {
	    	existingProduct.setPrice(ProductDetails.getPrice());
	    }
	    if (ProductDetails.getImgUrl() != null) {
	    	existingProduct.setImgUrl(ProductDetails.getImgUrl());
	    }
	    
	    return productRepository.save(existingProduct);
	}
	
	public void deleteProduct(Long id) {
		Product existingProduct = productRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
		productRepository.deleteById(id);
	}
}
