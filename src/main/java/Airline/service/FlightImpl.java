package Airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import Airline.domain.Flight;
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
}
