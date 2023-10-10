package com.wt.rentalcar.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wt.rentalcar.entities.*;
import com.wt.rentalcar.repositories.*;

@Configuration
public class TestConfig implements CommandLineRunner {

  @Autowired
  private CarRepository carRepository;

  @Autowired
  private ClientRepository clientRepository;

  @Override
  public void run(String... args) throws Exception {

    carRepository.deleteAll();
    clientRepository.deleteAll();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    Car newCar1 = new Car(null, "toyota", "hilux", sdf.parse("03/04/2023"));
    Car newCar2 = new Car(null, "chevrolet", "onix", sdf.parse("14/06/2023"));

    carRepository.saveAll(Arrays.asList(newCar1, newCar2));

    Client c1 = new Client(null, "Jean Torres", "99985645140",
        sdf.parse("25/03/1995"), new Date(), null, newCar2);

    Client c2 = new Client(null, "Bruna Mesquita", "54215689542",
        sdf.parse("15/01/1994"), new Date(), null, newCar1);

    clientRepository.saveAll(Arrays.asList(c1, c2));
  }

}
