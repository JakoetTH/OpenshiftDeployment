package Airline.repository;

import Airline.App;
import Airline.domain.Ticket;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testTicketCrudRepository extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    TicketRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Ticket ticket = new Ticket.Builder("First Class")
                .price(200)
                .build();
        repository.save(ticket);
        id = ticket.getID();
        Assert.assertNotNull(ticket);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Ticket ticket = repository.findOne(id);
        Assert.assertEquals("First Class",ticket.getTicketClass());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Ticket ticket = repository.findOne(id);
        Ticket newTicket = new Ticket.Builder("Business Class")
                .ID(id)
                .price(200)
                .build();
        repository.save(newTicket);

        Ticket updatedTicket = repository.findOne(id);
        Assert.assertEquals("Business Class",updatedTicket.getTicketClass());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Ticket ticket = repository.findOne(id);
        repository.delete(ticket);
        Ticket newTicket = repository.findOne(id);
        Assert.assertNull(newTicket);
    }

}
