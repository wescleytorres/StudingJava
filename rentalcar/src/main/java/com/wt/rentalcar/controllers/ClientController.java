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

import com.wt.rentalcar.dto.ClientDTO;
import com.wt.rentalcar.entities.Client;
import com.wt.rentalcar.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

  @Autowired
  private ClientService service;

  @GetMapping
  public ResponseEntity<Page<Client>> findAll(
      @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {

    return ResponseEntity.ok().body(service.findAll(pageable));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Client> findById(@PathVariable UUID id) {

    return ResponseEntity.ok().body(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<Client> insert(@RequestBody @Valid ClientDTO obj) {
    Client client = service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(client.getId()).toUri();
    return ResponseEntity.created(uri).body(client);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Client> update(@PathVariable UUID id, @RequestBody ClientDTO obj) {
    service.update(id, obj);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
