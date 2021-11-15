package edu.miu.ea.cm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    @Column(unique = true)
    @Digits(fraction = 0, integer = 20)
    @NotEmpty
    private String ticketNumber;
    private String flightId;
    private Long passengerId;
    @NonNull
    @Future
    private LocalDate flightDate;

    @Column(unique = true)
    @Size(min=6,max=6)
    private String reservationCode;
}
