package miu.edu.ea.cs.services;

import edu.miu.ea.cm.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    public List<Airport> allAirports();

    public Optional<Airport> oneAirport(long id);

    public void deleteAirport(long id);

    public Airport saveAirport(Airport airport);

    public Airport updateAirport(long id, Airport airport);


}
