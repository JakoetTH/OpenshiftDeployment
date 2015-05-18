package Airline.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Flight implements FlightDisplay, Serializable{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String ID;
    private Date departureTime;
    private Date arrivalTime;
    private String departureLocation;
    private String arrivalLocation;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="ID")
    private List<Ticket> tickets;

    private Flight()
    {

    }

    public Flight(Builder builder)
    {
        this.ID=builder.ID;
        this.departureTime=builder.departureTime;
        this.arrivalTime=builder.arrivalTime;
        this.departureLocation=builder.departureLocation;
        this.arrivalLocation=builder.arrivalLocation;
        this.tickets=builder.tickets;
    }
    @Override
    public String getID()
    {
        return this.ID;
    }
    @Override
    public Date getDepartureTime()
    {
        return this.departureTime;
    }
    @Override
    public Date getArrivalTime()
    {
        return this.arrivalTime;
    }
    @Override
    public String getDepartureLocation()
    {
        return this.departureLocation;
    }
    @Override
    public String getArrivalLocation()
    {
        return this.arrivalLocation;
    }
    @Override
    public String displayFlightTimes()
    {
        return "";
    }
    @Override
    public String displayFlightLocations()
    {
        return "";
    }
    @Override
    public List<Ticket> getTickets()
    {
        return this.tickets;
    }

    public static class Builder
    {
        private String ID;
        private Date departureTime;
        private Date arrivalTime;
        private String departureLocation;
        private String arrivalLocation;
        private List<Ticket> tickets;

        public Builder(String ID)
        {
            this.ID=ID;
        }

        public Builder departureTime(Date departureTime)
        {
            this.departureTime=departureTime;
            return this;
        }

        public Builder arrivalTime(Date arrivalTime)
        {
            this.arrivalTime=arrivalTime;
            return this;
        }

        public Builder departureLocation(String departureLocation)
        {
            this.departureLocation=departureLocation;
            return this;
        }

        public Builder arrivalLocation(String arrivalLocation)
        {
            this.arrivalLocation=arrivalLocation;
            return this;
        }

        public Builder tickets(List<Ticket> tickets)
        {
            this.tickets=tickets;
            return this;
        }

        public Builder copy(Flight flight)
        {
            this.ID=flight.getID();
            this.departureTime=flight.getDepartureTime();
            this.arrivalTime=flight.getArrivalTime();
            this.departureLocation=flight.getDepartureLocation();
            this.arrivalLocation=flight.getArrivalLocation();
            this.tickets=flight.getTickets();
            return this;
        }

        public Flight build()
        {
            return new Flight(this);
        }
    }

}

