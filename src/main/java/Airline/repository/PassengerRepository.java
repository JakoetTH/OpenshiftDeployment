package Airline.repository;

import Airline.domain.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger,String>{
    public Passenger findByID(String ID);
}
