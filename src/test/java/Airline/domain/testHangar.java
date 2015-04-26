package Airline.domain;

import Airline.conf.HangarFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testHangar {
    private Hangar hangar;
    private Hangar newHangar;
    @Before
    public void setUp()
    {
        hangar = HangarFactory.createHangar("12345","Space Available",500);
    }
    @Test
    public void testCreateHangar() throws Exception
    {
        Assert.assertEquals("12345",hangar.getID());
    }
    @Test
    public void testUpdateHangar()
    {
        newHangar = new Hangar
                .Builder(hangar.getID())
                .copy(hangar)
                .status("Full").build();

        Assert.assertEquals("12345",newHangar.getID());
        Assert.assertEquals("Full",newHangar.getStatus());
    }
    @After
    public void tearDown()
    {

    }
}
