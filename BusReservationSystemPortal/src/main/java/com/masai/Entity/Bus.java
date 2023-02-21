package com.masai.Entity;

import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;
	
	@NotNull(message  = "Bus name can't be null")
	@NotEmpty(message = "Bus name can't be empty")
	@Size(min = 2, max = 30, message = "Bus name should have at least 2 and atmost 30 characters")
	private String busName;
	
	private String driverName;
	
	private String busType;
	
	private String routeForm;
	
	private String routeTo;
	
	private LocalTime arrivalTime;
	
	private LocalTime departureTime;
	
	private Integer seats;
	
	private Integer availabeSeats;
	
	@JsonIgnore
	@OneToOne
	private Reservation reser;
	
	@JsonIgnore
	@OneToOne(mappedBy = "bus")
	private Feedback feedback;
	
	@JsonIgnore
	@ManyToOne
	private Route route;
	
	
}
