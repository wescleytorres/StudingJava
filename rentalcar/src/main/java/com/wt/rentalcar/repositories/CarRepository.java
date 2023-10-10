package com.wt.rentalcar.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wt.rentalcar.entities.Car;

public interface CarRepository extends JpaRepository<Car, UUID> {

}
