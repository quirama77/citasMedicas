package com.citasmedicas.citas.controller;
import com.citasmedicas.citas.entities.Doctor;
import com.citasmedicas.citas.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getall(){
        return doctorService.getAll();
    }



    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Doctor d){
        doctorService.save(d);
        return ResponseEntity.status(201).build();


    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Doctor d){
        doctorService.update(d);
        return ResponseEntity.status(201).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        doctorService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
