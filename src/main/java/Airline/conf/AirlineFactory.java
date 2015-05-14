package Airline.conf;

import Airline.domain.Aircraft;
import Airline.domain.Airline;
import java.util.List;

public class AirlineFactory {

    public static Airline createAirline(String ID,
                                          String name,
                                          String nationality,
                                          List<Aircraft> aircrafts)
    {
        Airline airline = new Airline
                .Builder(ID)
                .name(name)
                .nationality(nationality)
                .aircraft(aircrafts)
                .build();
        return airline;
    }
}

