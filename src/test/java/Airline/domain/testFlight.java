package Airline.domain;

import Airline.conf.FlightFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.Date;

public class testFlight {
    private Flight flight;
    private Flight newFlight;
    private Date date = new Date();
    @Before
    public void setUp()
    {
        flight = FlightFactory.createFlight("12345",date,date,"Johannesburg","Belgium");
    }
    @Test
    public void testCreateFlight() throws Exception
    {
        Assert.assertEquals("12345",flight.getID());
    }
    @Test
    public void testUpdateFlight()
    {
        newFlight = new Flight
                .Builder(flight.getID())
                .copy(flight)
                .departureLocation("London").build();

        Assert.assertEquals("12345",newFlight.getID());
        Assert.assertEquals("London",newFlight.getDepartureLocation());
    }
    @After
    public void tearDown()
    {

    }
}
