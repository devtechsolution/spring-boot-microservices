package org.as.devtechsolution.order.repository;

import org.as.devtechsolution.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}