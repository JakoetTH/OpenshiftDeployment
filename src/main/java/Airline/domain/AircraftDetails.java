package Airline.domain;

import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public interface AircraftDetails {
    public Long getID();
    public String getAircraftType();
    public int getSeats();
    public int getFuelCapacity();
    public List<Flight> getFlights();

}
