package miu.edu.ea.cs.services;

import edu.miu.ea.cm.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<Flight> allFlights();

    Flight saveFlight(Flight flight);

    List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String destinationAirport);
    //TODO
    Flight editFlight(int id,Flight flight);


    void deleteFlight(int fid);

    void deleteFlightById(int fid);

    Flight getFlightById(int flightid);

    public Flight updateFlight(Flight flight, int id);


}
