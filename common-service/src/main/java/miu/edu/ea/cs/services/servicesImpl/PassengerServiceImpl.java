package miu.edu.ea.cs.services.servicesImpl;

import edu.miu.ea.cm.Passenger;
import miu.edu.ea.cs.repository.PassengerRepository;
import miu.edu.ea.cs.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerRepository passengerRepository;
    @Override
    public Page<Passenger> findAllPassengers(Pageable pageable) {
        return passengerRepository.findAll(pageable);
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Optional<Passenger> findById(long id) {
        return passengerRepository.findById(id);
    }

    @Override
    public Passenger updatePassenger(Passenger passenger, int id) {

        Optional<Passenger> existingPassenger = findById(id);
        Passenger passenger2 = existingPassenger.orElse(null);
        if (passenger2 != null) {
            passenger2.setFirstName(passenger.getFirstName());
            passenger2.setLastName(passenger.getLastName());
            passenger2.setDoB(passenger.getDoB());
            passenger2.setAddress(passenger.getAddress());
            return passengerRepository.save(passenger2);
        }
        return null;
    }

    @Override
    public void deletePassenger(long id) {
        passengerRepository.deleteById(id);
    }
}
