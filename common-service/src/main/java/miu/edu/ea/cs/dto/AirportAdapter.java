package miu.edu.ea.cs.dto;

import org.springframework.stereotype.Component;


import miu.edu.ea.cs.model.Address;
import miu.edu.ea.cs.model.Airport;
@Component
public class AirportAdapter {

	
	public Airport DTOtoAirport(AirportDTO addressDTO) {
		Airport airport = new Airport();
		Address address = new Address();
		airport.setCode(addressDTO.getCode());
		airport.setName(addressDTO.getName());
		address.setCity(addressDTO.getCity());
		address.setStreet(addressDTO.getStreet());
		address.setZip(addressDTO.getZip());
		address.setState(addressDTO.getState());
		airport.setAddress(address);
		return airport;
	}
}
