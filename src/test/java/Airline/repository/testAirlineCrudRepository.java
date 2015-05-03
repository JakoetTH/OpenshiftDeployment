package Airline.repository;

import Airline.App;
import Airline.domain.Airline;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testAirlineCrudRepository extends AbstractTestNGSpringContextTests{
    private String id;

    @Autowired
    AirlineRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Airline airline = new Airline.Builder("12345")
                .name("Mango")
                .nationality("South Africa")
                .build();
        repository.save(airline);
        id = airline.getID();
        Assert.assertNotNull(airline);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Airline airline = repository.findOne(id);
        Assert.assertEquals("12345",airline.getID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Airline airline = repository.findOne(id);
        Airline newAirline = new Airline.Builder(airline.getID())
                .name("Mango Advanced")
                .nationality("South Africa")
                .build();
        repository.save(newAirline);

        Airline updatedAirline = repository.findOne(id);
        Assert.assertEquals("Mango Advanced",updatedAirline.getAirlineName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Airline airline = repository.findOne(id);
        repository.delete(airline);
        Airline newAirline = repository.findOne(id);
        Assert.assertNull(newAirline);
    }

}
