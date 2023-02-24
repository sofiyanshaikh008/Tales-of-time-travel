package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Entity.Reservation;
import com.masai.exception.ReservationException;
import com.masai.repository.ReservationDao;

public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private BusDao bdao;
	
	@Autowired
	private SessionRepo srepo;
	
	@Autowired
	private UserRepo uRepo;
	

	@Override
	public Reservation addNewReservation(Integer busId, Reservation reservation, String key)
			throws ReservationException, BusException, UserException {
		// TODO Auto-generated method stub
		reservationDao.save(reservation);
		return null;
	}

	@Override
	public Reservation updateReservation(Reservation reservation, String key)
			throws ReservationException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation DeleteReservation(Integer reservationId, String key) throws ReservationException, userException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation viewReservationById(Integer reservationid, String key)
			throws ReservationException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> viewAllReservation(String key) throws ReservationException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getAllReservationByDate(LocalDate date, String key)
			throws ReservationException, userException {
		// TODO Auto-generated method stub
		return null;
	}

}
