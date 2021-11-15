package miu.edu.ea.cs.services.servicesImpl;

import edu.miu.ea.cm.Airport;
import miu.edu.ea.cs.repository.AirportRepository;
import miu.edu.ea.cs.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportRepository repository;

    public List<Airport> allAirports(){
        return repository.findAll();
    }

    public Airport saveAirport(Airport airport) {
        return repository.save(airport);
    }

    @Override
    public Optional<Airport> oneAirport(long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteAirport(long id) {
        repository.deleteById(id);
    }


    @Override
    public Airport updateAirport(long id, Airport airport) {
        Optional<Airport> airport2 = oneAirport(id);
        Airport ap = airport2.orElse(null);
        ap.setAddress(airport.getAddress());
        ap.setCode(airport.getCode());
        ap.setName(airport.getName());
        saveAirport(ap);
        return airport;
    }


}

