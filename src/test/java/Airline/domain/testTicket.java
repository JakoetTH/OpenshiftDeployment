package Airline.domain;

import Airline.conf.TicketFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testTicket {
    private Ticket ticket;
    private Ticket newTicket;
    @Before
    public void setUp()
    {
        ticket = TicketFactory.createTicket(123,"Business");
    }
    @Test
    public void testCreateTicket() throws Exception
    {
        Assert.assertEquals("Business",ticket.getTicketClass());
    }
    @Test
    public void testUpdateTicket()
    {
        newTicket = new Ticket
                .Builder(ticket.getTicketClass())
                .copy(ticket)
                .price(122).build();

        Assert.assertEquals("Business",newTicket.getTicketClass());
        Assert.assertEquals(122,newTicket.getPrice());
    }
    @After
    public void tearDown()
    {

    }
}