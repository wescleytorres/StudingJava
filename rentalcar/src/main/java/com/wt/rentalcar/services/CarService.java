package com.wt.rentalcar.services;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wt.rentalcar.dto.CarDTO;
import com.wt.rentalcar.entities.Car;
import com.wt.rentalcar.repositories.CarRepository;
import com.wt.rentalcar.services.exception.ObjectNotFoundException;

@Service
public class CarService {

  @Autowired
  private CarRepository repo;

  public Page<Car> findAll(Pageable pageable) {
    return repo.findAll(pageable);
  }

  public Car findById(UUID id) {
    Optional<Car> obj = repo.findById(id);

    return obj.orElseThrow(() -> new ObjectNotFoundException(id));
  }

  public Car insert(CarDTO obj) {
    var car = fromDTO(obj);
    car.setDataCadastro(new Date());
    return repo.save(car);
  }

  public Car update(UUID id, Car obj) {
    Car entity = repo.getReferenceById(id);
    updateData(entity, obj);
    return repo.save(entity);
  }

  public void delete(UUID id) {
    findById(id);
    repo.deleteById(id);
  }

  private void updateData(Car entity, Car obj) {
    if (obj.getMarca() != null) {
      entity.setMarca(obj.getMarca());
    }
    if (obj.getModelo() != null) {
      entity.setModelo(obj.getModelo());
    }
  }

  private Car fromDTO(CarDTO obj) {
    var car = new Car();
    BeanUtils.copyProperties(obj, car);
    return car;
  }
}
