package Airline.domain;

import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public interface AirportDetails {
    public String getID();
    public String getName();
    public String getCountry();
    public String getCity();
    public String getType();
    public List<Hangar> getHangars();
    public List<Runway> getRunways();
}
