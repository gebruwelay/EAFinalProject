package edu.miu.ea.cm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Airport {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    @Size(min=3,max=3)
    private String code;
    @NonNull
    @Size(min=2,max = 20)
    private String name;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


}
