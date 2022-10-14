package com.citasmedicas.citas.service;


import com.citasmedicas.citas.entities.Doctor;
import com.citasmedicas.citas.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }

    public Optional<Doctor> getDoctor(int id){
        return doctorRepository.getDoctor(id);
    }

    public Doctor save(Doctor d){
        if(d.getId()==null){
            return doctorRepository.save(d);

        }else {
            Optional<Doctor> e = doctorRepository.getDoctor(d.getId());
            if(e.isPresent()){
                return d;

            }else {return doctorRepository.save(d);}
        }

    }
    public Doctor update(Doctor d){
        if(d.getId()!=null){
            Optional<Doctor> e = doctorRepository.getDoctor(d.getId());
            if (!e.isEmpty()){
                if(d.getName()!=null){e.get().setName(d.getName());}
                if(d.getDepartment()!=null){e.get().setDepartment(d.getDepartment());}
                if(d.getYear()!=null){e.get().setYear(d.getYear());}
                if(d.getDescription()!=null){e.get().setDescription(d.getDescription());}
                if(d.getSpecialty()!=null){e.get().setSpecialty(d.getSpecialty());}

                doctorRepository.save(e.get());
                return e.get();
            }else {return d;}
        }else {return d;}
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Doctor> e=doctorRepository.getDoctor(id);
        if(e.isPresent()){
            doctorRepository.delete(e.get());
            flag = true;
        }


        return flag;
    }

}
