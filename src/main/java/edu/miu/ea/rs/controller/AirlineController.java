package edu.miu.ea.rs.controller;

import java.net.URI;
import java.util.List;

import edu.miu.ea.rs.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import lombok.Data;
import edu.miu.ea.rs.model.Airline;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Data
@RequestMapping("/api/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping
    public List<Airline> allAirlines() {
        return airlineService.allAirlines();
    }

    @GetMapping("/{airportcode}")
    public ResponseEntity<?>  findByAiportCode(@PathVariable String airportcode) {
    	System.out.println("---- in findbyairport code"+airportcode);
    	Airline airlines=airlineService.findByAirlineCode(airportcode);
        System.out.println("====> in findbyairport code"+airlines);
        if(airlines==null)
            return new ResponseEntity<>("airlines not found by the given airportcode",HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(airlines,HttpStatus.OK);

    }

    @PostMapping()
    @PreAuthorize("hasAnyAuthority('Role_Admin')")
    public ResponseEntity<Airline> saveAirline(@RequestBody Airline airline) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/airlines/create").toUriString());
        return ResponseEntity.created(uri).body(airlineService.saveAirline(airline));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Role_Admin')")
    ResponseEntity<?> updateAirline(@RequestBody Airline newAirline, @PathVariable int id) {

        Airline airline1 = airlineService.updateAirline(newAirline, id);
        if (airline1 == null)
            return new ResponseEntity<>("Id not found",HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(airline1, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Role_Admin')")
    void deleteAirline(@PathVariable int id) {
        airlineService.deleteAirline(id);
    }

}
