package com.citasmedicas.citas.service;

import com.citasmedicas.citas.entities.Client;

import com.citasmedicas.citas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getIdClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);

        }else {
            Optional<Client> p = clientRepository.getClient(c.getIdClient());
            if(p.isPresent()){
                return c;

            }else {return clientRepository.save(c);}
        }

    }

    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> e = clientRepository.getClient(c.getIdClient());
            if (!e.isEmpty()){
                if(c.getEmail()!=null){e.get().setEmail(c.getEmail());}
                if(c.getPassword()!=null){e.get().setPassword(c.getPassword());}
                if(c.getAge()!=null){e.get().setAge(c.getAge());}
                if(c.getName()!=null){e.get().setName(c.getName());}

                clientRepository.save(e.get());
                return e.get();
            }else {return c;}
        }else {return c;}
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Client> e=clientRepository.getClient(id);
        if(e.isPresent()){
            clientRepository.delete(e.get());
            flag = true;
        }


        return flag;
    }




}
