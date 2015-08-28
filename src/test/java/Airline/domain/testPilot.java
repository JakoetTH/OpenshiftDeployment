package Airline.domain;

import Airline.conf.PilotFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testPilot {
    private Pilot pilot;
    private Pilot newPilot;
    @Before
    public void setUp()
    {
        pilot = PilotFactory.createPilot("Thawhir","Jakoet","15 Shiraaz Close","54321","Junior");
    }
    @Test
    public void testCreatePilot() throws Exception
    {
        Assert.assertEquals("Thawhir",pilot.getFirstName());
    }
    @Test
    public void testUpdatePilot()
    {
        newPilot = new Pilot
                .Builder(pilot.getFirstName())
                .copy(pilot)
                .rank("Senior").build();

        Assert.assertEquals("Thawhir",newPilot.getFirstName());
        Assert.assertEquals("Senior",newPilot.getRank());
    }
    @After
    public void tearDown()
    {

    }
}
