package org.as.devtechsolution.order.controller;

import java.util.UUID;

import org.as.devtechsolution.order.client.InventoryClient;
import org.as.devtechsolution.order.dto.OrderDto;
import org.as.devtechsolution.order.entity.Order;
import org.as.devtechsolution.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
//@RequiredArgsConstructor
@Slf4j
public class OrderController {

	private final OrderRepository orderRepository;
	private final InventoryClient inventoryClient;
	
	
	

	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestBody OrderDto orderDto) {
		boolean allProductInStock = orderDto.getOrderLineItemsList().stream()
				.allMatch(orderItem -> inventoryClient.checkStock(orderItem.getSkuCode()));
		
		if (allProductInStock) {
			Order order = Order.builder().orderNumber(UUID.randomUUID().toString()).orderLineItems(orderDto.getOrderLineItemsList())
					.build();
			return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Order failed, one of the products in the order is not in stock",
					HttpStatus.NOT_FOUND);
		}
	}

	private Boolean handleErrorCase() {
		return false;
	}

	public OrderController(OrderRepository orderRepository, InventoryClient inventoryClient) {
		super();
		this.orderRepository = orderRepository;
		this.inventoryClient = inventoryClient;
	}
}