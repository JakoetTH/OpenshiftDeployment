package Airline.repository;

import Airline.domain.Runway;
import org.springframework.data.repository.CrudRepository;
public interface RunwayRepository extends CrudRepository <Runway,Long> {
}
