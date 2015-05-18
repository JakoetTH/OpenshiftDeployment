package Airline.repository;

import Airline.domain.Airline;
import org.springframework.data.repository.CrudRepository;
public interface AirlineRepository extends CrudRepository<Airline,String> {
}
