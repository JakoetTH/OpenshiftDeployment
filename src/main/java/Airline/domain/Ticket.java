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
    private Long ID;
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
    public Long getID()
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
        private Long ID;
        private float price;
        private String ticketClass;

        public Builder(String ticketClass) {
            this.ticketClass = ticketClass;
        }


        public Builder price(float price)
        {
            this.price=price;
            return this;
        }

        public Builder ID(Long ID)
        {
            this.ID=ID;
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
