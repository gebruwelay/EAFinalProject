package miu.edu.ea.cs.repository;

import edu.miu.ea.cm.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    @Query("select a from Airline a where a.code=:airlineCode")
    Airline findByAirlineCode(String airlineCode);

  //  @Query("select f.airline from Flight f where f.departureAirport.code=:airportcode")
   // List<Airline> findByAiportCode(String airportcode);
}
