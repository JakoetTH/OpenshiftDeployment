package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Airport implements AirportDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ID;
    private String name;
    private String country;
    private String city;
    private String type;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="airport_id")
    private List<Hangar> hangars;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="airport_id")
    private List<Runway> runways;

    private Airport()
    {

    }

    public Airport(Builder builder)
    {
        this.ID=builder.ID;
        this.name=builder.name;
        this.country=builder.country;
        this.city=builder.city;
        this.type=builder.type;
        this.hangars=builder.hangars;
        this.runways=builder.runways;
    }
    @Override
    public String getID()
    {
        return this.ID;
    }
    @Override
    public String getName()
    {
        return this.name;
    }
    @Override
    public String getCountry()
    {
        return this.country;
    }
    @Override
    public String getCity()
    {
        return this.city;
    }
    @Override
    public String getType()
    {
        return this.type;
    }
    @Override
    public List<Hangar> getHangars()
    {
        return this.hangars;
    }
    @Override
    public List<Runway> getRunways()
    {
        return this.runways;
    }

    public static class Builder
    {
        private String ID;
        private String name;
        private String country;
        private String city;
        private String type;
        private List<Hangar> hangars;
        private List<Runway> runways;

        public Builder(String ID)
        {
            this.ID=ID;
        }

        public Builder name(String name)
        {
            this.name=name;
            return this;
        }

        public Builder country(String country)
        {
            this.country=country;
            return this;
        }

        public Builder city(String city)
        {
            this.city=city;
            return this;
        }

        public Builder type(String type)
        {
            this.type=type;
            return this;
        }

        public Builder hangars(List<Hangar> hangars)
        {
            this.hangars=hangars;
            return this;
        }

        public Builder runways(List<Runway> runways)
        {
            this.runways=runways;
            return this;
        }

        public Builder copy(Airport airport)
        {
            this.ID=airport.getID();
            this.name=airport.getName();
            this.country=airport.getCountry();
            this.city=airport.getCity();
            this.type=airport.getType();
            this.hangars=airport.getHangars();
            this.runways=airport.getRunways();
            return this;
        }

        public Airport build()
        {
            return new Airport(this);
        }
    }

}
