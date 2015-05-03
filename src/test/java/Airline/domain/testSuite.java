package Airline.domain;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        testAircraft.class,
        testAirline.class,
        testAirport.class,
        testClerk.class,
        testFlight.class,
        testHangar.class,
        testPassenger.class,
        testPilot.class,
        testRunway.class,
        testTicket.class
})
public class testSuite {
}

