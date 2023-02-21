package com.masai.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@NotNull(message = "Admin name is mandatory")
	@NotEmpty(message = "Admin name should not be empty")
	@Size(min = 2, max = 30, message = "Name should contain atleast 2 characters and atmost 30")
	private String userName;
	
	
	@NotNull(message = "Admin name is mandatory")
	@NotEmpty(message = "Admin name should not be empty")
	
	//@Pattern()
	private String password;
}
