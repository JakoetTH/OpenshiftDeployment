package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Passenger implements PersonDetails, Serializable{
    @Id
    private String ID;
    private String firstName;
    private String lastName;
    private String address;
    private String contact;

    private Passenger()
    {

    }

    public Passenger(Builder builder)
    {
        this.ID=builder.ID;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.address=builder.address;
        this.contact=builder.contact;
    }
    @Override
    public String getID()
    {
        return this.ID;
    }
    @Override
    public String getFirstName()
    {
        return this.firstName;
    }
    @Override
    public String getLastName()
    {
        return this.lastName;
    }
    @Override
    public String getAddress()
    {
        return this.address;
    }
    @Override
    public String getContact()
    {
        return this.contact;
    }

    public static class Builder
    {
        private String ID;
        private String firstName;
        private String lastName;
        private String address;
        private String contact;

        public Builder(String ID)
        {
            this.ID=ID;
        }

        public Builder firstName(String firstName)
        {
            this.firstName=firstName;
            return this;
        }

        public Builder lastName(String lastName)
        {
            this.lastName=lastName;
            return this;
        }

        public Builder address(String address)
        {
            this.address=address;
            return this;
        }

        public Builder contact(String contact)
        {
            this.contact=contact;
            return this;
        }

        public Builder copy(Passenger passenger)
        {
            this.ID=passenger.getID();
            this.firstName=passenger.getFirstName();
            this.lastName=passenger.getLastName();
            this.address=passenger.getAddress();
            this.contact=passenger.getContact();
            return this;
        }

        public Passenger build()
        {
            return new Passenger(this);
        }
    }

}
