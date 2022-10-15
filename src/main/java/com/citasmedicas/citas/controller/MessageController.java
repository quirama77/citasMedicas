package com.citasmedicas.citas.controller;

import com.citasmedicas.citas.entities.Message;
import com.citasmedicas.citas.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){return messageService.getAll();}

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Message m){
        messageService.save(m);
        return ResponseEntity.status(201).build();


    }
}
