package com.ecommerce.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.ecommerce.ecommerce.dto.ProductDTO;
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
	
	public Product saveProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setImgUrl(productDTO.getImgUrl());

		return productRepository.save(product);
	}
	
	public Product updateProduct(Long id, ProductDTO productDTO) {

		Product existingProduct = productRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	    
	    if (productDTO.getName() != null) {
	    	existingProduct.setName(productDTO.getName());
	    }
	    if (productDTO.getDescription() != null) {
	    	existingProduct.setDescription(productDTO.getDescription());
	    }
	    if (productDTO.getPrice() != null) {
	    	existingProduct.setPrice(productDTO.getPrice());
	    }
	    if (productDTO.getImgUrl() != null) {
	    	existingProduct.setImgUrl(productDTO.getImgUrl());
	    }
	    
	    return productRepository.save(existingProduct);
	}
	
	public void deleteProduct(Long id) {
		Product existingProduct = productRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
		productRepository.deleteById(id);
	}
}
