package miu.edu.ea.cs.services;

import edu.miu.ea.cm.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<Flight> allFlights();

    Flight saveFlight(Flight flight);

    List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String destinationAirport);

    Flight editFlight(long id,Flight flight);

    void deleteFlight(long fid);

    void deleteFlightById(long fid);

    Flight getFlightById(long flightid);

    public Flight updateFlight(Flight flight, long id);


}
