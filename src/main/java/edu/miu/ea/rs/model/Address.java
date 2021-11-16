package edu.miu.ea.rs.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    //private int id;   // no need of id

    private String street;
    private String city;
    private String state;
    private String zip;

    

}
