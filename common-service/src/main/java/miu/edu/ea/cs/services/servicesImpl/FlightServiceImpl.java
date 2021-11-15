package miu.edu.ea.cs.services.servicesImpl;

import edu.miu.ea.cm.Airline;
import edu.miu.ea.cm.Airport;
import edu.miu.ea.cm.Flight;
import miu.edu.ea.cs.repository.FlightRepository;
import miu.edu.ea.cs.services.AirlineService;
import miu.edu.ea.cs.services.AirportService;
import miu.edu.ea.cs.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository repository;
    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirportService airportService;

    public List<Flight> allFlights() {
        return repository.findAll();
    }

    public Flight saveFlight(Flight flight) {
        Flight flight1= new Flight();
        if(flight!=null) {
            System.out.println("1"+airlineService.findByAirlineCode(flight.getAirline().getCode()));
            Airline airline = (Airline) airlineService.findByAirlineCode(flight.getAirline().getCode());
            System.out.println("2");
            Optional<Airport> arrivalAirport = airportService.oneAirport(flight.getArrivalAirport().getId());
            System.out.println("3");
            Optional<Airport> departureAirport = airportService.oneAirport(flight.getDepartureAirport().getId());
            System.out.println("4");

            if (arrivalAirport.isPresent() && departureAirport.isPresent() && airline!=null) {

                flight1.setCapacity(flight.getCapacity());
                flight1.setPrice(flight.getPrice());
                flight1.setFlightNumber(flight.getFlightNumber());
                flight1.setAvailableSeat(flight.getAvailableSeat());
                flight1.setDepartureTime(flight.getDepartureTime());
                flight1.setArrivalTime(flight.getArrivalTime());
                flight1.setDepartureAirport(departureAirport.get());
                flight1.setArrivalAirport(arrivalAirport.get());
                flight1.setAirline(airline);
                System.out.println("flight sent is"+ flight);
                return repository.save(flight1);
            }

        }
        return null;
    }

    @Override
    public List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String arivalAirport) {
        return repository.searchFlightbyDepartureandDestination(departureDate,departureAirport,arivalAirport);
    }

    @Override
    public Flight editFlight(long id, Flight flight) {

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
    public Flight updateFlight(Flight flightNew, long id) {
        Flight flight= getFlightById(id);

        if(flight!=null && flight!=null) {
            System.out.println("1"+airlineService.findByAirlineCode(flight.getAirline().getCode()));
            Airline airline = (Airline) airlineService.findByAirlineCode(flight.getAirline().getCode());
            System.out.println("2");
            Optional<Airport> arrivalAirport = airportService.oneAirport(flight.getArrivalAirport().getId());
            System.out.println("3");
            Optional<Airport> departureAirport = airportService.oneAirport(flight.getDepartureAirport().getId());
            System.out.println("4");
            if (arrivalAirport.isPresent() && departureAirport.isPresent() && airline!=null) {

                flight.setCapacity(flightNew.getCapacity());
                flight.setPrice(flightNew.getPrice());
                flight.setFlightNumber(flightNew.getFlightNumber());
                flight.setAvailableSeat(flightNew.getAvailableSeat());
                flight.setDepartureTime(flightNew.getDepartureTime());
                flight.setArrivalTime(flightNew.getArrivalTime());
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
    public Flight getFlightById (long flightid) {
        return  repository.findById(flightid).orElse(null);
    }

    @Override
    public void deleteFlight(long fid) {
        repository.deleteById(fid);
    }

    @Override
    public void deleteFlightById(long fid) {
        repository.deleteFlightById(fid);
    }
}