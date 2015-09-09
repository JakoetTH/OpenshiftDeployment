package Airline.service;


import java.util.List;

import Airline.domain.Flight;
import Airline.domain.Passenger;

public interface FlightService {
    public List<Flight> getAllFlights();
    public List<Flight> getAllPassengersFlights(Passenger pas);
}
