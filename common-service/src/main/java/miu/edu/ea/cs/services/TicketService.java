package miu.edu.ea.cs.services;

import edu.miu.ea.cm.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface TicketService {

    public Page<Ticket> allTickets(Pageable pageable);


    public Ticket saveTicket(Ticket ticket);


}
