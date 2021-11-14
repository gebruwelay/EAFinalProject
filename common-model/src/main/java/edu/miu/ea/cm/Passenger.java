package edu.miu.ea.cm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Passenger{
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate DoB;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private Address address;
}
