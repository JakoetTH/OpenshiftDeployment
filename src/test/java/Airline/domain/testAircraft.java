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
        aircraft = AircraftFactory.createAircraft("Boeing-474",200,5000);
    }
    @Test
    public void testCreateAircraft() throws Exception
    {
        Assert.assertEquals("Boeing-474",aircraft.getAircraftType());
    }
    @Test
    public void testUpdateAircraft()
    {
        newAircraft = new Aircraft
                .Builder(aircraft.getAircraftType())
                .copy(aircraft)
                .seats(300).build();

        Assert.assertEquals("Boeing-474",newAircraft.getAircraftType());
        Assert.assertEquals(300,newAircraft.getSeats());
    }
    @After
    public void tearDown()
    {

    }
}
