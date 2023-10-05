package com.torreswescley.jpahibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torreswescley.jpahibernate.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
