package Airline.domain;


import Airline.conf.AirlineFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testAirline {
    private Airline airline;
    private Airline newAirline;
    @Before
    public void setUp()
    {
        airline = AirlineFactory.createAirline("12345","Mango","South African");
    }
    @Test
    public void testCreateAirline() throws Exception
    {
        Assert.assertEquals("12345",airline.getID());
    }
    @Test
    public void testUpdateAirline()
    {
        newAirline = new Airline
                .Builder(airline.getID())
                .copy(airline)
                .nationality("Saudi Arabian").build();

        Assert.assertEquals("12345",newAirline.getID());
        Assert.assertEquals("Saudi Arabian",newAirline.getNationality());
    }
    @After
    public void tearDown()
    {

    }
}
