package Airline.repository;

import Airline.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket,Long>{
}
