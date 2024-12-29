package com.ecommerce.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get();
	}
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Long id, Category categoryDetails) {

		Category existingCategory = categoryRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
	    
	    if (categoryDetails.getName() != null) {
	    	existingCategory.setName(categoryDetails.getName());
	    }
	    
	    return categoryRepository.save(existingCategory);
	}


	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
