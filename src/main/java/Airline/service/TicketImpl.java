package Airline.service;

import Airline.domain.Ticket;
import Airline.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@Service
public class TicketImpl implements TicketService {
    @Autowired
    private TicketRepository repository;
    @Override
    public List<Ticket> getPassengerTickets(String ID)
    {
        Iterable<Ticket> ittickets = repository.findAll();
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (Ticket ticket : ittickets)
        {
            if(ticket.getID().equals(ID))
                tickets.add(ticket);
        }
        return tickets;
    }

}
