package Airline.conf;

import Airline.domain.Passenger;
import Airline.domain.Ticket;
import java.util.List;

public class PassengerFactory {

    public static Passenger createPassenger(String ID,
                                            String firstName,
                                            String lastName,
                                            String address,
                                            String contact,
                                            List<Ticket> tickets)
    {
        Passenger passenger = new Passenger
                .Builder(ID)
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .contact(contact)
                .tickets(tickets)
                .build();
        return passenger;
    }
}
