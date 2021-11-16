package miu.edu.ea.cs.service;

import miu.edu.ea.cs.dto.FlightDTO;
import miu.edu.ea.cs.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightServices {


    List<Flight> allFlights();

    Flight saveFlight(FlightDTO flightDTO);

    List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String destinationAirport);
        //TODO
    Flight editFlight(int id,Flight flight);


    void deleteFlight(int fid);
    
    void deleteFlightById(int fid);

    Flight getFlightById(int flightid);

    public Flight updateFlight(FlightDTO flightDTO, int id);
    
    
    

}
