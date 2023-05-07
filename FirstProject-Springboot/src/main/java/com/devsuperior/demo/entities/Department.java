package com.devsuperior.demo.entities;

public class Department {
  private Long Id;
  private String name;

  public Long getId() {
    return Id;
  }

  public Department() {

  }

  public Department(Long id, String name) {
    Id = id;
    this.name = name;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
