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

//@Service
//@Transactional
//public class FlightServiceImpl implements FlightService {
//    @Autowired
//    private FlightRepository repository;
//    @Autowired
//    private AirlineService airlineService;
//    @Autowired
//    private AirportService airportService;
//
//    public List<Flight> allFlights() {
//        return repository.findAll();
//    }
//
//
//    public Flight saveFlight(Flight flight) {
//        Flight flight1= new Flight();
//        System.out.println("dto recived"+ flight);
//        if(flight!=null) {
//            System.out.println("1"+airlineService.findByAirlineCode(flight.getAirlineCode()));
//            Airline airline = (Airline) airlineService.findByAirlineCode(flight.getAirlineCode());
//            System.out.println("2");
//            Optional<Airport> arrivalAirport = airportService.oneAirport(flight.getArrivalAirport());
//            System.out.println("3");
//            Optional<Airport> departureAirport = airportService.oneAirport(flight.getDepartureAirport());
//            System.out.println("4");
//            if (arrivalAirport != null && departureAirport != null && airline!=null) {
//
//                flight.setCapacity(flight.getCapacity());
//                flight.setPrice(flight.getPrice());
//                flight.setFlightNumber(flight.getFlightNumber());
//                flight.setAvailableSeat(flight.getAvailableSeat());
//                flight.setDepartureTime(flight.getDepartureTime());
//                flight.setArrivalTime(flight.getArrivalTime());
//                flight.setDepartureAirport(departureAirport.get());
//                flight.setArrivalAirport(arrivalAirport.get());
//                flight.setAirline(airline);
//
//                System.out.println("flight sent is"+ flight);
//
//                return repository.save(flight);
//            }
//            //todo need airport by code now it oworks by ID
//
//        }
//        return null;
//    }
//
//    @Override
//    public List<Flight> searchFlightbyDepartureandDestination(LocalDateTime departureDate, String departureAirport, String arivalAirport) {
//        return repository.searchFlightbyDepartureandDestination(departureDate,departureAirport,arivalAirport);
//    }
//
//    @Override
//    public Flight editFlight(int id,Flight flight) {
//
//        Flight flight2= getFlightById(id);
//
//        if (flight2 != null) {
//            flight2.setFlightNumber(flight.getFlightNumber());
//            flight2.setAirline(flight.getAirline());
//            flight2.setCapacity(flight.getCapacity());
//            flight2.setArrivalAirport(flight.getArrivalAirport());
//            flight2.setAirline(flight.getAirline());
//            flight2.setArrivalTime(flight.getArrivalTime());
//            flight2.setDepartureAirport(flight.getDepartureAirport());
//            flight2.setDepartureTime(flight.getDepartureTime());
//            flight2.setPrice(flight.getPrice());
//
//            return repository.save(flight2);
//        }
//        return null;
//    }
//
//    @Override
//    public Flight updateFlight(Flight fligh, int id) {
//        Flight flight= getFlightById(id);
//
//        System.out.println("dto recived"+ fligh);
//        if(fligh!=null && flight!=null) {
//            System.out.println("1"+airlineService.findByAirlineCode(fligh.getAirlineCode()));
//            Airline airline = (Airline) airlineService.findByAirlineCode(fligh.getAirlineCode());
//            System.out.println("2");
//            Optional<Airport> arrivalAirport = airportService.oneAirport(fligh.getArrivalAirport());
//            System.out.println("3");
//            Optional<Airport> departureAirport = airportService.oneAirport(fligh.getDepartureAirport());
//            System.out.println("4");
//            if (arrivalAirport != null && departureAirport != null && airline!=null) {
//
//                flight.setCapacity(fligh.getCapacity());
//                flight.setPrice(fligh.getPrice());
//                flight.setFlightNumber(fligh.getFlightNumber());
//                flight.setAvailableSeat(fligh.getAvailableSeat());
//                flight.setDepartureTime(fligh.getDepartureTime());
//                flight.setArrivalTime(fligh.getArrivalTime());
//                flight.setDepartureAirport(departureAirport.get());
//                flight.setArrivalAirport(arrivalAirport.get());
//                flight.setAirline(airline);
//
//                System.out.println("flight sent is"+ flight);
//
//                return repository.save(flight);
//            }
//            //todo need airport by code now it oworks by ID
//
//        }
//        return null;
//    }
//
//    @Override
//    public Flight getFlightById (int flightid) {
//        return  repository.findById(flightid).orElse(null);
//    }
//
//    @Override
//    public void deleteFlight(int fid) {
//        repository.deleteById(fid);
//    }
//
//
//    @Override
//    public void deleteFlightById(int fid) {
//        repository.deleteFlightById(fid);
//    }
//
//
//
//

    //}
