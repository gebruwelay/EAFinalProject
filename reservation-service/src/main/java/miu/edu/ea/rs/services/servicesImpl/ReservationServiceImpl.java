package miu.edu.ea.rs.services.servicesImpl;


import edu.miu.ea.cm.*;
import edu.miu.ea.cm.enums.ReservationStatus;
import miu.edu.ea.cs.services.TicketService;
import miu.edu.ea.cs.services.UserService;
import miu.edu.ea.rs.repository.ReservationRepository;
import miu.edu.ea.rs.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Override
    public Page<Reservation> allReservations(Pageable pageable) {
        // TODO Auto-generated method stub
        return reservationRepository.findAll(pageable);
    }

    @Override
    public Optional<Reservation> oneReservation(int id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {

        return reservationRepository.save(reservation);
    }


    @Override
    public Reservation updateReservation(int id, Reservation reservation) {
        Reservation reservation2 = oneReservation(id).orElse(null);
        if(reservation2!=null) {
            reservation2.setCode(reservation.getCode());
            reservation2.setReservationDate(reservation.getReservationDate());
            reservation2.setTotalPrice(reservation.getTotalPrice());
            reservation2.setReservationStatus(reservation.getReservationStatus());
            reservation2.setActiveFlights(reservation.getActiveFlights());
            reservation2.setPassenger(reservation.getPassenger());
            reservation2.setTickets(reservation.getTickets());
            reservation2.setUser(reservation.getUser());
            //reservation2.setFlightList(reservation.getFlightList());
            saveReservation(reservation2);
            return reservation2;
        }
        return null;
    }

    @Override
    public Reservation getOneReservationByPassenger(int pid, int rid) {
        // TODO Auto-generated method stub
        return reservationRepository.getOneReservationByPassenger(pid, rid);
    }

    @Override
    public List<Reservation> getAllReservationsByPassenger(int pid) {
        // TODO Auto-generated method stub
        return reservationRepository.getAllReservationsByPassenger(pid);
    }

    @Override
    public Reservation cancelReservation(int rid) {
        Reservation reservation  = oneReservation(rid).orElse(null);
        if(reservation!=null) {reservation.setReservationStatus(ReservationStatus.CANCELLED);
            return saveReservation(reservation);
        }
        return null;

    }

    @Override
    public List<Ticket> payReservation(int id) {
        Reservation reservation = oneReservation(id).orElse(null);
        if(reservation!=null) {
            List<Ticket> tickets = new ArrayList<>();

            List<ActiveFlight> flights = reservation.getActiveFlights();
            Passenger passenger = reservation.getPassenger();
            reservation.setReservationStatus(ReservationStatus.CONFIRMED);
            //double totalPayment = 0.0;
            for(ActiveFlight f: flights) {
                Ticket ticket = new Ticket();
                ticket.setTicketNumber(randomString());
                ticket.setFlightId(f.getFlight().getFlightNumber());
                ticket.setPassengerId(passenger.getId());
                ticket.setReservationCode(reservation.getCode());
                ticket.setFlightDate(f.getDepartureDate());
                tickets.add(ticket);

                ///////////////////// don't forget to uncomment this line......................................................................................
                ticketService.saveTicket(ticket);
                //totalPayment+=f.getPrice();
            }
            //System.out.println("totl price is"+totalPayment);
            //reservation.setTotalPrice(totalPayment);
            reservation.setTickets(tickets);
            saveReservation(reservation);
            return tickets;
        }
        return null;
    }


    private String randomString() {
        char[] CHARSET_AZ_09 = "0123456789".toCharArray();
        int length = 20;
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(CHARSET_AZ_09.length);
            result[i] = CHARSET_AZ_09[randomCharIndex];
        }
        return new String(result);
    }

    @Override
    public List<Reservation> allReservationsByagent() {
//        User loggedInUser = userService.getLoggedInUser();
//
//        System.out.println("from reservation service loegged in user"+loggedInUser);
//        List<Role> roles = (List<Role>) loggedInUser.getRoles();
//        List<Role> agentRole = roles.stream().filter(r -> r.getName().equals("Role_Agent")).collect(Collectors.toList());
//        if(loggedInUser!=null && !agentRole.isEmpty()) {
//            System.out.println("here---++");
//            return reservationRepository.getAllReservationsByAgent(loggedInUser.getId());
//        }
        return null;
    }

//
}

