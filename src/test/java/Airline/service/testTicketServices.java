package Airline.service;

/* Airline.App;
import Airline.domain.Ticket;
import Airline.repository.TicketRepository;
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
    private TicketRepository repository;
    @Autowired
    private TicketImpl service;

    private String id;
    private List<Ticket> tickets;
    @BeforeMethod
    public void setUp()
    {
        tickets = new ArrayList<Ticket>();
        id = "12345";
    }

    @Test
    public void testCreateTickets()
    {
        Ticket ticket = new Ticket.Builder("12345")
                .price(200)
                .ticketClass("First Class")
                .build();
        Ticket tickettwo = new Ticket.Builder("12346")
                .price(200)
                .ticketClass("First Class")
                .build();

        tickets.add(ticket);
        repository.save(ticket);
        Assert.assertNotNull(ticket);

        tickets.add(tickettwo);
        repository.save(tickettwo);
        Assert.assertNotNull(tickettwo);

    }

    @Test(dependsOnMethods = "testCreateTickets")
    public void testGetPassengerTickets()
    {
        List<Ticket> tickets = service.getPassengerTickets(id);
        Assert.assertTrue(tickets.size() == 1);
    }
}*/
