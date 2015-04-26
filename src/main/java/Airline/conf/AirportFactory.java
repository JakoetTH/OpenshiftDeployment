package Airline.conf;

import Airline.domain.Airport;

public class AirportFactory {

    public static Airport createAirport(String ID,
                                            String name,
                                            String country,
                                            String city,
                                            String type)
    {
        Airport airport = new Airport
                .Builder(ID)
                .name(name)
                .country(country)
                .city(city)
                .type(type)
                .build();
        return airport;
    }
}
