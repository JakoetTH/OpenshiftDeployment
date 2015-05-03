package Airline.repository;

import Airline.App;
import Airline.domain.Airport;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testAirportCrudRepository extends AbstractTestNGSpringContextTests{
    private String id;

    @Autowired
    AirportRepository repository;

    @Test
    public void testCreate()
    {
        Airport airport = new Airport.Builder("12345")
                .name("Cape Town Airport")
                .country("South Africa")
                .city("Cape Town")
                .type("public")
                .build();
        repository.save(airport);
        id = airport.getID();
        Assert.assertNotNull(airport);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Airport airport = repository.findOne(id);
        Assert.assertEquals("12345",airport.getID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Airport airport = repository.findOne(id);
        Airport newAirport = new Airport.Builder(airport.getID())
                .name("Cape Town Airport")
                .country("South Africa")
                .city("Cape Town")
                .type("private")
                .build();
        repository.save(newAirport);

        Airport updatedAirport = repository.findOne(id);
        Assert.assertEquals("private",updatedAirport.getType());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        Airport airport = repository.findOne(id);
        repository.delete(airport);
        Airport newAirport = repository.findOne(id);
        Assert.assertNull(newAirport);
    }

}
