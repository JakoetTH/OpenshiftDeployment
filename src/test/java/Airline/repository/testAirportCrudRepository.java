package Airline.repository;

import Airline.App;
import Airline.domain.Airport;
import Airline.domain.Hangar;
import Airline.domain.Runway;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import java.util.List;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testAirportCrudRepository extends AbstractTestNGSpringContextTests{
    private Long id;
    private List<Hangar> hangars;
    private List<Runway> runways;

    @Autowired
    AirportRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Airport airport = new Airport.Builder("Cape Town Airport")
                .country("South Africa")
                .city("Cape Town")
                .type("public")
                .build();
        repository.save(airport);
        id = airport.getID();
        Assert.assertNotNull(airport);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Airport airport = repository.findOne(id);
        Assert.assertEquals("Cape Town Airport",airport.getName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Airport airport = repository.findOne(id);
        Airport newAirport = new Airport.Builder(airport.getName())
                .ID(id)
                .country("South Africa")
                .city("Cape Town")
                .type("private")
                .build();
        repository.save(newAirport);

        Airport updatedAirport = repository.findOne(id);
        Assert.assertEquals("private",updatedAirport.getType());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Airport airport = repository.findOne(id);
        repository.delete(airport);
        Airport newAirport = repository.findOne(id);
        Assert.assertNull(newAirport);
    }

}
