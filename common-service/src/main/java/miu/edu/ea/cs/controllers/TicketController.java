package miu.edu.ea.cs.controllers;

import edu.miu.ea.cm.Ticket;
import lombok.Data;
import miu.edu.ea.cs.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping()
    //@PreAuthorize("hasAnyAuthority('Role_Admin')")
    public Page<Ticket> allTickets(Pageable pageable){

        return ticketService.allTickets(pageable);
    }

//    @PostMapping
//	public Ticket saveTicket(Ticket ticket) {
//		return ticketService.saveTicket(ticket);
//	}
}
