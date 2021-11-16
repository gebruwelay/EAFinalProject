package edu.miu.ea.rs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.miu.ea.rs.model.Reservation;
import edu.miu.ea.rs.model.Ticket;

@Service
public interface ReservationService {

	
public List<Reservation> allReservations();
	
	public Optional<Reservation> oneReservation(int id);
	
	public void deleteReservation(int id);
	
	public Reservation saveReservation(Reservation reservation);
	
	public Reservation updateReservation(int id, Reservation reservation);
	
	public Reservation getOneReservationByPassanger(int pid, int rid);
	
	public List<Reservation> getAllReservationsByPassanger(int pid);
	
	public Reservation cancelReservation(int rid);
	
	public List<Ticket> payReservation(int id);
	
	public List<Reservation> allReservationsByagent();
	
}
