package miu.edu.ea.cs.controller;

import java.util.List;


import miu.edu.ea.cs.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import lombok.Data;
import miu.edu.ea.cs.model.Passenger;

@RestController
@Data
@RequestMapping("/passangers")
public class PassangerController {

	@Autowired
	private PassengerService passengerService;

	@GetMapping
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	public List<Passenger> allPassangers(){
		return passengerService.allPassangers();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	public ResponseEntity<?> findById(@PathVariable int id){
		Passenger passenger= passengerService.findById(id).orElse(null);
		if(passenger==null){
			return new ResponseEntity<>("Passenger Id not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(passenger, HttpStatus.OK);
	}

	@PostMapping()
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	public ResponseEntity<Passenger> savePassanger(@RequestBody Passenger passanger) {
		//URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/passangers/create").toUriString());
		//return ResponseEntity.created(uri).body(passengerService.savePassanger(passanger));
		return new ResponseEntity<>(passengerService.savePassanger(passanger), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	ResponseEntity<?> updatePassenger(@RequestBody Passenger newPassenger, @PathVariable int id) {
		Passenger p1 = passengerService.updatePassenger(newPassenger,id);
		if (p1 == null)
			return new ResponseEntity<>("Id not found", HttpStatus.BAD_REQUEST);
		else return new ResponseEntity<>(p1, HttpStatus.OK);

	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	void deletePassenger(@PathVariable int id) {
		passengerService.deletePassenger(id);
	}
}
