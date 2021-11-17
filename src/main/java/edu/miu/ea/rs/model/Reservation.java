package edu.miu.ea.rs.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reservationCode;
    private LocalDate reservedDate;
    private double totalPrice;
    private ReservationStatus status;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Flight> flightList= new ArrayList<>();
    @ManyToOne( cascade = CascadeType.PERSIST)
    private Passenger passenger;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ticket> tickets=new
			ArrayList<>();
    @ManyToOne( cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private User user;
	public Reservation(String reservationCode, LocalDate reservationDate, ReservationStatus status,
			List<Flight> flightList, Passenger passenger, User user) {
		this.reservationCode = reservationCode;
		this.reservedDate = reservationDate;
		this.totalPrice = getTotalPrice(flightList);
		this.status = status;
		this.flightList = flightList;
		this.passenger = passenger;
		this.user = user;
	}
	
	public double getTotalPrice(List<Flight> flightList) {
		double total = 0.0;
		for(Flight f:flightList) {
			total+=f.getPrice();
		}
		return total;
	}
    
    
}
