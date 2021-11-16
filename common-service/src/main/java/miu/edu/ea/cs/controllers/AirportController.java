package miu.edu.ea.cs.controllers;

import edu.miu.ea.cm.Airport;
import lombok.Data;
import miu.edu.ea.cs.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Data
@RequestMapping("/api/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Airport> allAirports(){
        return airportService.allAirports();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Airport addAirport(@RequestBody Airport airport) {
        System.out.println("==>"+ airport);
        return airportService.saveAirport(airport);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Airport updateAirport(@PathVariable long id, @RequestBody Airport airport) {
        return airportService.updateAirport(id, airport);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Airport> findOneAirport(@PathVariable long id){
        return airportService.oneAirport(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAirport(@PathVariable long id){
        airportService.deleteAirport(id);
        return new ResponseEntity("Airport deleted", HttpStatus.ACCEPTED);
    }
}
