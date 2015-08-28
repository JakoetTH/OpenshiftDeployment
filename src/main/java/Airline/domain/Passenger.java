package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Passenger implements PersonDetails, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="passenger_id")
    private List<Ticket> tickets;

    private Passenger()
    {

    }

    public Passenger(Builder builder)
    {
        this.ID=builder.ID;
        this.userName=builder.userName;
        this.password=builder.password;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.address=builder.address;
        this.contact=builder.contact;
        this.tickets=builder.tickets;
    }
    @Override
    public Long getID()
    {
        return this.ID;
    }
    public String getUserName() {
        return this.userName;
    }
    public String getPassword()
    {
        return this.password;
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
    public List<Ticket> getTickets(){
        return this.tickets;
    }

    public static class Builder
    {
        private Long ID;
        private String userName;
        private String password;
        private String firstName;
        private String lastName;
        private String address;
        private String contact;
        private List<Ticket> tickets;

        public Builder(String userName)
        {
            this.userName=userName;
        }

        public Builder ID(Long ID)
        {
            this.ID=ID;
            return this;
        }

        public Builder password(String password)
        {
            this.password=password;
            return this;
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

        public Builder tickets(List<Ticket> tickets)
        {
            this.tickets=tickets;
            return this;
        }

        public Builder copy(Passenger passenger)
        {
            this.ID=passenger.getID();
            this.userName=passenger.getUserName();
            this.password=passenger.getPassword();
            this.firstName=passenger.getFirstName();
            this.lastName=passenger.getLastName();
            this.address=passenger.getAddress();
            this.contact=passenger.getContact();
            this.tickets=passenger.getTickets();
            return this;
        }

        public Passenger build()
        {
            return new Passenger(this);
        }
    }

}
