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
        runway = RunwayFactory.createRunway("No current flights",5000);
    }
    @Test
    public void testCreateRunway() throws Exception
    {
        Assert.assertEquals("No current flights",runway.getStatus());
    }
    @Test
    public void testUpdateRunway()
    {
        newRunway = new Runway
                .Builder(runway.getStatus())
                .copy(runway)
                .length(4000).build();

        Assert.assertEquals("No current flights",newRunway.getStatus());
        Assert.assertEquals(4000,newRunway.getSize());
    }
    @After
    public void tearDown()
    {

    }
}
