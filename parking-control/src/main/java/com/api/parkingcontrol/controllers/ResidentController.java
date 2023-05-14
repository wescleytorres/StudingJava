package com.api.parkingcontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dto.ResidentDto;
import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.models.ResidentModel;
import com.api.parkingcontrol.services.CarService;
import com.api.parkingcontrol.services.ParkingSpotService;
import com.api.parkingcontrol.services.ResidentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/resident")
public class ResidentController {
  @Autowired
  private ResidentService residentService;

  @Autowired
  private ParkingSpotService parkingSpotService;

  @Autowired
  private CarService carService;

  @PostMapping("/{parkingId}")
  public ResponseEntity<Object> saveParkingSpot(@PathVariable UUID parkingId,
      @RequestBody @Valid ResidentDto residentDto) {
    Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(parkingId);
    if (parkingSpotModelOptional.isPresent()) {
      System.out.println("entrou aqui");
      var residentModel = new ResidentModel();
      BeanUtils.copyProperties(residentDto, residentModel);
      ParkingSpotModel parkingSpotModel = parkingSpotModelOptional.get();
      parkingSpotModel.setResident(residentModel);
      parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
      parkingSpotService.save(parkingSpotModel);

      var carModel = new CarModel();
      BeanUtils.copyProperties(residentModel.getCar(), carModel);
      carModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
      System.out.println(carService.save(carModel));
      // carService.save(carModel);

      // return
      // ResponseEntity.status(HttpStatus.CREATED).body(residentService.save(residentModel));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");

  }

}
