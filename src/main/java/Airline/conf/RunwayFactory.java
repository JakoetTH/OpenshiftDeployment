package Airline.conf;

import Airline.domain.Runway;

public class RunwayFactory {

    public static Runway createRunway(String ID,
                                      String status,
                                      int length)
    {
        Runway runway = new Runway
                .Builder(ID)
                .status(status)
                .length(length)
                .build();
        return runway;
    }
}
