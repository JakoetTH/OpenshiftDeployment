package Airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import Airline.domain.Passenger;
import Airline.domain.Ticket;
import Airline.repository.PassengerRepository;

/**
 * Created by Thawhir on 2015/08/28.
 */
@Service
public class PasssengerImpl implements PassengerService{
    @Autowired
    private PassengerRepository repository;
    @Override
    public Passenger getPassenger(String ID)
    {
        Passenger passenger;
        List<Ticket> tickets = new ArrayList<Ticket>();


        return passenger;
    }
    @Override
    public void newPassenger(String ID, String Username)
    {
        Passenger passenger;
        List<Ticket> tickets = new ArrayList<Ticket>();
    }
}
