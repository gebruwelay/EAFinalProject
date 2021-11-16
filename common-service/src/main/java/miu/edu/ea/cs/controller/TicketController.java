package miu.edu.ea.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import miu.edu.ea.cs.model.Ticket;
import miu.edu.ea.cs.service.TicketService;

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
