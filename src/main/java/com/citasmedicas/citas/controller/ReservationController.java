package com.citasmedicas.citas.controller;

import com.citasmedicas.citas.entities.Reservation;
import com.citasmedicas.citas.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){return reservationService.getAll();}

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Reservation r){
        reservationService.save(r);
        return ResponseEntity.status(201).build();
    }
}
