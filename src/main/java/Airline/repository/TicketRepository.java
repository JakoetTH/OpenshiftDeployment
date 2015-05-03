package Airline.repository;

import Airline.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket,String>{
    public Ticket findByID(String ID);
}
