package Airline.conf;

import Airline.domain.Hangar;

public class HangarFactory {

    public static Hangar createHangar(String ID,
                                          String status,
                                          int capacity)
    {
        Hangar hangar = new Hangar
                .Builder(ID)
                .status(status)
                .capacity(capacity)
                .build();
        return hangar;
    }
}
