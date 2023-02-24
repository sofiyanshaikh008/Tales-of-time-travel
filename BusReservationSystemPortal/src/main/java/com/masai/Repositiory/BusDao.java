package com.masai.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entity.Bus;

@Repository
public interface BusDao extends JpaRepository<Bus, Integer> {

}
