package miu.edu.ea.cs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@SecondaryTable(name="History")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 3)
    private String code;
    private String name;
    @Column(table="History", length = 2000)
    private String history;
    
	public Airline(String code, String name, String history) {
		super();
		this.code = code;
		this.name = name;
		this.history = history;
	}
    
    
}
