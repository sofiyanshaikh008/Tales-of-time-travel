package com.masai.Entity;

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
	private Integer userLoginId;
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private long contact;
	
	private String email;
	
	@OneToOne
	private Reservation reservation;
}
