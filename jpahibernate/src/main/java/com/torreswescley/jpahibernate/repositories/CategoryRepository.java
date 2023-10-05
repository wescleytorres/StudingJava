package com.torreswescley.jpahibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torreswescley.jpahibernate.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
