package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Clerk implements PersonDetails, Serializable{
    private String ID;
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    private String position;

    private Clerk()
    {

    }

    public Clerk(Builder builder)
    {
        this.ID=builder.ID;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.address=builder.address;
        this.contact=builder.contact;
        this.position=builder.position;
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
    public String getPosition() {
        return this.position;
    }

    public static class Builder
    {
        private String ID;
        private String firstName;
        private String lastName;
        private String address;
        private String contact;
        private String position;

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
        public Builder position(String position)
        {
            this.position=position;
            return this;
        }

        public Builder copy(Clerk clerk)
        {
            this.ID=clerk.getID();
            this.firstName=clerk.getFirstName();
            this.lastName=clerk.getLastName();
            this.address=clerk.getAddress();
            this.contact=clerk.getContact();
            this.position=clerk.getPosition();
            return this;
        }

        public Clerk build()
        {
            return new Clerk(this);
        }
    }

}
