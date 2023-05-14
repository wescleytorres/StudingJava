package com.api.parkingcontrol.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.models.ResidentModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.repositories.ResidentRepository;

import jakarta.transaction.Transactional;

@Service
public class ResidentService {

  @Autowired
  private ResidentRepository residentRepository;

  @Transactional
  public ResidentModel save(ResidentModel residentModel) {
    return residentRepository.save(residentModel);
  }

  // public boolean existsByLicensePlateCar(String licensePlateCar) {
  // return residentRepository.existsByLicensePlateCar(licensePlateCar);
  // }

  // public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
  // return residentRepository.existsByParkingSpotNumber(parkingSpotNumber);
  // }

  // public boolean existsByApartmentAndBlock(String apartment, String block) {
  // return residentRepository.existsByApartmentAndBlock(apartment, block);
  // }

  // public Page<ParkingSpotModel> findAll(Pageable pageable) {
  // return residentRepository.findAll(pageable);
  // }

  // public Optional<ParkingSpotModel> findById(UUID id) {
  // return residentRepository.findById(id);
  // }

  // @Transactional
  // public void delete(ParkingSpotModel parkingSpotModel) {
  // residentRepository.delete(parkingSpotModel);
  // }
}
