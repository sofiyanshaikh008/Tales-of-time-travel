package com.masai.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	
	private String routeFrom;
	
	private String routeTo;
	
	private Integer distance;
	
	@OneToMany
	private List<Bus> buslist;
}
