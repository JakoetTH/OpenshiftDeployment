package Airline.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        testAircraftCrudRepository.class,
        testAirlineCrudRepository.class,
        testAirportCrudRepository.class,
        testClerkCrudRepository.class,
        testFlightCrudRepository.class,
        testHangarCrudRepository.class,
        testPassengerCrudRepository.class,
        testPilotCrudRepository.class,
        testRunwayCrudRepository.class,
        testTicketCrudRepository.class
})
public class testSuite {
}
