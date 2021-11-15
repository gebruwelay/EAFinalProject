package miu.edu.ea.cs.services.servicesImpl;

import edu.miu.ea.cm.Airline;
import miu.edu.ea.cs.repository.AirlineRepository;
import miu.edu.ea.cs.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AirlineServiceImpl implements AirlineService {
    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public Page<Airline> findAllAirlines(Pageable pageable) {
        return airlineRepository.findAll(pageable);
    }

    @Override
    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public Airline findByAirlineCode(String airlinecode) {
        return airlineRepository.findByAirlineCode(airlinecode);
    }

    @Override
    public List<Airline> findByAirportCode(String airportcode) {
        return null;
                //airlineRepository.findByAiportCode(airportcode);
    }

    @Override
    public Optional<Airline> findById(long id) {
        return airlineRepository.findById(id);
    }

    @Override
    public Airline updateAirline(Airline airline, int id) {
        Optional<Airline> existingAirline = findById(id);
        Airline airline2 = existingAirline.orElse(null);
        if (airline2 != null) {
            airline2.setCode(airline.getCode());
            airline2.setName(airline.getName());
            airline2.setHistory(airline.getHistory());
            return airlineRepository.save(airline2);
        }
        return null;
    }

    @Override
    public void deleteAirline(long id) {
        airlineRepository.deleteById(id);
    }
}
