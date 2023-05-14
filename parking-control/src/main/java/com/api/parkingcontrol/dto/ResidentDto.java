package com.api.parkingcontrol.dto;

import java.util.ArrayList;

import jakarta.validation.constraints.NotBlank;

public class ResidentDto {

  @NotBlank
  private String responsibleName;
  @NotBlank
  private String apartment;
  @NotBlank
  private String block;
  @NotBlank
  private ArrayList<CarDto> car;

  public ArrayList<CarDto> getCar() {
    return car;
  }

  public void setCar(ArrayList<CarDto> car) {
    this.car = car;
  }

  public String getResponsibleName() {
    return responsibleName;
  }

  public void setResponsibleName(String responsibleName) {
    this.responsibleName = responsibleName;
  }

  public String getApartment() {
    return apartment;
  }

  public void setApartment(String apartment) {
    this.apartment = apartment;
  }

  public String getBlock() {
    return block;
  }

  public void setBlock(String block) {
    this.block = block;
  }

}
