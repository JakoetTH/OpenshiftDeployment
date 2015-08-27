package Airline.conf;

import Airline.domain.Runway;

public class RunwayFactory {

    public static Runway createRunway(String status,
                                      int length)
    {
        Runway runway = new Runway
                .Builder(status)
                .length(length)
                .build();
        return runway;
    }
}
