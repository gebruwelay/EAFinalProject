package edu.miu.ea.rs.service;

import java.util.List;

import edu.miu.ea.rs.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import edu.miu.ea.rs.model.Ticket;

@Service
@Data
public class TicketService {

	@Autowired
	private TicketRepository repository;
	
	public List<Ticket> allTickets(){
		return repository.findAll();
	}
	
	public Ticket saveTicket(Ticket ticket) {
		return repository.save(ticket);
	}
}
