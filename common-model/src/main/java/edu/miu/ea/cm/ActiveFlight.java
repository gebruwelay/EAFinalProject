package edu.miu.ea.cm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ActiveFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private Double  price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private Flight flight;
}
