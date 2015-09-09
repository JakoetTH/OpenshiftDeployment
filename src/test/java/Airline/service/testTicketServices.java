package Airline.service;

import Airline.App;
import Airline.conf.PassengerFactory;
import Airline.domain.Passenger;
import Airline.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testTicketServices extends AbstractTestNGSpringContextTests{
    @Autowired
    private TicketImpl service;

    private Passenger passenger;
    private List<Ticket> tickets;
    @BeforeMethod
    public void setUp()
    {
        tickets = new ArrayList<Ticket>();
    }

    @Test
    public void testCreateTickets()
    {
        Ticket ticket = new Ticket.Builder("First Class")
                .price(200)
                .build();
        Ticket tickettwo = new Ticket.Builder("Business Class")
                .price(300)
                .build();

        tickets.add(ticket);
        Assert.assertNotNull(ticket);

        tickets.add(tickettwo);
        Assert.assertNotNull(tickettwo);
    }

    @Test(dependsOnMethods = "testCreateTickets")
    public void testCreatePassenger()
    {
        passenger = PassengerFactory.createPassenger("Redc","12345","Thawhir","Jakoet","15 Shiraaz Close","083 477 1207", tickets);
    }

    @Test(dependsOnMethods = "testCreatePassenger")
    public void testGetPassengerTickets()
    {
        List<Ticket> tickets = service.getPassengerTickets(passenger);
        Assert.assertEquals(tickets, passenger.getTickets());
    }
}
