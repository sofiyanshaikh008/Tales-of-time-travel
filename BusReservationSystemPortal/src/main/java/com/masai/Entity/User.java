package com.masai.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private long contact;
	
	@Column(unique = true)
	private String email;
	
	@OneToOne
	private Reservation reservation;
	
}
