package ninvit.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ninvit.model.Event;

@RestController
public class EventController {

    private List<Event> eventList = new ArrayList();
    Event event = new Event();
    LocalDateTime currentTime = LocalDateTime.now();

    public EventController() {
        eventList.add(new Event("Type", currentTime));
    }

    public ResponseEntity index(){
        return ResponseEntity.ok(eventList);
    }

}
