package com.citasmedicas.citas.repository.crudRepository;

import com.citasmedicas.citas.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor,Integer> {
}
