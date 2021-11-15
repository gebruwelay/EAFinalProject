package edu.miu.ea.cm;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    @Size(min=2,max = 20)
    private String street;
    @NonNull
    @Size(min=2,max = 20)
    private String city;
    @NonNull
    @Size(min=2,max = 20)
    private String state;
    @NonNull
    @Size(min=2,max = 10)
    @Column(unique = true)
    private String zip;
}
