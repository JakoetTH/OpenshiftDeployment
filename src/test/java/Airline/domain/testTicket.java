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
        ticket = TicketFactory.createTicket("12345",123,"Business","1","2","2");
    }
    @Test
    public void testCreateTicket() throws Exception
    {
        Assert.assertEquals("12345",ticket.getID());
    }
    @Test
    public void testUpdateTicket()
    {
        newTicket = new Ticket
                .Builder(ticket.getID())
                .copy(ticket)
                .ticketClass("standard").build();

        Assert.assertEquals("12345",newTicket.getID());
        Assert.assertEquals("standard",newTicket.getTicketClass());
    }
    @After
    public void tearDown()
    {

    }
}