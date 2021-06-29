package org.as.devtechsolution.order.controller;

import org.as.devtechsolution.order.dto.OrderDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto) {
		
    	
    	return "hello";
    }

    private Boolean handleErrorCase() {
        return false;
    }
}