package Airline.domain;

import Airline.conf.ClerkFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testClerk {
    private Clerk clerk;
    private Clerk newClerk;
    @Before
    public void setUp()
    {
        clerk = ClerkFactory.createClerk("12345","Thawhir","Jakoet","15 Shiraaz Close","54321");
    }
    @Test
    public void testCreateClerk() throws Exception
    {
        Assert.assertEquals("12345",clerk.getID());
    }
    @Test
    public void testUpdateClerk()
    {
        newClerk = new Clerk
                .Builder(clerk.getID())
                .copy(clerk)
                .lastName("Samsodien").build();

        Assert.assertEquals("12345",newClerk.getID());
        Assert.assertEquals("Samsodien",newClerk.getLastName());
    }
    @After
    public void tearDown()
    {

    }
}
