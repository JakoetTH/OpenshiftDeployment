package Airline.domain;

import Airline.conf.ClerkFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.List;

public class testClerk {
    private Clerk clerk;
    private Clerk newClerk;
    private List<Ticket> tickets;
    @Before
    public void setUp()
    {
        clerk = ClerkFactory.createClerk("Thawhir","Jakoet","15 Shiraaz Close","54321","Ticketclerk",tickets);
    }
    @Test
    public void testCreateClerk() throws Exception
    {
        Assert.assertEquals("Thawhir",clerk.getFirstName());
    }
    @Test
    public void testUpdateClerk()
    {
        newClerk = new Clerk
                .Builder(clerk.getFirstName())
                .copy(clerk)
                .position("Floorclerk").build();

        Assert.assertEquals("Thawhir",newClerk.getFirstName());
        Assert.assertEquals("Floorclerk",newClerk.getPosition());
    }
    @After
    public void tearDown()
    {

    }
}
