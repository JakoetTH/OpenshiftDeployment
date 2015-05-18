package Airline.repository;

import Airline.domain.Flight;
import org.springframework.data.repository.CrudRepository;
public interface FlightRepository extends CrudRepository <Flight,String>{
}
