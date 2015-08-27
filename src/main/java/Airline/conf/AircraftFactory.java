package Airline.conf;

import java.util.List;

import Airline.domain.Aircraft;
import Airline.domain.Flight;

public class AircraftFactory {

    public static Aircraft createAircraft(String aircraftType,
                                    int seats,
                                    int fuelCapacity,
                                    List<Flight> flights)
    {
        Aircraft aircraft = new Aircraft
                .Builder(aircraftType)
                .seats(seats)
                .fuelCapacity(fuelCapacity)
                .flights(flights)
                .build();
        return aircraft;
    }
}
