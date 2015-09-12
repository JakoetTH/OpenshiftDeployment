package Airline.service;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Airline.App;
import Airline.conf.FlightFactory;
import Airline.conf.PassengerFactory;
import Airline.domain.Flight;
import Airline.domain.Passenger;
import Airline.domain.Ticket;
import Airline.repository.FlightRepository;
import Airline.repository.PassengerRepository;
import Airline.repository.TicketRepository;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testFlightServices extends AbstractTestNGSpringContextTests{
    private List<Flight> flights;
    private List<Ticket> tickets;
    private Flight flight;
    private Ticket ticket;
    private Ticket tickettwo;
    private Passenger passenger;
    private Date date = new Date();


    @Autowired
    FlightImpl flightService;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    @BeforeMethod
    public void setUp()
    {
        flights = new ArrayList<Flight>();
        tickets = new ArrayList<Ticket>();
    }

    @Test
    public void testCreateTickets()
    {
        ticket = new Ticket.Builder("First Class")
                .price(200)
                .build();
        tickettwo = new Ticket.Builder("Business Class")
                .price(300)
                .build();

        tickets.add(ticket);
        Assert.assertNotNull(ticket);
        ticketRepository.save(ticket);
        tickets.add(tickettwo);
        Assert.assertNotNull(tickettwo);
        ticketRepository.save(tickettwo);
    }

    @Test(dependsOnMethods = "testCreateTickets")
    public void testCreatePassenger()
    {
        passenger = PassengerFactory.createPassenger("Redc", "12345", "Thawhir", "Jakoet", "15 Shiraaz Close", "083 477 1207", tickets);
        Assert.assertNotNull(passenger);
        passengerRepository.save(passenger);
    }

    @Test(dependsOnMethods = "testCreatePassenger")
    public void testCreateFlight()
    {
        flight = FlightFactory.createFlight(date, date, "Johannesburg", "Belgium", 200, tickets);
        Assert.assertNotNull(flight);
        flightRepository.save(flight);
    }

    @Test(dependsOnMethods = "testCreateFlight")
    public void testGetAllFlights()
    {
        long count = flightRepository.count();
        flights = flightService.getAllFlights();
        Assert.assertTrue(flights.size() == count);
    }

    @Test(dependsOnMethods = "testGetAllFlights")
    public void testGetAllPassengersFlights()
    {
        flights = flightService.getAllPassengersFlights(passenger);
        Assert.assertNotNull(flights);
    }
}
