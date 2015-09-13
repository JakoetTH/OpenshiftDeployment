package Airline.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import Airline.domain.Flight;
import Airline.domain.Passenger;
import Airline.domain.Ticket;
import Airline.repository.FlightRepository;
import Airline.repository.PassengerRepository;
import Airline.repository.TicketRepository;
import Airline.service.FlightService;
import Airline.service.PassengerService;
import Airline.service.TicketService;

@RestController
@RequestMapping("/api/**")
public class PassengerController {
    @Autowired
    PassengerService passengerService;
    @Autowired
    FlightService flightService;
    @Autowired
    TicketService ticketService;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    FlightRepository flightRepository;
   // @RequestMapping(value = "/passenger/create",method = RequestMethod.POST)
   // public ResponseEntity<Void> createPassenger(@RequestBody Passenger passenger, UriComponentsBuilder ucBuilder)
   // {
   //     service.newPassenger();
   // }
//    public ResponseEntity<Void> createSubject(@RequestBody Subject subject,    UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating Subject " + subject.getName());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

 //       service.save(subject);

    //    HttpHeaders headers = new HttpHeaders();
     //   headers.setLocation(ucBuilder.path("/subject/{id}").buildAndExpand(subject.getId()).toUri());
     //   return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  //  }
    //Creates new Ticket
    @RequestMapping(value = "/ticket/create", method = RequestMethod.POST)
    public ResponseEntity<Void> newTicket(@RequestParam long userid,
                                          @RequestParam long flightid,
                                          @RequestParam float price,
                                          @RequestParam String ticketclass)
    {
        Passenger passenger = passengerRepository.findOne(userid);
        Flight flight = flightRepository.findOne(flightid);
        ticketService.newTicket(passenger,flight,price,ticketclass);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //Delete a ticket by ticket ID
    @RequestMapping(value = "/ticket/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Ticket> deleteTicket(@PathVariable("id") long id)
    {
        Ticket ticket = ticketRepository.findOne(id);
        if(ticket==null)
            return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
        ticketService.deleteTicket(id);
        return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
    }

    //Returns all flights
    @RequestMapping(value = "/flight/all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> getAllFlights()
    {
        List<Flight> flights = flightService.getAllFlights();
        if(flights==null)
            return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }

    //Returns all of a passenger's flights
    @RequestMapping(value = "/flight/bypassenger/{username}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> getAllPassengerFlights(@PathVariable("username") String username)
    {
        Passenger passenger = passengerService.getPassenger(username);
        List<Flight> flights = flightService.getAllPassengersFlights(passenger);
        if(flights==null)
            return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }

    //Returns passenger by User name
    @RequestMapping(value = "/passenger/{username}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Passenger> getPassenger(@PathVariable("username") String username)
    {

        Passenger passenger = passengerService.getPassenger(username);
        if(passenger==null)
            return new ResponseEntity<Passenger>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
    }
}