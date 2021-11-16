package edu.miu.ea.rs.dto;

import java.time.LocalDate;
import java.util.List;

import edu.miu.ea.rs.model.Passenger;
import edu.miu.ea.rs.model.ReservationStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReservationDTO {

	//private String reservationCode;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate reservedDate;
    private ReservationStatus status;
    private List<Integer> flightIds;
    private int passangerId;
    private Passenger passenger;
    private int userId;
    
}
