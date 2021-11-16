package miu.edu.ea.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import miu.edu.ea.cs.model.Passenger;

@Repository
@Transactional
public interface PassangerRepository extends JpaRepository<Passenger, Integer> {

}
