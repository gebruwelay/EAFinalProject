package edu.miu.ea.rs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="ticketNumber", length = 20, nullable = false)
    private String ticketNumber; //List<String> TicketNumbers
    private int flightId;

    private int passangerId;

    private String ReservationCode;
}
