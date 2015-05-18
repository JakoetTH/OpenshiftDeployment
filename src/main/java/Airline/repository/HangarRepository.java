package Airline.repository;

import Airline.domain.Hangar;
import org.springframework.data.repository.CrudRepository;
public interface HangarRepository extends CrudRepository<Hangar,String> {
}
