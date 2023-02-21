package com.masai.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;

	private String reservationStatus;

	private String reservationType;

	private LocalDate reservationDate;

	private LocalTime reservationTime;

	private String source;

	private String destination;
	
	@OneToOne
	private Bus bus;
	
	@JsonIgnore
	@OneToOne
	private User user;
}