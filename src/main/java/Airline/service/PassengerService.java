package Airline.service;

import Airline.domain.Passenger;

/**
 * Created by Thawhir on 2015/08/28.
 */
public interface PassengerService {
    public Passenger getPassenger(String ID);
    public void newPassenger();
}
