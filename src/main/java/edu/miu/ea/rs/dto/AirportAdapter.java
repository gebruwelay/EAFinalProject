package edu.miu.ea.rs.dto;

import edu.miu.ea.rs.model.Address;
import edu.miu.ea.rs.model.Airport;
import org.springframework.stereotype.Component;

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
