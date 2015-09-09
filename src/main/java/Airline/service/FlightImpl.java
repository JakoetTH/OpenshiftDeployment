package Airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import Airline.domain.Flight;
import Airline.domain.Passenger;
import Airline.domain.Ticket;
import Airline.repository.FlightRepository;

@Service
public class FlightImpl implements FlightService {
    @Autowired
    private FlightRepository repositoryFlight;
    @Override//Read
    public List<Flight> getAllFlights()
    {
        Iterable<Flight> iflights = repositoryFlight.findAll();
        List<Flight> flights = new ArrayList<Flight>();
        for(Flight fli : iflights)
            flights.add(fli);
        return flights;
    }
    @Override//Read (Most inefficient code ever)
    public List<Flight> getAllPassengersFlights(Passenger pas)
    {
        Iterable<Flight> iflights = repositoryFlight.findAll();
        List<Flight> flights = new ArrayList<Flight>();
        List<Ticket> ptickets = pas.getTickets();
        List<Ticket> ftickets;
            for(Flight fli : iflights)
            {
                ftickets = fli.getTickets();
                for(Ticket ticket : ptickets)
                {
                    if(ftickets.contains(ticket))
                        flights.add(fli);
                }
            }
        return flights;
    }
}
