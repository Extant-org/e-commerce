package com.ecommerce.ecommerce.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.entities.Order;
import com.ecommerce.ecommerce.entities.OrderItem;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.entities.enums.OrderStatus;
import com.ecommerce.ecommerce.repositories.CategoryRepository;
import com.ecommerce.ecommerce.repositories.OrderItemRepository;
import com.ecommerce.ecommerce.repositories.OrderRepository;
import com.ecommerce.ecommerce.repositories.ProductRepository;
import com.ecommerce.ecommerce.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "teste", "teste@gmail.com", "123456879", "123456");
		User u2 = new User(null, "teste2", "teste2@gmail.com", "987654321", "654321");
		
		Order o1 = new Order(null, Instant.parse("2025-12-27T10:54:00Z"), OrderStatus.SHIPPED, u1);
		Order o2 = new Order(null, Instant.parse("2025-12-28T10:55:01Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2025-12-29T10:56:02Z"), OrderStatus.CANCELED, u1);
		
		Category cat1 = new Category(null, "portable appliances");
		Category cat2 = new Category(null, "Cell Phones");
		Category cat3 = new Category(null, "household appliance");
		
		Product p1 = new Product(null, "teste1", "Lorem ipsum dolor", 40.0, "");
		Product p2 = new Product(null, "teste2", "Lorem ipsum dolor", 50.0, "");
		Product p3 = new Product(null, "teste3", "Lorem ipsum dolor", 60.0, "");
		Product p4 = new Product(null, "teste4", "Lorem ipsum dolor", 70.0, "");
		Product p5 = new Product(null, "teste5", "Lorem ipsum dolor", 80.0, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat1);
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 1, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));


	}
}
