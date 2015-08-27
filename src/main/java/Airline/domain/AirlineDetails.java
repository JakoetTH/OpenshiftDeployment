package Airline.domain;

import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public interface AirlineDetails {
    public Long getID();
    public String getAirlineName();
    public String getNationality();
    public List<Aircraft> getAircrafts();
}
