package Airline.repository;

import Airline.App;
import Airline.domain.Flight;
import org.junit.Assert;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testFlightCrudRepository extends AbstractTestNGSpringContextTests{
    private String id;
    private Date date = new Date();
    @Autowired
    FlightRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Flight flight = new Flight.Builder("12345")
                .departureTime(date)
                .arrivalTime(date)
                .departureLocation("Johannesburg")
                .arrivalLocation("Cape Town")
                .build();
        repository.save(flight);
        id = flight.getID();
        Assert.assertNotNull(flight);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Flight flight = repository.findOne(id);
        Assert.assertEquals("12345",flight.getID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Flight flight = repository.findOne(id);
        Flight newFlight = new Flight.Builder(flight.getID())
                .departureTime(date)
                .arrivalTime(date)
                .departureLocation("Johannesburg")
                .arrivalLocation("London")
                .build();
        repository.save(newFlight);

        Flight updatedFlight = repository.findOne(id);
        Assert.assertEquals("London",updatedFlight.getArrivalLocation());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Flight flight = repository.findOne(id);
        repository.delete(flight);
        Flight newFlight = repository.findOne(id);
        Assert.assertNull(newFlight);
    }

}
