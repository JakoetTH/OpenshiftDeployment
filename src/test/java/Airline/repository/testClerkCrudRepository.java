package Airline.repository;

import Airline.App;
import Airline.domain.Clerk;
import Airline.domain.Ticket;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import java.util.List;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testClerkCrudRepository extends AbstractTestNGSpringContextTests{
    private Long id;
    private List<Ticket> tickets;

    @Autowired
    ClerkRepository repository;

    @Test
    public void testCreate() throws Exception
    {
        Clerk clerk = new Clerk.Builder("Thawhir")
                .lastName("Jakoet")
                .address("15 Shiraaz Close")
                .contact("021 123 4567")
                .position("Ticket Clerk")
                .tickets(tickets)
                .build();
        repository.save(clerk);
        id = clerk.getID();
        Assert.assertNotNull(clerk);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Clerk clerk = repository.findOne(id);
        Assert.assertEquals("Thawhir",clerk.getFirstName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Clerk clerk = repository.findOne(id);
        Clerk newClerk = new Clerk.Builder(clerk.getFirstName())
                .ID(id)
                .lastName("Jakoet")
                .address("15 Shiraaz Close")
                .contact("021 765 4321")
                .position("Ticket Clerk")
                .tickets(tickets)
                .build();
        repository.save(newClerk);

        Clerk updatedClerk = repository.findOne(id);
        Assert.assertEquals("021 765 4321",updatedClerk.getContact());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Clerk clerk = repository.findOne(id);
        repository.delete(clerk);
        Clerk newClerk = repository.findOne(id);
        Assert.assertNull(newClerk);
    }

}
