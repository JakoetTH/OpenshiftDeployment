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
        hangar = HangarFactory.createHangar("Space Available",500);
    }
    @Test
    public void testCreateHangar() throws Exception
    {
        Assert.assertEquals("Space Available",hangar.getStatus());
    }
    @Test
    public void testUpdateHangar()
    {
        newHangar = new Hangar
                .Builder(hangar.getStatus())
                .copy(hangar)
                .capacity(400).build();

        Assert.assertEquals("Space Available",newHangar.getStatus());
        Assert.assertEquals(400,newHangar.getSize());
    }
    @After
    public void tearDown()
    {

    }
}
