package edu.miu.ea.rs.controller;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import edu.miu.ea.rs.service.FlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import lombok.Data;
import edu.miu.ea.rs.dto.FlightDTO;
import edu.miu.ea.rs.model.Flight;

@RestController
@Data
@RequestMapping("/api/flights")
public class FlightController {

	@Autowired
	private FlightServices flightService;
	

	@PostMapping()
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	public ResponseEntity<?> saveFlight(@RequestBody FlightDTO flightDTO) {
		System.out.println("controller flight DTO"+flightDTO);
		Flight flight1=flightService.saveFlight(flightDTO);
		if(flight1!=null){
			return  new ResponseEntity<>(flight1,HttpStatus.OK);
		}
		else
			return  new ResponseEntity<>("Not valid flight to save",HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<?> searchflightbydepartue(@RequestParam(name = "departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate, @RequestParam(name = "departureAirport") String departureAirport, @RequestParam(name = "arrivalAirport") String arrivalAirport) {
		System.out.println(departureDate+" "+departureAirport+" "+ arrivalAirport);
		Collection<Flight> flightslist= flightService.searchFlightbyDepartureandDestination(departureDate,departureAirport,arrivalAirport);
	 	if(flightslist!=null) {
	 		System.out.println("------>>>");
	 		System.out.println(flightslist);
	 		return new ResponseEntity<>(flightslist.stream().collect(Collectors.toList()), HttpStatus.OK);
	 	}
	 		else {
	 			System.out.println("------<<<");
	 			return new ResponseEntity<>("NO Flight Found", HttpStatus.NOT_FOUND);
	 		}
				
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	public void deleteFlight(@PathVariable int id){
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		flightService.deleteFlight(id);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	public ResponseEntity<?>editFlight(@PathVariable int id,@RequestBody FlightDTO flightDTO){
		Flight flight1= flightService.updateFlight(flightDTO, id);
		if(flight1!=null){
			return  new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return  new ResponseEntity<>("Not valid flight to edit",HttpStatus.NOT_FOUND);


	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Flight> getAllFlights(){
		return flightService.allFlights();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Flight getFlightById(@PathVariable int id) {
		return flightService.getFlightById(id);
	}


}
