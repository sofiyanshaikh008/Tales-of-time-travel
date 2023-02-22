package com.masai.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackId;
	
	private Integer driverRating;
	
	private Integer serviceRating;
	
	private Integer overallRating;
	
	private String comments;
	
	private LocalDate feedbackDate;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Reservation reservation;
}
