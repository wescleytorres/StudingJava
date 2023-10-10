package com.wt.rentalcar.dto;

import jakarta.validation.constraints.NotBlank;

public class CarDTO {
  @NotBlank(message = "Marca nao pode ser em branco")
  private String marca;
  @NotBlank(message = "Modelo nao pode ser em branco")
  private String modelo;

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

}
