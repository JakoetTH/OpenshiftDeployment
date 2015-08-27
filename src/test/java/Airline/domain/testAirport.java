package Airline.domain;


import Airline.conf.AirportFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.List;

public class testAirport {
    private Airport airport;
    private Airport newAirport;
    private List<Hangar> hangars;
    private List<Runway> runways;
    @Before
    public void setUp()
    {
        airport = AirportFactory.createAirport("South African National Airport","South Africa","Cape Town","public",hangars,runways);
    }
    @Test
    public void testCreateAirport() throws Exception
    {
        Assert.assertEquals("South African National Airport",airport.getName());
    }
    @Test
    public void testUpdateAirport()
    {
        newAirport = new Airport
                .Builder(airport.getName())
                .copy(airport)
                .type("semi-private").build();

        Assert.assertEquals("South African National Airport",newAirport.getName());
        Assert.assertEquals("semi-private",newAirport.getType());
    }
    @After
    public void tearDown()
    {

    }
}
