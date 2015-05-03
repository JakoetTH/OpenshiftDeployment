package Airline.repository;

import Airline.App;
import Airline.domain.Pilot;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testPilotCrudRepository extends AbstractTestNGSpringContextTests{
    private String id;

    @Autowired
    PilotRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Pilot pilot = new Pilot.Builder("12345")
                .firstName("Thawhir")
                .lastName("Jakoet")
                .address("15 Shiraaz Close")
                .contact("021 123 4567")
                .rank("junior pilot")
                .build();
        repository.save(pilot);
        id = pilot.getID();
        Assert.assertNotNull(pilot);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Pilot pilot = repository.findOne(id);
        Assert.assertEquals("12345",pilot.getID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Pilot pilot = repository.findOne(id);
        Pilot newPilot = new Pilot.Builder(pilot.getID())
                .firstName("Thawhir")
                .lastName("Jakoet")
                .address("15 Shiraaz Close")
                .contact("021 123 4567")
                .rank("senior pilot")
                .build();
        repository.save(newPilot);

        Pilot updatedPilot = repository.findOne(id);
        Assert.assertEquals("senior pilot",updatedPilot.getRank());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Pilot pilot = repository.findOne(id);
        repository.delete(pilot);
        Pilot newPilot = repository.findOne(id);
        Assert.assertNull(newPilot);
    }

}
