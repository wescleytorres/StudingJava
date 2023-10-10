package com.wt.rentalcar.dto;

import java.util.Date;
import java.util.UUID;

public class ClientDTO {
  private String name;
  private String cpf;
  private Date bithDate;
  private UUID carId;

  public ClientDTO() {
  }

  public ClientDTO(String name, String cpf, Date bithDate, UUID carId) {
    this.name = name;
    this.cpf = cpf;
    this.bithDate = bithDate;
    this.carId = carId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Date getBithDate() {
    return bithDate;
  }

  public void setBithDate(Date bithDate) {
    this.bithDate = bithDate;
  }

  public UUID getCarId() {
    return carId;
  }

  public void setCarId(UUID carId) {
    this.carId = carId;
  }
}
