package Airline.conf;

import Airline.domain.Flight;
import java.util.Date;

public class FlightFactory {

    public static Flight createFlight(String ID,
                                    Date departureTime,
                                    Date arrivalTime,
                                    String departureLocation,
                                    String arrivalLocation)
    {
        Flight flight = new Flight
                .Builder(ID)
                .departureTime(departureTime)
                .arrivalTime(arrivalTime)
                .departureLocation(departureLocation)
                .arrivalLocation(arrivalLocation)
                .build();
        return flight;
    }
}
