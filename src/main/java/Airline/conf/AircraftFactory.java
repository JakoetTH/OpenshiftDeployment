package Airline.conf;

import Airline.domain.Aircraft;

public class AircraftFactory {

    public static Aircraft createAircraft(String ID,
                                    String aircraftType,
                                    int seats,
                                    int fuelCapacity,
                                    String airlineID)
    {
        Aircraft aircraft = new Aircraft
                .Builder(ID)
                .aircraftType(aircraftType)
                .seats(seats)
                .fuelCapacity(fuelCapacity)
                .airlineID(airlineID)
                .build();
        return aircraft;
    }
}
