package com.masai.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Bus;

public interface BusRepo extends JpaRepository<Bus, Integer> {

}
