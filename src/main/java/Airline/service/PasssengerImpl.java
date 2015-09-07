package Airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import Airline.domain.Passenger;
import Airline.conf.PassengerFactory;
import Airline.repository.PassengerRepository;
import Airline.domain.Ticket;


@Service
public class PasssengerImpl implements PassengerService{
    @Autowired
    private PassengerRepository repository;
    @Override//Read
    public Passenger getPassenger(String username)
    {
        Iterable<Passenger> passengers = repository.findAll();
        Passenger passenger = null;
        for(Passenger pas : passengers)
        {
            if(pas.getUserName().equalsIgnoreCase(username))
                passenger = pas;
        }
        return passenger;
    }
    @Override//Create
    public void newPassenger(String username, String password, String firstname, String lastname, String address, String contact)
    {
        List<Ticket> tickets = new ArrayList<Ticket>();
        Passenger passenger = PassengerFactory.createPassenger(username,password,firstname,lastname,address,contact,tickets);
        if(getPassenger(username)==null)//implement this check outside of this function to return error msg to the user
            repository.save(passenger);
    }
}
