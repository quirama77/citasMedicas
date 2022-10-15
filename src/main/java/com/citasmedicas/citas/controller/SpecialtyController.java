package com.citasmedicas.citas.controller;

import com.citasmedicas.citas.entities.Specialty;

import com.citasmedicas.citas.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Specialty")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/all")
    public List<Specialty> getAll(){return  specialtyService.getAll();}

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Specialty d){
        specialtyService.save(d);
        return ResponseEntity.status(201).build();

    }


}
