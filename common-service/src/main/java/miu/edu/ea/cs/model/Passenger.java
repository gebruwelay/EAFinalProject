package miu.edu.ea.cs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @Past
    private LocalDate dateOfBirth;
    private String email;
    @Embedded
    private Address address;

	public Passenger(String firstName, String lastName, @Past LocalDate dateOfBirth, String email,
			Address residenceAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = residenceAddress;
	}
    
    
    
}
