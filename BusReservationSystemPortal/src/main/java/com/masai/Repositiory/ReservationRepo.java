package com.masai.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entity.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer>{

}
