package edu.miu.ea.cm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Airline")
@SecondaryTable(name = "History")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(unique = true)
    @Size(min=2,max=2)
    private String code;
    @NonNull
    @Size(min=2,max = 20)
    private String name;

    @NotEmpty
    @Column(table = "History", length = 2000)
    private String history;

}
