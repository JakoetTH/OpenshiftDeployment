package Airline.repository;

import Airline.domain.Clerk;
import org.springframework.data.repository.CrudRepository;
public interface ClerkRepository extends CrudRepository <Clerk,String>{
    public Clerk findByID(String ID);
}
