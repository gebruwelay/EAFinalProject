package edu.miu.ea.rs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    @Embedded
    private Address address;
    
	public Airport(String code, String name, Address address) {
		this.code = code;
		this.name = name;
		this.address = address;
	}
	
	
    
    
}
