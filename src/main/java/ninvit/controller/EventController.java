package ninvit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ninvit.model.Event;
import ninvit.repository.EventRepository;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> Get() {
        return eventRepository.findAll();
    }

    @RequestMapping(value = "/event/{type}", method = RequestMethod.GET)
    public ResponseEntity<Event> GetById(@PathVariable(value = "type") String type)
    {
        Optional<Event> event = eventRepository.findById(type);
        if(event.isPresent())
            return new ResponseEntity<Event>(event.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/event", method =  RequestMethod.POST)
    public Event Post(@RequestBody Event event)
    {
        return eventRepository.save(event);
    }

    @RequestMapping(value = "/event/{type}", method =  RequestMethod.PUT)
    public ResponseEntity<Event> Put(@PathVariable(value = "type") String type, @RequestBody Event newEvent)
    {
        Optional<Event> oldEvent = eventRepository.findById(type);
        if(oldEvent.isPresent()){
            Event event = oldEvent.get();
            event.setTimestamp(newEvent.getTimestamp());
            eventRepository.save(event);
            return new ResponseEntity<Event>(event, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/event/{type}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "type") String type)
    {
        Optional<Event> event = eventRepository.findById(type);
        if(event.isPresent()){
            eventRepository.delete(event.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}