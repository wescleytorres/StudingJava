package com.api.parkingcontrol.dto;

import jakarta.validation.constraints.NotBlank;

public class ParkingSpotDto {

  @NotBlank
  private String parkingSpotNumber;

  public String getParkingSpotNumber() {
    return parkingSpotNumber;
  }

  public void setParkingSpotNumber(String parkingSpotNumber) {
    this.parkingSpotNumber = parkingSpotNumber;
  }

}
