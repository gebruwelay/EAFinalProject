package edu.miu.ea.rs.service;

import java.util.List;
import java.util.Optional;

import edu.miu.ea.rs.repository.AirPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.ea.rs.model.Airport;

@Service
public class AirportServiceImp implements AirportService{

	@Autowired
	private AirPortRepository repository;
	
	public List<Airport> allAirports(){
		return repository.findAll();
	}
	
	public Airport saveAirport(Airport airport) {
		return repository.save(airport);
	}

	@Override
	public Optional<Airport> oneAirport(int id) {
		return repository.findById(id);
	}

	@Override
	public void deleteAirport(int id) {
		 repository.deleteById(id);
	}


	@Override
	public Airport updateAirport(int id, Airport airport) {
		Optional<Airport> airport2 = oneAirport(id);
		Airport existingAirport = airport2.orElse(null);
		existingAirport.setAddress(airport.getAddress());
		existingAirport.setCode(airport.getCode());
		existingAirport.setName(airport.getName());
		saveAirport(existingAirport);
		return airport;
	}

}
