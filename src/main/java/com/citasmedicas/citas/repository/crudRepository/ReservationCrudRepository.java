package com.citasmedicas.citas.repository.crudRepository;

import com.citasmedicas.citas.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
