package miu.edu.ea.cs.services.servicesImpl;

import edu.miu.ea.cm.Ticket;
import miu.edu.ea.cs.repository.TicketRepository;
import miu.edu.ea.cs.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository repository;

    public Page<Ticket> allTickets(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Ticket saveTicket(Ticket ticket) {

        return repository.save(ticket);
    }

}
