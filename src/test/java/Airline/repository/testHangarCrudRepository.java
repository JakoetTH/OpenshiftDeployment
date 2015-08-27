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
    private Long id;

    @Autowired
    HangarRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Hangar hangar = new Hangar.Builder("Empty")
                .capacity(2000)
                .build();
        repository.save(hangar);
        id = hangar.getID();
        Assert.assertNotNull(hangar);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Hangar hangar = repository.findOne(id);
        Assert.assertEquals("Empty", hangar.getStatus());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Hangar hangar = repository.findOne(id);
        Hangar newHangar = new Hangar.Builder(hangar.getStatus())
                .ID(id)
                .capacity(1000)
                .build();
        repository.save(newHangar);

        Hangar updatedHangar = repository.findOne(id);
        Assert.assertEquals(1000,updatedHangar.getSize());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Hangar hangar = repository.findOne(id);
        repository.delete(hangar);
        Hangar newHangar = repository.findOne(id);
        Assert.assertNull(newHangar);
    }

}