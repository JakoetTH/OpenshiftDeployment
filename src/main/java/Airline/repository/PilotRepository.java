package Airline.repository;

import Airline.domain.Pilot;
import org.springframework.data.repository.CrudRepository;

public interface PilotRepository extends CrudRepository<Pilot,String> {
    //public Pilot findByID(String ID);
}
