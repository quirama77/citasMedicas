package com.citasmedicas.citas.controller;
import com.citasmedicas.citas.entities.Doctor;
import com.citasmedicas.citas.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Doctor save(@RequestBody Doctor d){
        return doctorService.save(d);

    }
}
