package com.ecommerce.ecommerce.resources;

import java.net.URI;
import java.util.List;

import com.ecommerce.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.ecommerce.entities.Order;
import com.ecommerce.ecommerce.services.OrderService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = orderService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedOrder.getId())
				.toUri();

		return ResponseEntity.created(location).body(savedOrder);
    }

	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
		Order updatedOrder = orderService.updateOrder(id, orderDetails);
		return ResponseEntity.ok(updatedOrder);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }


}
