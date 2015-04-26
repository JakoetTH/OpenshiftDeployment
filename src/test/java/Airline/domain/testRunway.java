package Airline.domain;

import Airline.conf.RunwayFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testRunway {
    private Runway runway;
    private Runway newRunway;
    @Before
    public void setUp()
    {
        runway = RunwayFactory.createRunway("12345","No current flights",5000);
    }
    @Test
    public void testCreateRunway() throws Exception
    {
        Assert.assertEquals("12345",runway.getID());
    }
    @Test
    public void testUpdateRunway()
    {
        newRunway = new Runway
                .Builder(runway.getID())
                .copy(runway)
                .status("Flight currently scheduled").build();

        Assert.assertEquals("12345",newRunway.getID());
        Assert.assertEquals("Flight currently scheduled",newRunway.getStatus());
    }
    @After
    public void tearDown()
    {

    }
}
