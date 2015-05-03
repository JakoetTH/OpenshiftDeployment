package Airline.repository;

import Airline.App;
import Airline.domain.Hangar;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testHangarCrudRepository extends AbstractTestNGSpringContextTests{
    private String id;

    @Autowired
    HangarRepository repository;

    @Test
    public void testCreate()
    {
        Hangar hangar = new Hangar.Builder("12345")
                .status("Empty")
                .capacity(2000)
                .build();
        repository.save(hangar);
        id = hangar.getID();
        Assert.assertNotNull(hangar);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Hangar hangar = repository.findOne(id);
        Assert.assertEquals("12345", hangar.getID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Hangar hangar = repository.findOne(id);
        Hangar newHangar = new Hangar.Builder(hangar.getID())
                .status("Full")
                .capacity(2000)
                .build();
        repository.save(newHangar);

        Hangar updatedHangar = repository.findOne(id);
        Assert.assertEquals("Full",updatedHangar.getStatus());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        Hangar hangar = repository.findOne(id);
        repository.delete(hangar);
        Hangar newHangar = repository.findOne(id);
        Assert.assertNull(newHangar);
    }

}