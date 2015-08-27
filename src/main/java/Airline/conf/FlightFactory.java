package Airline.conf;

import Airline.domain.Flight;
import Airline.domain.Ticket;

import java.util.Date;
import java.util.List;

public class FlightFactory {

    public static Flight createFlight(Date departureTime,
                                    Date arrivalTime,
                                    String departureLocation,
                                    String arrivalLocation,
                                    List<Ticket> tickets)
    {
        Flight flight = new Flight
                .Builder(departureLocation)
                .departureTime(departureTime)
                .arrivalTime(arrivalTime)
                .arrivalLocation(arrivalLocation)
                .tickets(tickets)
                .build();
        return flight;
    }
}
