package Airline.service;

import Airline.domain.Passenger;
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
    public List<Ticket> getPassengerTickets(Passenger passenger)
    {
        List<Ticket> tickets = passenger.getTickets();
        return tickets;
    }

}
