package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.Entity.Reservation;

public interface ReservationService {

   public Reservation addNewReservation(Integer busId,Reservation reservation, String key)throws ReservationException, BusException, UserException;
	
   public Reservation updateReservation(Reservation reservation,String key) throws ReservationException,UserException;
   
   public Reservation DeleteReservation(Integer reservationId,String key) throws ReservationException, userException;
   
   public Reservation viewReservationById(Integer reservationid,String key) throws ReservationException, UserException;
   
   public List<Reservation> viewAllReservation(String key) throws ReservationException,UserException;
   
   public List<Reservation> getAllReservationByData(LocalDate data,String key) throws ReservationException,userException;
   
}






