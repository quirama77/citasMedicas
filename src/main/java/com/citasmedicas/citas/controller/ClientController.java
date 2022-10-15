package com.citasmedicas.citas.controller;


import com.citasmedicas.citas.entities.Client;
import com.citasmedicas.citas.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Client c){
        clientService.save(c);
        return ResponseEntity.status(201).build();

    }

}
