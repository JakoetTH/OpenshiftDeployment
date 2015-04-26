package Airline.domain;

import Airline.conf.AircraftFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testAircraft {
    private Aircraft aircraft;
    private Aircraft newAircraft;
    @Before
    public void setUp()
    {
        aircraft = AircraftFactory.createAircraft("12345","Boeing-474",200,5000,"321");
    }
    @Test
    public void testCreateAircraft() throws Exception
    {
        Assert.assertEquals("12345",aircraft.getID());
    }
    @Test
    public void testUpdateAircraft()
    {
        newAircraft = new Aircraft
                .Builder(aircraft.getID())
                .copy(aircraft)
                .seats(300).build();

        Assert.assertEquals("12345",newAircraft.getID());
        Assert.assertEquals(300,newAircraft.getSeats());
    }
    @After
    public void tearDown()
    {

    }
}
