package com.masai.Service;

import java.util.List;

import com.masai.Entity.Route;
import com.masai.Exception.RouteException;
import com.masai.Exception.UserException;

public interface RouteService {

	public Route addRoute(Route route,String key) throws RouteException, UserException;
	
	public Route updateRoute(Route route,String key) throws RouteException, UserException;
	
	public Route deleteRoute(Integer routeId,String key) throws RouteException, UserException;
	
	public Route viewRoute(Integer routeId,String key) throws RouteException, UserException;
	
	public List<Route> viewAllRoute(String key) throws RouteException, UserException;
	
	
	
	
}
