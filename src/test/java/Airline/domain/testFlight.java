package Airline.domain;

import Airline.conf.FlightFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.Date;
import java.util.List;

public class testFlight {
    private Flight flight;
    private Flight newFlight;
    private List<Ticket> tickets;
    private Date date = new Date();
    @Before
    public void setUp()
    {
        flight = FlightFactory.createFlight(date,date,"Johannesburg","Belgium",200,tickets);
    }
    @Test
    public void testCreateFlight() throws Exception
    {
        Assert.assertEquals("Johannesburg",flight.getDepartureLocation());
    }
    @Test
    public void testUpdateFlight()
    {
        newFlight = new Flight
                .Builder(flight.getDepartureLocation())
                .copy(flight)
                .arrivalLocation("London").build();

        Assert.assertEquals("Johannesburg",newFlight.getDepartureLocation());
        Assert.assertEquals("London",newFlight.getArrivalLocation());
    }
    @After
    public void tearDown()
    {

    }
}
