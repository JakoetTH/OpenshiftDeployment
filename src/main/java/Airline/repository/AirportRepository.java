package Airline.repository;

import Airline.domain.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport,Long> {
}
