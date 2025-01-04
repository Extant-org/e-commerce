package com.ecommerce.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.ecommerce.ecommerce.resources.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entities.Order;
import com.ecommerce.ecommerce.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		return orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
	}

	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order updateOrder (Long id, Order OrderDetails) {

		Order existingOrder = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

		if (OrderDetails.getMoment() != null) {
			existingOrder.setMoment(OrderDetails.getMoment());
		}
		if (OrderDetails.getOrderStatus() != null) {
			existingOrder.setOrderStatus(OrderDetails.getOrderStatus());
		}

		return orderRepository.save(existingOrder);
	}

	public void deleteOrder(Long id) {
		Order existingOrder = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
		orderRepository.deleteById(id);
	}

}
