package com.wt.rentalcar.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wt.rentalcar.entities.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
