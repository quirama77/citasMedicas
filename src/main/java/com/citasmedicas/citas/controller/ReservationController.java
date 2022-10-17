package com.citasmedicas.citas.controller;

import com.citasmedicas.citas.entities.CountClient;
import com.citasmedicas.citas.entities.Reservation;
import com.citasmedicas.citas.entities.ReservationCount;
import com.citasmedicas.citas.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/report-status")

    public ReservationCount reportStatus(){return reservationService.getReportStatus();}

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")

    public List<Reservation> getReservationPeriod(@PathVariable("dateOne")String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne, dateTwo);

    }

    @GetMapping("/report-clients")
    public List<CountClient> getTopClient(){return reservationService.getTopClients();}




}
