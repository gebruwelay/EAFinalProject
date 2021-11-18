package edu.miu.ea.rs.repository;

import edu.miu.ea.rs.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.ea.rs.model.Passenger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface PassangerRepository extends JpaRepository<Passenger, Integer> {
    @Query("select p from Reservation r join r.passenger p join r.flightList f where Date(f.departureTime)=:date")
    List<Passenger> findEmail(java.sql.Date date);
}
