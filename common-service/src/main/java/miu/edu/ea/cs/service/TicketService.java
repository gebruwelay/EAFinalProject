package miu.edu.ea.cs.service;

import java.util.List;

import miu.edu.ea.cs.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.edu.ea.cs.model.Ticket;

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
