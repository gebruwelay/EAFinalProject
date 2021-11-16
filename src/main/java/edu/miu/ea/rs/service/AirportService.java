package edu.miu.ea.rs.service;

import java.util.List;
import java.util.Optional;

import edu.miu.ea.rs.model.Airport;

public interface AirportService {
	
	public List<Airport> allAirports();
	
	public Optional<Airport> oneAirport(int id);
	
	public void deleteAirport(int id);
	
	public Airport saveAirport(Airport airport);
	
	public Airport updateAirport(int id, Airport airport);
	
	
}
