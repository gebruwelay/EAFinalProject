package edu.miu.ea.cm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor

public class Flight {
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

    //@Override
    public int compareTo(Flight o) {
        if (getDepartureTime() == null || o.getDepartureTime() == null) {
            return 0;
        }
        return getDepartureTime().compareTo(o.getDepartureTime());
    }


}
