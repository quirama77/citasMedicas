package com.citasmedicas.citas.service;

import com.citasmedicas.citas.entities.*;
import com.citasmedicas.citas.repository.ReservationRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    public List<Reservation> getAll(){return reservationRepository.getAll();}


    public Optional<Reservation> getReservation(int id){return reservationRepository.getReservation(id);}


    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){

            return reservationRepository.save(r);

        }else {
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if(e.isPresent()){
                return r;

            }else {return reservationRepository.save(r);}
        }

    }

    public Reservation update(Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if (!e.isEmpty()){

                if(r.getStartDate()!=null){e.get().setStartDate(r.getStartDate());}
                if (r.getDevolutionDate()!=null){e.get().setDevolutionDate(r.getDevolutionDate());}
                if (r.getDoctor()!=null){e.get().setDoctor(r.getDoctor());}
                if (r.getClient()!=null){e.get().setClient(r.getClient());}

                reservationRepository.save(e.get());
                return e.get();
            }else {return r;}
        }else {return r;}
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Reservation> e= reservationRepository.getReservation(id);
        if(e.isPresent()){
            reservationRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }

    public ReservationCount getReportStatus(){
        List<Reservation>completed=reservationRepository.getReportStatus("completed");
        List<Reservation>cancelled=reservationRepository.getReportStatus("cancelled");

        return new ReservationCount(completed.size(),cancelled.size());

    }



    public List<Reservation> getReservationPeriod(String a, String b){

        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date date1= new Date();
        Date date2=new Date();
        try {
            date1 = parser.parse(a);
            date2 = parser.parse(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(date1.before(date2)){
            return reservationRepository.getReservationPeriod(date1,date2);
        }else return new ArrayList<>();
    }

    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }


}
