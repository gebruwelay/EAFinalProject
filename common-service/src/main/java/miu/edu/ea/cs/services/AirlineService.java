package miu.edu.ea.cs.services;

import edu.miu.ea.cm.Airline;
import edu.miu.ea.cm.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AirlineService {
    Page<Airline> findAllAirlines(Pageable pageable);
    Airline saveAirline(Airline airline);
    Airline findByAirlineCode(String airlinecode);
    List<Airline> findByAirportCode(String airportcode);
    Optional<Airline> findById(long id);
    Airline updateAirline(Airline newAirline,int id);
    void deleteAirline(long id);
}
