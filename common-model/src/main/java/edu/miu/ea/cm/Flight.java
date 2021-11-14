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
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private Integer capacity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private Airline airline;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private Airport origin;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private Airport destination;
}
