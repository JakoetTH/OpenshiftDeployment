package Airline.conf;

import Airline.domain.Airport;
import Airline.domain.Hangar;
import Airline.domain.Runway;

import java.util.List;

public class AirportFactory {

    public static Airport createAirport(String ID,
                                            String name,
                                            String country,
                                            String city,
                                            String type,
                                            List<Hangar> hangars,
                                            List<Runway> runways)
    {
        Airport airport = new Airport
                .Builder(ID)
                .name(name)
                .country(country)
                .city(city)
                .type(type)
                .hangars(hangars)
                .runways(runways)
                .build();
        return airport;
    }
}
