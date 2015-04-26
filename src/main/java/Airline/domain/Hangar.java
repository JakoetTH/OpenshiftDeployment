package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Hangar implements AirportVenueDetails, Serializable {
    private String ID;
    private String status;
    private int capacity;

    private Hangar()
    {

    }

    public Hangar(Builder builder)
    {
        this.ID=builder.ID;
        this.status=builder.status;
        this.capacity=builder.capacity;

    }
    @Override
    public String getID()
    {
        return this.ID;
    }
    @Override
    public String getStatus()
    {
        return this.status;
    }
    @Override
    public int getSize()
    {
        return this.capacity;
    }

    public static class Builder
    {
        private String ID;
        private String status;
        private int capacity;

        public Builder(String ID)
        {
            this.ID=ID;
        }

        public Builder status(String status)
        {
            this.status=status;
            return this;
        }

        public Builder capacity(int capacity)
        {
            this.capacity=capacity;
            return this;
        }

        public Builder copy(Hangar hangar)
        {
            this.ID=hangar.getID();
            this.status=hangar.getStatus();
            this.capacity=hangar.getSize();
            return this;
        }

        public Hangar build()
        {
            return new Hangar(this);
        }
    }

}
