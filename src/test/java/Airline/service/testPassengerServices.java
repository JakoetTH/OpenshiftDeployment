package Airline.service;

import Airline.App;
import Airline.domain.Passenger;
import Airline.repository.PassengerRepository;
import Airline.domain.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testPassengerServices extends AbstractTestNGSpringContextTests{
    private Passenger passenger;
    private List<Ticket> tickets;

    @Autowired
    PassengerImpl passengerService;
    @Autowired
    PassengerRepository passengerRepository;

    public testPassengerServices() {
    }

    @BeforeMethod
    public void setUp()
    {
        tickets = new ArrayList<Ticket>();
    }

    @Test
    public void testNewPassenger()
    {
        long count = passengerRepository.count();
        passengerService.newPassenger("Aziz","Password","Abdul","Samsodien","test","1234567890");
        Assert.assertNotEquals(count, passengerRepository.count());
    }

    @Test(dependsOnMethods = "testNewPassenger")
    public void testGetPassenger()
    {
        passenger = passengerService.getPassenger("Aziz");
        Assert.assertNotNull(passenger);
        passengerRepository.delete(passenger);
    }


}
