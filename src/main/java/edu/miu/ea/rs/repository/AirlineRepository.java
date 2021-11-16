package edu.miu.ea.rs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.ea.rs.model.Airline;

import java.util.List;

@Repository
@Transactional
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

    @Query("select a from Airline a where a.code=:airlineCode")
    Airline findByAirlineCode(String airlineCode);
    
    @Query("select f.airline from Flight f where f.departureAirport.code=:airportcode")
    List<Airline> findByAiportCode(String airportcode);
}


