package com.citasmedicas.citas.repository;

import com.citasmedicas.citas.entities.Specialty;
import com.citasmedicas.citas.repository.crudRepository.SpecialtyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class SpecialtyRepository {
    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;

    public List<Specialty> getAll(){
        return (List<Specialty>) specialtyCrudRepository.findAll();
    }

    public Optional<Specialty> getSpecialty(int id){
        return specialtyCrudRepository.findById(id);
    }

    public Specialty save(Specialty d){
        return specialtyCrudRepository.save(d);
    }


    public void delete(Specialty d){
        specialtyCrudRepository.delete(d);
    }
}
