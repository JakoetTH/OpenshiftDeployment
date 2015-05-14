package Airline.conf;

import Airline.domain.Flight;
import Airline.domain.Ticket;

import java.util.Date;
import java.util.List;

public class FlightFactory {

    public static Flight createFlight(String ID,
                                    Date departureTime,
                                    Date arrivalTime,
                                    String departureLocation,
                                    String arrivalLocation,
                                    List<Ticket> tickets)
    {
        Flight flight = new Flight
                .Builder(ID)
                .departureTime(departureTime)
                .arrivalTime(arrivalTime)
                .departureLocation(departureLocation)
                .arrivalLocation(arrivalLocation)
                .tickets(tickets)
                .build();
        return flight;
    }
}
