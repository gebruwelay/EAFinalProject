package miu.edu.ea.cs.service;

import java.util.List;
import java.util.Optional;

import miu.edu.ea.cs.model.Airport;

public interface AirportService {
	
	public List<Airport> allAirports();
	
	public Optional<Airport> oneAirport(int id);
	
	public void deleteAirport(int id);
	
	public Airport saveAirport(Airport airport);
	
	public Airport updateAirport(int id, Airport airport);
	
	
}
