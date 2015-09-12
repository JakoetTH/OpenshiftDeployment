package Airline.service;

import Airline.App;
import Airline.conf.FlightFactory;
import Airline.conf.PassengerFactory;
import Airline.domain.Flight;
import Airline.domain.Passenger;
import Airline.domain.Ticket;
import Airline.repository.FlightRepository;
import Airline.repository.PassengerRepository;
import Airline.repository.TicketRepository;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testTicketServices extends AbstractTestNGSpringContextTests{
    private Passenger passenger;
    private Flight flight;
    private List<Ticket> tickets;
    private Ticket ticket;
    private Ticket tickettwo;
    private Date date = new Date();

    @Autowired
    TicketImpl service;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;



    public testTicketServices() {
    }

    @BeforeMethod
    public void setUp()
    {
        tickets = new ArrayList<Ticket>();
    }

    @Test
    public void testCreateTickets()
    {
        ticket = new Ticket.Builder("First Class")
                .price(200)
                .build();
        tickettwo = new Ticket.Builder("Business Class")
                .price(300)
                .build();

        tickets.add(ticket);
        Assert.assertNotNull(ticket);
        ticketRepository.save(ticket);
        tickets.add(tickettwo);
        Assert.assertNotNull(tickettwo);
        ticketRepository.save(tickettwo);
    }

    @Test(dependsOnMethods = "testCreateTickets")
    public void testCreatePassenger()
    {
        passenger = PassengerFactory.createPassenger("Redc","12345","Thawhir","Jakoet","15 Shiraaz Close","083 477 1207", tickets);
        Assert.assertNotNull(passenger);
        passengerRepository.save(passenger);
    }

    @Test(dependsOnMethods = "testCreatePassenger")
    public void testCreateFlight()
    {
        flight = FlightFactory.createFlight(date, date, "Johannesburg", "Belgium", 200, tickets);
        Assert.assertNotNull(flight);
        flightRepository.save(flight);
    }

    @Test(dependsOnMethods = "testCreateFlight")
    public void testGetPassengerTickets()
    {
        List<Ticket> tickets = service.getPassengerTickets(passenger);
        Assert.assertEquals(tickets, passenger.getTickets());
    }

    @Test(dependsOnMethods = "testGetPassengerTickets")
    public void testNewTicket()
    {
        long count = ticketRepository.count();
        service.newTicket(passenger,flight,200,"Third Class");
        Assert.assertNotEquals(count, ticketRepository.count());
    }

    @Test(dependsOnMethods = "testNewTicket")
    public void testDeleteTicket()
    {
        long count = ticketRepository.count();
        Iterable<Ticket> itickets = ticketRepository.findAll();
        Long maxID = Long.parseLong("0");
        for(Ticket tic: itickets)
        {
            if(tic.getID()>maxID)
                maxID = tic.getID();
        }
        service.deleteTicket(maxID);
        Assert.assertNotEquals(count,ticketRepository.count());
    }
}
