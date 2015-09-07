package Airline.service;

import Airline.conf.TicketFactory;
import Airline.domain.Flight;
import Airline.domain.Passenger;
import Airline.domain.Ticket;
import Airline.repository.FlightRepository;
import Airline.repository.PassengerRepository;
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
    private TicketRepository repositoryTicket;
    private PassengerRepository repositoryPassenger;
    private FlightRepository repositoryFlight;
    @Override//Read
    public List<Ticket> getPassengerTickets(Passenger passenger)
    {
        List<Ticket> tickets = passenger.getTickets();
        return tickets;
    }
    @Override//Create
    public void newTicket(Passenger passenger, Flight flight, float price, String ticketclass)
    {
        Ticket ticket = TicketFactory.createTicket(price, ticketclass);
        //add ticket to corresponding passenger's ticket List
        List<Ticket> ptickets = passenger.getTickets();
        ptickets.add(ticket);
        Passenger updatedPassenger = new Passenger
                                              .Builder(passenger.getUserName())
                                              .copy(passenger)
                                              .tickets(ptickets).build();
        //Add ticket to corresponding flight's ticket List
        List<Ticket> ftickets = flight.getTickets();
        ftickets.add(ticket);
        Flight updatedFlight = new Flight
                                        .Builder(flight.getDepartureLocation())
                                        .copy(flight)
                                        .seatsAvailable(flight.getSeatsAvailable() - 1)
                                        .tickets(ftickets)
                                        .build();

        repositoryPassenger.save(updatedPassenger);
        repositoryFlight.save(updatedFlight);
        repositoryTicket.save(ticket);
    }
    @Override//Delete
    public void deleteTicket(Ticket ticket)
    {
        Iterable<Passenger> passengers = repositoryPassenger.findAll();
        Iterable<Flight> flights = repositoryFlight.findAll();
        List<Ticket> ptickets;
        List<Ticket> ftickets;
        //Iterates through passenger objects and deletes ticket from existing passenger
        for(Passenger pas : passengers)
        {
            ptickets = pas.getTickets();
                if(ptickets.contains(ticket))
                {
                    ptickets.remove(ticket);
                    pas = new Passenger
                                    .Builder(pas.getUserName())
                                    .copy(pas)
                                    .tickets(ptickets).build();
                    repositoryPassenger.save(pas);
                }
        }
        //Iterates through flight objects and deletes ticket from existing flight
        for(Flight fli : flights)
        {
            ftickets = fli.getTickets();
                if(ftickets.contains(ticket))
                {
                    ftickets.remove(ticket);
                    fli = new Flight
                                .Builder(fli.getDepartureLocation())
                                .copy(fli)
                                .tickets(ftickets).build();
                    repositoryFlight.save(fli);
                }
        }
        repositoryTicket.delete(ticket);
    }
}
