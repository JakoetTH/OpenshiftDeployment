package Airline.domain;


import Airline.conf.AirportFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testAirport {
    private Airport airport;
    private Airport newAirport;
    @Before
    public void setUp()
    {
        airport = AirportFactory.createAirport("12345","South African National Airport","South Africa","Cape Town","public");
    }
    @Test
    public void testCreateAirport() throws Exception
    {
        Assert.assertEquals("12345",airport.getID());
    }
    @Test
    public void testUpdateAirport()
    {
        newAirport = new Airport
                .Builder(airport.getID())
                .copy(airport)
                .type("semi-private").build();

        Assert.assertEquals("12345",newAirport.getID());
        Assert.assertEquals("semi-private",newAirport.getType());
    }
    @After
    public void tearDown()
    {

    }
}
