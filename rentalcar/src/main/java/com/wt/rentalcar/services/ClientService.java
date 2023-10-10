package com.wt.rentalcar.services;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wt.rentalcar.dto.ClientDTO;
import com.wt.rentalcar.entities.Car;
import com.wt.rentalcar.entities.Client;
import com.wt.rentalcar.repositories.ClientRepository;
import com.wt.rentalcar.services.exception.ObjectNotFoundException;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private CarService carService;

  public Page<Client> findAll(Pageable pageable) {
    return clientRepository.findAll(pageable);
  }

  public Client findById(UUID id) {
    Optional<Client> obj = clientRepository.findById(id);

    return obj.orElseThrow(() -> new ObjectNotFoundException(id));
  }

  public Client insert(ClientDTO obj) {
    var client = fromDTO(obj);
    Car car = carService.findById(obj.getCarId());

    client.setCar(car);
    client.setCreatedAt(new Date());
    return clientRepository.save(client);
  }

  public Client update(UUID id, ClientDTO obj) {
    Client entity = clientRepository.getReferenceById(id);
    updateData(entity, obj);
    entity.setUpdatedAt(new Date());
    return clientRepository.save(entity);
  }

  public void delete(UUID id) {
    findById(id);
    clientRepository.deleteById(id);
  }

  private void updateData(Client entity, ClientDTO obj) {
    if (obj.getName() != null) {
      entity.setName(obj.getName());
    }
    if (obj.getCpf() != null) {
      entity.setCpf(obj.getCpf());
    }
    if (obj.getBithDate() != null) {
      entity.setBithDate(obj.getBithDate());
    }
    if (obj.getCarId() != null) {
      Car car = carService.findById(obj.getCarId());
      entity.setCar(car);
    }
  }

  private Client fromDTO(ClientDTO obj) {
    var client = new Client();
    BeanUtils.copyProperties(obj, client);
    return client;
  }
}
