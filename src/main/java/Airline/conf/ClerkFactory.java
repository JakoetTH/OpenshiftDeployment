package Airline.conf;

import Airline.domain.Clerk;

public class ClerkFactory {

    public static Clerk createClerk(String ID,
                                            String firstName,
                                            String lastName,
                                            String address,
                                            String contact)
    {
        Clerk clerk = new Clerk
                .Builder(ID)
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .contact(contact)
                .build();
        return clerk;
    }
}
