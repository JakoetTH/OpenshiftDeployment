package Airline.conf;

import Airline.domain.Aircraft;

public class AircraftFactory {

    public static Aircraft createAircraft(String ID,
                                    String aircraftType,
                                    int seats,
                                    int fuelCapacity)
    {
        Aircraft aircraft = new Aircraft
                .Builder(ID)
                .aircraftType(aircraftType)
                .seats(seats)
                .fuelCapacity(fuelCapacity)
                .build();
        return aircraft;
    }
}
