package miu.edu.ea.cs.service;

import miu.edu.ea.cs.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    List<Passenger> allPassangers();

    Passenger savePassanger(Passenger passanger);

    Optional<Passenger> findById(int id);

    Passenger updatePassenger(Passenger passenger, int id);

    void deletePassenger(int id);
}
