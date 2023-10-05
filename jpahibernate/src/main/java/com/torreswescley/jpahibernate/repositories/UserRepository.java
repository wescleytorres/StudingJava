package com.torreswescley.jpahibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torreswescley.jpahibernate.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
