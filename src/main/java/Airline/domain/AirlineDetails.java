package Airline.domain;

import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public interface AirlineDetails {
    public String getID();
    public String getAirlineName();
    public String getNationality();
    public List<Aircraft> getAircrafts();
}
