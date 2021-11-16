package edu.miu.ea.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.ea.rs.model.Passenger;

@Repository
@Transactional
public interface PassangerRepository extends JpaRepository<Passenger, Integer> {

}
