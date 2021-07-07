package org.as.devtechsolution.order.controller;

import java.util.UUID;

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

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDto orderDto) {
    	
    	String randomNumber = UUID.randomUUID().toString();
		
    	Order order = Order.builder().orderNumber(randomNumber)
    			.orderLineItems(orderDto.getOrderLineItemsList())
    			.build();
		return new  ResponseEntity<Order>(orderRepository.save(order), HttpStatus.CREATED);
    }

    private Boolean handleErrorCase() {
        return false;
    }
}