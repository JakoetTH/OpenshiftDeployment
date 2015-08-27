package Airline.conf;

import Airline.domain.Aircraft;

public class AircraftFactory {

    public static Aircraft createAircraft(String aircraftType,
                                    int seats,
                                    int fuelCapacity)
    {
        Aircraft aircraft = new Aircraft
                .Builder(aircraftType)
                .seats(seats)
                .fuelCapacity(fuelCapacity)
                .build();
        return aircraft;
    }
}
