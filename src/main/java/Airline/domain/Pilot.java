package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Pilot implements PersonDetails, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    private String rank;

    private Pilot()
    {

    }

    public Pilot(Builder builder)
    {
        this.ID=builder.ID;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.address=builder.address;
        this.contact=builder.contact;
        this.rank=builder.rank;
    }
    @Override
    public Long getID()
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
    public String getRank() { return this.rank; }

    public static class Builder
    {
        private Long ID;
        private String firstName;
        private String lastName;
        private String address;
        private String contact;
        private String rank;

        public Builder(String firstName)
        {
            this.firstName=firstName;
        }

        public Builder ID(Long ID)
        {
            this.ID=ID;
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

        public Builder rank(String rank)
        {
            this.rank=rank;
            return this;
        }

        public Builder copy(Pilot pilot)
        {
            this.ID=pilot.getID();
            this.firstName=pilot.getFirstName();
            this.lastName=pilot.getLastName();
            this.address=pilot.getAddress();
            this.contact=pilot.getContact();
            this.rank=pilot.getRank();
            return this;
        }

        public Pilot build()
        {
            return new Pilot(this);
        }
    }

}