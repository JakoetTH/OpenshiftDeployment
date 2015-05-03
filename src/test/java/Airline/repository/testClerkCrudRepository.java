package Airline.repository;

import Airline.App;
import Airline.domain.Clerk;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testClerkCrudRepository extends AbstractTestNGSpringContextTests{
    private String id;

    @Autowired
    ClerkRepository repository;

    @Test
    public void testCreate()
    {
        Clerk clerk = new Clerk.Builder("12345")
                .firstName("Thawhir")
                .lastName("Jakoet")
                .address("15 Shiraaz Close")
                .contact("021 123 4567")
                .position("Ticket Clerk")
                .build();
        repository.save(clerk);
        id = clerk.getID();
        Assert.assertNotNull(clerk);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Clerk clerk = repository.findOne(id);
        Assert.assertEquals("12345",clerk.getID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Clerk clerk = repository.findOne(id);
        Clerk newClerk = new Clerk.Builder(clerk.getID())
                .firstName("Thawhir")
                .lastName("Jakoet")
                .address("15 Shiraaz Close")
                .contact("021 765 4321")
                .position("Ticket Clerk")
                .build();
        repository.save(newClerk);

        Clerk updatedClerk = repository.findOne(id);
        Assert.assertEquals("021 765 4321",updatedClerk.getContact());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        Clerk clerk = repository.findOne(id);
        repository.delete(clerk);
        Clerk newClerk = repository.findOne(id);
        Assert.assertNull(newClerk);
    }

}
