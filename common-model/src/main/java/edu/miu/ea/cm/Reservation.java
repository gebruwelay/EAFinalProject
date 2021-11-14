package edu.miu.ea.cm;

import edu.miu.ea.cm.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(unique = true)
    @Size(min=6,max=6)
    private String code;

    private LocalDate reservationDate;

    @NonNull
    @NotEmpty
    private Double totalPrice;
    private ReservationStatus reservationStatus;

    @NonNull @NotEmpty
    @OneToMany
    @Fetch(FetchMode.SUBSELECT)
    private List<Ticket> tickets;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private ActiveFlight activeFlight;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private Passenger passenger;

}
