package Airline.domain;


import Airline.conf.AirlineFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.List;

public class testAirline {
    private Airline airline;
    private Airline newAirline;
    private List<Aircraft> aircrafts;
    @Before
    public void setUp()
    {
        airline = AirlineFactory.createAirline("Mango","South African",aircrafts);
    }
    @Test
    public void testCreateAirline() throws Exception
    {
        Assert.assertEquals("Mango",airline.getAirlineName());
    }
    @Test
    public void testUpdateAirline()
    {
        newAirline = new Airline
                .Builder(airline.getAirlineName())
                .copy(airline)
                .nationality("Saudi Arabian").build();

        Assert.assertEquals("Mango",newAirline.getAirlineName());
        Assert.assertEquals("Saudi Arabian",newAirline.getNationality());
    }
    @After
    public void tearDown()
    {

    }
}
