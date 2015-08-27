package Airline.repository;

import Airline.App;
import Airline.domain.Aircraft;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testAircraftCrudRepository extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    AircraftRepository repository;

    @Test
    public void testCreate()  throws Exception
    {
        Aircraft aircraft = new Aircraft.Builder("Boeing-474")
                .seats(200)
                .fuelCapacity(5000)
                .build();
        repository.save(aircraft);
        id = aircraft.getID();
        Assert.assertNotNull(aircraft);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()  throws Exception
    {
        Aircraft aircraft = repository.findOne(id);
        Assert.assertEquals("Boeing-474",aircraft.getAircraftType());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate()  throws Exception
    {
        Aircraft aircraft = repository.findOne(id);
        Aircraft newAircraft = new Aircraft.Builder(aircraft.getAircraftType())
                .ID(id)
                .seats(300)
                .fuelCapacity(5000)
                .build();
        repository.save(newAircraft);

        Aircraft updatedAircraft = repository.findOne(id);
        Assert.assertEquals(300,updatedAircraft.getSeats());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()  throws Exception
    {
        Aircraft aircraft = repository.findOne(id);
        repository.delete(aircraft);
        Aircraft newAircraft = repository.findOne(id);
        Assert.assertNull(newAircraft);
    }

}
