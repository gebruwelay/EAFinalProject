package edu.miu.ea.rs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import java.time.LocalDateTime;



@Entity
@Data
@NoArgsConstructor
public class Flight implements Comparable<Flight>{
    //adding maximum reservation for every instance flight
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String flightNumber;
    private int capacity;
    @Transient
    private int availableSeat;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double price;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Airline airline;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Airport arrivalAirport;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Airport departureAirport;
    
    //add available seat in the counstructor
	public Flight(String flightNumber, int capacity, LocalDateTime departureTime, LocalDateTime arrivalTime, double price,
			Airline airline, Airport arrivalAirport, Airport departureAirport) {
		
		this.flightNumber = flightNumber;
		this.capacity = capacity;
		this.availableSeat = capacity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.airline = airline;
		this.arrivalAirport = arrivalAirport;
		this.departureAirport = departureAirport;
	}

	@Override
	public int compareTo(Flight o) {
		if (getDepartureTime() == null || o.getDepartureTime() == null) {
		      return 0;
		    }
		return getDepartureTime().compareTo(o.getDepartureTime());
	}

    
}
