package miu.edu.ea.cs.service;

import java.util.List;
import java.util.Optional;

import miu.edu.ea.cs.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.edu.ea.cs.model.Airline;
import org.springframework.transaction.annotation.Transactional;


@Service
@Data
@Transactional
public class AirlineServiceImp implements AirlineService{

	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private AirportService airportService;
	
	public List<Airline> allAirlines(){
		return airlineRepository.findAll();
	}
	
	public Airline saveAirline(Airline airline) {
		return airlineRepository.save(airline);
	}

//	public List<Airline> findByAirlineCode(String airportcode) {
//		return repository.findByAiportCode(airportcode);
//	}


	public Airline findById(int id) {
		return airlineRepository.findById(id).orElse(null);
	}

	@Override
	public Airline updateAirline(Airline airline, int id) {
		Optional<Airline> updatedairline= Optional.ofNullable(findById(id));
		Airline airline2=updatedairline.orElse(null);
		if(airline2!=null){
			airline2.setCode(airline.getCode());
			airline2.setName(airline.getName());
			airline2.setHistory(airline.getHistory());
			return airlineRepository.save(airline2);
		}
		return  null;

	}


	public void deleteAirline(int id) {
		airlineRepository.deleteById(id);
	}

//	@Override
//	public Airline findByAirLineCode(String airlinecode) {
//		return airlineRepository.findByAirlineCode(airlinecode);
//	}

//	@Override
//	public List<Airport> findByAirportCode(String airportcode) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Airline findByAirlineCode(String airlinecode) {
		return airlineRepository.findByAirlineCode(airlinecode);
	}

	@Override
	public List<Airline> findByAirportCode(String airportcode) {
		return airlineRepository.findByAiportCode(airportcode);
	}

//	@Override
//	public Airline findByAirLineCode(String airportcode) {
//		return repository.findByAirlineCode(airportcode);
//	}

//	@Override
//	public List<Airport> findByAirportCode(String airportcode) {
//		return repository.findByAiportCode(airportcode);
//	}


}
