package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Ticket implements TicketDetails, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ID;
    private float price;
    private String ticketClass;

    private Ticket()
    {

    }
    public Ticket(Builder builder)
    {
        this.ID=builder.ID;
        this.price=builder.price;
        this.ticketClass=builder.ticketClass;
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

    public static class Builder
    {
        private String ID;
        private float price;
        private String ticketClass;

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


        public Builder copy(Ticket ticket)
        {
            this.ID=ticket.getID();
            this.price=ticket.getPrice();
            this.ticketClass=ticket.getTicketClass();
            return this;
        }

        public Ticket build()
        {
            return new Ticket(this);
        }
    }

}
