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
    @Override
    public List<Ticket> getPassengerTickets(Passenger passenger)
    {
        List<Ticket> tickets = passenger.getTickets();
        return tickets;
    }
    @Override
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
                                        .seatsAvailable(flight.getSeatsAvailable()-1)
                                        .tickets(ftickets)
                                        .build();

        repositoryPassenger.save(updatedPassenger);
        repositoryFlight.save(updatedFlight);
        repositoryTicket.save(ticket);
    }
}
