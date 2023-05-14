package com.api.parkingcontrol.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CAR")
public class CarModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @Column(nullable = false, unique = true, length = 7)
  private String licensePlateCar;
  @Column(nullable = false, length = 70)
  private String brandCar;
  @Column(nullable = false, length = 70)
  private String modelCar;
  @Column(nullable = false, length = 70)
  private String colorCar;
  @Column(nullable = false)
  private LocalDateTime registrationDate;

  public CarModel() {
  }

  public CarModel(String licensePlateCar, String brandCar, String modelCar, String colorCar,
      LocalDateTime registrationDate) {
    this.licensePlateCar = licensePlateCar;
    this.brandCar = brandCar;
    this.modelCar = modelCar;
    this.colorCar = colorCar;
    this.registrationDate = registrationDate;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getLicensePlateCar() {
    return licensePlateCar;
  }

  public void setLicensePlateCar(String licensePlateCar) {
    this.licensePlateCar = licensePlateCar;
  }

  public String getBrandCar() {
    return brandCar;
  }

  public void setBrandCar(String brandCar) {
    this.brandCar = brandCar;
  }

  public String getModelCar() {
    return modelCar;
  }

  public void setModelCar(String modelCar) {
    this.modelCar = modelCar;
  }

  public String getColorCar() {
    return colorCar;
  }

  public void setColorCar(String colorCar) {
    this.colorCar = colorCar;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

}
