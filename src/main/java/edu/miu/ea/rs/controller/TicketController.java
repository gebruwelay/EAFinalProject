package edu.miu.ea.rs.controller;

import java.util.List;

import edu.miu.ea.rs.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import edu.miu.ea.rs.model.Ticket;

@RestController
@Data
@RequestMapping("/api/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping()
	@PreAuthorize("hasAnyAuthority('Role_Admin')")
	public List<Ticket> allTickets(){
		return ticketService.allTickets();
	}

//	public Ticket saveTicket(Ticket ticket) {
//		return ticketService.saveTicket(ticket);
//	}
}
