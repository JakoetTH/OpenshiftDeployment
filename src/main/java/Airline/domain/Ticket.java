package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Ticket implements TicketDetails, Serializable{
    private String ID;
    private float price;
    private String ticketClass;
    private String clerkID;
    private String passengerID;
    private String flightID;

    private Ticket()
    {

    }
    public Ticket(Builder builder)
    {
        this.ID=builder.ID;
        this.price=builder.price;
        this.ticketClass=builder.ticketClass;
        this.clerkID=builder.clerkID;
        this.passengerID=builder.passengerID;
        this.flightID=builder.flightID;
    }
    @Override
    public String getID()
    {
        return this.ID;
    }
    @Override
    public float getPrice()
    {
        return this.price;
    }
    @Override
    public String getTicketClass()
    {
        return this.ticketClass;
    }
    @Override
    public String getClerkID()
    {
        return this.clerkID;
    }
    @Override
    public String getPassengerID()
    {
        return this.passengerID;
    }
    @Override
    public String getFlightID()
    {
        return this.flightID;
    }

    public static class Builder
    {
        private String ID;
        private float price;
        private String ticketClass;
        private String clerkID;
        private String passengerID;
        private String flightID;

        public Builder(String ID)
        {
            this.ID=ID;
        }

        public Builder price(float price)
        {
            this.price=price;
            return this;
        }

        public Builder ticketClass(String ticketClass)
        {
            this.ticketClass=ticketClass;
            return this;
        }

        public Builder clerkID(String clerkID)
        {
            this.clerkID=clerkID;
            return this;
        }

        public Builder passengerID(String passengerID)
        {
            this.passengerID=passengerID;
            return this;
        }

        public Builder flightID(String flightID)
        {
            this.flightID=flightID;
            return this;
        }

        public Builder copy(Ticket ticket)
        {
            this.ID=ticket.getID();
            this.price=ticket.getPrice();
            this.ticketClass=ticket.getTicketClass();
            this.clerkID=ticket.getClerkID();
            this.passengerID=ticket.getPassengerID();
            this.flightID=ticket.getFlightID();
            return this;
        }

        public Ticket build()
        {
            return new Ticket(this);
        }
    }

}
