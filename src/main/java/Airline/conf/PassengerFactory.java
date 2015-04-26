package Airline.conf;

import Airline.domain.Passenger;

public class PassengerFactory {

    public static Passenger createPassenger(String ID,
                                            String firstName,
                                            String lastName,
                                            String address,
                                            String contact)
    {
        Passenger passenger = new Passenger
                .Builder(ID)
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .contact(contact)
                .build();
        return passenger;
    }
}
