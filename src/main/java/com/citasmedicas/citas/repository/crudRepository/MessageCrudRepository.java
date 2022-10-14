package com.citasmedicas.citas.repository.crudRepository;

import com.citasmedicas.citas.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
