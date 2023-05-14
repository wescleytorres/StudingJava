package com.api.parkingcontrol.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.CarRepository;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

import jakarta.transaction.Transactional;

@Service
public class CarService {

  @Autowired
  private CarRepository carRepository;

  @Transactional
  public CarModel save(CarModel carModel) {
    return carRepository.save(carModel);
  }

  // public boolean existsByLicensePlateCar(String licensePlateCar) {
  // return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
  // }

  // public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
  // return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
  // }

  // public boolean existsByApartmentAndBlock(String apartment, String block) {
  // return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
  // }

  // public Page<ParkingSpotModel> findAll(Pageable pageable) {
  // return parkingSpotRepository.findAll(pageable);
  // }

  // public Optional<ParkingSpotModel> findById(UUID id) {
  // return parkingSpotRepository.findById(id);
  // }

  // @Transactional
  // public void delete(ParkingSpotModel parkingSpotModel) {
  // parkingSpotRepository.delete(parkingSpotModel);
  // }
}
