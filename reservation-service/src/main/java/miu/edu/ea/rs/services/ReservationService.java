package miu.edu.ea.rs.services;

import edu.miu.ea.cm.Airline;
import edu.miu.ea.cm.Reservation;
import edu.miu.ea.cm.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {

public Page<Reservation> allReservations(Pageable pageable);

public Optional<Reservation> oneReservation(int id);

public void deleteReservation(int id);

public Reservation saveReservation(Reservation reservation);

public Reservation updateReservation(int id, Reservation reservation);

public Reservation getOneReservationByPassenger(int pid, int rid);

public List<Reservation> getAllReservationsByPassenger(int pid);

public Reservation cancelReservation(int rid);

public List<Ticket> payReservation(int id);

public List<Reservation> allReservationsByagent();

        }
