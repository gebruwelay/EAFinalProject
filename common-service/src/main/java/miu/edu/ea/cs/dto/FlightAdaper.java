package miu.edu.ea.cs.dto;

import miu.edu.ea.cs.model.Flight;
import miu.edu.ea.cs.service.AirlineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FlightAdaper {
    @Autowired
    AirlineService airlineService;
    public static Flight getFlight(FlightDTO flightDTO){
//        Flight flight= new Flight();
//        if(flightDTO!=null){
//             Airline airline= airlineService.findByAiportCode(flightDTO.getAirlineCode());
//
//            Airport arrivalAirport;
//
//             Airport departureAirport;
//        }
        return null;

    }
    public static FlightDTO getflightDTO(){
        return null;
    }
    public static List<FlightDTO> getflightDTOList(){
        return null;
    }

}
