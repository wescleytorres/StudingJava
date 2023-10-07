package com.torreswescley.jpahibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torreswescley.jpahibernate.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
