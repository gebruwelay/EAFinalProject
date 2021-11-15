package miu.edu.ea.rs.controllers;


import edu.miu.ea.cm.Reservation;
import edu.miu.ea.cm.Ticket;
import miu.edu.ea.cs.services.UserService;
import miu.edu.ea.rs.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    //@PreAuthorize("hasAnyAuthority('Role_Admin')")
    public Page<Reservation> allReservations(Pageable pageable){

        return reservationService.allReservations(pageable);
    }

    @RequestMapping(value = "/{reservationId}", method = RequestMethod.GET)
    public Reservation oneReservation(@PathVariable int reservationId){
        return reservationService.oneReservation(reservationId).orElse(null);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
   // @PreAuthorize("hasAnyAuthority('Role_Admin','Role_Customer','Role_Agent')")
    public ResponseEntity<?> saveReservation(@RequestBody Reservation reservation) {
        System.out.println("=======================");
//        System.out.println(reservation);
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/passangers/create").toUriString());
//        Reservation reservation = reactiveAdapter.DTOtoEntity(reservation);
//        System.out.println("--------------------------");
//        System.out.println("==>"+reservation);
        Reservation savedReservation= reservationService.saveReservation(reservation);
        System.out.println("+++++"+savedReservation);
        return new ResponseEntity<Reservation>(savedReservation, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{rid}", method = RequestMethod.PUT)
   // @PreAuthorize("hasAnyAuthority('Role_Admin','Role_Customer','Role_Agent')")
    public ResponseEntity<?> updateReservation(@PathVariable int rid, @RequestBody Reservation updatedReservation) {
        Reservation reservation1 = oneReservation(rid);


//        if(reservation1!=null && reservation1.getUser().getId() == userService.getLoggedInUser().getId()) {
//            System.out.println("=======================");
//            System.out.println(updatedReservation);
//            Reservation reservation = reactiveAdapter.DTOtoEntity(updatedReservation);
//            System.out.println("--------------------------");
//            System.out.println("==>"+reservation);
//            Reservation updateReservation= reservationService.updateReservation(rid,reservation);
//            System.out.println("+++++"+updateReservation);
//
//            return new ResponseEntity<Reservation>(updateReservation, HttpStatus.ACCEPTED);
//
//
//        }
        if(reservation1 != null){
            Reservation updateReservation= reservationService.updateReservation(rid,updatedReservation);
            System.out.println("+++++"+updateReservation);

            return new ResponseEntity<Reservation>(updateReservation, HttpStatus.ACCEPTED);

        }

        return new ResponseEntity<>("your are attempting wrong update", HttpStatus.CONFLICT);


    }

    @RequestMapping(value = "/byPassanger/{pid}/reservations", method = RequestMethod.GET)
    public List<Reservation> getAllReservationsByPassenger(@PathVariable int pid) {
        return reservationService.getAllReservationsByPassenger(pid);
    }

    @RequestMapping(value = "/byPassanger/{pid}/reservations/{rid}", method = RequestMethod.GET)
    public Reservation getOneReservationByPassenger(@PathVariable int pid,@PathVariable int rid) {
        return reservationService.getOneReservationByPassenger(pid, rid);
    }

    @RequestMapping(value = "/{id}/cancel", method = RequestMethod.DELETE)
    public Reservation cancelReservation(@PathVariable int rid) {
        return reservationService.cancelReservation(rid);
    }

    @RequestMapping(value = "/{rid}", method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable int rid) {
        reservationService.deleteReservation(rid);
    }

    @RequestMapping(value = "/{rid}/pay", method = RequestMethod.POST)
    public List<Ticket> payReservation(@PathVariable int rid) {
        return reservationService.payReservation(rid);
    }

    @RequestMapping(value = "/agent", method = RequestMethod.GET)
    public List<Reservation> getReservationsByAgent() {
        return reservationService.allReservationsByagent();
    }
}
