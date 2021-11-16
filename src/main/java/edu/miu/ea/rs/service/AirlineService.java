package edu.miu.ea.rs.service;

import edu.miu.ea.rs.model.Airline;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AirlineService {
    List<Airline> allAirlines();
    Airline saveAirline(Airline airline);
    Airline findByAirlineCode(String airlinecode);
    List<Airline> findByAirportCode(String airportcode);
    Airline findById(int id);
    Airline updateAirline(Airline newAirline,int id);
    void deleteAirline(int id);
}
