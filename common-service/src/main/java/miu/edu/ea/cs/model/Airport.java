package miu.edu.ea.cs.model;

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
   // @Column(length = 3)
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
