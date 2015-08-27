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
    private Long id;

    @Autowired
    RunwayRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Runway runway = new Runway.Builder("available")
                .length(1)
                .build();
        repository.save(runway);
        id = runway.getID();
        Assert.assertNotNull(runway);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Runway runway = repository.findOne(id);
        Assert.assertEquals("available",runway.getStatus());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Runway runway = repository.findOne(id);
        Runway newRunway = new Runway.Builder(runway.getStatus())
                .ID(id)
                .length(2)
                .build();
        repository.save(newRunway);

        Runway updatedRunway = repository.findOne(id);
        Assert.assertEquals(2,updatedRunway.getSize());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Runway runway = repository.findOne(id);
        repository.delete(runway);
        Runway newRunway = repository.findOne(id);
        Assert.assertNull(newRunway);
    }

}
