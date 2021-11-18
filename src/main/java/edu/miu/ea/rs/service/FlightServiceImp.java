package edu.miu.ea.rs.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import edu.miu.ea.rs.model.Airline;
import edu.miu.ea.rs.model.Airport;
import edu.miu.ea.rs.model.Flight;
import edu.miu.ea.rs.repository.FlightRepository;
import edu.miu.ea.rs.dto.FlightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class FlightServiceImp implements FlightServices {

    @Autowired
    private FlightRepository repository;
    @Autowired
    private AirlineService airlineService;
@Autowired
private AirportService airportService;
    public List<Flight> allFlights() {
        return repository.findAll();
    }


    public Flight saveFlight(FlightDTO flightDTO) {
        Flight flight= new Flight();
        System.out.println("dto recived"+ flightDTO);
        if(flightDTO!=null) {
        	System.out.println("1"+airlineService.findByAirlineCode(flightDTO.getAirlineCode()));
            Airline airline = (Airline) airlineService.findByAirlineCode(flightDTO.getAirlineCode());
            System.out.println("2");
            Optional<Airport> arrivalAirport = airportService.oneAirport(flightDTO.getArrivalAirport());
            System.out.println("3");
            Optional<Airport> departureAirport = airportService.oneAirport(flightDTO.getDepartureAirport());
            System.out.println("4");
            if (arrivalAirport != null && departureAirport != null && airline!=null) {

                flight.setCapacity(flightDTO.getCapacity());
                flight.setPrice(flightDTO.getPrice());
                flight.setFlightNumber(flightDTO.getFlightNumber());
                flight.setAvailableSeat(flightDTO.getAvailableSeat());
                flight.setDepartureTime(flightDTO.getDepartureTime());
                flight.setArrivalTime(flightDTO.getArrivalTime());
                flight.setDepartureAirport(departureAirport.get());
                flight.setArrivalAirport(arrivalAirport.get());
                flight.setAirline(airline);
                
                System.out.println("flight sent is"+ flight);
                
                return repository.save(flight);
            }
            //todo need airport by code now it oworks by ID

        }
        return null;
    }

    @Override
    public List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String arrivalAirport) {
        return repository.searchFlightbyDepartureandDestination(departureDate,departureAirport,arrivalAirport);
    }

    @Override
    public Flight editFlight(int id,Flight flight) {

        Flight flight2= getFlightById(id);

        if (flight2 != null) {
          flight2.setFlightNumber(flight.getFlightNumber());
          flight2.setAirline(flight.getAirline());
          flight2.setCapacity(flight.getCapacity());
          flight2.setArrivalAirport(flight.getArrivalAirport());
          flight2.setAirline(flight.getAirline());
          flight2.setArrivalTime(flight.getArrivalTime());
          flight2.setDepartureAirport(flight.getDepartureAirport());
          flight2.setDepartureTime(flight.getDepartureTime());
          flight2.setPrice(flight.getPrice());

            return repository.save(flight2);
        }
        return null;
    }
    
    	@Override
    	public Flight updateFlight(FlightDTO flightDTO, int id) {
    		Flight flight= getFlightById(id);
        
        System.out.println("dto recived"+ flightDTO);
        if(flightDTO!=null && flight!=null) {
        	System.out.println("1"+airlineService.findByAirlineCode(flightDTO.getAirlineCode()));
            Airline airline = (Airline) airlineService.findByAirlineCode(flightDTO.getAirlineCode());
            System.out.println("2");
            Optional<Airport> arrivalAirport = airportService.oneAirport(flightDTO.getArrivalAirport());
            System.out.println("3");
            Optional<Airport> departureAirport = airportService.oneAirport(flightDTO.getDepartureAirport());
            System.out.println("4");
            if (arrivalAirport != null && departureAirport != null && airline!=null) {

                flight.setCapacity(flightDTO.getCapacity());
                flight.setPrice(flightDTO.getPrice());
                flight.setFlightNumber(flightDTO.getFlightNumber());
                flight.setAvailableSeat(flightDTO.getAvailableSeat());
                flight.setDepartureTime(flightDTO.getDepartureTime());
                flight.setArrivalTime(flightDTO.getArrivalTime());
                flight.setDepartureAirport(departureAirport.get());
                flight.setArrivalAirport(arrivalAirport.get());
                flight.setAirline(airline);
                
                System.out.println("flight sent is"+ flight);
                
                return repository.save(flight);
            }
            //todo need airport by code now it oworks by ID

        }
        return null;
    }

    @Override
    public Flight getFlightById (int flightid) {
        return  repository.findById(flightid).orElse(null);
    }

    @Override
    public void deleteFlight(int fid) {
        repository.deleteById(fid);
    }


	@Override
	public void deleteFlightById(int fid) {
		repository.deleteFlightById(fid);	
	}


	


}
