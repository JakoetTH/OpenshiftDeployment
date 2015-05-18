package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Runway implements AirportVenueDetails, Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String ID;
    private String status;
    private int length;

    private Runway()
    {

    }

    public Runway(Builder builder)
    {
        this.ID=builder.ID;
        this.status=builder.status;
        this.length=builder.length;

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
        return this.length;
    }

    public static class Builder
    {
        private String ID;
        private String status;
        private int length;

        public Builder(String ID)
        {
            this.ID=ID;
        }

        public Builder status(String status)
        {
            this.status=status;
            return this;
        }

        public Builder length(int length)
        {
            this.length=length;
            return this;
        }

        public Builder copy(Runway runway)
        {
            this.ID=runway.getID();
            this.status=runway.getStatus();
            this.length=runway.getSize();
            return this;
        }

        public Runway build()
        {
            return new Runway(this);
        }
    }

}
