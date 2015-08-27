package Airline.repository;

import Airline.App;
import Airline.domain.Aircraft;
import Airline.domain.Airline;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.List;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testAirlineCrudRepository extends AbstractTestNGSpringContextTests{
    private Long id;
    private List<Aircraft> aircrafts;

    @Autowired
    AirlineRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Airline airline = new Airline.Builder("Mango")
                .nationality("South Africa")
                .aircraft(aircrafts)
                .build();
        repository.save(airline);
        id = airline.getID();
        Assert.assertNotNull(airline);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Airline airline = repository.findOne(id);
        Assert.assertEquals("Mango",airline.getAirlineName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Airline airline = repository.findOne(id);
        Airline newAirline = new Airline.Builder(airline.getAirlineName())
                .ID(id)
                .nationality("Namibia")
                .aircraft(aircrafts)
                .build();
        repository.save(newAirline);

        Airline updatedAirline = repository.findOne(id);
        Assert.assertEquals("Namibia",updatedAirline.getNationality());
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
