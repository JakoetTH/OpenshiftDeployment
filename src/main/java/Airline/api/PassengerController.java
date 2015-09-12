package Airline.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import Airline.domain.Passenger;
import Airline.repository.PassengerRepository;
import Airline.service.PassengerService;

@RestController
@RequestMapping("/api/**")
public class PassengerController {
    @Autowired
    PassengerService passengerService;
    @Autowired
    PassengerRepository passengerRepository;
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
    @RequestMapping(value = "passenger/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Passenger> getPassenger(@PathVariable("id") long id)
    {
        Passenger passenger = passengerRepository.findOne(id);
        if(passenger==null)
            return new ResponseEntity<Passenger>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
    }
}