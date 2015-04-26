package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Airport implements AirportDetails, Serializable {
    private String ID;
    private String name;
    private String country;
    private String city;
    private String type;

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

    public static class Builder
    {
        private String ID;
        private String name;
        private String country;
        private String city;
        private String type;

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

        public Builder copy(Airport airport)
        {
            this.ID=airport.getID();
            this.name=airport.getName();
            this.country=airport.getCountry();
            this.city=airport.getCity();
            this.type=airport.getType();
            return this;
        }

        public Airport build()
        {
            return new Airport(this);
        }
    }

}
