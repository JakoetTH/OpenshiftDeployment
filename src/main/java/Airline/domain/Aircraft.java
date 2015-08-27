package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Aircraft implements AircraftDetails, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String aircraftType;
    private int seats;
    private int fuelCapacity;

    private Aircraft()
    {

    }

    public Aircraft(Builder builder)
    {
        this.ID=builder.ID;
        this.aircraftType=builder.aircraftType;
        this.seats=builder.seats;
        this.fuelCapacity=builder.fuelCapacity;
    }
    @Override
    public Long getID()
    {
        return this.ID;
    }
    @Override
    public String getAircraftType()
    {
        return this.aircraftType;
    }
    @Override
    public int getSeats()
    {
        return this.seats;
    }
    @Override
    public int getFuelCapacity()
    {
        return this.fuelCapacity;
    }

    public static class Builder
    {
        private Long ID;
        private String aircraftType;
        private int seats;
        private int fuelCapacity;

        public Builder(String aircraftType)
        {
            this.aircraftType=aircraftType;
        }

        public Builder ID(Long ID)
        {
            this.ID=ID;
            return this;
        }

        public Builder seats(int seats)
        {
            this.seats=seats;
            return this;
        }

        public Builder fuelCapacity(int fuelCapacity)
        {
            this.fuelCapacity=fuelCapacity;
            return this;
        }

        public Builder copy(Aircraft aircraft)
        {
            this.ID=aircraft.getID();
            this.aircraftType=aircraft.getAircraftType();
            this.seats=aircraft.getSeats();
            this.fuelCapacity=aircraft.getFuelCapacity();
            return this;
        }

        public Aircraft build()
        {
            return new Aircraft(this);
        }
    }
}
