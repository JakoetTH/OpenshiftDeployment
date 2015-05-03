package Airline.repository;

import Airline.App;
import Airline.domain.Passenger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testPassengerCrudRepository extends AbstractTestNGSpringContextTests{
    private String id;

    @Autowired
    PassengerRepository repository;

    @Test
    public void testCreate()
    {
        Passenger passenger = new Passenger.Builder("12345")
                .firstName("Thawhir")
                .lastName("Jakoet")
                .address("15 Shiraaz Close")
                .contact("021 123 4567")
                .build();
        repository.save(passenger);
        id = passenger.getID();
        Assert.assertNotNull(passenger);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Passenger passenger = repository.findOne(id);
        Assert.assertEquals("12345",passenger.getID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Passenger passenger = repository.findOne(id);
        Passenger newPassenger = new Passenger.Builder(passenger.getID())
                .firstName("Thawhir")
                .lastName("Jakoet")
                .address("15 Shiraaz Close")
                .contact("021 765 4321")
                .build();
        repository.save(newPassenger);

        Passenger updatedPassenger = repository.findOne(id);
        Assert.assertEquals("021 765 4321",updatedPassenger.getContact());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        Passenger passenger = repository.findOne(id);
        repository.delete(passenger);
        Passenger newPassenger = repository.findOne(id);
        Assert.assertNull(newPassenger);
    }

}
