package com.citasmedicas.citas.repository;

import com.citasmedicas.citas.entities.Message;
import com.citasmedicas.citas.entities.Specialty;
import com.citasmedicas.citas.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message d){
        return messageCrudRepository.save(d);
    }

    public void delete(Message d){
        messageCrudRepository.delete(d);
    }

}
