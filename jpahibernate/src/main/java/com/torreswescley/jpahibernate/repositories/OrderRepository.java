package com.torreswescley.jpahibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torreswescley.jpahibernate.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
