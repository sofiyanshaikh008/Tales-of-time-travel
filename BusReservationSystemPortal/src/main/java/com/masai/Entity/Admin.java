package com.masai.Entity;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@Column(unique = true)
	@NotNull(message = "Admin name is mandatory")
	@NotEmpty(message = "Admin name should not be empty")
	@Size(min = 2, max = 30, message = "Name should contain atleast 2 characters and atmost 30")
	private String email;
	
	
	@NotNull(message = "Password is mandatory")
	@NotEmpty(message = "Password should not be empty")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles;
}
