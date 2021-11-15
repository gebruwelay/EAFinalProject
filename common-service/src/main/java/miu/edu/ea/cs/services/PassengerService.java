package miu.edu.ea.cs.services;

import edu.miu.ea.cm.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Page<Passenger> findAllPassengers(Pageable pageable);
    Passenger savePassenger(Passenger passenger);
    Optional<Passenger> findById(long id);
    Passenger updatePassenger(Passenger passenger, int id);
    void deletePassenger(long id);
}
