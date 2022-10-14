package com.citasmedicas.citas.service;

import com.citasmedicas.citas.entities.Message;

import com.citasmedicas.citas.entities.Specialty;
import com.citasmedicas.citas.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){return messageRepository.getAll();}

    public Optional<Message> getMessage(int id){return messageRepository.getMessage(id);}

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);

        }else {
            Optional<Message> e = messageRepository.getMessage(m.getIdMessage());
            if(e.isPresent()){
                return m;

            }else {return messageRepository.save(m);}
        }

    }

    public Message update(Message m){
        if(m.getIdMessage()!=null){
            Optional<Message> e = messageRepository.getMessage(m.getIdMessage());
            if (!e.isEmpty()){

                if(m.getMessageText()!=null){e.get().setMessageText(m.getMessageText());}
                if (m.getDoctor()!=null){e.get().setDoctor(m.getDoctor());}
                if (m.getClient()!=null){e.get().setClient(m.getClient());}


                messageRepository.save(e.get());
                return e.get();
            }else {return m;}
        }else {return m;}
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Message> e= messageRepository.getMessage(id);
        if(e.isPresent()){
            messageRepository.delete(e.get());
            flag = true;
        }


        return flag;
    }


}
