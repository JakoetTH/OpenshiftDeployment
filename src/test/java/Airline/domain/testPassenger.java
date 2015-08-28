package Airline.domain;

import Airline.conf.PassengerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.List;

public class testPassenger {
    private Passenger passenger;
    private Passenger newPassenger;
    private List<Ticket> tickets;
    @Before
    public void setUp()
    {
        passenger = PassengerFactory.createPassenger("Redc","12345","Thawhir","Jakoet","15 Shiraaz Close","54321",tickets);
    }
    @Test
    public void testCreatePassenger() throws Exception
    {
        Assert.assertEquals("Redc",passenger.getUserName());
    }
    @Test
    public void testUpdatePassenger()
    {
        newPassenger = new Passenger
                .Builder(passenger.getUserName())
                .copy(passenger)
                .lastName("Samsodien").build();

        Assert.assertEquals("Redc",newPassenger.getUserName());
        Assert.assertEquals("Samsodien",newPassenger.getLastName());
    }
    @After
    public void tearDown()
    {

    }
}
