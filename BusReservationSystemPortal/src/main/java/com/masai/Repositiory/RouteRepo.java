package com.masai.Repositiory;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Route;

public interface RouteRepo extends JpaRepository<Route, Integer> {

	public Route findByRouteFromAndRouteTo(String from, String To);
	
}