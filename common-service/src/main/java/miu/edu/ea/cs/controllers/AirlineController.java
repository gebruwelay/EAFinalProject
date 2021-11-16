package miu.edu.ea.cs.controllers;

import edu.miu.ea.cm.Airline;
import edu.miu.ea.cm.Airport;
import lombok.Data;
import miu.edu.ea.cs.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Data
@RequestMapping("/api/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;
    @GetMapping
    public Page<Airline> allAirlines(Pageable pageable) {
        return airlineService.findAllAirlines(pageable);
    }

    @GetMapping("/{airportCode}")
    public ResponseEntity<?> findByAirportCode(@PathVariable String airportCode) {
        List<Airline> airlines = airlineService.findByAirportCode(airportCode);
        if(airlines==null)
            return new ResponseEntity<>("airlines not found by the given airport code", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(airlines,HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public Optional<Airline> findOneAirline(@PathVariable long id){
//        return airlineService.findById(id);
//    }

    @PostMapping()
    public ResponseEntity<Airline> addAirline(@RequestBody Airline airline) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/airlines/create").toUriString());
        return ResponseEntity.created(uri).body(airlineService.saveAirline(airline));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateAirline(@RequestBody Airline newAirline, @PathVariable long id) {
        Airline airline1 = airlineService.updateAirline(newAirline, id);
        if (airline1 == null)
            return new ResponseEntity<>("Id not found",HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(airline1, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    void deleteAirline(@PathVariable long id) {
        airlineService.deleteAirline(id);
    }
}
