package edu.miu.ea.cm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Column(unique = true)
    @Digits(fraction = 0, integer = 20)
    @NotEmpty
    private String number;
    @NonNull
    @Future
    private LocalDate flightDate;

    @Column(unique = true)
    @Size(min=6,max=6)
    private String reservationCode;
}
