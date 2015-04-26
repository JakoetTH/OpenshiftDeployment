package Airline.conf;

import Airline.domain.Airline;

public class AirlineFactory {

    public static Airline createAirline(String ID,
                                          String name,
                                          String nationality)
    {
        Airline airline = new Airline
                .Builder(ID)
                .name(name)
                .nationality(nationality)
                .build();
        return airline;
    }
}

