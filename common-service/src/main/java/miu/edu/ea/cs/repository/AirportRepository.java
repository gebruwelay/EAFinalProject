package miu.edu.ea.cs.repository;

import edu.miu.ea.cm.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Query("select distinct a from Airline a join Flight  f where f.departureAirport.code =:airportcode")
    List<Airport> findByAiportCode(String airportcode);



}
