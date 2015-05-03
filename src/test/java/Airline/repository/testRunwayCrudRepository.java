package Airline.repository;

import Airline.App;
import Airline.domain.Runway;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testRunwayCrudRepository extends AbstractTestNGSpringContextTests{
    private String id;

    @Autowired
    RunwayRepository repository;

    @Test
    public void testCreate()
    {
        Runway runway = new Runway.Builder("12345")
                .status("available")
                .length(2000)
                .build();
        repository.save(runway);
        id = runway.getID();
        Assert.assertNotNull(runway);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Runway runway = repository.findOne(id);
        Assert.assertEquals("12345",runway.getID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Runway runway = repository.findOne(id);
        Runway newRunway = new Runway.Builder(runway.getID())
                .status("in use")
                .length(2000)
                .build();
        repository.save(newRunway);

        Runway updatedRunway = repository.findOne(id);
        Assert.assertEquals("in use",updatedRunway.getStatus());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        Runway runway = repository.findOne(id);
        repository.delete(runway);
        Runway newRunway = repository.findOne(id);
        Assert.assertNull(newRunway);
    }

}
