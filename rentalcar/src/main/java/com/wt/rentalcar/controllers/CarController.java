package com.wt.rentalcar.controllers;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wt.rentalcar.dto.CarDTO;
import com.wt.rentalcar.entities.Car;
import com.wt.rentalcar.services.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

  @Autowired
  private CarService carService;

  @GetMapping
  public ResponseEntity<Page<Car>> findAll(
      @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {

    return ResponseEntity.ok().body(carService.findAll(pageable));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Car> findById(@PathVariable UUID id) {

    return ResponseEntity.ok().body(carService.findById(id));
  }

  @PostMapping
  public ResponseEntity<Car> insert(@RequestBody @Valid CarDTO obj) {
    Car car = carService.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(car.getId()).toUri();
    return ResponseEntity.created(uri).body(car);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Car> update(@PathVariable UUID id, @RequestBody Car obj) {
    carService.update(id, obj);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    carService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
