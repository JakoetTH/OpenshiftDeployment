package Airline.conf;

import Airline.domain.Hangar;

public class HangarFactory {

    public static Hangar createHangar(String status,
                                          int capacity)
    {
        Hangar hangar = new Hangar
                .Builder(status)
                .capacity(capacity)
                .build();
        return hangar;
    }
}
